
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
 * The type Wide easy.
 */
public class WideEasy implements LevelInformation {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;


    @Override
    public int numberOfBalls() {
        return 10;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Velocity velocity = Velocity.fromAngleAndSpeed(-35 + 10 * i, 4);
            velocities.add(velocity);
        }
        return velocities;
    }


    @Override
    public int paddleSpeed() {
        return 5;
    }

    @Override
    public int paddleWidth() {
        return 600;
    }


    @Override
    public String levelName() {
        return "Wide Easy";
    }

    @Override
    public Sprite getBackground() {
        Sprite background = new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(new Color(20, 60, 80));
                d.fillRectangle(0, 0, WIDTH, HEIGHT);
                d.setColor(Color.WHITE);
                d.fillRectangle(0, 0, 800, 20);
                d.setColor(Color.BLACK);
                d.drawText(600, 20, "Level Name: Wide Easy", 15);
                d.setColor(Color.ORANGE);
                for (int i = 0; i < 70; i++) {
                    d.drawLine(200, 200, 10 * i, 300);
                }
                d.setColor(Color.pink);
                d.fillCircle(200, 200, 50);
                d.setColor(Color.ORANGE);
                d.fillCircle(200, 200, 40);
                d.setColor(Color.YELLOW);
                d.fillCircle(200, 200, 30);
                drawCloud(d, 100, 70, 1.5);
                drawCloud(d, 400, 150, 1.2);

                // Draw flowers
                d.setColor(Color.YELLOW);
                int flowerSize = 12;
                for (int i = 50; i < WIDTH; i += 60) {
                    d.setColor(new Color(24, 112, 33)); // Green stem color
                    d.fillRectangle(i, HEIGHT - 50, 6, 50);
                    d.setColor(Color.YELLOW); // Flower petals color
                    d.fillCircle(i + 3, HEIGHT - 75, flowerSize);
                    d.setColor(Color.ORANGE); // Flower center color
                    d.fillCircle(i + 3, HEIGHT - 75, flowerSize / 2);
                }


            }

            @Override
            public void timePassed() {

            }
        };

        return background;
    }

    private void drawCloud(DrawSurface d, int x, int y, double size) {
        d.setColor(Color.LIGHT_GRAY);
        int cloudWidth = (int) (80 * size);
        int cloudHeight = (int) (40 * size);
        d.fillOval(x, y, cloudWidth, cloudHeight);
        d.fillOval(x + cloudWidth / 2, y - cloudHeight / 2, cloudWidth, cloudHeight);
        d.fillOval(x + cloudWidth, y, cloudWidth, cloudHeight);
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Block b = new Block(20 + 50 * i, 300, 50, 20, Color.RED);
            blocks.add(b);
        }
        for (int i = 0; i < 2; i++) {
            Block b = new Block(120 + 50 * i, 300, 50, 20, Color.ORANGE);
            blocks.add(b);
        }
        for (int i = 0; i < 2; i++) {
            Block b = new Block(220 + 50 * i, 300, 50, 20, Color.YELLOW);
            blocks.add(b);
        }
        for (int i = 0; i < 3; i++) {
            Block b = new Block(320 + 50 * i, 300, 50, 20, Color.GREEN);
            blocks.add(b);
        }
        for (int i = 0; i < 2; i++) {
            Block b = new Block(470 + 50 * i, 300, 50, 20, Color.BLUE);
            blocks.add(b);
        }
        for (int i = 0; i < 2; i++) {
            Block b = new Block(570 + 50 * i, 300, 50, 20, Color.PINK);
            blocks.add(b);
        }
        for (int i = 0; i < 2; i++) {
            Block b = new Block(670 + 50 * i, 300, 50, 20, Color.CYAN);
            blocks.add(b);
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
}
