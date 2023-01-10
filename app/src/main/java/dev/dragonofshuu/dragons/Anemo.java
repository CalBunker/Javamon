package dev.dragonofshuu.dragons;
import dev.dragonofshuu.utils.Statics;

public class Anemo extends Dragon {
    private static final long serialVersionUID = 32L;

    public static String[] types = {
        "Gastly",
        "Misdreavus",
        "Duskull",
        "Drifloon",
        "Spiritomb"
    };

    public Anemo(int environmentLevel) {
        super(
            Statics.pickRItem(types), 
            environmentLevel
        );
    }
}
