package dev.dragonofshuu.pokemon;
import dev.dragonofshuu.utils.Statics;

public class Grass extends Pokemon {
    private static final long serialVersionUID = 32L;

    public static String[] types = {
        "Bulbasaur",
        "Oddish",
        "Bellsprout",
        "Tangela",
        "Hoppip"
    };

    public Grass(int environmentLevel) {
        super(
            Statics.pickRItem(types), 
            environmentLevel
        );
    }
}
