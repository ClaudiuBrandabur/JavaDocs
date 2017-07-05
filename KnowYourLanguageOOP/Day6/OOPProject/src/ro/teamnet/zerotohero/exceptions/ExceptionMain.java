package ro.teamnet.zerotohero.exceptions;

import ro.teamnet.zerotohero.oop.graphicshape.Circle;

import java.io.IOException;

/**
 * Created by Claudiu.Brandabur on 04-Jul-17.
 */
public class ExceptionMain {
    public static void main(String[] args) throws Exception1 {

        Calculate compute = new Calculate(3,5);

        try {
            compute.add(21,9);
        } catch (MyException e) {
            System.out.println(e.getMessage());
            Exception1 exceptieNoua = new Exception1("!!");
            throw exceptieNoua;


            //e.printStackTrace();
        }
        finally {
            System.out.println("Goodbye!");
        }

        try {
            compute.add(66,9);
            compute.substract(4,4);
            compute.multiply(0,4);
            compute.divide(5,0);
        } catch (MyException | MyException1 | MyException2 | MyException3 e) {
            System.out.println(e.getMessage());

            //e.printStackTrace();
        }
        finally {
            System.out.println("Goodbyeee!");
        }



    }
}
