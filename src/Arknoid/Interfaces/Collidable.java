
// Yehonatan Hayat
// ID 318228046

package Arknoid.Interfaces;
import Arknoid.GameSetup.Velocity;
import Arknoid.Shapes.Ball;
import Arknoid.Shapes.Point;
import Arknoid.Shapes.Rectangle;


/**
 * The interface Collidable.
 */
public interface Collidable {

    /**
     * Gets collision rectangle.
     *
     * @return the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();


    /**
     * Hit velocity.
     *
     * @param hitter          the hitter
     * @param collisionPoint  the collision point
     * @param currentVelocity the current velocity
     * @return the velocity
     */
    // Notify the object that we collided with it at collisionPoint with
    // a given velocity.
    // The return is the new velocity expected after the hit (based on
    // the force the object inflicted on us).
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
