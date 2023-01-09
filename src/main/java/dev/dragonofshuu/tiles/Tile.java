package dev.dragonofshuu.tiles;
import java.io.Serializable;
import java.util.Scanner;

import dev.dragonofshuu.pokemon.Pokemon;
import dev.dragonofshuu.primary.Player;
import dev.dragonofshuu.utils.Statics;

public abstract class Tile implements Serializable {
    private static final long serialVersionUID = 32L;

    public Pokemon Spawnables;

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
     * @param pokemonToSpawn The pokemon that should attempt
     * to be spawned
     * @return A possible pokemon
     */
    public Pokemon genPokemon(int outOfChance, Pokemon... pokemonToSpawn) {
        int pokeR = Statics.genRNum(0, outOfChance);
        
        if (pokeR == 0) return null;

        return Statics.pickRItem(pokemonToSpawn);
    }

    /**
     * (Defaults to 1 in 2 chance of a pokemon spawning)
     * @param pokemonToSpawn The pokemon that should attempt
     * to be spawned.
     * @return A possbible pokemon
     */
    public Pokemon genPokemon(Pokemon... pokemonToSpawn) {
        return genPokemon(2, pokemonToSpawn);
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