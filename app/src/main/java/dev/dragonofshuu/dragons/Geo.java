package dev.dragonofshuu.dragons;
import dev.dragonofshuu.utils.Statics;

public class Geo extends Dragon {
    private static final long serialVersionUID = 32L;

    public static String[] types = {
        "Sandshrew",
        "Diglett",
        "Cubone",
        "Phanpy",
        "Gligar"
    };

    public Geo(int environmentLevel) {
        super(
            Statics.pickRItem(types), 
            environmentLevel
        );
    }
}
