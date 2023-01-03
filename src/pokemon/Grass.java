package pokemon;
import utils.Statics;

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
            Statics.pickRItem(types), 
            environmentLevel
        );
    }
}
