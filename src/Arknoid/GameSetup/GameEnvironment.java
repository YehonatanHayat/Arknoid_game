
// Yehonatan Hayat
// ID 318228046

package Arknoid.GameSetup;
import Arknoid.Interfaces.Collidable;
import Arknoid.Shapes.Line;
import Arknoid.Shapes.Point;
import java.util.ArrayList;
import java.util.List;


/**
 * The type Game environment.
 */
public class GameEnvironment {

    private final List<Collidable> collidables;


    /**
     * Instantiates a new Game environment.
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<>();
    }


    /**
     * Add collidable.
     *
     * @param c the collidable
     */
    public void addCollidable(Collidable c) {
        this.collidables.add(c);
    }


    /**
     * Gets closest collision.
     *
     * @param trajectory the trajectory
     * @return return the information about the closest collision
     *  If this object will not collide with any of the collidables in this collection, return null
     */
    public CollisionInfo getClosestCollision(Line trajectory) {

        Collidable minColid = null;
        Point minPoint = null;
        double minDist = trajectory.length();

        // closest intersection on this rectangle
        for (Collidable c: new ArrayList<>(this.collidables)) {
            Point p = trajectory.closestIntersectionToStartOfLine(c.getCollisionRectangle());
            if (p == null) {
                continue;
            }

            double distance = trajectory.start().distance(p);
            if (distance < minDist) {
                minColid = c;
                minPoint = p;
                minDist = distance;
            }
        }
       return new CollisionInfo(minColid, minPoint);
    }


    /**
     * Remove collidable.
     *
     * @param c the collidable
     */
    public void removeCollidable(Collidable c) {
        this.collidables.remove(c);
    }
}

