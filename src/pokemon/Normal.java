package pokemon;

import utils.statics;

public class Normal extends APokemon {
    static String[] types = {
        "Pidgey",
        "Rattata",
        "Doduo",
        "Eevee",
        "Tauros",
        "Bidoof"
    };

    Normal(String name, int environmentLevel) {
        super(
            statics.pickRItem(types), 
            environmentLevel
        );
    }
}
