package tiles;
import utils.user.*;
import utils.Statics;
import pokemon.*;
import primary.*;

public class Mountain extends Tile {
    public Pokemon genPokemon(){
        boolean findPoke;
        int pokeR = Statics.genRNum(0,1);
        if (pokeR == 0) {
            int pokeType = Statics.genRNum(0, 2);
            Pokemon pokemon =
            switch (pokeType) {
                  case 0 -> new Psychic(Statics.genRNum(41,65));
                  case 1 -> new Rock(Statics.genRNum(41,65));
                  case 2 -> new Ground(Statics.genRNum(41,65));
                  default -> new Electric(Statics.genRNum(41,65));
            } ;
        }else {
            return null;
        }
    }

    @Override
    public void activate(Player player) {
        Pokemon pokemon = genPokemon();
        if (pokemon != null) {
            Screen.typed("You found a " + pokemon.getName()+"!");
            boolean win = encounterBattle(pokemon, player);
            Screen.typed("1 - Fight!");
            Screen.typed("2 - Catch!");
            Screen.typed("3 - Run!");
            int action = scan.nextLine();
            while (action != 1 || action != 2 || action != 3) {
                Screen.typed("Please enter a valid action.");
                action = scan.nextLine();
            }
            if (action == 1) {
                if (win) {
                    Screen.typed("You won the battle!");
                    player.addPokemon(pokemon);
                    Screen.typed("Would you like to catch the wild Pokemon? (y/n)");
                    String action2 = scan.nextLine();
                    while (action2 != "y" || action2 != "n") {
                        Screen.typed("Please enter a valid action.");
                        action2 = scan.nextLine();
                    }
                    if (action2 == "y") {
                        Screen.typed("You caught the pokemon!");
                        player.addPokemon(pokemon);
                    } else {
                        Screen.typed("You left the poor thing to die. :(");
                    }
                } else {
                    Screen.typed("You lost the battle, and your Pokemon died!");
                    player.removePokemon(pokemon);
                }
            } else if (action == 2) {
                boolean win2 = calculateCatch(pokemon);
                if (win2) {
                    Screen.typed("You caught the pokemon!");
                    player.addPokemon(pokemon);
                } else {
                    Screen.typed("You failed to catch the pokemon :(");
                }
            } else if (action == 3) {
                Screen.typed("You ran away!");
            }
        } else {
            Screen.typed("You found nothing. :(");
        }
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
