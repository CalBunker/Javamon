import utils.user.Question;
import utils.user.Screen;

import java.util.Scanner;

public class GameManager {
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

    /**
     * The main program loop
     * @param scan The Scanner object
     * @param world The main world
     * @return True if the loop should continue
     */
    public static boolean mainLoop(Scanner scan, World world) {
        Screen.clear();
        printStatistics(world);

        int action = Question.chooseItem(scan, "What action do you want to take?", 
            "North",
            "East",
            "West",
            "South",
            "Open Backpack",
            "Exit");
        
        try {
            return determineDirection(action, world);
        } catch (IndexOutOfBoundsException e) {
            Screen.typed("You peer over a sudden cliff down towards an infinite void. Your brain cannot comprehend it's sheer vastness.");
            Screen.typed("You suddenly awake, about three feet away from the cliff. You do not know how much time has passed since you peered over it's edge, but you get the feeling you should do it again.");
            return true;
        }
    }

    /**
     * @return True if the loop should continue
     */
    private static boolean determineDirection(int action, World world) {
        switch (action) {
            // THE BOTTOM RIGHT IS 0, 0
            case 0: // North
                world.offsetPlayer(0, 1);
                break;
            
            case 1: // East
                world.offsetPlayer(1, 0);
                break;

            case 2: // West
                world.offsetPlayer(-1, 0);
                break;
            
            case 3: // South
                world.offsetPlayer(0, -1);
                break;

            case 4: // Open Backpack
                world.player.printBag();
                break;

            case 5: // Exit
                return false;
            default:
                break;
        }

        return true;
    }

    private static void printStatistics(World world) {
        System.out.println("Player Coords - (" + world.player.getXPos() + ", " + world.player.getYPos() + ")");
        System.out.println("Current Tile: " + world.getTile(world.player.getXPos(), world.player.getYPos()).getName());
    }
}
