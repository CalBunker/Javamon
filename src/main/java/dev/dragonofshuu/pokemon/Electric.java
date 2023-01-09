package dev.dragonofshuu.pokemon;
import dev.dragonofshuu.utils.Statics;

public class Electric extends Pokemon {
    private static final long serialVersionUID = 32L;

    public static String[] types = {
        "Pikachu",
        "Magnemite",
        "Voltorb",
        "Electabuzz",
        "Jolteon"
    };

    public Electric(int environmentLevel) {
        super(
            Statics.pickRItem(types), 
            environmentLevel
        );
    }
}
