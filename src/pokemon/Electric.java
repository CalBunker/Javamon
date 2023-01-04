package pokemon;
import utils.Statics;

public class Electric extends Pokemon {
    static String[] types = {
        "Pikachu",
        "Magnemite",
        "Voltorb",
        "Electabuzz",
        "Jolteon"
    };

    public Electric(int environmentLevel) {
        super(
            Statics.pickRItem(types), 
            environmentLevel
        );
    }
}
