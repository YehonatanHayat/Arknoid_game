
// Yehonatan Hayat
// ID 318228046

package Arknoid.Interfaces;
import Arknoid.Shapes.Ball;
import Arknoid.Shapes.Block;


/**
 * The interface Hit listener.
 */
public interface HitListener {

    /**
     * Hit event.
     *
     * @param beingHit the being hit
     * @param hitter   the hitter
     */
    // This method is called whenever the beingHit object is hit.
    // The hitter parameter is the Ball that's doing the hitting.
    void hitEvent(Block beingHit, Ball hitter);
}
