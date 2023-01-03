package pokemon;

import utils.Statics;

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
            Statics.pickRItem(types), 
            environmentLevel
        );
    }
}
