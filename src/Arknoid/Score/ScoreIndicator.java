
// Yehonatan Hayat
// ID 318228046


package Arknoid.Score;
import Arknoid.GameSetup.Counter;
import Arknoid.GameSetup.GameLevel;
import Arknoid.Interfaces.Sprite;
import biuoop.DrawSurface;
import java.awt.Color;


/**
 * The type Score indicator.
 */
public class ScoreIndicator implements Sprite {
    private final Counter score;

    /**
     * Instantiates a new Score indicator.
     *
     * @param score the score
     */
    public ScoreIndicator(Counter score) {
        this.score = score;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.blue);
        d.fillRectangle(GameLevel.WIDTH / 3, 0, GameLevel.WIDTH / 3, 20);
        d.setColor(Color.BLACK);
        d.drawText(GameLevel.WIDTH / 2 - 30, 15, "Score:" + (this.score.getValue()), 16);
    }

    @Override
    public void timePassed() {
    }

    /**
     * Add to game.
     *
     * @param game the game
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }
}
