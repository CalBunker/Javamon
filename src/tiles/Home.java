package tiles;

public class Home extends Tile {
    @Override
    public void activate() {
        System.out.println("You walk up to your house.");
    }

    @Override
    public char repr() {
        return 'H';
    }

    @Override
    public String getName() {
        return "Home";
    }
}
