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
            clearStatementAndConnection(statement, con);
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
            clearStatementAndConnection(statement, con);
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
            clearStatementAndConnection(statement, con);
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
            clearStatementAndConnection(statement, con);
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

    public void clearStatementAndConnection(Statement statement, Connection connection) {
        if (statement != null)
            try {
                statement.close();
            } catch (Exception e2) {
                System.out.println("Eroare la inchiderea statement-ului!" + e2);
                System.exit(1);
            }
        if (connection != null)
            try {
                connection.close();
            } catch (Exception e3) {
                System.out.println("Eroare la inchiderea conexiunii!" + e3);
                System.exit(1);
            }
    }


}

