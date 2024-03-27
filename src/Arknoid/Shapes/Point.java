
// Yehonatan Hayat
// ID 318228046

package Arknoid.Shapes;

/**
 * The type Point.
 */
public class Point {
    private double x;
    private double y;


    /**
     * Instantiates a new Point.
     *
     * @param x the x
     * @param y the y
     */
    public Point(double x, double y) {

        this.x = x;
        this.y = y;
    }


    /**
     * Distance double.
     *
     * @param other the other
     * @return the double
     */
    public double distance(Point other) {
        double disX = this.x - other.getX();
        double disY = this.y - other.getY();

        double disXsq = Math.pow(disX, 2);
        double disYsq = Math.pow(disY, 2);
        double distance = Math.sqrt(disXsq + disYsq);

        return distance;
    }


    /**
     * Equals boolean.
     *
     * @param other the other
     * @return the boolean
     */
    public boolean equals(Point other) {
        boolean isXEqual;
        boolean isYEqual;

        isXEqual = this.x == other.getX();
        isYEqual = this.y == other.getY();

        return isXEqual && isYEqual;
    }


    /**
     * Gets x.
     *
     * @return the x
     */
    public double getX() {
        return this.x;
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public double getY() {
        return this.y;
    }
}
