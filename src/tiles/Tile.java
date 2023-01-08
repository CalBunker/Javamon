package tiles;
import java.io.Serializable;
import java.util.Scanner;

import pokemon.Pokemon;
import primary.Player;
import utils.Statics;

public abstract class Tile implements Serializable {
    private static final long serialVersionUID = 32L;

    public Pokemon Spawnables;

    public boolean explored = false;

    public abstract void activate(Player player, Scanner scan);
    public final void activation(Player player, Scanner scan) {
        explored = true;
        activate(player, scan);
    }

    /**
     * 
     * @param outOfChance The chance a pokemon will spawn;
     * the higher the number, the lower the chance.
     * @param pokemonToSpawn The pokemon that should attempt
     * to be spawned
     * @return A possible pokemon
     */
    public Pokemon genPokemon(int outOfChance, Pokemon... pokemonToSpawn) {
        int pokeR = Statics.genRNum(0, outOfChance);
        
        if (pokeR == 0) return null;

        return Statics.pickRItem(pokemonToSpawn);
    }

    public Pokemon genPokemon(Pokemon... pokemonToSpawn) {
        return genPokemon(2, pokemonToSpawn);
    }

    public char repr() {
        return 'T';
    }

    public String getName() {
        return "Tile";
    }
}