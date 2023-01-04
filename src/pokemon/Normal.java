package pokemon;

import utils.Statics;

public class Normal extends Pokemon {
    public static String[] types = {
        "Pidgey",
        "Rattata",
        "Doduo",
        "Eevee",
        "Tauros",
        "Bidoof"
    };

    public Normal(int environmentLevel) {
        super(
            Statics.pickRItem(types), 
            environmentLevel
        );
    }
}
