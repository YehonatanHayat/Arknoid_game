
// Yehonatan Hayat
// ID 318228046

package Arknoid.Interfaces;
import biuoop.DrawSurface;


/**
 * The interface Sprite.
 */
public interface Sprite {


    /**
     * Draw on.
     *
     * @param d the drawSurface
     */
    void drawOn(DrawSurface d);
    /**
     * Time passed.
     */
    void timePassed();
}
