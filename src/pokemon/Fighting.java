package pokemon;
import utils.Statics;

public class Fighting extends Pokemon {
    private static final long serialVersionUID = 32L;

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
