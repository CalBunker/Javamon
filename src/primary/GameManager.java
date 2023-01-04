package primary;
import utils.user.Question;
import utils.user.Screen;
import java.util.Scanner;

public class GameManager {
    public static World setup(Scanner scan) {
        // ===
        // MAIN MENU
        // ===
        Screen.typed("                         LogiBunk Studios Presents:");
        Screen.typed("    ___  ________  ___      ___ ________  _____ ______   ________  ________      ");
        Screen.typed("   |\\  \\|\\   __  \\|\\  \\    /  /|\\   __  \\|\\   _ \\  _   \\|\\   __  \\|\\   ___  \\    ");
        Screen.typed("   \\ \\  \\ \\  \\|\\  \\ \\  \\  /  / | \\  \\|\\  \\ \\  \\\\\\__\\ \\  \\ \\  \\|\\  \\ \\  \\\\ \\  \\   ");
        Screen.typed(" __ \\ \\  \\ \\   __  \\ \\  \\/  / / \\ \\   __  \\ \\  \\\\|__| \\  \\ \\  \\\\\\  \\ \\  \\\\ \\  \\  ");
        Screen.typed("|\\  \\\\_\\  \\ \\  \\ \\  \\ \\    / /   \\ \\  \\ \\  \\ \\  \\    \\ \\  \\ \\  \\\\\\  \\ \\  \\\\ \\  \\ ");
        Screen.typed("\\ \\________\\ \\__\\ \\__\\ \\__/ /     \\ \\__\\ \\__\\ \\__\\    \\ \\__\\ \\_______\\ \\__\\\\ \\__\\");
        Screen.typed(" \\|________|\\|__|\\|__|\\|__|/       \\|__|\\|__|\\|__|     \\|__|\\|_______|\\|__| \\|__|");
        Screen.typed("                         Press Enter to Continue...");
        scan.nextLine();
        Screen.typed("First, there was nothing.");
        Screen.typed("Then, there was something.");
        Screen.typed("That something was you, a Pokemon Master, destined for greatness.");
        Screen.typed("Even though you are eternally 11 years old, and have no dad, you are destined for greatness.");
        Screen.typed("Your mom is supportive, but she just stands awkwardly in the kitchen for the entire game and that's literally her entire purpose.");
        Screen.typed("One day though, you received a mysterious letter from The Professor.");
        Screen.typed("It read:");
        System.out.println("");
        Screen.typed("Dear Pokemon Master,");
        Screen.typed("I am Professor Tree, and I study Pokemon.");
        Screen.typed("The Plot requires that you have a goal, so I have entrusted you with this Pokedex.");
        Screen.typed("Catch 'Em All™, and you will be the greatest Pokemon Master of all time.");
        System.out.println("");
        Screen.typed("Sincerely,");
        Screen.typed("Professor Tree");
        System.out.println("");
        Screen.typed("Also inside the package was a Pokemon and a Pokedex.");
        Screen.typed("You named the Pokemon 'Shuckle.'");
        Screen.typed("You named the Pokedex 'Pokedex.'");
        Screen.typed("You named yourself...");
        System.out.println("");
        Screen.typed("...wait, what's your name again?");
        String playerName = scan.nextLine();
        System.out.println("");
        Screen.typed("Oh yeah, it's " + playerName + ".");
        Screen.typed("Well, "+ playerName + ", you're ready to start your journey.");

        // ===
        // SETUP WORLD
        // ===
        int size = (int) Question.chooseItem(scan, 
            "What would you like the size of your world to be?",
            new String[] {"16x16", "32x32", "64x64"},
            new Object[] {16,32, 64}
        );
        
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
            "Move North",
            "Move East",
            "Move West",
            "Move South",
            "Open Backpack",
            "Back");
        
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
