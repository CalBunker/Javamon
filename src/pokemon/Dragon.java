package pokemon;
import utils.Statics;

public class Dragon extends Pokemon {
    private static final long serialVersionUID = 32L;

    public static String[] types = {
        "Dragonite",
        "Salamence",
        "Garchomp",
        "Hydreigon"
    };

    public Dragon(int environmentLevel) {
        super(
            Statics.pickRItem(types), 
            environmentLevel
        );
    }
}
