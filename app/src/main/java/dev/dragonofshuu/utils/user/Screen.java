package dev.dragonofshuu.utils.user;

import java.util.Scanner;

public class Screen {
    /**
     * Clear the screen of all
     * text (doesn't always work;
     * depends on the platform,
     * and the terminal used.)
     */
    public static void clear() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    /**
     * Type out text character
     * by character
     * @param text The text to print out
     * @param millInBetween The amount of 
     * milliseconds between each character.
     */
    public static void typed(String text, int millInBetween) {
        char[] printable = text.toCharArray();
        
        try {
            for (char p : printable) {
                System.out.print(p);
                Thread.sleep(millInBetween);
            }
        } catch (InterruptedException e) {
            System.out.println();
            System.out.println(text);
        }

        System.out.println();
    }

    /**
     * Type out text character
     * by character. (defaults to
     * 80 milliseconds between
     * each character)
     * @param text The text to print out.
     */
    public static void typed(String text) {
        typed(text, 10);
    }

    /**
     * Wait for the user to press
     * enter.
     * @param scan The Scanner object
     * in the current context.
     */
    public static void awaitUser(Scanner scan) {
        System.out.println("<Press Enter to Continue>");
        scan.nextLine();
    }
}
