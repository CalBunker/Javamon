package tiles;
import utils.user.*;
import utils.Statics;

import java.util.Scanner;

import events.PokeEncounter;
import pokemon.*;
import primary.*;

public class Mistlands extends Tile {
    private static final long serialVersionUID = 32L;

    @Override
    public void activate(Player player, Scanner scan) {
        Screen.typed("You entered the mistlands...");
        Screen.awaitUser(scan);

        Pokemon pokemon = genPokemon( 10,
            new Dragon(Statics.genRNum(76,99))
        );
        
        if (pokemon == null) { Screen.typed("You found nothing. :("); return; }

        new PokeEncounter().handleEvent(pokemon, player, scan);
    }

    @Override
    public char repr() {
        return 'L';
    }

    @Override
    public String getName() {
        return "Mistlands";
    }
}
