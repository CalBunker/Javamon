package pokemon;
import utils.statics;

public class Grass extends APokemon {
    static String[] types = {
        "Bulbasaur",
        "Oddish",
        "Bellsprout",
        "Tangela",
        "Hoppip"
    };

    Grass(String name, int environmentLevel) {
        super(
            statics.pickRItem(types), 
            environmentLevel
        );
    }
}
