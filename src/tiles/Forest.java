package tiles;

public class Forest extends Tile {
    @Override
    public void activate() {
        System.out.println("Forest activated");
    }

    @Override
    public char repr() {
        return 'F';
    }

    @Override
    public String getName() {
        return "Forest";
    }
}
