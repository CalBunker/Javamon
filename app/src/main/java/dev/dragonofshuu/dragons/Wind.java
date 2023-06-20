package dev.dragonofshuu.dragons;
import dev.dragonofshuu.utils.Statics;

public class Wind extends Dragon {
    private static final long serialVersionUID = 32L;

    public static String[] types = {
        "Gastly",
        "Misdreavus",
        "Duskull",
        "Drifloon",
        "Spiritomb"
    };

    public Wind(int environmentLevel, float startingHealth) {
        super(
            Statics.pickRItem(types), 
            environmentLevel,
            startingHealth
        );
    }
}
