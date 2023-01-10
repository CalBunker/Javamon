package dev.dragonofshuu.tiles;
import dev.dragonofshuu.utils.user.*;
import dev.dragonofshuu.utils.Statics;

import java.util.Scanner;

import dev.dragonofshuu.dragons.*;
import dev.dragonofshuu.events.DragonEncounter;
import dev.dragonofshuu.player.Player;
public class Grassland extends Tile {
    private static final long serialVersionUID = 32L;

    @Override
    public void activate(Player player, Scanner scan) {
        Screen.typed("You entered the grassland...");
        Screen.awaitUser(scan);
        
        Dragon pokemon = genPokemon(10,
            new Hydro(Statics.genRNum(1,25)),
            new Anemo(Statics.genRNum(1,25)),
            new Pyro(Statics.genRNum(1,25)),
            new Dendro(Statics.genRNum(1,25))
        );

        // If there is no pokemon
        if (pokemon == null) { Screen.typed("You found nothing. :("); return; }

        new DragonEncounter().handleEvent(pokemon, player, scan);
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