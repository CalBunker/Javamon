package tiles;

public class Grassland extends Tile {
    public Grassland() {
        
    }

    @Override
    public void activate() {
        System.out.println("Grassland activated");
    }

    @Override
    public char repr() {
        return 'G';
    }

    @Override
    public String getName() {
        return "Grassland";
    }
}