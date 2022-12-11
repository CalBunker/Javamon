package pokemon;
import utils.statics;

public class Fighting extends Pokemon {
    static String[] types = {
        "Mankey",
        "Machop",
        "Hitmonlee",
        "Hitmonchan",
        "Hitmontop"
    };

    Fighting(String name, int environmentLevel) {
        super(
            statics.pickRItem(types), 
            environmentLevel
        );
    }
}
