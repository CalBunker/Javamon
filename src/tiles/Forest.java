package tiles;
import utils.user.*;
import utils.Statics;

import java.util.Scanner;

import battle.PokeBattle;
import pokemon.*;
import primary.*;

public class Forest extends Tile {
    public Pokemon genPokemon(){
        int pokeR = Statics.genRNum(0,1);

        if (pokeR == 1) return null;

        int pokeType = Statics.genRNum(0, 3);
        
        return
            switch (pokeType) {
                    case 0 -> new Water(Statics.genRNum(21,45));
                    case 1 -> new Grass(Statics.genRNum(21,45));
                    case 2 -> new Fighting(Statics.genRNum(21,45));
                    default -> new Normal(Statics.genRNum(21,45));
            };
    }

    @Override
    public void activate(Player player, Scanner scan) {
        Screen.typed("You entered the forest...");
        Pokemon pokemon = genPokemon();
        
        if (pokemon == null) { Screen.typed("You found nothing. :("); return; }

        PokeBattle.handlePokemon(pokemon, player, scan);
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
