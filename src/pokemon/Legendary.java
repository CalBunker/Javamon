package pokemon;

import utils.statics;

public class Legendary {
    static String[] types = {
        "Articuno",
        "Zapdos",
        "Moltres",
        "Shuckle",
        "Mew",
        "Mewtwo"
    };

    Legendary(String name, int environmentLevel) {
        super(
            statics.pickRItem(types), 
            statics.genRNum(90, 100)
            );
    }
}
