package exercise3;

/**
 * Created by Claudiu.Brandabur on 07-Jul-17.
 */
public class StudentB extends Student {

    public StudentB() {
    }

    public StudentB(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public int hashCode(){
        return getFirstName().hashCode();
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        StudentB stud = (StudentB) o;
        if ( getFirstName().equals(stud.getFirstName()) && getLastName().equals(stud.getLastName()) )
            return true;
        return false;
    }
}
