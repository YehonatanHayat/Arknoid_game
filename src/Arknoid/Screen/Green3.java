
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
 * The type Green 3.
 */
public class Green3 implements LevelInformation {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;


    @Override
    public int numberOfBalls() {
        return 2;
    }


    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        Velocity v1 = new Velocity(4, 4);
        Velocity v2 = new Velocity(-3.5, -3.5);
        velocities.add(v1);
        velocities.add(v2);
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
        return "Green 3";
    }


    @Override
    public Sprite getBackground() {
        Sprite background = new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(Color.green);
                d.fillRectangle(0, 0, WIDTH, HEIGHT);
                d.setColor(Color.WHITE);
                d.fillRectangle(0, 0, 800, 20);
                d.setColor(Color.BLACK);
                d.drawText(600, 20, "Level Name: Green 3", 15);
                d.setColor(Color.BLACK);
                d.fillRectangle(50, 400, 150, 200);
                d.setColor(Color.WHITE);
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        d.fillRectangle(60 + 28 * i, 410 + 45 * j, 18, 35);
                    }
                }
                d.setColor(Color.DARK_GRAY);
                d.fillRectangle(100, 300, 50, 100);
                d.setColor(Color.GRAY);
                d.fillRectangle(110, 150, 10, 150);
                d.setColor(Color.ORANGE);
                d.fillCircle(115, 150, 15);
                d.setColor(Color.RED);
                d.fillCircle(115, 150, 10);
                d.setColor(Color.WHITE);
                d.fillCircle(115, 150, 4);
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
        //first row of blocks
        Block[] firstRow = new Block[10];
        for (int i = 0; i < firstRow.length; ++i) {
            firstRow[i] = new Block(WIDTH - 20 - 50 - i * 50, 100, 50, 20, Color.LIGHT_GRAY);
            blocks.add(firstRow[i]);
        }

        //second row of blocks
        Block[] secondRow = new Block[9];
        for (int i = 0; i < secondRow.length; ++i) {
            secondRow[i] = new Block(WIDTH - 20 - 50 - i * 50, 100 + 20, 50, 20, Color.RED);
            blocks.add(secondRow[i]);
        }

        //third row of blocks
        Block[] thirdRow = new Block[8];
        for (int i = 0; i < thirdRow.length; ++i) {
            thirdRow[i] = new Block(WIDTH - 20 - 50 - i * 50, 100 + 2 * 20, 50, 20, Color.YELLOW);
            blocks.add(thirdRow[i]);
        }

        //forth row of blocks
        Block[] forthRow = new Block[7];
        for (int i = 0; i < forthRow.length; ++i) {
            forthRow[i] = new Block(WIDTH - 20 - 50 - i * 50, 100 + 3 * 20, 50, 20, Color.BLUE);
            blocks.add(forthRow[i]);
        }

        //fifth row of blocks
        Block[] fifthRow = new Block[6];
        for (int i = 0; i < fifthRow.length; ++i) {
            fifthRow[i] = new Block(WIDTH - 20 - 50 - i * 50, 100 + 4 * 20, 50, 20, Color.WHITE);
            blocks.add(fifthRow[i]);
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}

