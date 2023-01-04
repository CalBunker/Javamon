package tiles;
import utils.user.*;

import java.util.Scanner;

import pokemon.Pokemon;
import primary.*;

public class Home extends Tile {
    @Override
    public Pokemon genPokemon() {
        return null;
    }

    @Override
    public void activate(Player player, Scanner scan) {
        Screen.typed("You walk up to your house.");
        Screen.typed("\"Hello, " + player.getName() + "!\", your mother says.");
        Screen.typed("That's all. You can't do anything else here.");
    }

    @Override
    public char repr() {
        return 'H';
    }

    @Override
    public String getName() {
        return "Home";
    }
}
