package dev.dragonofshuu.dragons;
import dev.dragonofshuu.utils.Statics;

public class Electric extends Dragon {
    private static final long serialVersionUID = 32L;

    public static String[] types = {
        "Pikachu",
        "Magnemite",
        "Voltorb",
        "Electabuzz",
        "Jolteon"
    };

    public Electric(int environmentLevel, float startingHealth) {
        super(
            Statics.pickRItem(types), 
            environmentLevel,
            startingHealth
        );
    }
}
