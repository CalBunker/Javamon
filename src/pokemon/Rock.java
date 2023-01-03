package pokemon;
import utils.Statics;

public class Rock extends APokemon {
    static String[] types = {
        "Geodude",
        "Onix",
        "Rhyhorn",
        "Aerodactyl"
    };

    Rock(String name, int environmentLevel) {
        super(
            Statics.pickRItem(types), 
            environmentLevel
        );
    }
}
