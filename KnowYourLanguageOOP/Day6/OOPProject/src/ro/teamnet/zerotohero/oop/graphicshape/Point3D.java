package ro.teamnet.zerotohero.oop.graphicshape;
import ro.teamnet.zerotohero.oop.graphicshape.Point;

/**
 * Created by Claudiu.Brandabur on 04-Jul-17.
 */
public class Point3D extends Point{

    private int zPos;

    public Point3D(int xPos, int yPos, int zPos) {
        super(xPos, yPos);
        this.zPos = zPos;
    }
}
