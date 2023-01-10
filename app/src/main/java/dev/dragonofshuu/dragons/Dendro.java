package dev.dragonofshuu.dragons;

import dev.dragonofshuu.utils.Statics;

public class Dendro extends Dragon {
    private static final long serialVersionUID = 32L;

    public static String[] types = {
        "Pidgey",
        "Rattata",
        "Doduo",
        "Eevee",
        "Tauros",
        "Bidoof"
    };

    public Dendro(int environmentLevel) {
        super(
            Statics.pickRItem(types), 
            environmentLevel
        );
    }
}
