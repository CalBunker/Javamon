package utils.save;

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

import primary.World;
import utils.user.Question;

public class Save implements Serializable {
    private static final long serialVersionUID = 32L;

    private static final String FOLDER_LOCATION = "data";

    public static int counter = 0;

    private String fileName;
    private long id;
    World world;

    public Date date_made;

    public Save(World world) {
        counter++;

        date_made = new Date();
        this.world = world;

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

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public Save updateDate() {
        date_made = new Date();
        return this;
    }

    public static Save chooseSaves(Scanner scan, Save[] saves) {
        String[] options = new String[saves.length+1];

        // Arrange items into list
        for (int i = 0; i < saves.length; i++) {
            Save item = saves[i];
            Date date = item.date_made;

            options[i] = date.toString();
        }
        options[options.length-1] = "New Save";

        // Ask for user to choose option
        int answer = Question.chooseItem(scan, "Please choose a save", options);

        // If they choose new save, make a new save
        if (options[answer].equals(options[options.length-1])) return null;

        return saves[answer];
    }
}
