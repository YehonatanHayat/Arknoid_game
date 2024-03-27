
// Yehonatan Hayat
// ID 318228046

package Arknoid.Shapes;

import Arknoid.GameSetup.GameLevel;
import Arknoid.GameSetup.Velocity;
import Arknoid.Interfaces.Collidable;
import Arknoid.Interfaces.Sprite;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.awt.Color;


/**
 * The type Paddle.
 */
public class Paddle implements Sprite, Collidable {

    private biuoop.KeyboardSensor keyboard;
    private Color color;
    private Rectangle rectangle;
    private final int speed;
    private int boardRightBound;

    /**
     * Instantiates a new Paddle.
     *
     * @param keyboard  the keyboard
     * @param color     the color
     * @param rectangle the rectangle
     * @param speed     the speed
     */
    public Paddle(KeyboardSensor keyboard, Color color, Rectangle rectangle, int speed) {
        this.keyboard = keyboard;
        this.color = color;
        this.rectangle = rectangle;
        this.speed = speed;
    }

    /**
     * Instantiates a new Paddle.
     *
     * @param p      the p
     * @param width  the width
     * @param height the height
     * @param color  the color
     * @param gui    the gui
     * @param right  the right
     * @param speed  the speed
     */
    public Paddle(Point p, int width, int height, Color color, GUI gui, int right, int speed) {
        this.rectangle = new Rectangle(p, width, height);
        this.color = color;
        this.keyboard = gui.getKeyboardSensor();
        this.boardRightBound = right;
        this.speed = speed;
    }


    /**
     * Move left.
     */
    public void moveLeft() {

        Point point = this.rectangle.getUpperLeft();
        double width = this.rectangle.getWidth();
        double height = this.rectangle.getHeight();

        Point newPoint = new Point(point.getX() - speed, point.getY());
        this.rectangle = new Rectangle(newPoint, width, height);
    }

    /**
     * Move right.
     */
    public void moveRight() {
        Point point = this.rectangle.getUpperLeft();
        double width = this.rectangle.getWidth();
        double height = this.rectangle.getHeight();

        Point newPoint = new Point(point.getX() + speed, point.getY());
        this.rectangle = new Rectangle(newPoint, width, height);
    }

    @Override
    public void timePassed() {
        if (this.keyboard.isPressed(KeyboardSensor.LEFT_KEY) && this.rectangle.getUpperLeft().getX() >= 0) {
            this.moveLeft();
        }
        if (this.keyboard.isPressed(KeyboardSensor.RIGHT_KEY) && this.rectangle.getUpperLeft().getX()
                + rectangle.getWidth() < GameLevel.WIDTH) {
            this.moveRight();
        }
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX(),
                (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
    }


    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        // array of lines of rectangle
        Line[] lines = this.rectangle.getLines();
        // funny paddle
        if (lines[0].isPointOnLine(collisionPoint)) {
            return hitParts(lines[0], collisionPoint, currentVelocity);
        }
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();

        for (int i = 1; i < lines.length; i++) {
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


    // Returns the part of the pedal that the ball collided with
    private Velocity hitParts(Line line, Point collisionPoint, Velocity currentVelocity) {
        int part = findPart(line, collisionPoint);
        if (part == 3) {
            return new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
        }
        if (part == -1) {
            part = 5;
        }

        int angle = (270 + part * 30) % 360;
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();
        double speed = Math.sqrt(dx * dx + dy * dy);

        return Velocity.fromAngleAndSpeed(angle, speed);
    }


    private int findPart(Line line, Point collisionPoint) {
        double lineSegment = line.length() / 5;

        double pX = collisionPoint.getX();
        double lX = Math.min(line.start().getX(), line.end().getX());

        for (int i = 1; i <= 5; i++) {
            if (pX <= lX + lineSegment * i) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Add to game.
     *
     * @param g the game
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }
}