package ro.teamnet.zerotohero.exceptions;

/**
 * Created by Claudiu.Brandabur on 04-Jul-17.
 */
public class Calculate {

    private float a;
    private float b;

    public Calculate(float a, float b) {
        this.a = a;
        this.b = b;
    }

    public float getA() {
        return a;
    }

    public void setA(float a) {
        this.a = a;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }

    public float add(float a, float b) throws MyException{
        if( a > 10 ) throw new MyException("Numar a trebuie sa fie mai mic ca 10!");
        return a+b;
    }

    public float substract(float a, float b) throws MyException1{
        if ( a == b ) throw new MyException1("Numerele sunt identice!");
        if ( a < b ) throw new MyException1("Numarul a este mai mic decat numarul b!");
        return a-b;
    }

    public float multiply(float a, float b) throws MyException2{
        if ( a == 0 || b == 0 ) throw new MyException2("Numerele trebuie sa fie diferite de 0!");
        return a*b;
    }

    public float divide(float a, float b) throws MyException3{
        if ( b == 0 ) throw new MyException3("Nu se poate imparti la 0! Numarul b nu poate fi 0!");
        if ( a == 0 ) throw new  MyException3("Numarul a este 0!");
        return a/b;
    }

}
