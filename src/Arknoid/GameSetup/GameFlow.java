
// Yehonatan Hayat
// ID 318228046

package Arknoid.GameSetup;
import Arknoid.Interfaces.LevelInformation;
import Arknoid.Screen.EndScreen;
import Arknoid.Screen.KeyPressStoppableAnimation;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.util.List;

/**
 * The type Game flow.
 */
public class GameFlow {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private final AnimationRunner animationRunner;
    private final KeyboardSensor keyboardSensor;
    private final GUI gui;
    private final Counter score;
    private boolean win = true;


    /**
     * constructor.
     */
    public GameFlow() {
        this.gui = new GUI("Arkanoid", WIDTH, HEIGHT);
        this.animationRunner = new AnimationRunner(this.gui, 60);
        this.keyboardSensor = this.gui.getKeyboardSensor();
        this.score = new Counter(0);
    }

    /**
     * this methode runs the levels according to level's list.
     *
     * @param levels list of levels
     */
    public void runLevels(List<LevelInformation> levels) {
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, this.keyboardSensor, this.animationRunner, this.gui, this.score);
            level.initialize();

            while (!level.shouldStop()) {
                level.run();
            }

            if (level.getBallCount().getValue() == 0) {
                this.win = false;
                break;
            }
        }
        EndScreen end = new EndScreen(this.keyboardSensor, this.win, this.score);
        animationRunner.run(new KeyPressStoppableAnimation(end, this.keyboardSensor));
        this.gui.close();
    }
}

