package dev.dragonofshuu.pokemon;
import dev.dragonofshuu.utils.Statics;

public class Poison extends Pokemon {
    private static final long serialVersionUID = 32L;

    public static String[] types = {
        "Ekans",
        "Nidoran",
        "Zubat",
        "Venonat",
        "Grimer"
    };

    public Poison(int environmentLevel) {
        super(
            Statics.pickRItem(types), 
            environmentLevel
        );
    }
}
