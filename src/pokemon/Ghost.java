package pokemon;
import utils.Statics;

public class Ghost extends Pokemon {
    private static final long serialVersionUID = 32L;

    public static String[] types = {
        "Gastly",
        "Misdreavus",
        "Duskull",
        "Drifloon",
        "Spiritomb"
    };

    public Ghost(int environmentLevel) {
        super(
            Statics.pickRItem(types), 
            environmentLevel
        );
    }
}
