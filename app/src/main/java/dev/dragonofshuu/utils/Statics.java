package dev.dragonofshuu.utils;

import java.util.Random;

public class Statics {
    /**
     * Generate a number between the 
     * minimum and maximum (maximum
     * not included)
     * @param min Minimum value (included)
     * @param max Maximum value (excluded)
     * @return The new random value
     * @throws IndexOutOfBoundsException If 
     * the minimum is larger than the maximum
     */
    public static int genRNum(int min, int max) 
        throws IndexOutOfBoundsException {
        
        if (max < min) {
            throw new IndexOutOfBoundsException("Minimum cannot be larger than maximum");
        }

        Random rand = new Random();

        if (max-min == 0) return 0+min;
        else              return rand.nextInt(max-min)+min;
    }

    /**
     * Pick a random item from
     * a list of Strings.
     * @param x The List of Strings
     * @return The random item chosen.
     */
    public static <T> T pickRItem(T[] x) {
        if (x.length == 0) return null;

        if (x.length == 1) return x[0];

        return x[new Random().nextInt(x.length-1)];
    }

    /**
     * Check if the given object
     * is inside of the array.
     * @param x The array
     * @param toFind The object to find
     * @return True if the object is found
     */
    public static boolean checkIfInArr(Object[] x, Object toFind) {
        for (Object x2 : x) {
            if (x2.equals(toFind)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This will allow you to invert
     * a number using a minimum and
     * maximum value.
     * @param num The number to invert
     * @param min The minimum of the bounds
     * @param max The maximum of the bounds
     * @return The new inverted number
     * <hr/>
     * {@code invertNum(0.3, 0, 1)} -> {@code 0.7}
     */
    public static float invertNum(float num, float min, float max) {
        float diff = max - min;
        float normNum = num-min;

        double percentage = ((double)normNum)/((double) diff);
        return (float) ((1-percentage)*(double) diff) + min;

    }

    /**
     * Converts a list of enums into a list of strings.
     * @param x A list of enums to convert
     * @return The list of Strings.
     */
    public static String[] fromEnumToString(Enum<?>[] x) {
        String[] appendable = new String[x.length];

        for (int i = 0; i < x.length; i++) {
            appendable[i] = x[i].name();
        }

        return appendable;
    }
}
