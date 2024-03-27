
// Yehonatan Hayat
// ID 318228046

package Arknoid.GameSetup;
import Arknoid.Interfaces.Sprite;
import biuoop.DrawSurface;
import java.util.ArrayList;
import java.util.List;


/**
 * The type Sprite collection.
 */
public class SpriteCollection {

    private final List<Sprite> sprites;


    /**
     * Instantiates a new Sprite collection.
     */
    public SpriteCollection() {
      this.sprites = new ArrayList<>();
    }


    /**
     * Add sprite.
     *
     * @param s the sprite
     */
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }


    /**
     * Notify all time passed.
     */
    public void notifyAllTimePassed() {
        for (Sprite s: new ArrayList<>(this.sprites)) {
            s.timePassed();
        }
    }
    /**
     * Draw all on.
     *
     * @param d the drawSurface
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s: new ArrayList<>(this.sprites)) {
            s.drawOn(d);
        }
    }


    /**
     * Remove sprite.
     *
     * @param s the sprite
     */
    public void removeSprite(Sprite s) {
        this.sprites.remove(s);
    }
}

