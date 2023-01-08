package primary;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

import tiles.*;
import utils.Statics;
import pokemon.*;

public class World implements Serializable {
    private static final long serialVersionUID = 32L;

    ArrayList<ArrayList<Tile>> worldTiles;
    private boolean generated;

    public static int pokeCount() {
        int sum = 0;
        sum =+ Grass.types.length;
        sum =+ Rock.types.length;
        sum =+ Water.types.length;
        sum =+ Fire.types.length;
        sum =+ Electric.types.length;
        sum =+ Psychic.types.length;
        sum =+ Dragon.types.length;
        sum =+ Ghost.types.length;
        sum =+ Dark.types.length;
        sum =+ Poison.types.length;
        sum =+ Fighting.types.length;
        sum =+ Normal.types.length;
        sum =+ Psychic.types.length;
        return sum;
    }

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
            int sizingRatio = (sizeX/ ((10*((sizeX-16)/ 48)) + 16) );

            int count = (int) ((Math.sin(y/4)*(5.0d*(sizingRatio)))-3);
            
            for (int x = 0; x < count; x++) {
                replaceTile(x, y, new Mistlands());
                replaceTile((sizeX-1)-x, y, new Mistlands());
            }
        }
    }

    // The top of the map will have the mountins
    public void generateMountain() {
        Random rand = new Random();

        for (int y = 0; y < worldTiles.size(); y++) {
            ArrayList<Tile> row = worldTiles.get(y);
            float chance = 100.f*(((float) sizeX)/10)/ ((float) y*3);
            
            for (int x = 0; x < row.size(); x++) {
                if (rand.nextFloat()*100f <= chance) 
                    replaceTile(x, y, new Mountain());
            }
        }
    }

    // The bottom of the map will have the swamp
    public void generateSwamp() {
        Random rand = new Random();

        for (int y = 0; y < worldTiles.size(); y++) {
            ArrayList<Tile> row = worldTiles.get(y);
            float chance = 100.f*(((float) sizeX)/16) / ((float) (Statics.invertNum(y, 0, worldTiles.size()-1))*4);
            
            for (int x = 0; x < row.size(); x++) {
                if (rand.nextFloat()*100f <= chance) 
                    replaceTile(x, y, new Swamp());
            }
        }
    }

    // Grassland will randomly be replaced with Forest
    public void generateForest() {
        for (int y = 0; y < worldTiles.size(); y++) {
            for (int x = 0; x < worldTiles.get(y).size(); x++) {
                if (getTile(x, y).getClass() == Grassland.class) {
                    Random rand = new Random();
    
                    if (rand.nextInt(3) == 0) {
                        replaceTile(x, y, new Forest());
                    }
                }
            }
        }
    }

    public ArrayList<ArrayList<Tile>> generate() {
        if (generated) {
            // Ignore generation
            return worldTiles;
        }

        generated = true;
        
        // Generate the Grasslands
        // - 256 -
        // 78
        // 30.468%

        // - 4096 -
        // 1,248
        worldTiles = new ArrayList<ArrayList<Tile>>();
        for (int y = 0; y < this.sizeY; y++) {
            worldTiles.add( generateRowGrassland(this.sizeX) );
        }

        // Generate Mountains
        // - 256 -
        // 34
        // 13.281%

        // - 4096 -
        // 544
        generateMountain();

        // Generate Swamp
        // - 256 -
        // 24
        // 9.375%

        // - 4096 - 
        // 384
        generateSwamp();

        // Generate Forest
        // - 256 -
        // 60
        // 23.4375%

        // - 4096 -
        // 960
        generateForest();

        // Generate Mistlands
        // - 256 -
        // 16
        // 6.25%

        // - 4096 -
        // 256
        generateMistlands();

        // Generate the player's home
        replaceTile(player.getXPos(), player.getYPos(), new Home());

        return worldTiles;
    }

    /**
     * Offset the player from
     * their current location.
     * @param x The x offset
     * @param y The y offset
     * @param updateTile If the tile
     * the player lands on should
     * be activated.
     * @param scan The current Scanner
     * object in the current context.
     * @throws IndexOutOfBoundsException If
     * the player is offsetted out of 
     * existence.
     */
    public void offsetPlayer(int x, int y, boolean updateTile, Scanner scan) throws IndexOutOfBoundsException {
        if (!checkTileExists(player.getXPos()+ x, player.getYPos() + y)) {
            throw new IndexOutOfBoundsException("Player cannot fall off map.");
        }

        player.movePlayer(x, y);
        
        if (updateTile) getTile(player.getXPos(), player.getYPos()).activation(player, scan);
    }

    /**
     * Offset the player from
     * their current location.
     * (updateTile defaults true)
     * @param x The x offset
     * @param y The y offset
     * @param scan The current
     * Scanner object in the current
     * context.
     * @throws IndexOutOfBoundsException If
     * the player is offsetted out of 
     * existence.
     */
    public void offsetPlayer(int x, int y, Scanner scan) throws IndexOutOfBoundsException {
        offsetPlayer(x, y, true, scan);
    }

    /**
     * Get the tile based off
     * of the x and y position.
     * @param x The x position.
     * @param y The y position.
     * @return A reference to the
     * tile in that position.
     * @throws IndexOutOfBoundsException If
     * the tile accessed is off the map.
     */
    public Tile getTile(int x, int y) throws IndexOutOfBoundsException {
        return worldTiles.get(y).get(x);
    }

    /**
     * Check if the the tile 
     * exists.(Avoids the 
     * Index out of bounds error)
     * @param x The x position.
     * @param y The y position.
     * @return True if the tile exists.
     */
    public boolean checkTileExists(int x, int y) {
        try {
            return (getTile(x, y) != null);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    /**
     * @return True if the world
     * has generated.
     */
    public boolean isGenerated() {
        return generated;
    }

    /**
     * @return The ratio between
     * x and y (between 1 and 0)
     * <hr />
     * {@code largest_axis/smallest_axis}
     */
    public double getRatio() {
        if (sizeX > sizeY) return sizeX/sizeY;
        else return sizeY/sizeX;
    }

    /**
     * Visualize the entire map.
     * @return The entire map.
     */
    public List<List<String>> visualize() {
        
        List<List<String>> stringList = 
            worldTiles.stream().map((x) -> 
                x.stream().map((y) -> {
                    return String.valueOf(y.repr());
                }).collect(Collectors.toList())
            ).collect(Collectors.toList());
        
        // stringList.forEach((x) -> {
        //     System.out.println(String.join("", x));
        // });

        for (int i = stringList.size()-1; i>=0; i--) {
            List<String> row = stringList.get(i);
            Collections.reverse(row);
            System.out.println(String.join("", row));
        }

        return stringList;
    }

    /**
     * Print the amount of each
     * type of tile.
     */
    public void worldBreakdown() {
        int grassland = 0;
        int forest = 0;
        int mistland = 0;
        int mountain = 0;
        int swamp = 0;
        int other = 0;

        for (ArrayList<Tile> worldTiles1 : worldTiles) {
            for (Tile worldTiles2 : worldTiles1) {
                char name = worldTiles2.repr();

                switch (name) {
                    case 'G':
                        grassland+=1;
                        break;
                    
                    case 'F':
                        forest+=1;
                        break;
                    
                    case 'L':
                        mistland+=1;
                        break;

                    case 'M':
                        mountain+=1;
                        break;
                    
                    case 'S':
                        swamp+=1;
                        break;

                    default:
                        other+=1;
                        break;
                }
            }
        }

        System.out.println("Grassland: " + grassland);
        System.out.println("Forest: " + forest);
        System.out.println("Mistland: " + mistland);
        System.out.println("Mountain: " + mountain);
        System.out.println("Swamp: " + swamp);

        System.out.println("Other: " + other);
    }
}