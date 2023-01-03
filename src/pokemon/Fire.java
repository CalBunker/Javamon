package pokemon;
import utils.Statics;

public class Fire extends APokemon{
    static String[] types = {
        "Charmander",
        "Vulpix",
        "Growlithe",
        "Ponyta",
        "Flareon"
    };

    Fire(String name, int environmentLevel) {
        super(
            Statics.pickRItem(types), 
            environmentLevel
        );
    }
}
