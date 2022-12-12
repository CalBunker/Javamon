package pokemon;

import utils.statics;

<<<<<<< Updated upstream
public class Legendary extends Pokemon {
=======
public class Legendary extends Pokemon{
>>>>>>> Stashed changes
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
