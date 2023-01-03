package utils.user;

public class Screen {
    public static void clear() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public static void typed(String text) {
        char[] printable = text.toCharArray();
        
        try {
            for (char p : printable) {
                System.out.print(p);
                Thread.sleep(80);
            }
        } catch (InterruptedException e) {
            System.out.println();
            System.out.println(text);
        }

        System.out.println();
    }
}
