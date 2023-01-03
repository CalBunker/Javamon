package pokemon;
import utils.Statics;

public class Ghost extends APokemon {
    static String[] types = {
        "Gastly",
        "Misdreavus",
        "Duskull",
        "Drifloon",
        "Spiritomb"
    };

    Ghost(String name, int environmentLevel) {
        super(
            Statics.pickRItem(types), 
            environmentLevel
        );
    }
}
