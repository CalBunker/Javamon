package tiles;
import utils.user.*;
import utils.Statics;

import java.util.Scanner;

import battle.PokeBattle;
import pokemon.*;
import primary.*;

public class Forest extends Tile {
    private static final long serialVersionUID = 32L;

    @Override
    public void activate(Player player, Scanner scan) {
        Screen.typed("You entered the forest...");
        Screen.awaitUser(scan);

        Pokemon pokemon = genPokemon(
            new Water(Statics.genRNum(21,45)),
            new Grass(Statics.genRNum(21,45)),
            new Fighting(Statics.genRNum(21,45)),
            new Normal(Statics.genRNum(21,45))
        );
        
        if (pokemon == null) { Screen.typed("You found nothing. :("); return; }

        PokeBattle.handlePokemon(pokemon, player, scan);
    }

    @Override
    public char repr() {
        return 'F';
    }

    @Override
    public String getName() {
        return "Forest";
    }
}
