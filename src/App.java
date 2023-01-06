import java.io.FileNotFoundException;
import java.util.Scanner;

import primary.GameManager;
import primary.World;
import utils.save.Save;
import utils.user.Question;
import utils.user.Screen;
import utils.user.editables.EditUI;
import utils.user.editables.EditUI.ExitType;

public class App {
    public static Save determineSave(Scanner scan) {
        Save[] saves;

        try {
            // Attempt to load the saves
            saves = Save.loadGame();

        } catch (FileNotFoundException e) {
            // If failure, start the game like it has never been played
            return new Save(GameManager.setup(scan, true));
        }

        Save save;
        while (true) {
            EditUI results = Save.chooseSaves(scan, saves);

            if (results == null) {
                save = null;
                break;
            }
            else if (results.exitType == ExitType.EXIT) continue;
            else {
                save = (Save) results.returnItem;
                break;
            }
        }

        // If the player chooses a save, load the save
        if (save != null) return save.updateDate();

        // If the player chooses to make a new save,
        // ask to play the intro, and then run the
        // setup.
        boolean playIntro = Question.requestBoolean(scan, "Run the intro?");
        return new Save(GameManager.setup(scan, playIntro));
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Screen.clear();

        Save mainSave = determineSave(scan);
        World world = mainSave.getWorld();
        
        boolean bContinue = true;
        while (bContinue) {

            bContinue = GameManager.mainLoop(scan, world);
            
            mainSave.saveGame();

            if (bContinue) Screen.awaitUser(scan);
        }

        scan.close();
    }
}
