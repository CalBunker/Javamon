package tiles;
import utils.user.*;
import utils.Statics;

import java.util.Scanner;

import battle.PokeBattle;
import pokemon.*;
import primary.*;

public class Mistlands extends Tile {
    private static final long serialVersionUID = 32L;

    public Pokemon genPokemon(){
        int pokeR = Statics.genRNum(0,2);

        if (pokeR == 1) return null;

        return new Dragon(Statics.genRNum(76,99));        
    }

    @Override
    public void activate(Player player, Scanner scan) {
        Screen.typed("You entered the mistlands...");
        Screen.awaitUser(scan);

        Pokemon pokemon = genPokemon();
        
        if (pokemon == null) { Screen.typed("You found nothing. :("); return; }

        PokeBattle.handlePokemon(pokemon, player, scan);
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
