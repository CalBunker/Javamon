package dev.dragonofshuu.pokemon;
import dev.dragonofshuu.utils.Statics;

public class Water extends Pokemon {
    private static final long serialVersionUID = 32L;

    public static String[] types = {
        "Squirtle",
        "Psyduck",
        "Slowpoke",
        "Horsea",
        "Vaporeon"
    };

    public Water(int environmentLevel) {
        super(
            Statics.pickRItem(types), 
            environmentLevel
        );
    }
}
