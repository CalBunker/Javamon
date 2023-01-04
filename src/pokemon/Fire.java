package pokemon;
import utils.Statics;

public class Fire extends Pokemon{
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
