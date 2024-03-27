
// Yehonatan Hayat
// ID 318228046

package Arknoid.Shapes;

import Arknoid.GameSetup.GameLevel;
import Arknoid.GameSetup.Velocity;
import Arknoid.Interfaces.Collidable;
import Arknoid.Interfaces.HitListener;
import Arknoid.Interfaces.HitNotifier;
import Arknoid.Interfaces.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


/**
 * The type Block.
 */
public class Block implements Collidable, Sprite, HitNotifier {

    private final Rectangle rect;
    private final Color color;
    private final List<HitListener> listeners;

    private Point start;
    private int height;
    private int width;

    /**
     * Instantiates a new Block.
     *
     * @param rect the rectangle
     * @param col  the color
     */
    public Block(Rectangle rect, Color col) {
        this.rect = rect;
        this.color = col;
        this.listeners = new ArrayList<>();
    }


    /**
     * Instantiates a new Block.
     *
     * @param x      the x
     * @param y      the y
     * @param width  the width
     * @param height the height
     * @param color  the color
     */
    public Block(int x, int y, int width, int height, Color color) {
        this.start = new Point(x, y);
        this.rect = new Rectangle(this.start, width, height);
        this.color = color;
        this.width = width;
        this.height = height;
        this.listeners = new ArrayList<HitListener>();
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return this.rect;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        // array of lines of rectangle
        Line[] lines = this.rect.getLines();
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();

        this.notifyHit(hitter);

        // if ball gets to line bounces other way
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].isPointOnLine(collisionPoint)) {
                if (i % 2 == 0) {
                    dy = dy * -1;
                } else {
                    dx = dx * -1;
                }
            }
        }
        // if either changes a ball bounced and hit
        return new Velocity(dx, dy);
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawRectangle((int) this.rect.getUpperLeft().getX(), (int) this.rect.getUpperLeft().getY(),
                (int) this.rect.getWidth(), (int) this.rect.getHeight());
        d.setColor(this.color);
        d.fillRectangle((int) this.rect.getUpperLeft().getX(), (int) this.rect.getUpperLeft().getY(),
                (int) this.rect.getWidth(), (int) this.rect.getHeight());
    }

    @Override
    public void timePassed() {

    }

    /**
     * Add to game.
     *
     * @param g the g
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }
    @Override
    public void addHitListener(HitListener hl) {
        this.listeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.listeners.remove(hl);
    }

    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.listeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    /**
     * Remove from game.
     *
     * @param game the game
     */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }
}

