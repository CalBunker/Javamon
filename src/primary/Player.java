package primary;

import java.util.Scanner;

import java.util.ArrayList;
import pokemon.Pokemon;
import utils.user.*;

public class Player {
    // Player Name
    private String name;
    // Pokemon Storage
    private ArrayList<Pokemon> Pokemon = new ArrayList<Pokemon>();
    // X location
    private int xPos;
    // Y location
    private int yPos;
    // Player's active Pokemon
    private Pokemon activePokemon = null;
    // Player XP
    private int xp = 0;
    
    // Initialize Player
    public Player(String name, int x, int y) {
        this.name = name;
        xPos = x;
        yPos = y;
        Pokemon starter = new Pokemon("Shuckle", 15);
        Pokemon.add(starter);
        activePokemon = starter;
    }

    // Get Player Name
    public String getName() {
        return name;
    }

    // Get Pokemon Storage
    public ArrayList<Pokemon> getPokemon() {
        return Pokemon;
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
    public Pokemon getActivePokemon() {
        return activePokemon;
    }

    // Add Pokemon to Storage
    public void addPokemon(Pokemon pokemon) {
        Pokemon.add(pokemon);
        if (activePokemon == null) {
            activePokemon = pokemon;
        }
        else if (pokemon.getLevel() > activePokemon.getLevel()) {
            activePokemon = pokemon;
        }
    }

    // Remove Pokemon from Storage
    public void removePokemon(Pokemon pokemon) {
        Pokemon.remove(pokemon);
    }

    // Grants the player XP, silence bool silences the level up text
    public void addXP(int amount, boolean silence, Scanner scan){
        if (silence){
        } else {
            int lvl = getLevel();
            xp =+ amount;

            if (getLevel() != lvl){

                Screen.typed("You leveled up! Your new player level is: "+getLevel());
                scan.nextLine();

            } else{
            }
        }
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
    public void setActivePokemon(Pokemon newActive) {
        activePokemon = newActive;
    }

    // Print out the Pokemon in the player's bag
    public void printBag() {
        for (int i = 0; i < Pokemon.size(); i++) {
            Screen.typed(Pokemon.get(i).printName());
        }
    }

    // Moves the player based on an x input and y input
    public void movePlayer(int x, int y) {
        xPos += x;
        yPos += y;
    }
}