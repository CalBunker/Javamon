package pokemon;
import utils.Statics;

public class Water extends APokemon {
    static String[] types = {
        "Squirtle",
        "Psyduck",
        "Slowpoke",
        "Horsea",
        "Vaporeon"
    };

    Water(String name, int environmentLevel) {
        super(
            Statics.pickRItem(types), 
            environmentLevel
        );
    }
}
