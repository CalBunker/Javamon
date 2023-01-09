package dev.dragonofshuu.pokemon;
import dev.dragonofshuu.utils.Statics;

public class Ground extends Pokemon {
    private static final long serialVersionUID = 32L;

    public static String[] types = {
        "Sandshrew",
        "Diglett",
        "Cubone",
        "Phanpy",
        "Gligar"
    };

    public Ground(int environmentLevel) {
        super(
            Statics.pickRItem(types), 
            environmentLevel
        );
    }
}
