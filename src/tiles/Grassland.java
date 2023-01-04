package tiles;
import utils.user.*;
import utils.Statics;

import java.util.Scanner;

import battle.PokeBattle;
import pokemon.*;
import primary.*;

public class Grassland extends Tile {
    public Pokemon genPokemon(){
        int pokeR = Statics.genRNum(0,1);

        if (pokeR == 1) return null;

        int pokeType = Statics.genRNum(0, 3);
        
        return switch (pokeType) {
            case 0 -> new Water(Statics.genRNum(1,25));
            case 1 -> new Grass(Statics.genRNum(1,25));
            case 2 -> new Fire(Statics.genRNum(1,25));
            default -> new Normal(Statics.genRNum(1,25));
        };
    }

    @Override
    public void activate(Player player, Scanner scan) {
        Pokemon pokemon = genPokemon();

        // If there is no pokemon
        if (pokemon == null) { Screen.typed("You found nothing. :("); return; }

        PokeBattle.handlePokemon(pokemon, player, scan);
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