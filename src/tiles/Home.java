package tiles;
import utils.user.*;

import java.util.Scanner;

import primary.*;

public class Home extends Tile {
    private static final long serialVersionUID = 32L;

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
