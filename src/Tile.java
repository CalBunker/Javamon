package tiles;

public class Tile {
    TileTypes tileType;

    enum TileTypes {
        HOUSE,
        GRASSLAND,
        FOREST,
        CAVE,
        SWAMP,
        MOUNTAIN,
        MISTLANDS;
    }
    
    Tile(TileTypes tileType) {
        this.tileType = tileType;
    }

    protected Player activate(Player player) {
        return player;
    }
}