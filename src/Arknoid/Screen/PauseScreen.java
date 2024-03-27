
// Yehonatan Hayat
// ID 318228046
package Arknoid.Screen;
import Arknoid.Interfaces.Animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;


/**
 * The type Pause screen.
 */
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     * constructor.
     *
     * @param k Keyboard Sensor
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }

 @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "Paused -- press space to continue", 32);
    }

@Override
    public boolean shouldStop() {
        return this.stop;
    }
}