import java.util.ArrayList;

public class World {
    ArrayList<ArrayList<Tile>> worldTiles;
    int sizeX;
    int sizeY;

    World(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public ArrayList<Tile> generateRowGrassland(int size) {
        ArrayList<Tile> appendable = new ArrayList<>();
        for (int x = 0; x < size; x++) {
            appendable.add(new Grassland());
        }
        return appendable;
    }

    public ArrayList<ArrayList<Tile>> generate() {
        worldTiles = new ArrayList<ArrayList<Tile>>();
        for (int y = 0; y < this.sizeY; y++) {
            worldTiles.add( generateRowGrassland(this.sizeX) );
        }
        return worldTiles;
    }

    public ArrayList<ArrayList<String>> visualize() {

    }
}