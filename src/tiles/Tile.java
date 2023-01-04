package tiles;
import java.util.Scanner;

import pokemon.Pokemon;
import primary.Player;

public abstract class Tile {
    public abstract void activate(Player player, Scanner scan);
    public abstract Pokemon genPokemon();
    public Pokemon Spawnables;

    public char repr() {
        return 'T';
    }

    public String getName() {
        return "Tile";
    }
}