package tiles;
import utils.user.*;
import utils.Statics;

import java.util.Scanner;

import events.PokeEncounter;
import pokemon.*;
import primary.*;

public class Grassland extends Tile {
    private static final long serialVersionUID = 32L;

    @Override
    public void activate(Player player, Scanner scan) {
        Screen.typed("You entered the grassland...");
        Screen.awaitUser(scan);
        
        Pokemon pokemon = genPokemon(
            new Water(Statics.genRNum(1,25)),
            new Grass(Statics.genRNum(1,25)),
            new Fire(Statics.genRNum(1,25)),
            new Normal(Statics.genRNum(1,25))
        );

        // If there is no pokemon
        if (pokemon == null) { Screen.typed("You found nothing. :("); return; }

        new PokeEncounter().handleEvent(pokemon, player, scan);
    }

    @Override
    public char repr() {
        return 'G';
    }

    @Override
    public String getName() {
        return "Grassland";
    }
}