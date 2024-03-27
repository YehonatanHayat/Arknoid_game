
// Yehonatan Hayat
// ID 318228046

package Arknoid.Screen;

import Arknoid.Interfaces.Animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;


/**
 * The type Key press stoppable animation.
 */
public class KeyPressStoppableAnimation implements Animation {
    private Animation animation;
    private KeyboardSensor keyboard;
    private boolean stop;
    private boolean isAlreadyPressed;


    /**
     * Instantiates a new Key press stoppable animation.
     *
     * @param animation the animation
     * @param keyboard  the keyboard
     */
    public KeyPressStoppableAnimation(Animation animation, KeyboardSensor keyboard) {
        this.animation = animation;
        this.keyboard = keyboard;
        this.stop = false;
        this.isAlreadyPressed = true;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)
                && !this.isAlreadyPressed) {
            this.stop = true;
        }
        if (!this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.isAlreadyPressed = false;
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}

