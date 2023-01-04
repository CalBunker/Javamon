package pokemon;
import utils.Statics;

public class Fighting extends Pokemon {
    public static String[] types = {
        "Mankey",
        "Machop",
        "Hitmonlee",
        "Hitmonchan",
        "Hitmontop"
    };

    public Fighting(int environmentLevel) {
        super(
            Statics.pickRItem(types), 
            environmentLevel
        );
    }
}
