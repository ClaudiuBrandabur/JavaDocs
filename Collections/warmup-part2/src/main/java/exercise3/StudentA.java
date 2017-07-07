package exercise3;

/**
 * Created by Claudiu.Brandabur on 07-Jul-17.
 */
public class StudentA extends Student {

    public StudentA() {
    }

    public StudentA(String firstName, String lastName) {
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
        StudentA stud = (StudentA) o;
        if ( getFirstName().equals(stud.getFirstName()) )
            return true;
        return false;
    }
}
