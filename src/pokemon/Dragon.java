package pokemon;
import utils.Statics;

public class Dragon extends Pokemon {
    static String[] types = {
        "Dragonite",
        "Salamence",
        "Garchomp",
        "Hydreigon"
    };

    public Dragon(int environmentLevel) {
        super(
            Statics.pickRItem(types), 
            environmentLevel
        );
    }
}
