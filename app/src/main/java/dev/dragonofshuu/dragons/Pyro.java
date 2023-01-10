package dev.dragonofshuu.dragons;
import dev.dragonofshuu.utils.Statics;

public class Pyro extends Dragon{
    private static final long serialVersionUID = 32L;

    public static String[] types = {
        "Charmander",
        "Vulpix",
        "Growlithe",
        "Ponyta",
        "Flareon"
    };

    public Pyro(int environmentLevel) {
        super(
            Statics.pickRItem(types), 
            environmentLevel
        );
    }
}
