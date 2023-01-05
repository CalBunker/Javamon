package pokemon;

import java.io.Serializable;

public class Pokemon implements Serializable {
    private static final long serialVersionUID = 32L;
    
    // Pokemon Name
    private String name;
    // Pokemon Level
    private int level;

    // Initialize Pokemon
    public Pokemon(String name, int level) {
        this.name = name;
        this.level = level;
    }

    // Get Pokemon Name
    public String getName() {
        return name;
    }

    // Get Pokemon Level
    public int getLevel() {
        return level;
    }

    public String printName() {
        String string = name+" lvl "+level;
        return string;
    }
}