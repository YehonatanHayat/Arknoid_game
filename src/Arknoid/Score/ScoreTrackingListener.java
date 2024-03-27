
// Yehonatan Hayat
// ID 318228046

package Arknoid.Score;
import Arknoid.GameSetup.Counter;
import Arknoid.Interfaces.HitListener;
import Arknoid.Shapes.Ball;
import Arknoid.Shapes.Block;

/**
 * The type Score tracking listener.
 */
public class ScoreTrackingListener implements HitListener {
    private final Counter scoreUntilNow;
    /**
     * Instantiates a new Score tracking listener.
     *
     * @param scoreCounter the score counter
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.scoreUntilNow = scoreCounter;
    }
@Override
    public void hitEvent(Block beingHit, Ball hitter) {
        scoreUntilNow.increase(5);
    }
}