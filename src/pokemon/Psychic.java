package pokemon;
import utils.Statics;

public class Psychic extends Pokemon {
    public static String[] types = {
        "Abra",
        "Drowzee",
        "Mr. Mime",
        "Natu",
        "Espeon"
    };

    public Psychic(int environmentLevel) {
        super(
            Statics.pickRItem(types), 
            environmentLevel
        );
    }
}
