package dev.dragonofshuu.dragons;

import dev.dragonofshuu.utils.Statics;

public class Nature extends Dragon {
    private static final long serialVersionUID = 32L;

    public static String[] types = {
        "Pidgey",
        "Rattata",
        "Doduo",
        "Eevee",
        "Tauros",
        "Bidoof"
    };

    public Nature(int environmentLevel, float startingHealth) {
        super(
            Statics.pickRItem(types), 
            environmentLevel,
            startingHealth
        );
    }
}
