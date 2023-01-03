import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.List;

import tiles.*;

public class World {
    ArrayList<ArrayList<Tile>> worldTiles;
    private boolean generated;

    Player player;

    int sizeX;
    int sizeY;

    World(int sizeX, int sizeY, Player player) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.player = player;
    }

    private void replaceTile(int xPos, int yPos, Tile tile) {
        worldTiles.get(yPos).set(xPos, tile);
    }

    public ArrayList<Tile> generateRowGrassland(int size) {
        ArrayList<Tile> appendable = new ArrayList<>();
        for (int x = 0; x < size; x++) {
            appendable.add(new Grassland());
        }
        return appendable;
    }

    // Appears on the left and right sides of the map
    public void generateMistlands() {
        for (int y = 0; y < worldTiles.size(); y++) {
            int count = (int) ((Math.sin(y/4)*(5.0d*(sizeX/16)))-3);
            
            for (int x = 0; x < count; x++) {
                replaceTile(x, y, new Mistlands());
                replaceTile((sizeX-1)-x, y, new Mistlands());
            }
        }
    }

    // The top of the map will have the mountins
    public void generateMountain() {

    }

    // The bottom of the map will have the swamp
    public void generateSwamp() {

    }

    // A random square in the map will be forest
    public void generateForest() {
        
    }

    public ArrayList<ArrayList<Tile>> generate() {
        if (generated) {
            // Ignore generation
            return worldTiles;
        }

        generated = true;
        
        // Generate the Grasslands
        worldTiles = new ArrayList<ArrayList<Tile>>();
        for (int y = 0; y < this.sizeY; y++) {
            worldTiles.add( generateRowGrassland(this.sizeX) );
        }

        // Generate Mistlands
        generateMistlands();

        // Generate the player's home
        replaceTile(player.getXPos(), player.getYPos(), new Home());

        return worldTiles;
    }

    public List<List<Character>> visualize() {
        
        List<List<Character>> stringList = 
            worldTiles.stream().map((x) -> 
                x.stream().map((y) -> y.repr()).collect(Collectors.toList())
            ).collect(Collectors.toList());
        
        stringList.forEach((x) -> {
            System.out.println(String.join(" ", String.valueOf(x)));
        });

        return stringList;
    }

    public void offsetPlayer(int x, int y, boolean updateTile) throws IndexOutOfBoundsException {
        if (!checkTileExists(player.getXPos()+ x, player.getYPos() + y)) {
            throw new IndexOutOfBoundsException("Player cannot fall off map.");
        }

        player.movePlayer(x, y);
        
        if (updateTile) getTile(player.getXPos(), player.getYPos()).activate();
    }

    public void offsetPlayer(int x, int y) throws IndexOutOfBoundsException {
        offsetPlayer(x, y, true);
    }

    public Tile getTile(int x, int y) throws IndexOutOfBoundsException {
        return worldTiles.get(y).get(x);
    }

    public boolean checkTileExists(int x, int y) {
        try {
            return (getTile(x, y) != null);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public boolean isGenerated() {
        return generated;
    }

    public double getRatio() {
        if (sizeX > sizeY) return sizeX/sizeY;
        else return sizeY/sizeX;
    }
}