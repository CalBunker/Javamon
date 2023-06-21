package dev.dragonofshuu.tiles;
import dev.dragonofshuu.utils.user.*;
import dev.dragonofshuu.utils.Statics;

import java.util.Scanner;

import dev.dragonofshuu.dragons.*;
import dev.dragonofshuu.events.DragonEncounter;
import dev.dragonofshuu.player.Player;


public class Mistlands extends Tile {
    private static final long serialVersionUID = 32L;

    @Override
    public void activate(Player player, Scanner scan) {
        Screen.typed("You entered the mistlands...");
        Screen.awaitUser(scan);

        Dragon dragon = genDragon( 4,
            new Water(Statics.genRNum(76,99), 100),
            new Fire(Statics.genRNum(76, 99), 100)
        );
        
        if (dragon == null) { Screen.typed("You found nothing. :("); return; }

        new DragonEncounter().handleEvent(dragon, player, scan);
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
