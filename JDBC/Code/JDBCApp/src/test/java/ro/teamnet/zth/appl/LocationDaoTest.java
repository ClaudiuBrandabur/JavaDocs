package ro.teamnet.zth.appl;

import ro.teamnet.zth.appl.dao.LocationDao;
import ro.teamnet.zth.appl.domain.Location;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Claudiu.Brandabur on 14-Jul-17.
 */
public class LocationDaoTest {

    public static void main(String[] args) {

        LocationDao ld = new LocationDao();

        System.out.print("find by id: " + ld.findById((long) 60));
        System.out.println("get next id val: " + ld.getNextIdVal("LOCATION_ID"));

        System.out.println("insert: ");
        Location l = new Location();
        l.setStreetAddress("Independentei");
        l.setStateProvince("buzau");
        l.setPostalCode("123123");
        l.setCity("BUZAU");
        System.out.println(ld.insert(l));

        System.out.println("find all: " + ld.findAll());

        System.out.print("update: ");
        Location l1 = new Location();
        l1.setId(Long.valueOf(271));
        l1.setStreetAddress("Independentei");
        l1.setStateProvince("buzau");
        l1.setPostalCode("123123");
        l1.setCity("BUZAU");
        System.out.print(ld.update(l1));

        System.out.print("delete: ");
        Location l2 = new Location();
        l2.setId(Long.valueOf(3222));
        ld.delete(l2);

        Map<String,Object> myMap = new HashMap<>();
        myMap.put("city","BUZAU");
        myMap.put("state_province","buzau");
        System.out.println("find by params: " + ld.findByParams(myMap));

    }

}
