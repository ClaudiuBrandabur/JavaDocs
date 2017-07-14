package ro.teamnet.zth.appl;

import ro.teamnet.zth.appl.dao.DepartmentDao;
import ro.teamnet.zth.appl.domain.Department;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Claudiu.Brandabur on 14-Jul-17.
 */
public class DepartmentDaoTest {

    public static void main(String[] args) {

        DepartmentDao dd = new DepartmentDao();

        System.out.print("find by id: " + dd.findById((long) 60));
        System.out.println("get next id val: " + dd.getNextIdVal("DEPARTMENT_ID"));

        System.out.println("insert: ");
        Department d = new Department();
        d.setDepartmentName("MyDep");
        d.setLocation(Long.valueOf(1700));
        //System.out.println(dd.insert(d));

        System.out.println("find all: " + dd.findAll());

        Department d1 = new Department();
        d1.setId(Long.valueOf(271));
        d1.setDepartmentName("AnotherDepartment4TheWin");
        d1.setLocation(Long.valueOf(1000));
        System.out.print("update: " + dd.update(d1));

        System.out.print("delete: ");
        Department d2 = new Department();
        d2.setId(Long.valueOf(3222));
        dd.delete(d2);

        System.out.println("find by params: ");
        Map<String,Object> myMap = new HashMap<>();
        myMap.put("location_id",1700);
        System.out.println(dd.findByParams(myMap));

    }

}
