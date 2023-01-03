package utils.user;

import java.util.Scanner;

/**
 * This class is used for
 * safely, and non-repetitiously
 * asking the user for an
 * answer.
 */
public class Question {
    public static final String[] trueAnswers = {
        "yes",
        "indeed",
        "mhm",
        "true",
        "t",
        "y",
        "yep",
        "uh-huh"
    };

    public static final String[] falseAnswers = {
        "no",
        "not at all",
        "nah",
        "false",
        "f",
        "n",
        "nope",
        "nuh-uh"
    };
    
    /**
     * Obtain a String from the user.
     * @param scan The scanner object
     * @param question The question being asked of the user
     * @return Their answer
     */
    public static String requestString(Scanner scan, String question) {
        System.out.println(question);
        System.out.print(">>> ");
        return scan.nextLine();
    }

    public static void printIndexedArray(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            String item = arr[i];
            System.out.println("[" + i + "] " + item);
        }
    }

    /**
     * @return The user's answer as an integer.
     */
    public static int requestInt(Scanner scan, String question) {
        while (true) {
            String answer = requestString(scan, question);

            try {
                return Integer.parseInt(answer);
            } catch (Exception e) {
                System.out.println("Your answer was not an integer.");
            }
        }
    }

    /**
     * @param options The available options for the user to choose.
     * @return The number index they chose
     */
    public static int chooseItem(Scanner scan, String question, String... options) {
        while (true) {
            printIndexedArray(options);
            int answer = requestInt(scan, question);

            if (answer < options.length && answer >= 0) return answer;
            else {
                System.out.println("Your answer was not within the range of options.");
            }
        }
    }

    public static Object chooseItem(Scanner scan, String question, String[] options, Object[] answers) {
        while (true) {
            printIndexedArray(options);
            int answer = requestInt(scan, question);

            if (answer < options.length && answer >= 0) return answers[answer];
            else {
                System.out.println("Your answer was not within the range of options.");
            }
        }
    }

    /**
     * @return The user's answer as a float
     */
    public static float requestFloat(Scanner scan, String question) {
        while (true) {
            String answer = requestString(scan, question);

            try {
                return Float.parseFloat(answer);
            } catch (Exception e) {
                System.out.println("Your answer was not an float.");
            }
        }
    }

    /**
     * @return The user's answer as a boolean
     */
    public static boolean requestBoolean(Scanner scan, String question) {
        while (true) {
            String answer = requestString(scan, question);

            answer = answer.strip().toLowerCase();

            if (checkIfInArr(trueAnswers, answer)) return true;
            else if (checkIfInArr(falseAnswers, answer)) return false;
            else {
                System.out.println("Your answer was not a valid yes or no.");
            }
        }
    }

    /**
     * Check if the given object
     * is inside of the array.
     * @param x The array
     * @param toFind The object to find
     * @return True if the object is found
     */
    private static boolean checkIfInArr(String[] x, String toFind) {
        for (String x2 : x) {
            if (x2.equals(toFind)) {
                return true;
            }
        }
        return false;
    }
}
