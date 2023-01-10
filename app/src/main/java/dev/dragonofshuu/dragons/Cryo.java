package dev.dragonofshuu.dragons;
import dev.dragonofshuu.utils.Statics;

public class Cryo extends Dragon {
    private static final long serialVersionUID = 32L;

    public static String[] types = {
        "Abra",
        "Drowzee",
        "Mr. Mime",
        "Natu",
        "Espeon"
    };

    public Cryo(int environmentLevel) {
        super(
            Statics.pickRItem(types), 
            environmentLevel
        );
    }
}
