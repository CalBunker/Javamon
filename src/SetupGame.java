import utils.user.Question;
import java.util.Scanner;

public class SetupGame {
    public static World setup(Scanner scan) {

        // ===
        // SETUP WORLD
        // ===
        int size = (int) Question.chooseItem(scan, 
            "What would you like the size of your world to be?",
            new String[] {"16x16", "32x32", "64x64"},
            new Object[] {16,32, 64}
        );

        // ===
        // SETUP PLAYER
        // ===
        String playerName = Question.requestString(scan, "Please give your character a name");
        
        // ===
        // WORLD INITIALIZATION
        // ===
        World world = new World(size, size, new Player(playerName, size/2, size/2));
        world.generate();
        return world;
    }
}
