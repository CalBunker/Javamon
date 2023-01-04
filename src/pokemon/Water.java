package pokemon;
import utils.Statics;

public class Water extends Pokemon {
    public static String[] types = {
        "Squirtle",
        "Psyduck",
        "Slowpoke",
        "Horsea",
        "Vaporeon"
    };

    public Water(int environmentLevel) {
        super(
            Statics.pickRItem(types), 
            environmentLevel
        );
    }
}
