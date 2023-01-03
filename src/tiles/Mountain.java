package tiles;

public class Mountain extends Tile {
    @Override
    public void activate() {
        System.out.println("Mountain activated");
    }

    @Override
    public char repr() {
        return 'M';
    }

    @Override
    public String getName() {
        return "Mountain";
    }
}
