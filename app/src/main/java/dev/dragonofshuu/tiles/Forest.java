package dev.dragonofshuu.tiles;
import dev.dragonofshuu.utils.user.*;
import dev.dragonofshuu.utils.Statics;

import java.util.Scanner;

import dev.dragonofshuu.dragons.*;
import dev.dragonofshuu.events.DragonEncounter;
import dev.dragonofshuu.player.Player;

public class Forest extends Tile {
    private static final long serialVersionUID = 32L;

    @Override
    public void activate(Player player, Scanner scan) {
        Screen.typed("You entered the forest...");
        Screen.awaitUser(scan);

        Dragon pokemon = genPokemon( 10,
            new Hydro(Statics.genRNum(21,45)),
            new Anemo(Statics.genRNum(21,45)),
            new Geo(Statics.genRNum(21,45)),
            new Dendro(Statics.genRNum(21,45))
        );
        
        if (pokemon == null) { Screen.typed("You found nothing. :("); return; }

        new DragonEncounter().handleEvent(pokemon, player, scan);
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
