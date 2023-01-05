package tiles;
import java.io.Serializable;
import java.util.Scanner;

import pokemon.Pokemon;
import primary.Player;

public abstract class Tile implements Serializable {
    private static final long serialVersionUID = 32L;

    public abstract Pokemon genPokemon();
    public Pokemon Spawnables;

    public boolean explored = false;

    public abstract void activate(Player player, Scanner scan);
    public final void activation(Player player, Scanner scan) {
        explored = true;
        activate(player, scan);
    }

    public char repr() {
        return 'T';
    }

    public String getName() {
        return "Tile";
    }
}