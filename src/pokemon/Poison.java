package pokemon;
import utils.Statics;

public class Poison extends Pokemon {
    static String[] types = {
        "Ekans",
        "Nidoran",
        "Zubat",
        "Venonat",
        "Grimer"
    };

    public Poison(int environmentLevel) {
        super(
            Statics.pickRItem(types), 
            environmentLevel
        );
    }
}
