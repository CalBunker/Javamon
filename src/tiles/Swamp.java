package tiles;
import utils.user.*;
import utils.Statics;

import java.util.Scanner;

import events.PokeEncounter;
import pokemon.*;
import primary.*;

public class Swamp extends Tile {
    private static final long serialVersionUID = 32L;

    @Override
    public void activate(Player player, Scanner scan) {
        Screen.typed("You entered the swamp...");
        Screen.awaitUser(scan);

        Pokemon pokemon = genPokemon( 10,
            new Ghost(Statics.genRNum(61,85)),
            new Dark(Statics.genRNum(61,85)),
            new Poison(Statics.genRNum(61,85))
        );
        
        if (pokemon == null) { Screen.typed("You found nothing. :("); return; }

        new PokeEncounter().handleEvent(pokemon, player, scan);
    }
    @Override
    public char repr() {
        return 'S';
    }

    @Override
    public String getName() {
        return "Swamp";
    }
}
