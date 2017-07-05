package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Claudiu.Brandabur on 04-Jul-17.
 */
public class Square extends Shape{

    private int side;

    public Square(int side) {
        this.side = side;
    }

    public double area(){
        return this.side*this.side;
    }
}
