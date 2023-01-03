package pokemon;
import utils.Statics;

public class Psychic extends APokemon {
    static String[] types = {
        "Abra",
        "Drowzee",
        "Mr. Mime",
        "Natu",
        "Espeon"
    };

    Psychic(String name, int environmentLevel) {
        super(
            Statics.pickRItem(types), 
            environmentLevel
        );
    }
}
