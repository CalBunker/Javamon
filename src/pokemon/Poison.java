package pokemon;
import utils.Statics;

public class Poison extends APokemon {
    static String[] types = {
        "Ekans",
        "Nidoran",
        "Zubat",
        "Venonat",
        "Grimer"
    };

    Poison(String name, int environmentLevel) {
        super(
            Statics.pickRItem(types), 
            environmentLevel
        );
    }
}
