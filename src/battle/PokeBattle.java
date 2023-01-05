package battle;

import java.util.Scanner;

import pokemon.Pokemon;
import primary.Player;
import utils.Statics;
import utils.user.Question;
import utils.user.Screen;

public class PokeBattle {
    public static Scanner scan;

    // does the necessary battle logic to determine a winner
    private static boolean encounterBattle(Pokemon wildPoke, Player player) {
        if (wildPoke.getLevel() > player.getActivePokemon().getLevel()) {
            return false;
        } else {
            return true;
        }
    }

    // does the necessary logic to determine if a pokemon is caught
    private static boolean calculateCatch(Pokemon pokemon, Player player) {
        int level = pokemon.getLevel();
        int catchRate = (level-(player.getLevel()*5))/4;
        
        int catchChance;
        if (catchRate > 0) {
            catchChance = Statics.genRNum(1, catchRate);
        } else {
            catchChance = 1;
        }
        
        if (catchChance == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static void handlePokemon(Pokemon pokemon, Player player, Scanner scans) {
        scan = scans;

        Screen.typed("You found a " + pokemon.getName()+"!");

        int action = Question.chooseItem(scan, "Choose an action:", "Fight!", "Catch!", "Run!");

        switch (action) {
            case 0:
                fightPoke(pokemon, player);
                break;
            case 1: 
                catchPoke(pokemon, player);
                break;
            default:
                Screen.typed("You ran away!");
                break;
        }
    }

    private static void catchPoke(Pokemon pokemon, Player player) {
        boolean win = calculateCatch(pokemon, player);

        if (win) {
            Screen.typed("You caught the pokemon!");
            player.addPokemon(pokemon);
            player.addXP(1, false, scan);
        } else {
            Screen.typed("You failed to catch the pokemon :(");
        }
    }

    private static void fightPoke(Pokemon pokemon, Player player) {
        boolean win = encounterBattle(pokemon, player);

        if (win) {
            Screen.typed("You won the battle!");
            boolean action2 = Question.requestBoolean(scan, "Would you like to catch the wild Pokemon? (y/n)");

            if (action2) {
                Screen.typed("You caught the pokemon!");
                player.addPokemon(pokemon);
                player.addXP(1, false, scan);
            } else {
                Screen.typed("You left the poor thing to die. :(");
            }

        } else {
            Screen.typed("You lost the battle, and your Pokemon died!");
            player.removePokemon(pokemon);
        }
    }
}
