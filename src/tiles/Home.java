package tiles;
import utils.user.*;
import primary.*;

public class Home extends Tile {
    @Override
    public void activate(Player player) {
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
