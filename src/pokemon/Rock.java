package pokemon;
import utils.Statics;

public class Rock extends Pokemon {
    public static String[] types = {
        "Geodude",
        "Onix",
        "Rhyhorn",
        "Aerodactyl"
    };

    public Rock(int environmentLevel) {
        super(
            Statics.pickRItem(types), 
            environmentLevel
        );
    }
}
