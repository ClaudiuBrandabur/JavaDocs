package ro.teamnet.zerotohero.oop.graphicshape;
import static java.lang.Math.PI;

/**
 * Created by Claudiu.Brandabur on 04-Jul-17.
 */
public class Circle extends Shape{

    private int xPos;
    private int yPos;
    private int radius;

    public Circle() {
        this.xPos = 7;
        this.yPos = 8;
        this.radius = 12;
    }

    public Circle(int xPos) {
        this.xPos = xPos;
    }

    public Circle(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public Circle(int xPos, int yPos, int radius) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = radius;
    }

    public double area(){
        System.out.println("Circle class");
        return PI*this.radius*this.radius;
    }

    public String toString(){
        return "center = ( "+xPos+" , "+yPos+ ") and radius = "+radius;
    }

    public void fillColour(){
        System.out.println("Super class color = "+super.getColor());
    }

    public void fillColour(int color){
        super.setColor(color);
        System.out.println("The circle color is now = "+super.getColor());
    }

    public void fillColour(float saturation){
        super.setSaturation(saturation);
        System.out.println("The circle saturation is now = "+super.getSaturation());
    }

}
