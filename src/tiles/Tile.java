package tiles;
import pokemon.APokemon;

public abstract class Tile {
    public abstract void activate();
    public APokemon Spawnables;

    public char repr() {
        return 'T';
    }

    public String getName() {
        return "Tile";
    }
}