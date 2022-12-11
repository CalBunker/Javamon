package pokemon;
import utils.statics;

public class Ghost extends Pokemon {
    static String[] types = {
        "Gastly",
        "Misdreavus",
        "Duskull",
        "Drifloon",
        "Spiritomb"
    };

    Ghost(String name, int environmentLevel) {
        super(
            statics.pickRItem(types), 
            environmentLevel
        );
    }
}
