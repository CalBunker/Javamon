package pokemon;
import utils.statics;

public class Dragon extends Pokemon {
    static String[] types = {
        "Dragonite",
        "Salamence",
        "Garchomp",
        "Hydreigon"
    };

    Dragon(String name, int environmentLevel) {
        super(
            statics.pickRItem(types), 
            environmentLevel
        );
    }
}
