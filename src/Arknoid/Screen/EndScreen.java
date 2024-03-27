
// Yehonatan Hayat
// ID 318228046

package Arknoid.Screen;
import Arknoid.GameSetup.Counter;
import Arknoid.Interfaces.Animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;


/**
 * The type End screen.
 */
public class EndScreen implements Animation {
    private  KeyboardSensor keyboard;
    private final boolean stop;
    private final Boolean win;
    private final Counter score;

    /**
     * constructor.
     *
     * @param k     keyboard sensor
     * @param win   if user wins or loses
     * @param score the final score
     */
    public EndScreen(KeyboardSensor k, Boolean win, Counter score) {
        this.keyboard = k;
        this.stop = false;
        this.win = win;
        this.score = score;
    }

@Override
    public void doOneFrame(DrawSurface d) {
        if (this.win) {
            d.drawText(10, d.getHeight() / 2,
                    "YOU WIN! Your score is: " + this.score.getValue(), 32);
        } else {
            d.drawText(10, d.getHeight() / 2,
                    "GAME OVER. Your score is: " + this.score.getValue(), 32);
        }
    }

  @Override
    public boolean shouldStop() {
        return this.stop;
    }
}

