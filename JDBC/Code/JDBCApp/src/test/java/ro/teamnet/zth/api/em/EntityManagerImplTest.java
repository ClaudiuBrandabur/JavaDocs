package ro.teamnet.zth.api.em;

import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Location;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Claudiu.Brandabur on 13-Jul-17.
 */
public class EntityManagerImplTest {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        EntityManagerImpl myEntity = new EntityManagerImpl();
        System.out.print("method 1: " + myEntity.findById(Department.class, (long) 10));

        System.out.println("method 2: " + myEntity.getNextIdVal("DEPARTMENTS","DEPARTMENT_ID"));

        System.out.print("method 3: ");

        Department d = new Department();
        d.setDepartmentName("MyDep");
        d.setLocation(Long.valueOf(1700));
        //System.out.print(myEntity.insert(d));;

        Location l = new Location();
        l.setCity("BUCURESTI");
        l.setPostalCode("120201");
        l.setStateProvince("bucuresti");
        l.setStreetAddress("Splaiul Independentei");
        //System.out.println(myEntity.insert(l));

        System.out.println("method 4: " + myEntity.findAll(Department.class));

        System.out.print("method 5: ");
        Department d1 = new Department();
        d1.setId(Long.valueOf(271));
        d1.setDepartmentName("AnotherDepartment");
        d1.setLocation(Long.valueOf(1000));
        System.out.print(myEntity.update(d1));;

        System.out.print("method 6: ");
        Location l1 = new Location();
        l1.setId(Long.valueOf(3222));
        myEntity.delete(l1);
//        Location l2 = new Location();
//        l2.setId(Long.valueOf(3202));
//        myEntity.delete(l2);
//        Location l3 = new Location();
//        l3.setId(Long.valueOf(3203));
//        myEntity.delete(l3);
//        Location l4 = new Location();
//        l4.setId(Long.valueOf(3204));
//        myEntity.delete(l4);

        System.out.print("method 7: ");
        Location loc = new Location();
        loc.setCity("BUZAU");
        loc.setPostalCode("120201");
        loc.setStateProvince("buzau");
        loc.setStreetAddress("Splaiul Independentei");
        //System.out.print(myEntity.insert(loc));
        Location loc1 = new Location();
        loc1.setCity("BUZAU");
        loc1.setPostalCode("115332");
        loc1.setStateProvince("buzau");
        loc1.setStreetAddress("Razboieni");
        //System.out.print(myEntity.insert(loc1));
        Location loc3 = new Location();
        loc3.setCity("BUZAU");
        loc3.setPostalCode("024985");
        loc3.setStateProvince("buzau");
        loc3.setStreetAddress("Unirii");
        //System.out.print(myEntity.insert(loc3));
        Map<String,Object> myMap = new HashMap<>();
        myMap.put("city","BUZAU");
        myMap.put("state_province","buzau");
        System.out.println(myEntity.findByParams(Location.class,myMap));

        System.out.println("method 8: ");


        long endTime = System.currentTimeMillis();

        long duration = (endTime - startTime);
        System.out.println("Time to execute main: " + duration + " ms");
    }

}
