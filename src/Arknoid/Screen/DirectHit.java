
// Yehonatan Hayat
// ID 318228046

package Arknoid.Screen;

import Arknoid.Interfaces.LevelInformation;
import Arknoid.GameSetup.Velocity;
import Arknoid.Interfaces.Sprite;
import Arknoid.Shapes.Block;
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


/**
 * The type Direct hit.
 */
public class DirectHit implements LevelInformation {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        velocities.add(Velocity.fromAngleAndSpeed(0, 3));
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return 5;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }


    @Override
    public String levelName() {
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        Sprite background = new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(Color.BLACK);
                d.fillRectangle(0, 0, WIDTH, HEIGHT);
                d.setColor(Color.ORANGE);
                d.drawText(600, 20, "Level Name: Direct Hit", 15);
                d.setColor(Color.BLUE);
                d.drawCircle(400, 165, 120);
                d.drawCircle(400, 165, 90);
                d.drawCircle(400, 165, 60);
                d.drawLine(400, 40, 400, 140);
                d.drawLine(400, 195, 400, 300);
                d.drawLine(265, 165, 380, 165);
                d.drawLine(420, 165, 535, 165);

                d.setColor(Color.YELLOW);
                for (int i = 0; i < 100; i++) {
                    int x = (int) (Math.random() * WIDTH);
                    int y = (int) (Math.random() * HEIGHT);
                    d.fillCircle(x, y, 2);
                }


            }

            @Override
            public void timePassed() {
            }
        };
        return background;
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        blocks.add(new Block(385, 150, 30, 30, Color.RED));
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }

}

