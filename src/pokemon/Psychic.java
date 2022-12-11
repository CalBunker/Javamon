package pokemon;
import utils.statics;

public class Psychic extends Pokemon {
    static String[] types = {
        "Abra",
        "Drowzee",
        "Mr. Mime",
        "Natu",
        "Espeon"
    };

    Psychic(String name, int environmentLevel) {
        super(
            statics.pickRItem(types), 
            environmentLevel
        );
    }
}
