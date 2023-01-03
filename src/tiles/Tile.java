package tiles;
import pokemon.Pokemon;

public abstract class Tile {
    public abstract void activate();
    public Pokemon Spawnables;

    public char repr() {
        return 'T';
    }
}