package pokemon;

import utils.Statics;

public class Normal extends Pokemon {
    private static final long serialVersionUID = 32L;

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
