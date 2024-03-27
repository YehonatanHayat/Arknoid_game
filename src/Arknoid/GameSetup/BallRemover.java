// Yehonatan Hayat
// ID 318228046

package Arknoid.GameSetup;
import Arknoid.Interfaces.HitListener;
import Arknoid.Shapes.Ball;
import Arknoid.Shapes.Block;


/**
 * The type Ball remover.
 */
public class BallRemover implements HitListener {
    private  final GameLevel game;
    private final Counter counter;


    /**
     * Instantiates a new Ball remover.
     *
     * @param game    the game
     * @param counter the counter
     */
    public BallRemover(GameLevel game, Counter counter) {
        this.game = game;
        this.counter = counter;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
        this.counter.decrease(1);
    }
}
