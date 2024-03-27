
// Yehonatan Hayat
// ID 318228046

package Arknoid.Interfaces;
import biuoop.DrawSurface;


/**
 * The interface Animation.
 */
public interface Animation {

    /**
     * Do one frame.
     *
     * @param d the drawSurface
     */
    void doOneFrame(DrawSurface d);


    /**
     * Should stop boolean.
     *
     * @return the boolean
     */
    boolean shouldStop();
}
