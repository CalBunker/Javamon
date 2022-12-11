import java.util.ArrayList;

public class World {
    ArrayList<ArrayList<Tile>> worldTiles;
    int sizeX;
    int sizeY;

    World(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public ArrayList<ArrayList<Tile>> generate() {
        for (int y = 0; y < this.sizeY; y++) {

            for (int x = 0; x < this.sizeX; x++) {
                
            }

        }
    }

    public ArrayList<ArrayList<String>> visualize() {

    }
}