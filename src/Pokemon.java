public class Pokemon {
    // Pokemon Name
    private String name;
    // Catchrate
    private double catchrate;
    // Pokemon Type
    private String type;
    // Pokemon Level
    private int level;

    // The types of pokemon
    enum PokemonType {
        DARK, 
        DRAGON, 
        ELECTRIC, 
        GHOST, 
        GRASS, 
        GROUND, 
        FIGHTING, 
        FIRE,  
        NORMAL, 
        POISON,
        PSYCHIC, 
        ROCK, 
        WATER        
    }

    // Initialize Pokemon
    public Pokemon(String name, double catchrate, String type, int level) {
        this.name = name;
        this.catchrate = catchrate;
        this.type = type;
        this.level = level;
    }

    // Get Pokemon Name
    public String getName() {
        return name;
    }

    // Get Catchrate
    public double getCatchrate() {
        return catchrate;
    }

    // Get Pokemon Type
    public String getType() {
        return type;
    }

    // Get Pokemon Level
    public int getLevel() {
        return level;
    }
}