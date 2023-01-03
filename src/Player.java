import java.util.ArrayList;
import pokemon.APokemon;
import utils.user.*;

public class Player {
    // Player Name
    private String name;
    // Pokemon Storage
    private ArrayList<APokemon> Pokemon = new ArrayList<APokemon>();
    // X location
    private int xPos;
    // Y location
    private int yPos;
    
    // Initialize Player
    public Player(String name, int x, int y) {
        this.name = name;
        xPos = x;
        yPos = y;
    }

    // Get Player Name
    public String getName() {
        return name;
    }

    // Get Pokemon Storage
    public ArrayList<APokemon> getPokemon() {
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

    // Add Pokemon to Storage
    public void addPokemon(APokemon pokemon) {
        Pokemon.add(pokemon);
    }

    // Set X location
    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    // Set Y location
    public void setYPos(int yPos) {
        this.yPos = yPos;
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