package dev.dragonofshuu.dragons;
import dev.dragonofshuu.utils.Statics;

public class Earth extends Dragon {
    private static final long serialVersionUID = 32L;

    public static String[] types = {
        "Sandshrew",
        "Diglett",
        "Cubone",
        "Phanpy",
        "Gligar"
    };

    public Earth(int environmentLevel, float startingHealth) {
        super(
            Statics.pickRItem(types), 
            environmentLevel,
            startingHealth
        );
    }
}
