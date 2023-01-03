package pokemon;

import utils.Statics;

public class Legendary extends APokemon{
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
            Statics.pickRItem(types), 
            Statics.genRNum(90, 100)
            );
    }
}
