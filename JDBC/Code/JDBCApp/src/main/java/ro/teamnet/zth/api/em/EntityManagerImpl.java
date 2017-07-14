package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.database.DBManager;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Claudiu.Brandabur on 13-Jul-17.
 */
public class EntityManagerImpl implements EntityManager{

    @Override
    public <T> T findById(Class<T> entityClass, Long id) {
        Connection con = DBManager.getConnection();

        String tableName = EntityUtils.getTableName(entityClass);
        List<ColumnInfo> columns = EntityUtils.getColumns(entityClass);
        List<Field> ColumnFields = EntityUtils.getFieldsByAnnotations(entityClass, Column.class);
        Field IdFields = EntityUtils.getFieldsByAnnotations(entityClass, Id.class).get(0);
        ColumnFields.add(0,IdFields);

        Condition condition = new Condition();
        Statement statement = null;
        ResultSet resultSet = null;

        QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.setTableName(tableName);
        queryBuilder.addQueryColumns(columns);
        queryBuilder.setQueryType(QueryType.SELECT);

        T instance = null;
        Field fieldInstance;

        for (ColumnInfo index:columns) {
            if(index.isId()) {
                condition.setColumnName(tableName + "." + index.getDbColumnName());
                condition.setValue(id);
                queryBuilder.addCondition(condition);
                break;
            }
        }

        String myQuery = queryBuilder.createQuery();
        //System.out.println(myQuery);

        try{
            statement = con.createStatement();
            resultSet = statement.executeQuery(myQuery);

            while(resultSet.next()){
                instance = entityClass.newInstance();

                for (ColumnInfo index: columns) {
                    fieldInstance = instance.getClass().getDeclaredField(index.getColumnName());
                    fieldInstance.setAccessible(true);
                    fieldInstance.set(instance,EntityUtils.
                            castFromSqlType(resultSet.getObject(index.getDbColumnName()),fieldInstance.getType()));
                }
            }
        } catch (Exception e) {
            System.out.println("Eroare: " + e);
            System.exit(1);
        } finally {
            clearResultSet(resultSet);
            clearStatement(statement);
            clearConnection(con);
        }
        return instance;
    }

    @Override
    public long getNextIdVal(String tableName, String columnIdName) {
        Connection con = DBManager.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        String myQuery = "SELECT MAX (" + columnIdName + ") FROM " + tableName;
        //System.out.println(myQuery);
        long max = Long.MIN_VALUE;

        try {
            statement = con.createStatement();
            resultSet = statement.executeQuery(myQuery);

            while(resultSet.next()){
                max = resultSet.getLong(1);
            }
        } catch (Exception e) {
            System.out.println("Eroare: " + e);
            System.exit(1);
        } finally {
            clearResultSet(resultSet);
            clearStatement(statement);
            clearConnection(con);
        }

        return max + 1;
    }

    @Override
    public <T> Object insert(T entity) {
        Connection con = DBManager.getConnection();
        Statement statement = null;
        long currentId = 0;
        
        String tableName = EntityUtils.getTableName(entity.getClass());
        List<ColumnInfo> columns = EntityUtils.getColumns(entity.getClass());

        for (ColumnInfo index:columns) {
            if(index.isId()) {
                currentId = getNextIdVal(tableName,index.getDbColumnName());
                index.setValue(getNextIdVal(tableName,index.getDbColumnName()));
            }
            else{
                try {
                    Field currentField = entity.getClass().getDeclaredField(index.getColumnName());
                    currentField.setAccessible(true);
                    index.setValue(currentField.get(entity));
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                    System.out.println("Nu exista acest Field!");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.setTableName(tableName);
        queryBuilder.setQueryType(QueryType.INSERT);
        queryBuilder.addQueryColumns(columns);

        String myQuery = queryBuilder.createQuery();
        //System.out.println(myQuery);

        try {
            statement = con.createStatement();
            int nrx = statement.executeUpdate(myQuery);
            //System.out.println("ROWS UPDATED : " + nrx);
        } catch (SQLException e) {
            //e.printStackTrace();
            System.out.println("Error: Can`t execute query!");
        } finally {
            clearStatement(statement);
            clearConnection(con);
        }

        return findById(entity.getClass(),currentId);
    }

    @Override
    public <T> List<T> findAll(Class<T> entityClass) {
        Connection con = DBManager.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;

        String tableName = EntityUtils.getTableName(entityClass);
        List<ColumnInfo> columns = EntityUtils.getColumns(entityClass);

        QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.setTableName(tableName);
        queryBuilder.setQueryType(QueryType.SELECT);
        queryBuilder.addQueryColumns(columns);

        String myQuery = queryBuilder.createQuery();
        //System.out.println(myQuery);

        ArrayList<T> myList = new ArrayList<>();
        T instance;
        Field instanceField;

        try {
            statement = con.createStatement();
            resultSet = statement.executeQuery(myQuery);

            while(resultSet.next()){
                instance = entityClass.newInstance();

                for (ColumnInfo index:columns) {
                    instanceField = instance.getClass().getDeclaredField(index.getColumnName());
                    instanceField.setAccessible(true);
                    instanceField.set(instance,EntityUtils.
                            castFromSqlType(resultSet.getObject(index.getDbColumnName()),instanceField.getType()));
                }
                myList.add(instance);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Eroare: " + e);
        } finally {
            clearResultSet(resultSet);
            clearStatement(statement);
            clearConnection(con);
        }

        return myList;
    }

    @Override
    public <T> T update(T entity) {
        Connection con = DBManager.getConnection();

        String tableName = EntityUtils.getTableName(entity.getClass());
        List<ColumnInfo> columns = EntityUtils.getColumns(entity.getClass());

        Statement statement = null;
        Condition condition = new Condition();

        String currentColumnName = null;
        long currentId = 0;

        for (ColumnInfo index:columns) {
            try {
                Field currentField = entity.getClass().getDeclaredField(index.getColumnName());
                currentField.setAccessible(true);
                index.setValue(currentField.get(entity));

                if (index.isId()) {
                    if (index.getValue() == null){
                        System.out.println("Id-ul nu poate fi null!");
                        clearConnection(con);
                        return null;
                    }
                    currentId = (long) index.getValue();
                    currentColumnName = index.getDbColumnName();
                    condition.setValue(currentId);
                    condition.setColumnName(currentColumnName);
                }

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Eroare: " + e);
            }
        }

        QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.setTableName(tableName);
        queryBuilder.setQueryType(QueryType.UPDATE);
        queryBuilder.addQueryColumns(columns);
        queryBuilder.addCondition(condition);

        String myQuery = queryBuilder.createQuery();
        //System.out.println(myQuery);

        try {
            statement = con.createStatement();
            int nrx = statement.executeUpdate(myQuery);
            //System.out.println("ROWS UPDATED : " + nrx);
            if (nrx == 0)
                System.out.println("Id-ul nu exista!");
        } catch (SQLException e) {
            //e.printStackTrace();
            System.out.println("Error: Can`t execute query!");
        } finally {
            clearStatement(statement);
            clearConnection(con);
        }

        return (T) findById(entity.getClass(),currentId);
    }

    @Override
    public void delete(Object entity) {
        Connection con = DBManager.getConnection();

        String tableName = EntityUtils.getTableName(entity.getClass());
        List<ColumnInfo> columns = EntityUtils.getColumns(entity.getClass());

        Statement statement = null;
        Condition condition = new Condition();

        String currentColumnName = null;
        long currentId = 0;

        for (ColumnInfo index:columns) {
            try {
                Field currentField = entity.getClass().getDeclaredField(index.getColumnName());
                currentField.setAccessible(true);
                index.setValue(currentField.get(entity));

                if (index.isId()) {
                    if (index.getValue() == null){
                        System.out.println("Id-ul nu poate fi null!");
                        clearConnection(con);
                        return;
                    }
                    currentId = (long) index.getValue();
                    currentColumnName = index.getDbColumnName();
                    condition.setValue(currentId);
                    condition.setColumnName(currentColumnName);
                    break;
                }

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Eroare: " + e);
            }
        }

        QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.setTableName(tableName);
        queryBuilder.setQueryType(QueryType.DELETE);
        queryBuilder.addQueryColumns(columns);
        queryBuilder.addCondition(condition);

        String myQuery = queryBuilder.createQuery();
        //System.out.println(myQuery);

        try {
            statement = con.createStatement();
            int nrx = statement.executeUpdate(myQuery);
            //System.out.println("ROWS UPDATED : " + nrx);
            if (nrx == 0)
                System.out.println("Id-ul nu exista!");
            else
                System.out.println("Row deleted!");
        } catch (SQLException e) {
            //e.printStackTrace();
            System.out.println("Error: Can`t execute query!");
        } finally {
            clearStatement(statement);
            clearConnection(con);
        }

    }

    @Override
    public <T> List<T> findByParams(Class<T> entityClass, Map<String, Object> params) {
        Connection con = DBManager.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;

        String tableName = EntityUtils.getTableName(entityClass);
        List<ColumnInfo> columns = EntityUtils.getColumns(entityClass);

        Condition condition;

        Object currentParam = null;
        String currentColumnName = null;
        boolean ok = false;

        QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.setTableName(tableName);
        queryBuilder.setQueryType(QueryType.SELECT);
        queryBuilder.addQueryColumns(columns);

        //Verify if columns from condition exist in my table
        for (Map.Entry<String,Object> index:params.entrySet()) {

            ok = false;

            for (ColumnInfo ind:columns) {
                if (index.getKey().equals(ind.getDbColumnName()))
                    ok = true;
            }

            if (ok == false) {
                System.out.println("Coloana/Coloanele nu exista!");
                clearConnection(con);
                return null;
            }
        }

        for (ColumnInfo index:columns) {
            try {
                if (params.containsKey(index.getDbColumnName())){
                    condition = new Condition();
                    ok = true;

                    currentParam = params.get(index.getDbColumnName());
                    currentColumnName = index.getDbColumnName();

                    condition.setValue(currentParam);
                    condition.setColumnName(currentColumnName);

                    queryBuilder.addCondition(condition);
                }

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Eroare: " + e);
            }
        }

        String myQuery = queryBuilder.createQuery();
        //System.out.println(myQuery);

        ArrayList<T> myList = new ArrayList<>();
        T instance;
        Field instanceField;

        try {
            statement = con.createStatement();
            resultSet = statement.executeQuery(myQuery);

            while(resultSet.next()){
                instance = entityClass.newInstance();

                for (ColumnInfo index:columns) {
                    instanceField = instance.getClass().getDeclaredField(index.getColumnName());
                    instanceField.setAccessible(true);
                    instanceField.set(instance,EntityUtils.
                            castFromSqlType(resultSet.getObject(index.getDbColumnName()),instanceField.getType()));
                }
                myList.add(instance);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Eroare: " + e);
        } finally {
            clearResultSet(resultSet);
            clearStatement(statement);
            clearConnection(con);
        }

        return myList;
    }

    public void clearResultSet(ResultSet resultSet) {
        if (resultSet != null)
            try {
                resultSet.close();
            } catch (Exception e1) {
                System.out.println("Eroare la inchiderea rezultatului!" + e1);
                System.exit(1);
            }
    }

    public void clearStatement(Statement statement) {
        if (statement != null)
            try {
                statement.close();
            } catch (Exception e2) {
                System.out.println("Eroare la inchiderea statement-ului!" + e2);
                System.exit(1);
            }
    }

    public void clearConnection(Connection connection) {

        if (connection != null)
            try {
                connection.close();
            } catch (Exception e3) {
                System.out.println("Eroare la inchiderea conexiunii!" + e3);
                System.exit(1);
            }
    }


}

