import java.util.Scanner;

import utils.user.Screen;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        World world = GameManager.setup(scan);
        
        boolean bContinue = true;
        while (bContinue) {

            bContinue = GameManager.mainLoop(scan, world);
            
            if (bContinue) Screen.awaitUser(scan);

        }

        scan.close();
    }
}
