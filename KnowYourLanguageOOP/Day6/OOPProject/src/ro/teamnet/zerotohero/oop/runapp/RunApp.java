package ro.teamnet.zerotohero.oop.runapp;
import ro.teamnet.zerotohero.canvas.Canvas;
import ro.teamnet.zerotohero.oop.graphicshape.*;

/**
 * Created by Claudiu.Brandabur on 04-Jul-17.
 */
public class RunApp {

    public static void main(String[] args){

        Circles c = new Circles();
        System.out.println("The default circle area is: " + c.getAreaPub());
        c.getAreaDef();
        Canvas canv = new Canvas();
        //canv.paint();
        Shape s = new Circle(10,10,4);
        System.out.println("Circle area: "+s.area());
        ShapeBehavior s1 = new Square(10);
        System.out.println("Square area: "+s1.area());

        Object p1 = new Point(10, 20);
        Object p2 = new Point(50, 100);
        Object p3 = new Point(10, 20);

        System.out.println("p1 equals p2 is " + p1.equals(p2));
        System.out.println("p1 equals p3 is " + p1.equals(p3));


    }

}
