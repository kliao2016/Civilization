import java.util.Scanner;
import java.util.Random;

public class Desert {

    private static Random rand = new Random();
    private Scanner scan = new Scanner(System.in);

    public int findTreasure() {
        int lost = rand.nextInt(10);
        boolean l = false;
        if (lost == 1) {
            l = lost();
        }
        while (l) {
            l = lost();
        }
        return rand.nextInt(500) + 1;
    }

    public boolean lost() {
        System.out.println("You have gotten lost! Press 1 to try escaping the"
            + " Desert.\nHopefully you can make it out alive.");
        int move = scan.nextInt();
        return (move == 1) ? false : true;
    }
}