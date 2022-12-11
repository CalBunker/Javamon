package pokemon;
import utils.statics;

public class Water extends Pokemon {
    static String[] types = {
        "Squirtle",
        "Psyduck",
        "Slowpoke",
        "Horsea",
        "Vaporeon"
    };

    Water(String name, int environmentLevel) {
        super(
            statics.pickRItem(types), 
            environmentLevel
        );
    }
}
