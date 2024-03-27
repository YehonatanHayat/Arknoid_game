
// Yehonatan Hayat
// ID 318228046


package Arknoid.GameSetup;
import Arknoid.Shapes.Point;


/**
 * The type Velocity.
 */
public class Velocity {
    private double dx;
    private double dy;


    /**
     * Instantiates a new Velocity.
     *
     * @param dx the dx
     * @param dy the dy
     */
// constructor
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }


    /**
     * Apply to point.
     *
     * @param p the point
     * @return new point with position (x+dx, y+dy)
     */
    public Point applyToPoint(Point p) {
        Point nextPoint = new Point(p.getX() + this.dx, p.getY() + this.dy);
        return nextPoint;
    }

    /**
     * From angle and speed velocity.
     *
     * @param angle the angle
     * @param speed the speed
     * @return the velocity
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double angleRad = Math.toRadians(angle);
        double dx = Math.sin(angleRad) * speed;
        double dy = -Math.cos(angleRad) * speed;
        return new Velocity(dx, dy);
    }

    /**
     * Gets dx.
     *
     * @return the dx
     */
    public double getDx() {
        return dx;
    }


    /**
     * Gets dy.
     *
     * @return the dy
     */
    public double getDy() {
        return dy;
    }
}

