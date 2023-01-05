package tiles;
import utils.user.*;
import utils.Statics;

import java.util.Scanner;

import battle.PokeBattle;
import pokemon.*;
import primary.*;

public class Mountain extends Tile {
    private static final long serialVersionUID = 32L;

    public Pokemon genPokemon(){
        int pokeR = Statics.genRNum(0,2);
        
        if (pokeR == 1) return null;
            
        int pokeType = Statics.genRNum(0, 4);

        return
            switch (pokeType) {
                    case 0 -> new Psychic(Statics.genRNum(41,65));
                    case 1 -> new Rock(Statics.genRNum(41,65));
                    case 2 -> new Ground(Statics.genRNum(41,65));
                    default -> new Electric(Statics.genRNum(41,65));
            } ;
    }

    @Override
    public void activate(Player player, Scanner scan) {
        Screen.typed("You entered the mountain...");
        Screen.awaitUser(scan);

        Pokemon pokemon = genPokemon();
        
        if (pokemon == null) { Screen.typed("You found nothing. :("); return; }

        PokeBattle.handlePokemon(pokemon, player, scan);
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
