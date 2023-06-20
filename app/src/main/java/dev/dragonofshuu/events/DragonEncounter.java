package dev.dragonofshuu.events;

import java.util.Scanner;

import dev.dragonofshuu.dragons.Dragon;
import dev.dragonofshuu.player.Player;
import dev.dragonofshuu.utils.Statics;
import dev.dragonofshuu.utils.user.Question;
import dev.dragonofshuu.utils.user.Screen;

public class DragonEncounter extends Event {
    public static Scanner scan;

    // does the necessary battle logic to determine a winner
    private static boolean encounterBattle(Dragon wildPoke, Player player) {
        if (wildPoke.getLevel() > player.getActiveDragon().getLevel()) {
            return false;
        } else {
            return true;
        }
    }

    // does the necessary logic to determine if a dragon is caught
    private static boolean calculateCatch(Dragon dragon, Player player) {
        int level = dragon.getLevel();
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

    @Override
    public ResolveType handleEvent(Dragon dragon, Player player, Scanner scans) {
        scan = scans;

        Screen.typed("You found a " + dragon +"!");
        Screen.typed("You sent out " + player.getActiveDragon() + "!");

        int action = Question.chooseItem(scan, "Choose an action:", "Fight!", "Catch!", "Run!");

        switch (action) {
            case 0:
                fightDrago(dragon, player);
                break;
            case 1: 
                catchDrago(dragon, player);
                break;
            default:
                Screen.typed("You ran away!");
                break;
        }

        return ResolveType.SUCCESS;
    }

    private static void catchDrago(Dragon dragon, Player player) {
        boolean win = calculateCatch(dragon, player);

        if (win) {
            Screen.typed("You caught the dragon!");
            player.addDragon(dragon);
            player.addXP(1);
        } else {
            Screen.typed("You failed to catch the dragon :(");
        }
    }

    private static void fightDrago(Dragon dragon, Player player) {
        boolean win = encounterBattle(dragon, player);

        if (win) {
            Screen.typed("You won the battle!");
            boolean action2 = Question.requestBoolean(scan, "Would you like to catch the wild Dragon? (y/n)");

            if (action2) {
                Screen.typed("You caught the dragon!");
                player.addDragon(dragon);
                player.addXP(1);
            } else {
                Screen.typed("You left the poor thing to die. :(");
            }

        } else {
            Screen.typed("You lost the battle, and your Dragon died!");
            player.removeDragon(dragon);
        }
    }
}