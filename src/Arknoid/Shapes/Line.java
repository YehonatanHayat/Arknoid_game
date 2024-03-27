
// Yehonatan Hayat
// ID 318228046

package Arknoid.Shapes;
import java.util.List;


/**
 * The type Line.
 */
public class Line {
    private Point start;
    private Point end;
    private double slope;
    private double temp;


    /**
     * Instantiates a new Line.
     *
     * @param start the start
     * @param end   the end
     */
    public Line(Point start, Point end) {
        // Setting Variables
        this.start = start;
        this.end = end;
        this.calculateSlopeAndB();
    }


    /**
     * Instantiates a new Line.
     *
     * @param x1 the x 1
     * @param y1 the y 1
     * @param x2 the x 2
     * @param y2 the y 2
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
        this.calculateSlopeAndB();
    }


    private void calculateSlopeAndB() {
        // to measure slope
        double dy = this.start.getY() - this.end.getY();
        double dx = this.start.getX() - this.end.getX();
        this.slope = dy / dx;

        // if the slope is a straight line from x down , no intersection with y (or on y in a straight line)
        if (dx == 0) {
            this.slope = Double.POSITIVE_INFINITY;
            this.temp = Double.POSITIVE_INFINITY;
        } else {
            this.slope = dy / dx;
            this.temp = this.start.getY() - this.slope * this.start.getX();
        }
    }


    /**
     * Length double.
     *
     * @return the double
     */
    public double length() {
        return this.start.distance(this.end);
    }


    /**
     * Middle point.
     *
     * @return the point
     */
    public Point middle() {
        double middleX = (this.start.getX() + this.end.getX()) / 2;
        double middleY = (this.start.getY() + this.end.getY()) / 2;

        return new Point(middleX, middleY);
    }


    /**
     * Start point.
     *
     * @return the point
     */
    public Point start() {
        return this.start;
    }


    /**
     * End point.
     *
     * @return the point
     */
    public Point end() {
        return this.end;
    }


    /**
     * Is intersecting boolean.
     *
     * @param other the other
     * @return the boolean
     */
    public boolean isIntersecting(Line other) {
        Point inter = this.intersectionWith(other);

        return inter != null;
    }


    /**
     * Intersection with point.
     *
     * @param other the other
     * @return the point
     */
    public Point intersectionWith(Line other) {
        double db;
        double dm;
        Point inter;

        // line are parallel to y if they don't have mutual points return null
        if (this.slope == Double.POSITIVE_INFINITY && other.slope == Double.POSITIVE_INFINITY) {
            if (this.start.equals(other.start) || this.start.equals(other.end)) {
                return this.start;
            }

            if (this.end.equals(other.start) || this.end.equals(other.end)) {
                return this.end;
            }
            return null;
        }

        // if one of them is infinity (no intersection with y or is on y)
        if (this.slope == Double.POSITIVE_INFINITY || other.slope == Double.POSITIVE_INFINITY) {
            if (this.slope == Double.POSITIVE_INFINITY) {
                double xI = this.start.getX();
                // y= m2x+b2
                double yI = other.slope * xI + other.temp;
                inter = new Point(xI, yI);
            } else {
                double xI = other.start.getX();
                double yI = this.slope * xI + this.temp;
                inter = new Point(xI, yI);
            }
        } else {
            db = this.temp - other.temp;
            dm = other.slope - this.slope;
            if (dm == 0) {
                if (this.start.equals(other.start) || this.start.equals(other.end)) {
                    return this.start;
                }

                if (this.end.equals(other.start) || this.end.equals(other.end)) {
                    return this.end;
                }
                return null;
            }
            double xI = db / dm;
            double yI = this.slope * xI + this.temp;
            inter = new Point(xI, yI);
        }
        if (this.isPointOnLine(inter) && other.isPointOnLine(inter)) {
            return inter;
        }
        return null;
    }


    /**
     * Is point on the line boolean.
     *
     * @param p the point
     * @return the boolean
     */
    public boolean isPointOnLine(Point p) {
        double xMin;
        double yMin;
        double xMax;
        double yMax;

        xMin = Math.min(this.start.getX(), this.end.getX());
        yMin = Math.min(this.start.getY(), this.end.getY());
        xMax = Math.max(this.start.getX(), this.end.getX());
        yMax = Math.max(this.start.getY(), this.end.getY());

        boolean isXInRange = xMin <= p.getX() && p.getX() <= xMax;
        boolean isYInRange = yMin <= p.getY() && p.getY() <= yMax;

        return isXInRange && isYInRange;
    }


    /**
     * Equals boolean.
     *
     * @param other the other
     * @return the boolean
     */
    public boolean equals(Line other) {
        boolean isSameStartEnd = this.start.equals(other.start) && this.end.equals(other.end);
        boolean isOpposite = this.end.equals(other.start) && this.start.equals(other.end);

        return isSameStartEnd || isOpposite;
    }


    /**
     * Closest intersection to start of line point.
     *
     * @param rect the rectangle
     * @return the closest intersection point
     * and Null If this line does not intersect with the rectangle
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> intersect = rect.intersectionPoints(this);

        Point minPoint = null;
        double minDist = this.length();

        for (Point p: intersect) {
            double distance = p.distance(this.start);
            if (distance < minDist) {
                minDist = distance;
                minPoint = p;
            }
        }
        return minPoint;
    }
}
