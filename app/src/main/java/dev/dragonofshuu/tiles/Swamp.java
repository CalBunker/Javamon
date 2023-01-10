package dev.dragonofshuu.tiles;
import dev.dragonofshuu.utils.user.*;
import dev.dragonofshuu.utils.Statics;

import java.util.Scanner;

import dev.dragonofshuu.dragons.*;
import dev.dragonofshuu.events.DragonEncounter;
import dev.dragonofshuu.player.Player;

public class Swamp extends Tile {
    private static final long serialVersionUID = 32L;

    @Override
    public void activate(Player player, Scanner scan) {
        Screen.typed("You entered the swamp...");
        Screen.awaitUser(scan);

        Dragon pokemon = genPokemon( 10,
            new Hydro(Statics.genRNum(61,85)),
            new Dendro(Statics.genRNum(61,85)),
            new Electro(Statics.genRNum(41,65))
        );
        
        if (pokemon == null) { Screen.typed("You found nothing. :("); return; }

        new DragonEncounter().handleEvent(pokemon, player, scan);
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
