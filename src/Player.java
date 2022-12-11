import java.util.ArrayList;

public class Player {
    // Player Name
    private String name;
    // Pokemon Storage
    private ArrayList<Pokemon> Pokemon = new ArrayList<Pokemon>();
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
    public ArrayList<Pokemon> getPokemon() {
        return Pokemon;
    }

    // Get Pokeball Storage
    public ArrayList<Pokeball> getPokeballs() {
        return Pokeballs;
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
    public void addPokemon(Pokemon pokemon) {
        Pokemon.add(pokemon);
    }

    // Add Pokeball to Storage
    public void addPokeball(Pokeball pokeball) {
        Pokeballs.add(pokeball);
    }

    // Set X location
    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    // Set Y location
    public void setYPos(int yPos) {
        this.yPos = yPos;
    }
}