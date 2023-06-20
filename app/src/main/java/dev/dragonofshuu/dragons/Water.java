package dev.dragonofshuu.dragons;
import dev.dragonofshuu.utils.Statics;

public class Water extends Dragon {
    private static final long serialVersionUID = 32L;

    public static String[] types = {
        "Squirtle",
        "Psyduck",
        "Slowpoke",
        "Horsea",
        "Vaporeon"
    };

    public Water(int environmentLevel, float startingHealth) {
        super(
            Statics.pickRItem(types), 
            environmentLevel,
            startingHealth
        );
    }
}
