package pokemon;
import utils.statics;

public class Ground extends Pokemon {
    static String[] types = {
        "Sandshrew",
        "Diglett",
        "Cubone",
        "Phanpy",
        "Gligar"
    };

    Ground(String name, int environmentLevel) {
        super(
            statics.pickRItem(types), 
            environmentLevel
        );
    }
}
