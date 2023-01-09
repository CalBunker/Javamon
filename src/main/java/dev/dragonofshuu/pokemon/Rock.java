package dev.dragonofshuu.pokemon;
import dev.dragonofshuu.utils.Statics;

public class Rock extends Pokemon {
    private static final long serialVersionUID = 32L;

    public static String[] types = {
        "Geodude",
        "Onix",
        "Rhyhorn",
        "Aerodactyl"
    };

    public Rock(int environmentLevel) {
        super(
            Statics.pickRItem(types), 
            environmentLevel
        );
    }
}
