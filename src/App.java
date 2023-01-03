import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        World world = GameManager.setup(scan);
        world.visualize();

        scan.close();
    }
}
