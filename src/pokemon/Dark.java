package pokemon;

import utils.Statics;

public class Dark extends Pokemon {
    private static final long serialVersionUID = 32L;

    public static String[] types = {
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
