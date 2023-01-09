package dev.dragonofshuu.pokemon;
import dev.dragonofshuu.utils.Statics;

public class Psychic extends Pokemon {
    private static final long serialVersionUID = 32L;

    public static String[] types = {
        "Abra",
        "Drowzee",
        "Mr. Mime",
        "Natu",
        "Espeon"
    };

    public Psychic(int environmentLevel) {
        super(
            Statics.pickRItem(types), 
            environmentLevel
        );
    }
}
