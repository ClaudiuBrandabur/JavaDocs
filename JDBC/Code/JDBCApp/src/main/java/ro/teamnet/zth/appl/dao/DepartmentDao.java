package ro.teamnet.zth.appl.dao;

import ro.teamnet.zth.api.em.EntityManager;
import ro.teamnet.zth.api.em.EntityManagerImpl;
import ro.teamnet.zth.api.em.EntityUtils;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Location;

import java.util.List;
import java.util.Map;

/**
 * Created by Claudiu.Brandabur on 14-Jul-17.
 */
public class DepartmentDao {

    private EntityManager entityManager;

    public DepartmentDao() {
        this.entityManager = new EntityManagerImpl();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Department findById (Long id) {
        return entityManager.findById(Department.class,id);
    }

    public long getNextIdVal (String columnIdName){
        return entityManager.getNextIdVal(EntityUtils.getTableName(Department.class),columnIdName);
    }

    public Department insert(Department department){
        return (Department) entityManager.insert(department);
    }

    public List<Department> findAll(){
        return entityManager.findAll(Department.class);
    }

    public Department update(Department department){
        return entityManager.update(department);
    }

    public void delete(Department department){
        entityManager.delete(department);
    }

    public List<Department> findByParams(Map<String, Object> params){
        return entityManager.findByParams(Department.class,params);
    }

}
