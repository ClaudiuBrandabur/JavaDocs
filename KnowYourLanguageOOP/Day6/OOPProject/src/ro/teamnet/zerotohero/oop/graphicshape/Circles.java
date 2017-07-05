package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Claudiu.Brandabur on 04-Jul-17.
 */
public class Circles {

    public double getAreaPub(){
        Circle c1 = new Circle();
        return c1.area();
    }

    public void getAreaDef(){
        Circle c2 = new Circle();
        c2.fillColour();
        c2.fillColour(4);
        c2.fillColour(5.6f);
    }
}
