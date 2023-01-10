package dev.dragonofshuu;

import java.io.FileNotFoundException;
import java.util.Scanner;

import dev.dragonofshuu.primary.GameManager;
import dev.dragonofshuu.primary.World;
import dev.dragonofshuu.utils.save.Save;
import dev.dragonofshuu.utils.user.Question;
import dev.dragonofshuu.utils.user.Screen;
import dev.dragonofshuu.utils.user.editables.EditUI;
import dev.dragonofshuu.utils.user.editables.EditUI.ExitType;

public class App {
    /**
     * Load the save object from
     * the file by the help of 
     * the user.
     * @param scan The current
     * Scanner object in the current
     * context.
     * @return The Save chosen
     * by the user.
     */
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

        GameManager.runLogo(scan);

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
