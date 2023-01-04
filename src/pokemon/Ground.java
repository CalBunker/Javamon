package pokemon;
import utils.Statics;

public class Ground extends Pokemon {
    static String[] types = {
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
