package tiles;
import utils.user.*;
import utils.Statics;

import java.util.Scanner;

import battle.PokeBattle;
import pokemon.*;
import primary.*;

public class Swamp extends Tile {
    public Pokemon genPokemon(){
        int pokeR = Statics.genRNum(0,1);

        if (pokeR == 1) return null;

        int pokeType = Statics.genRNum(0, 3);

        return
            switch (pokeType) {
                    case 0 -> new Ghost(Statics.genRNum(61,85));
                    case 1 -> new Dark(Statics.genRNum(61,85));
                    default -> new Poison(Statics.genRNum(61,85));
            };
    }

    @Override
    public void activate(Player player, Scanner scan) {
        Screen.typed("You entered the swamp...");
        Screen.awaitUser(scan);

        Pokemon pokemon = genPokemon();
        
        if (pokemon == null) { Screen.typed("You found nothing. :("); return; }

        PokeBattle.handlePokemon(pokemon, player, scan);
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
