package dev.dragonofshuu.utils.save;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.Scanner;

import dev.dragonofshuu.player.Player;
import dev.dragonofshuu.primary.Game;
import dev.dragonofshuu.utils.user.Question;
import dev.dragonofshuu.utils.user.editables.EditUI;
import dev.dragonofshuu.utils.user.editables.EditableItem;

public class Save implements Serializable, EditableItem {
    private static final long serialVersionUID = 32L;

    private static final String FOLDER_LOCATION = "data";

    public static int counter = 0;

    private String fileName;
    private long id;
    // World world;
    Game game;

    public Date date_made;
    public String name;

    private boolean favorite;

    public Save(Game game) {
        counter++;

        date_made = new Date();
        this.game = game;

        id = (System.currentTimeMillis() / 2l) + counter;
        fileName = FOLDER_LOCATION + "/" + id + ".dat";
    }

    public boolean saveGame() {
        File d = new File(FOLDER_LOCATION);
        if (!d.exists()) {
            d.mkdir();
        }

        try {
            // Delete the current file if it exists, and recreate.
            File f = new File(fileName);
            if (f.exists() && !f.isDirectory()) {
                f.delete();
            }
            f.createNewFile();
    
            FileOutputStream output = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(output);
    
            oos.writeObject(this);
    
            oos.close();
            output.close();

            return true;
        } catch (IOException e) {
            System.out.println("The game could not be saved. Make sure the game is not in a read only folder. Error:");
            e.printStackTrace();
            return false;
        }
    }

    public static Save[] loadGame() throws FileNotFoundException {
        File folder = new File(FOLDER_LOCATION);
        File[] allSaves = folder.listFiles();

        if (allSaves == null || allSaves.length==0) {
            throw new FileNotFoundException("The files don't exist.");
        }

        try {

            Save[] data = new Save[allSaves.length];
            for (int i = 0; i < allSaves.length; i++) {
                File file = allSaves[i];
    
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                Save currentSave = (Save) objectInputStream.readObject();
    
                data[i] = currentSave;
    
                objectInputStream.close();
                fileInputStream.close();
            }

            return data;

        } catch (IOException e) {
            System.out.println("The game could not load saves. Make sure the game is not in a read only folder. Error:");
            e.printStackTrace();
            return new Save[0];
        } catch (ClassNotFoundException e) {
            System.out.println("Your save files are corrupted. Please manually remove. (game_dir/data/)");
            return new Save[0];
        }
    }

    public Game getGame() {
        return this.game;
    }

    public void setWorld(Game game) {
        this.game = game;
    }

    public Save updateDate() {
        date_made = new Date();
        return this;
    }

    public static EditUI chooseSaves(Scanner scan, Save[] saves) {
        EditUI eUI = new EditUI(saves);

        eUI.initialize(scan, "Please choose a save", saves[0], null);
        
        if (eUI.createNew) return null;

        return eUI;
    }

    @Override
    public boolean canDelete() {return true;}

    @Override
    public Success delete() {
        File f = new File(fileName);
        f.delete();
        return Success.TRUE;
    }

    @Override
    public boolean canAdd() {return true;}

    @Override
    public Success add() {
        return null;
    }

    @Override
    public boolean isCompleteObjectAddition() {
        return true;
    }

    @Override
    public boolean canRename() {return true;}

    @Override
    public Success rename(Scanner scan) {
        name = Question.requestString(scan, "Enter a new name");
        saveGame();

        return Success.TRUE;
    }

    @Override
    public boolean canUse() {return true;}

    @Override
    public Success use(Player instigator) {
        return Success.TRUE;
    }

    @Override
    public String toString() {
        if (name == null) return date_made.toString();
        else              return name;
    }

    @Override
    public boolean canFavorite() { return true; }

    @Override
    public Boolean toggleFavorite() {
        favorite = !favorite;
        saveGame();
        return favorite; 
    }

    @Override
    public boolean isFavorite() { return favorite; }
}