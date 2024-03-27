// Yehonatan Hayat
// ID 318228046

package Arknoid.Shapes;
import Arknoid.GameSetup.CollisionInfo;
import Arknoid.GameSetup.GameLevel;
import Arknoid.GameSetup.GameEnvironment;
import Arknoid.GameSetup.Velocity;
import Arknoid.Interfaces.Collidable;
import Arknoid.Interfaces.Sprite;
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * The type Ball.
 */
public class Ball implements Sprite {

    private Point center;
    private int radius;
    private Color color;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;
    private int right;


    /**
     * Instantiates a new Ball.
     *
     * @param center the center
     * @param r      the r
     * @param color  the color
     */
// constructor
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.radius = r;
        this.color = color;
        this.velocity = new Velocity(0, 0);
    }

    /**
     * Instantiates a new Ball.
     *
     * @param x               the x
     * @param y               the y
     * @param r               the r
     * @param color           the color
     * @param bottom          the bottom
     * @param right           the right
     * @param gameEnvironment the game environment
     */
    public Ball(double x, double y, int r, java.awt.Color color, int bottom, int right,
                GameEnvironment gameEnvironment) {
        this.center = new Point(x, y);
        this.radius = r;
        this.color = color;
        this.right = right;
        this.gameEnvironment = gameEnvironment;
    }

    /**
     * Sets game environment.
     *
     * @param gameEnvironment the game environment
     */
    public void setGameEnvironment(GameEnvironment gameEnvironment) {
        this.gameEnvironment = gameEnvironment;
    }


    /**
     * Gets x.
     *
     * @return the x
     */
    public int getX() {
        return (int) this.center.getX();
    }


    /**
     * Gets y.
     *
     * @return the y
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * Gets size.
     *
     * @return the size
     */
    public int getSize() {
        return this.radius;
    }

    /**
     * Gets color.
     *
     * @return the color
     */
    public java.awt.Color getColor() {

        return this.color;
    }

  @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        // draw circle
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), this.radius);
        surface.setColor(Color.BLACK);
        surface.drawCircle((int) this.center.getX(), (int) this.center.getY(), this.radius);
    }

    @Override
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * Move one step.
     */
    public void moveOneStep() {
        // take the speed and apply it in the middle to move it
        if (this.gameEnvironment == null) {
            this.center = this.getVelocity().applyToPoint(this.center);
            return;
        }
        // start of line is center of ball and the speed and distance is end
        Line trajectory = new Line(this.center, this.velocity.applyToPoint(this.center));
        CollisionInfo cI = this.gameEnvironment.getClosestCollision(trajectory);
        Collidable collide = cI.collisionObject();
        if (collide == null) {
            this.center = this.getVelocity().applyToPoint(this.center);
            return;
        }
       this.velocity = collide.hit(this, cI.collisionPoint(), this.velocity);
        this.center = this.getVelocity().applyToPoint(this.center);
    }


// making sure we stay in screens frame
//    public void moveOneStep(Point start, Point end) {
//        double minX = start.getX();
//        double minY = start.getY();
//        double maxX = end.getX();
//        double maxY = end.getY();
//
//        // new point where the center will be
//        Point n = this.velocity.applyToPoint(this.center);
//        double dx = this.velocity.getDx();
//        double dy = this.velocity.getDy();
//        if (n.getX() < minX + this.radius || n.getX() > maxX - this.radius) {
//            // changing direction of dx
//            dx *= -1;
//        }
//        if (n.getY() < minY + this.radius || n.getY() > maxY - this.radius) {
//            // changing direction of dy
//            dy *= -1;
//        }
//        Velocity v = new Velocity(dx, dy);
//        this.center = v.applyToPoint(this.center);
//        this.velocity = v;
//    }


    /**
     * Sets velocity.
     *
     * @param v the v
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }


    /**
     * Sets velocity.
     *
     * @param dx the dx
     * @param dy the dy
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }


    /**
     * Gets velocity.
     *
     * @return the velocity
     */
    public Velocity getVelocity() {
        return this.velocity;
    }


    /**
     * Add to game.
     *
     * @param g the g
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        this.gameEnvironment = g.getEnvironment();
    }

    /**
     * Remove from game.
     *
     * @param game the game
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }
}

