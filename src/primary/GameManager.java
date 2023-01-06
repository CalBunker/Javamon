package primary;
import utils.user.Question;
import utils.user.Screen;
import java.util.Scanner;

public class GameManager {
    public static final boolean PLAY_INTRO = true;

    public static World setup(Scanner scan, boolean playIntro) {
        String playerName;

        // INTRODUCTION
        if (PLAY_INTRO && playIntro) {
            try {
                playerName = startIntroduction(scan);
            } catch (Exception e) {playerName = "undefined";}
        } else {
            playerName = Question.requestString(scan, "Give your name:");
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
            "-",
            "Open Backpack",
            "Open Map",
            "Close Game");
        
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

            case 4:
                Screen.typed("Congrats! You found an easter egg! Now move along...");
                break;

            case 5: // Open Backpack
                world.player.printBag();
                break;

            case 6:
                openMap(world);
                break;

            case 7: // Exit
                return false;
            default:
                break;
        }

        return true;
    }

    private static void openMap(World world) {
        renderMiniMap(world, world.player, 8, true);
    }

    private static void printStatistics(World world) {
        Player player = world.player;

        System.out.println("Player Coords - (" + world.player.getXPos() + ", " + world.player.getYPos() + ")");
        System.out.println("Current Tile: " + world.getTile(world.player.getXPos(), world.player.getYPos()).getName());

        renderMiniMap(world, player);
    }

    private static void renderMiniMap(World world, Player player, int radius, boolean hideUnexplored) {
        String[][] miniMap = new String[radius*2 + 1][radius*2 + 1];

        int maxLeft = player.getXPos()-radius;
        int maxRight = player.getXPos()+radius;
        
        int maxTop = player.getYPos()+radius;
        int maxBottom = player.getYPos()-radius;

        int yCount = 0;
        for (int y = maxTop; y >= maxBottom; y--) {
            int xCount = 0;
            for (int x = maxLeft; x <= maxRight; x++) {
                try {

                    boolean renderVoid = hideUnexplored && !world.getTile(x, y).explored;
                    miniMap[yCount][xCount] = renderVoid ?"█": String.valueOf(world.getTile(x, y).repr());

                } catch (IndexOutOfBoundsException e) {
                    miniMap[yCount][xCount] = " ";
                }

                xCount++;
            }

            yCount++;
        }

        miniMap[radius][radius] = "X";

        // Print top section
        System.out.print("╔");
        for (int i = 0; i < (miniMap.length*2)+1; i++) {
            System.out.print("═");
        }
        System.out.println("╗");

        // Prints the middle section
        for (String[] row : miniMap) {
            System.out.print("║ ");
            for (String item : row) {
                System.out.print(item + " ");
            }
            System.out.print("║");
            System.out.println();
        }

        // Print bottom section
        System.out.print("╚");
        for (int i = 0; i < (miniMap.length*2)+1; i++) {
            System.out.print("═");
        }
        System.out.println("╝");
    }

    private static void renderMiniMap(World world, Player player) {
        renderMiniMap(world, player, 1, false);
    }

    public static String startIntroduction(Scanner scan) throws InterruptedException {
        // ===
        // MAIN MENU
        // ===
        Screen.clear();
        // runLogo(scan);

        Screen.typed("First, there was nothing.");
        Screen.typed("Then, there was something.");
        Screen.typed("That something was you, a Pokemon Master, destined for greatness.");
        Screen.typed("Even though you are eternally 11 years old, and have no dad, you are destined for greatness.");
        Screen.typed("Your mom is supportive, but she just stands awkwardly in the kitchen for the whole game and that's literally her entire purpose.");
        Screen.typed("One day though, you received a mysterious letter from The Professor.");
        Screen.typed("It read:");
        System.out.println("");
        Screen.typed("Dear Pokemon Master,");
        System.out.println("");
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

    public static void runLogo(Scanner scan) throws InterruptedException {
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
        Screen.clear();
    }
}
