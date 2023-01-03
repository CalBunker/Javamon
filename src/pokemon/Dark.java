package pokemon;
import utils.Statics;

public class Dark extends APokemon {
    static String[] types = {
        "Murkrow",
        "Sneasel",
        "Poochyena",
        "Houndour",
        "Umbreon"
    };

    Dark(String name, int environmentLevel) {
        super(
            Statics.pickRItem(types), 
            environmentLevel
        );
    }
}
