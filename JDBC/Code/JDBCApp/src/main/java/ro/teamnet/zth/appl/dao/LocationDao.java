package ro.teamnet.zth.appl.dao;

import ro.teamnet.zth.api.em.EntityManager;
import ro.teamnet.zth.api.em.EntityManagerImpl;
import ro.teamnet.zth.api.em.EntityUtils;
import ro.teamnet.zth.appl.domain.Location;

import java.util.List;
import java.util.Map;

/**
 * Created by Claudiu.Brandabur on 14-Jul-17.
 */
public class LocationDao {

    private EntityManager entityManager;

    public LocationDao() {
        this.entityManager = new EntityManagerImpl();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Location findById (Long id) {
        return entityManager.findById(Location.class,id);
    }

    public long getNextIdVal (String columnIdName){
        return entityManager.getNextIdVal(EntityUtils.getTableName(Location.class),columnIdName);
    }

    public Location insert(Location location){
        return (Location) entityManager.insert(location);
    }

    public List<Location> findAll(){
        return entityManager.findAll(Location.class);
    }

    public Location update(Location location){
        return entityManager.update(location);
    }

    public void delete(Location location){
        entityManager.delete(location);
    }

    public List<Location> findByParams(Map<String, Object> params){
        return entityManager.findByParams(Location.class,params);
    }
}
