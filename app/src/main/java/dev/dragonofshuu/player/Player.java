package dev.dragonofshuu.player;

import java.io.Serializable;

import dev.dragonofshuu.dragons.Dragon;
import dev.dragonofshuu.player.backpack.Backpack;
import dev.dragonofshuu.utils.user.*;

public class Player implements Serializable {
    private static final long serialVersionUID = 32L;

    // Player Name
    private String name;
    // Pokemon Storage
    private Backpack dragons = new Backpack();
    // X location
    private int xPos;
    // Y location
    private int yPos;
    // Player's active Pokemon
    private Dragon activeDragon = null;
    // Player XP
    private int xp = 0;
    
    // Initialize Player
    public Player(String name, int x, int y) {
        this.name = name;
        xPos = x;
        yPos = y;
        Dragon starter = new Dragon("Shuckle", 15, 100);
        dragons.add(starter);
        activeDragon = starter;
    }

    // Get Player Name
    public String getName() {
        return name;
    }

    // Get Pokemon Storage
    public Backpack getBackpack() {
        return dragons;
    }

    // Calculate Player Level
    public int getLevel() {
        if (xp==0) return 0;
        else if (xp>=1 && xp<5) return 1;
        else if (xp>=5 && xp<10) return 2;
        else if (xp>=10 && xp < 15) return 3;
        else if (xp>=15 && xp <30) return 4;
        else if (xp>=30 && xp < 45) return 5;
        else if (xp>=45 && xp < 69) return 6;
        else if (xp==69) return 69;
        else if (xp>=70 && xp < 90) return 6;
        else if (xp>=90 && xp < 135) return 7;
        else if (xp>=135 && xp < 270) return 8;
        else if (xp>=270 && xp < 300) return 9;
        else if (xp>300) return 10;
        else return 0;
    }
    
    // Get X location
    public int getXPos() {
        return xPos;
    }

    // Get Y location
    public int getYPos() {
        return yPos;
    }

    // Get Player's active Pokemon
    public Dragon getActiveDragon() {
        return activeDragon;
    }

    // Add Pokemon to Storage
    public void addPokemon(Dragon dragon) {
        dragons.add(dragon);
        if (activeDragon == null) {
            activeDragon = dragon;
        }
        else if (dragon.getLevel() > activeDragon.getLevel()) {
            activeDragon = dragon;
        }
    }

    // Remove Pokemon from Storage
    public void removePokemon(Dragon dragon) {
        dragons.remove(dragon);
    }

    // Grants the player XP, silence bool silences the level up text
    public void addXP(int amount, boolean silence){
        int lvl = getLevel();
        xp += amount;

        // If their level is the same, or there needs to be silence,
        // exit the method
        if (getLevel() == lvl || silence) return;

        Screen.typed("You leveled up! Your new player level is: "+getLevel());
    }

    public void addXP(int amount) {
        addXP(amount, false);
    }

    // Set X location
    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    // Set Y location
    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

    // Set Player's active Pokemon
    public void setActivePokemon(Dragon newActive) {
        activeDragon = newActive;
    }

    // Print out the Pokemon in the player's bag
    public void printBag() {
        for (int i = 0; i < dragons.size(); i++) {
            Screen.typed(dragons.get(i).toString());
        }
    }

    // Moves the player based on an x input and y input
    public void movePlayer(int x, int y) {
        xPos += x;
        yPos += y;
    }
}