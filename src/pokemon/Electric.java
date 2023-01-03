package pokemon;
import utils.Statics;

public class Electric extends APokemon {
    static String[] types = {
        "Pikachu",
        "Magnemite",
        "Voltorb",
        "Electabuzz",
        "Jolteon"
    };

    Electric(String name, int environmentLevel) {
        super(
            Statics.pickRItem(types), 
            environmentLevel
        );
    }
}
