package ro.teamnet.zerotohero.reflection.demoobjects;

/**
 * Created by Claudiu.Brandabur on 12-Jul-17.
 */
public class MyNumber{

    private int aNumber = 56;
    private int bNumber = 67;
    public int cNumber;
    public int dNumber;

    public MyNumber() {
        System.out.println("Constructor gol");
    }

    public MyNumber(int aNumber, int bNumber) {
        this.aNumber = aNumber;
        this.bNumber = bNumber;
        System.out.println("Constructor cu 2 parametrii");
    }

    public int getaNumber() {
        return aNumber;
    }

    public void setaNumber(int aNumber) {
        this.aNumber = aNumber;
    }

    public int getbNumber() {
        return bNumber;
    }

    public void setbNumber(int bNumber) {
        this.bNumber = bNumber;
    }

    class SpecificNumberClass {
        int i = 0;
    }

    class OtherSpecificNumberClass {
        int i = 0;
    }

    public int add(int aNumber, int bNumber){
        return aNumber + bNumber;
    }
}
