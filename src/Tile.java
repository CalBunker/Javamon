import pokemon.Pokemon;

public abstract class Tile {
    // enum TileTypes {
    //     HOUSE,
    //     GRASSLAND,
    //     FOREST,
    //     CAVE,
    //     SWAMP,
    //     MOUNTAIN,
    //     MISTLANDS;
    // }

    public abstract void activate();
    public Pokemon Spawnables;

    public String representation() {
        return "T";
    }
}