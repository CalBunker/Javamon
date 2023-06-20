package dev.dragonofshuu.dragons;
import dev.dragonofshuu.utils.Statics;

public class Fire extends Dragon{
    private static final long serialVersionUID = 32L;

    public static String[] types = {
        "Charmander",
        "Vulpix",
        "Growlithe",
        "Ponyta",
        "Flareon"
    };

    public Fire(int environmentLevel, float startingHealth) {
        super(
            Statics.pickRItem(types), 
            environmentLevel,
            startingHealth
        );
    }
}
