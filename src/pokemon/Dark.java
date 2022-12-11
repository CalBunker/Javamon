package pokemon;
import utils.statics;

public class Dark extends Pokemon {
    static String[] types = {
        "Murkrow",
        "Sneasel",
        "Poochyena",
        "Houndour",
        "Umbreon"
    };

    Dark(String name, int environmentLevel) {
        super(
            statics.pickRItem(types), 
            environmentLevel
        );
    }
}
