
// Yehonatan Hayat
// ID 318228046

package Arknoid.GameSetup;
import Arknoid.Interfaces.Collidable;
import Arknoid.Shapes.Point;

/**
 * The type Collision info.
 */
public class CollisionInfo {

    private final Collidable c;
    private final Point point;


    /**
     * Instantiates a new Collision info.
     *
     * @param c the collidable
     * @param p   the point
     */
    public CollisionInfo(Collidable c, Point p) {
        this.c = c;
        this.point = p;
    }


    /**
     * Collision point.
     *
     * @return the point
     */
    public Point collisionPoint() {
        return this.point;
    }

    /**
     * Collision object collidable.
     *
     * @return the collidable
     */
    public Collidable collisionObject() {
        return this.c;
    }


}

