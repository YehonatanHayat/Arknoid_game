
// Yehonatan Hayat
// ID 318228046

package Arknoid.GameSetup;

import Arknoid.Interfaces.LevelInformation;
import Arknoid.Interfaces.Collidable;
import Arknoid.Interfaces.Animation;
import Arknoid.Interfaces.Sprite;
import Arknoid.Screen.KeyPressStoppableAnimation;
import Arknoid.Screen.PauseScreen;
import biuoop.KeyboardSensor;
import Arknoid.Score.ScoreIndicator;
import Arknoid.Score.ScoreTrackingListener;
import Arknoid.Shapes.Ball;
import Arknoid.Shapes.Point;
import Arknoid.Shapes.Block;
import Arknoid.Shapes.Rectangle;
import Arknoid.Shapes.Paddle;
import biuoop.DrawSurface;
import biuoop.GUI;
import java.awt.Color;

/**
 * The type Game level.
 */
public class GameLevel implements Animation {
    private final SpriteCollection sprites;
    private final GameEnvironment environment;
    private final GUI gui;
    private final Counter blockCount;
    private final Counter ballCount;
    private final Counter score;
    private final AnimationRunner animationRunner;
    private boolean running;
    private final LevelInformation levelInformation;
    private final biuoop.KeyboardSensor keyboard;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    private static final int BOUND = 20;


    /**
     * Instantiates a new Game level.
     *
     * @param levelInformation the level information
     * @param keyboard         the keyboard
     * @param runner           the runner
     * @param gui              the gui
     * @param score            the score
     */
    public GameLevel(LevelInformation levelInformation, KeyboardSensor keyboard,
                     AnimationRunner runner, GUI gui, Counter score) {

        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.blockCount = new Counter(0);
        this.ballCount = new Counter(levelInformation.numberOfBalls());
        this.gui = gui;
        this.running = true;
        this.animationRunner = runner;
        this.keyboard = keyboard;
        this.levelInformation = levelInformation;
        this.score = score;
    }


    /**
     * Add collidable.
     *
     * @param c the collidable
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }


    /**
     * Add sprite.
     *
     * @param s the sprite
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }


    /**
     * Initialize.
     */
    public void initialize() {
        createFrame();
        // create listeners
        BlockRemover blockRemover = new BlockRemover(this, this.blockCount);
        BallRemover ballRemover = new BallRemover(this, this.ballCount);
        ScoreTrackingListener scoreTracking = new ScoreTrackingListener(this.score);

        // create background
        this.addSprite(this.levelInformation.getBackground());

        //createBlocks

        for (Block b : this.levelInformation.blocks()) {
            b.addToGame(this);
            b.addHitListener(blockRemover);
            b.addHitListener(scoreTracking);
        }
        this.blockCount.increase(this.levelInformation.numberOfBlocksToRemove());
        // create the paddle
        Paddle paddle = new Paddle(new Point((float) (WIDTH - this.levelInformation.paddleWidth()) / 2,
                560), this.levelInformation.paddleWidth(),
                20, Color.YELLOW, this.gui, WIDTH - BOUND, this.levelInformation.paddleSpeed());
        paddle.addToGame(this);


        // create the balls
        int i = 0;
        for (Velocity v : this.levelInformation.initialBallVelocities()) {
            Ball ball = new Ball(WIDTH / 2, 555, 6, Color.WHITE, HEIGHT - 20, WIDTH - 20, this.environment);
            ball.setVelocity(v);
            ball.addToGame(this);
            ++i;
        }
        ScoreIndicator scoreIndicator = new ScoreIndicator(this.score);
        scoreIndicator.addToGame(this);
    }


    /**
     * Create frame.
     */
    public void createFrame() {
        int size = 30;
        Color c = Color.DARK_GRAY;
        BallRemover remover = new BallRemover(this, this.ballCount);


        Block b1 = new Block(new Rectangle(new Point(0, 0), WIDTH, size), c);
        Block b2 = new Block(new Rectangle(new Point(0, HEIGHT), WIDTH, size), c);
        Block b3 = new Block(new Rectangle(new Point(-size, 0), size, HEIGHT), c);
        Block b4 = new Block(new Rectangle(new Point(WIDTH, 0), size, HEIGHT), c);

        b1.addToGame(this);
        b2.addToGame(this);
        b2.addHitListener(remover);
        b3.addToGame(this);
        b4.addToGame(this);
    }


    /**
     * Run.
     */
    public void run() {
            this.animationRunner.run(new CountdownAnimation(8, 3, this.sprites));
            this.running = true;
            this.animationRunner.run(this);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.keyboard.isPressed("p")) {
            this.animationRunner.run(new KeyPressStoppableAnimation(new PauseScreen(this.keyboard), this.keyboard));
        }
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();

        if (this.blockCount.getValue() == 0) {
            score.increase(100);
            this.sprites.drawAllOn(d);
            this.running = false;
        }
        if (this.ballCount.getValue() == 0) {
            this.running = false;
        }
    }


    /**
     * Gets environment.
     *
     * @return the environment
     */
    public GameEnvironment getEnvironment() {
        return this.environment;
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }


    /**
     * Remove collidable.
     *
     * @param c the c
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }


    /**
     * Remove sprite.
     *
     * @param s the sprite
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * Gets ball count.
     *
     * @return the ball count
     */
    public Counter getBallCount() {
        return ballCount;
    }


}
