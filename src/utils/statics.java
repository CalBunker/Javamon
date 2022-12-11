package utils;

import java.util.Random;

public class statics {
    public static int genRNum(int min, int max) 
    throws IndexOutOfBoundsException {
        
        if (max < min) {
            throw new IndexOutOfBoundsException("Minimum cannot be larger than maximum");
        }

        Random rand = new Random();
        return rand.nextInt(max-min)+min;
    }

    /**
     * Pick a random item from
     * a list of Strings.
     * @param x The List of Strings
     * @return The random item chosen.
     */
    public static String pickRItem(String[] x) {
        return x[new Random().nextInt(x.length-1)];
    }
}
