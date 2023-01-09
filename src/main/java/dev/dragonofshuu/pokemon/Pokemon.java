package dev.dragonofshuu.pokemon;

import java.io.Serializable;

public class Pokemon implements Serializable {
    private static final long serialVersionUID = 32L;
    
    // Pokemon Name
    private String name;
    // Pokemon Level
    private int level;

    /**
     * Initialize the Pokemon.
     * @param name The name of the pokemon
     * @param level The level of the pokemon
     */
    public Pokemon(String name, int level) {
        this.name = name;
        this.level = level;
    }

    /**
     * @return The name of the Pokemon
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name+" lvl "+level;
    }

    /**
     * @return The level the pokemon 
     * is at.
     */
    public int getLevel() {
        return level;
    }
}