package exercise3;

/**
 * Created by Claudiu.Brandabur on 07-Jul-17.
 */
public class StudentD extends Student {

    public StudentD() {
    }

    public StudentD(String firstName, String lastName) {
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
        StudentD stud = (StudentD) o;
        if ( getFirstName().equals(stud.getFirstName()) && getLastName().equals(stud.getLastName()) )
            return true;
        return false;
    }
}
