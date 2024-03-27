
// Yehonatan Hayat
// ID 318228046


package Arknoid.GameSetup;
import Arknoid.Interfaces.Animation;
import biuoop.DrawSurface;
import biuoop.Sleeper;
import java.awt.Color;

/**
 * The type Countdown animation.
 */
public class CountdownAnimation implements Animation {
    private final double numOfSeconds;
    private final int startTime;
    private final SpriteCollection gameScreen;
    private final Sleeper sleeper;
    private boolean running;
    private int downCounting;

    /**
     * Instantiates a new Countdown animation.
     *
     * @param numOfSeconds the num of seconds
     * @param startTime    the start time
     * @param gameScreen   the game screen
     */
    public CountdownAnimation(double numOfSeconds, int startTime, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds / startTime;
        this.startTime = startTime;
        this.downCounting = startTime + 1;
        this.gameScreen = gameScreen;
        this.running = true;
        this.sleeper = new Sleeper();

    }

    @Override
    public void doOneFrame(DrawSurface d) {

        // for two seconds
        if (this.downCounting != (this.startTime + 1)) {
            this.sleeper.sleepFor((long) 666.666);
        }

        if (this.downCounting == 0) {
            this.running = false;
            return;
        }
        this.gameScreen.drawAllOn(d);
        d.setColor(Color.RED);
        if (this.downCounting == 1) {
            d.drawText(300, 400, "START!", 50);

        } else {
            d.drawText(375, 400, Integer.toString(downCounting - 1), 50);
        }
        this.downCounting--;


    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }
}
