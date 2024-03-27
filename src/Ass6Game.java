
// Yehonatan Hayat
// ID 318228046


import Arknoid.Screen.DirectHit;
import Arknoid.GameSetup.GameFlow;
import Arknoid.Interfaces.LevelInformation;
import Arknoid.Screen.Green3;
import Arknoid.Screen.WideEasy;
import java.util.ArrayList;
import java.util.List;


/**
 * this class has the main that runs the game.
 */
public class Ass6Game {


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        List<LevelInformation> levels = new ArrayList<>();
        DirectHit level1 = new DirectHit();
        WideEasy level2 = new WideEasy();
        Green3 level3 = new Green3();

        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                // if there is no integer --> skip
                try {
                    if (Integer.parseInt(args[i]) == 1) {
                        System.out.println(1);
                        levels.add(level1);
                    }
                    if (Integer.parseInt(args[i]) == 2) {
                        System.out.println(2);
                        levels.add(level2);
                    }
                    if (Integer.parseInt(args[i]) == 3) {
                        levels.add(level3);
                        System.out.println(3);
                    }

                } catch (NumberFormatException exception) {
                }
            }
        }


        if (levels.size() == 0) {
            levels.add(level1);
            levels.add(level2);
            levels.add(level3);
        }
        GameFlow game = new GameFlow();
        game.runLevels(levels);
    }
}
