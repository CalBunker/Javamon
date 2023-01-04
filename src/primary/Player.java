package primary;
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
    }

    // Remove Pokemon from Storage
    public void removePokemon(Pokemon pokemon) {
        Pokemon.remove(pokemon);
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
    public void setActivePokemon(Pokemon activePokemon) {
        this.activePokemon = activePokemon;
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