package pokemon;
import utils.Statics;

public class Grass extends Pokemon {
    static String[] types = {
        "Bulbasaur",
        "Oddish",
        "Bellsprout",
        "Tangela",
        "Hoppip"
    };

    public Grass(int environmentLevel) {
        super(
            Statics.pickRItem(types), 
            environmentLevel
        );
    }
}
