package pokemon;
import utils.Statics;

public class Ground extends APokemon {
    static String[] types = {
        "Sandshrew",
        "Diglett",
        "Cubone",
        "Phanpy",
        "Gligar"
    };

    Ground(String name, int environmentLevel) {
        super(
            Statics.pickRItem(types), 
            environmentLevel
        );
    }
}
