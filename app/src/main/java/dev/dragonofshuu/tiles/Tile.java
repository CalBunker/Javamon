package dev.dragonofshuu.tiles;
import java.io.Serializable;
import java.util.Scanner;

import dev.dragonofshuu.dragons.Dragon;
import dev.dragonofshuu.player.Player;
import dev.dragonofshuu.utils.Statics;

public abstract class Tile implements Serializable {
    private static final long serialVersionUID = 32L;

    public Dragon Spawnables;

    public boolean explored = false;

    /**
     * When the tile is stepped
     * on by the player.
     * @param player The instigator
     * player.
     * @param scan The Scanner object
     * in the current context.
     */
    public abstract void activate(Player player, Scanner scan);
    /**
     * The activation method. This 
     * makes the tile considered 
     * explored.
     * @param player The instigator
     * player.
     * @param scan The Scanner object
     * in the current context.
     */
    public final void activation(Player player, Scanner scan) {
        activate(player, scan);
        explored = true;
    }

    /**
     * 
     * @param outOfChance The chance a pokemon will spawn;
     * the higher the number, the higher the chance
     * @param dragonsToSpawn The pokemon that should attempt
     * to be spawned
     * @return A possible pokemon
     */
    public Dragon genPokemon(int outOfChance, Dragon... dragonsToSpawn) {
        int pokeR = Statics.genRNum(0, outOfChance);
        
        if (pokeR == 0) return null;

        return Statics.pickRItem(dragonsToSpawn);
    }

    /**
     * (Defaults to 1 in 2 chance of a pokemon spawning)
     * @param dragonsToSpawn The pokemon that should attempt
     * to be spawned.
     * @return A possbible pokemon
     */
    public Dragon genPokemon(Dragon... dragonsToSpawn) {
        return genPokemon(2, dragonsToSpawn);
    }

    /**
     * @return How the tile represents itself
     * as a character.
     */
    public char repr() {
        return 'T';
    }

    /**
     * @return The full name of the tile.
     */
    public String getName() {
        return "Tile";
    }
}