package pokemon;
import utils.statics;

public class Fire extends Pokemon{
    static String[] types = {
        "Charmander",
        "Vulpix",
        "Growlithe",
        "Ponyta",
        "Flareon"
    };

    Fire(String name, int environmentLevel) {
        super(
            statics.pickRItem(types), 
            environmentLevel
        );
    }
}
