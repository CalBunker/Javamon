package dev.dragonofshuu.dragons;
import dev.dragonofshuu.utils.Statics;

public class Electro extends Dragon {
    private static final long serialVersionUID = 32L;

    public static String[] types = {
        "Pikachu",
        "Magnemite",
        "Voltorb",
        "Electabuzz",
        "Jolteon"
    };

    public Electro(int environmentLevel) {
        super(
            Statics.pickRItem(types), 
            environmentLevel
        );
    }
}
