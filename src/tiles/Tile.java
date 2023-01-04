package tiles;
import pokemon.Pokemon;
import primary.*;
import utils.Statics;

public abstract class Tile {
    public abstract void activate(Player player);
    public Pokemon Spawnables;

    public char repr() {
        return 'T';
    }

    public String getName() {
        return "Tile";
    }

    // does the necessary battle logic to determine a winner
    public boolean encounterBattle(Pokemon wildPoke, Player player) {
        if (wildPoke.getLevel() > player.getActivePokemon().getLevel()) {
            return false;
        } else {
            return true;
        }
    }

    // does the necessary logic to determine if a pokemon is caught
    public boolean calculateCatch(Pokemon pokemon) {
        int level = pokemon.getLevel();
        int catchRate = level/4;
        int catchChance = Statics.genRNum(1, catchRate);
        if (catchChance == 1) {
            return true;
        } else {
            return false;
        }
    }
}