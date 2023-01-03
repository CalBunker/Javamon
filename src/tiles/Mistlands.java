package tiles;

public class Mistlands extends Tile {
    @Override
    public void activate() {
        System.out.println("Mistlands activated");
    }

    @Override
    public char repr() {
        return 'L';
    }

    @Override
    public String getName() {
        return "Mistlands";
    }
}
