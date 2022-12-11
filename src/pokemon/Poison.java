package pokemon;
import utils.statics;

public class Poison extends Pokemon {
    static String[] types = {
        "Ekans",
        "Nidoran",
        "Zubat",
        "Venonat",
        "Grimer"
    };

    Poison(String name, int environmentLevel) {
        super(
            statics.pickRItem(types), 
            environmentLevel
        );
    }
}
