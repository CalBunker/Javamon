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
     * Prints out an array item by item.
     * <hr/>
     * <strong>Note:
     * If a "-" is inputted, it will be ignored.
     * </strong>
     * <hr/>
     * @param arr The array to make elements of
     */
    public static void printIndexedArray(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            String item = arr[i];
            if (item.equals("-")) { System.out.println(); continue; }
            System.out.println("[" + i + "] " + item);
        }
    }
    
    /**
     * Obtain a String from the user.
     * @param scan The scanner object
     * @param question The question being asked of the user
     * @return Their answer
     */
    public static String requestString(Scanner scan, String question) {
        System.out.println(question);
        System.out.print("> ");
        return scan.nextLine();
    }

    /**
     * Request a String
     * with possible answers
     * from the user.
     * @param scan The current
     * Scanner object in the
     * current context.
     * @param question The
     * question to ask the user.
     * @param answers Possible
     * answers for the user to
     * input; basically a levelled
     * up version of request an
     * integer with a list of
     * options.
     * @return
     */
    public static String requestString(Scanner scan, String question, String... answers) {
        String[] possibleAnswers = new String[answers.length];
        for (int i = 0; i < answers.length; i++) {
            possibleAnswers[i] = answers[i].toLowerCase().strip();
        }

        String stringedAnswer = "";
        for (String a : answers) {
            stringedAnswer += " - " + a + "\n";
        }

        while (true) {
            String answer = requestString(scan, question+"\n"+stringedAnswer);
            answer = answer.strip().toLowerCase();

            if (checkIfInArr(possibleAnswers, answer)) return answer;
            else {
                System.out.println("That was not an allowed answer.");
            }
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

    /**
     * Have a user choose an
     * option, and return the
     * associated object with
     * their answer.
     * @param scan
     * @param question
     * @param options
     * @param answers
     * @return
     */
    public static Object chooseItem(Scanner scan, String question, String[] options, Object[] answers) {
        if (options.length != answers.length) {
            throw new ArrayStoreException("The options answer need to be the same length.");
        }

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
     * Converts the user's answer
     * from a normal English string
     * into an true/false statement.
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
