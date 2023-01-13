package dev.dragonofshuu.dragons;
import dev.dragonofshuu.utils.Statics;

public class Ice extends Dragon {
    private static final long serialVersionUID = 32L;

    public static String[] types = {
        "Abra",
        "Drowzee",
        "Mr. Mime",
        "Natu",
        "Espeon"
    };

    public Ice(int environmentLevel, float startingHealth) {
        super(
            Statics.pickRItem(types), 
            environmentLevel,
            startingHealth
        );
    }
}
