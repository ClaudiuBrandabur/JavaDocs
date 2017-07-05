package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Claudiu.Brandabur on 04-Jul-17.
 */
public class Shape extends AbstractShape implements ShapeBehavior{

    protected int color;
    protected float saturation;

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public float getSaturation() {
        return saturation;
    }

    public void setSaturation(float saturation) {
        this.saturation = saturation;
    }

    public double area(){
        System.out.println("Shape Class");
        double value = 12.45;
        return value;
    }
}
