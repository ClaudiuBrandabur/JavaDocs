package exercise3;

/**
 * Created by Claudiu.Brandabur on 07-Jul-17.
 */
public class StudentC extends Student {

    public StudentC() {
    }

    public StudentC(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public int hashCode(){
        int result = 1;
        result = 17 * result + getLastName().hashCode();
        result = 17 * result + getFirstName().hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        StudentC stud = (StudentC) o;
        if ( getFirstName().equals(stud.getFirstName()) )
            return true;
        return false;
    }
}
