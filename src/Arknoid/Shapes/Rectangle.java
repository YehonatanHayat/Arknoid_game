
// Yehonatan Hayat
// ID 318228046

package Arknoid.Shapes;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Rectangle.
 */
public class Rectangle {

    private Point upperLeft;
    private Line[] lines;
    private double width;
    private double height;


    /**
     * Gets width.
     *
     * @return the width
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Gets height.
     *
     * @return the height
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Gets upper left.
     *
     * @return the upper left
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * Instantiates a new Rectangle.
     *
     * @param upperLeft the upper left
     * @param width     the width
     * @param height    the height
     *                  Create a new rectangle with location and width/height.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
        Point upperRight = new Point(upperLeft.getX() + width, upperLeft.getY());
        Point downLeft = new Point(upperLeft.getX(), upperLeft.getY() + height);
        Point downRight = new Point(upperLeft.getX() + width, upperLeft.getY() + height);

        Line up = new Line(upperLeft, upperRight);
        Line right = new Line(upperRight, downRight);
        Line down = new Line(downRight, downLeft);
        Line left = new Line(downLeft, upperLeft);

        // clockwise
        this.lines = new Line[]{up, right, down, left};
    }

    /**
     * Get lines line [ ].
     *
     * @return the line [ ]
     */
    public Line[] getLines() {
        return this.lines;
    }
    /**
     * Intersection points java . util . list.
     *
     * @param line the line
     * @return a (possibly empty) List of intersection points with the specified line.
     */
    public java.util.List<Point> intersectionPoints(Line line) {

        List<Point> intersPoints = new ArrayList<>();

        for (Line l : this.lines) {
            // p is intersection point
            Point p = l.intersectionWith(line);
            if (p != null) {
                // to add to lists
                intersPoints.add(p);
            }
        }
        return intersPoints;
    }

}
