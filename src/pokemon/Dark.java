package pokemon;
import utils.Statics;

public class Dark extends Pokemon {
    static String[] types = {
        "Murkrow",
        "Sneasel",
        "Poochyena",
        "Houndour",
        "Umbreon"
    };

    public Dark(int environmentLevel) {
        super(
            Statics.pickRItem(types), 
            environmentLevel
        );
    }
}
