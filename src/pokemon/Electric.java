package pokemon;
import utils.statics;

public class Electric extends Pokemon {
    static String[] types = {
        "Pikachu",
        "Magnemite",
        "Voltorb",
        "Electabuzz",
        "Jolteon"
    };

    Electric(String name, int environmentLevel) {
        super(
            statics.pickRItem(types), 
            environmentLevel
        );
    }
}
