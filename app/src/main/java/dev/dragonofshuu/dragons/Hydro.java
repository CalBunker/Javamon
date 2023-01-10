package dev.dragonofshuu.dragons;
import dev.dragonofshuu.utils.Statics;

public class Hydro extends Dragon {
    private static final long serialVersionUID = 32L;

    public static String[] types = {
        "Squirtle",
        "Psyduck",
        "Slowpoke",
        "Horsea",
        "Vaporeon"
    };

    public Hydro(int environmentLevel) {
        super(
            Statics.pickRItem(types), 
            environmentLevel
        );
    }
}
