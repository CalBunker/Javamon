package tiles;

public class Swamp extends Tile {
    @Override
    public void activate() {
        System.out.println("Swamp activated");
    }

    @Override
    public char repr() {
        return 'S';
    }

    @Override
    public String getName() {
        return "Swamp";
    }
}
