package ro.teamnet.zth.api.em;

import ro.teamnet.zth.appl.domain.Department;

/**
 * Created by Claudiu.Brandabur on 13-Jul-17.
 */
public class EntityManagerImplTest {

    public static void main(String[] args) {
        EntityManagerImpl myEntity = new EntityManagerImpl();
        System.out.print("method 1: " + myEntity.findById(Department.class, (long) 10));

        System.out.println("method 2: " + myEntity.getNextIdVal("DEPARTMENTS","DEPARTMENT_ID"));

        System.out.print("method 3: ");
        Department d = new Department();
        d.setDepartmentName("MyDep");
        d.setLocation(Long.valueOf(1700));
        System.out.print(myEntity.insert(d));;

        System.out.println("method 4: " + myEntity.findAll(Department.class));
    }
}
