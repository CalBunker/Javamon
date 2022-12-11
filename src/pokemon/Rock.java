package pokemon;
import utils.statics;

public class Rock extends Pokemon {
    static String[] types = {
        "Geodude",
        "Onix",
        "Rhyhorn",
        "Aerodactyl"
    };

    Rock(String name, int environmentLevel) {
        super(
            statics.pickRItem(types), 
            environmentLevel
        );
    }
}
