package ro.teamnet.zth.api.em;


import java.util.List;
import java.util.Map;

/**
 * Created by Claudiu.Brandabur on 13-Jul-17.
 */
public interface EntityManager {

    <T> T findById (Class<T> entityClass, Long id);
    long getNextIdVal (String tableName, String columnIdName);
    <T> Object insert(T entity);
    <T> List<T> findAll(Class<T> entityClass);
    <T> T update(T entity);
    void delete(Object entity);
    <T> List<T> findByParams(Class<T> entityClass, Map<String, Object> params);
    <T> List<T> myFindMethod(String string);
    <T> void multipleInsert(List<T> enities);

}
