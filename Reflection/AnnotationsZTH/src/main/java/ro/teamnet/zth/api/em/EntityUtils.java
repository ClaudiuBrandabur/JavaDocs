package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Location;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by Claudiu.Brandabur on 12-Jul-17.
 */
public class EntityUtils {

    private EntityUtils() throws UnsupportedOperationException {
    }

    public static String getTableName(Class entity) {
        if( entity.isAnnotationPresent(Table.class) )
            return ( (Table)entity.getAnnotation(Table.class) ).name();
        return entity.getName();
    }

    public static ArrayList<ColumnInfo> getColumns(Class entity) {
        Field[] fields = entity.getDeclaredFields();
        ArrayList<ColumnInfo> result = new ArrayList<>();
        ColumnInfo coloana;

        for(int i=0; i<fields.length; i++) {
            if (fields[i].isAnnotationPresent(Column.class) ||
                    fields[i].isAnnotationPresent(Id.class)) {
                coloana = new ColumnInfo();

                if (fields[i].isAnnotationPresent(Column.class)) {
                    //coloana.setColumnName(fields[i].getName());
                    //coloana.setColumnType(fields[i].getType());
                    coloana.setDbColumnName(fields[i].getAnnotation(Column.class).name());
                    coloana.setId(false);
                }

                if (fields[i].isAnnotationPresent(Id.class)) {
                    //coloana.setColumnName(fields[i].getName());
                    //coloana.setColumnType(fields[i].getType());
                    coloana.setDbColumnName(fields[i].getAnnotation(Id.class).name());
                    coloana.setId(true);
                }

                coloana.setColumnName(fields[i].getName());
                coloana.setColumnType(fields[i].getType());

                result.add(coloana);
            }
        }

        return result;
    }

    public static Object castFromSqlType(Object value, Class wantedType){

        if ( value instanceof BigDecimal && wantedType.equals(Integer.class))
            return ((BigDecimal) value).intValue();

        if ( value instanceof BigDecimal && wantedType.equals(Long.class))
            return ((BigDecimal) value).longValue();

        if ( value instanceof BigDecimal && wantedType.equals(Float.class))
            return ((BigDecimal) value).floatValue();

        if ( value instanceof BigDecimal && wantedType.equals(Double.class))
            return ((BigDecimal) value).doubleValue();

        if (!(value instanceof BigDecimal))
            return value;

        return null;
    }

    public static ArrayList<Field> getFieldsByAnnotations(Class clazz, Class annotation){

        ArrayList<Field> result = new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields();

        for (int i=0; i<fields.length; i++)
            if (fields[i].isAnnotationPresent(annotation))
                result.add(fields[i]);

        return result;
    }

    public static void myPrint(ArrayList<Field> f){
        for(int i=0; i<f.size(); i++)
            System.out.println("name: " + f.get(i).getName() + " ; type: " + f.get(i).getType().getSimpleName());
    }

    public static Object getSqlValue(Object object) throws IllegalAccessException {
        if( object.getClass().isAnnotationPresent(Table.class) ){

            Field[] fields = object.getClass().getDeclaredFields();

            for (int i=0; i < fields.length; i++)
                if ( fields[i].isAnnotationPresent(Id.class) ){
                    fields[i].setAccessible(true);
                    return fields[i].get(object);
                }
        }
        return object;
    }

    public static void main(String[] args) throws IllegalAccessException {
        System.out.println(EntityUtils.getTableName(Department.class));
        System.out.println(EntityUtils.getColumns(Department.class));
        System.out.println(EntityUtils.castFromSqlType(new BigDecimal(9),Float.class));
        myPrint(EntityUtils.getFieldsByAnnotations(Department.class,Column.class));
        System.out.println(EntityUtils.getSqlValue
                (new Department(12,"IT", new Location
                                        (123,"Tudor Vladimirescu","120201",
                                        "Bucuresti","Bucuresti"))));
    }
}
