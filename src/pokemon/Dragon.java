package pokemon;
import utils.statics;

public class Dragon extends APokemon {
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
