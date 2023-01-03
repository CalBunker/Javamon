package pokemon;
import utils.Statics;

public class Fighting extends APokemon {
    static String[] types = {
        "Mankey",
        "Machop",
        "Hitmonlee",
        "Hitmonchan",
        "Hitmontop"
    };

    Fighting(String name, int environmentLevel) {
        super(
            Statics.pickRItem(types), 
            environmentLevel
        );
    }
}
