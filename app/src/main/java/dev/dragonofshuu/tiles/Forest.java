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

        Dragon dragon = genDragon( 10,
            new Water(Statics.genRNum(21,45), 100),
            new Wind(Statics.genRNum(21,45), 100),
            new Earth(Statics.genRNum(21,45), 100),
            new Nature(Statics.genRNum(21,45), 100)
        );
        
        if (dragon == null) { Screen.typed("You found nothing. :("); return; }

        new DragonEncounter().handleEvent(dragon, player, scan);
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
