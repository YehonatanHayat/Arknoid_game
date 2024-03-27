// Yehonatan Hayat
// ID 318228046

package Arknoid.GameSetup;
import Arknoid.Interfaces.HitListener;
import Arknoid.Shapes.Ball;
import Arknoid.Shapes.Block;


/**
 * The type Block remover.
 */
public class BlockRemover implements HitListener {
        private  final GameLevel game;
        private final Counter remainingBlocks;

    /**
     * Instantiates a new Block remover.
     *
     * @param game          the game
     * @param removedBlocks the removed blocks
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
            this.game = game;
            this.remainingBlocks = removedBlocks;
        }
    @Override
    // Blocks that are hit should be removed
    // from the game. Remember to remove this listener from the block
    // that is being removed from the game.
        public void hitEvent(Block beingHit, Ball hitter) {
            beingHit.removeFromGame(this.game);
            beingHit.removeHitListener(this);
            this.remainingBlocks.decrease(1);
        }
    }
