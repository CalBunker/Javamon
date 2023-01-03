package pokemon;
import utils.Statics;

public class Dragon extends APokemon {
    static String[] types = {
        "Dragonite",
        "Salamence",
        "Garchomp",
        "Hydreigon"
    };

    Dragon(String name, int environmentLevel) {
        super(
            Statics.pickRItem(types), 
            environmentLevel
        );
    }
}
