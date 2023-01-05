package pokemon;
import utils.Statics;

public class Fire extends Pokemon{
    private static final long serialVersionUID = 32L;

    public static String[] types = {
        "Charmander",
        "Vulpix",
        "Growlithe",
        "Ponyta",
        "Flareon"
    };

    public Fire(int environmentLevel) {
        super(
            Statics.pickRItem(types), 
            environmentLevel
        );
    }
}
