package tiles;
import utils.user.*;
import utils.Statics;

import java.util.Scanner;

import events.PokeEncounter;
import pokemon.*;
import primary.*;

public class Mountain extends Tile {
    private static final long serialVersionUID = 32L;

    @Override
    public void activate(Player player, Scanner scan) {
        Screen.typed("You entered the mountain...");
        Screen.awaitUser(scan);

        Pokemon pokemon = genPokemon(
            new Psychic(Statics.genRNum(41,65)),
            new Rock(Statics.genRNum(41,65)),
            new Ground(Statics.genRNum(41,65)),
            new Electric(Statics.genRNum(41,65))
        );
        
        if (pokemon == null) { Screen.typed("You found nothing. :("); return; }

        PokeEncounter.handlePokemon(pokemon, player, scan);
    }

    @Override
    public char repr() {
        return 'M';
    }

    @Override
    public String getName() {
        return "Mountain";
    }
}
