package primary;
import utils.user.Question;
import utils.user.Screen;
import java.util.Scanner;

public class GameManager {
    public static final boolean PLAY_INTRO = false;

    public static World setup(Scanner scan) {
        String playerName;

        // INTRODUCTION
        if (PLAY_INTRO) {
            try {
                playerName = startIntroduction(scan);
            } catch (Exception e) {playerName = "undefined";}
        } else {
            playerName = "f";
        }

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

        // Screen.clear();
        // world.visualize();
        // System.out.println();
        // world.worldBreakdown();
        // Screen.awaitUser(scan);
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
            return determineDirection(action, world, scan);
        } catch (IndexOutOfBoundsException e) {
            Screen.typed("You peer over a sudden cliff down towards an infinite void. Your brain cannot comprehend it's sheer vastness.");
            Screen.typed("You suddenly awake, about three feet away from the cliff. You do not know how much time has passed since you peered over it's edge, but you get the feeling you should do it again.");
            return true;
        }
    }

    /**
     * @return True if the loop should continue
     */
    private static boolean determineDirection(int action, World world, Scanner scan) {
        switch (action) {
            // THE BOTTOM RIGHT IS 0, 0
            case 0: // North
                world.offsetPlayer(0, 1, scan);
                break;
            
            case 1: // East
                world.offsetPlayer(1, 0, scan);
                break;

            case 2: // West
                world.offsetPlayer(-1, 0, scan);
                break;
            
            case 3: // South
                world.offsetPlayer(0, -1, scan);
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
        Player player = world.player;

        System.out.println("Player Coords - (" + world.player.getXPos() + ", " + world.player.getYPos() + ")");
        System.out.println("Current Tile: " + world.getTile(world.player.getXPos(), world.player.getYPos()).getName());

        renderMiniMap(world, player);
    }

    private static void renderMiniMap(World world, Player player) {
        String[][] miniMap = new String[3][3];

        int maxLeft = player.getXPos()-1;
        int maxRight = player.getXPos()+1;
        
        int maxTop = player.getYPos()+1;
        int maxBottom = player.getYPos()-1;

        int yCount = 0;
        for (int y = maxTop; y >= maxBottom; y--) {
            int xCount = 0;
            for (int x = maxLeft; x <= maxRight; x++) {
                miniMap[yCount][xCount] = String.valueOf(world.getTile(x, y).repr());

                xCount++;
            }

            yCount++;
        }

        System.out.println();
        for (String[] row : miniMap) {
            for (String item : row) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

    private static String startIntroduction(Scanner scan) throws InterruptedException {
        // ===
        // MAIN MENU
        // ===
        System.out.println("                         LogiBunk Studios Presents:");
        System.out.println("    ___  ________  ___      ___ ________  _____ ______   ________  ________      ");
        Thread.sleep(400);
        System.out.println("   |\\  \\|\\   __  \\|\\  \\    /  /|\\   __  \\|\\   _ \\  _   \\|\\   __  \\|\\   ___  \\    ");
        Thread.sleep(400);
        System.out.println("   \\ \\  \\ \\  \\|\\  \\ \\  \\  /  / | \\  \\|\\  \\ \\  \\\\\\__\\ \\  \\ \\  \\|\\  \\ \\  \\\\ \\  \\   ");
        Thread.sleep(400);
        System.out.println(" __ \\ \\  \\ \\   __  \\ \\  \\/  / / \\ \\   __  \\ \\  \\\\|__| \\  \\ \\  \\\\\\  \\ \\  \\\\ \\  \\  ");
        Thread.sleep(400);
        System.out.println("|\\  \\\\_\\  \\ \\  \\ \\  \\ \\    / /   \\ \\  \\ \\  \\ \\  \\    \\ \\  \\ \\  \\\\\\  \\ \\  \\\\ \\  \\ ");
        Thread.sleep(400);
        System.out.println("\\ \\________\\ \\__\\ \\__\\ \\__/ /     \\ \\__\\ \\__\\ \\__\\    \\ \\__\\ \\_______\\ \\__\\\\ \\__\\");
        Thread.sleep(400);
        System.out.println(" \\|________|\\|__|\\|__|\\|__|/       \\|__|\\|__|\\|__|     \\|__|\\|_______|\\|__| \\|__|");
        Thread.sleep(400);
        System.out.println("                         Press Enter to Continue...");
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

        Screen.awaitUser(scan);
        Screen.clear();

        return playerName;
    }
}
