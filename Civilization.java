import java.util.Scanner;

public class Civilization {
    static boolean playing = true;
    private String[] cityArray;
    private int numAttacks;
    private double gold;
    private double resources;
    private int happiness;
    private int military;
    private int techPoints;

    public Civilization(String[] city, int attacks, double gold,
                        double resources, int happiness, int military,
                        int tech) {
        city = new String[5];
        cityArray = city;
        numAttacks = attacks;
        gold = gold;
        resources = resources;
        happiness = happiness;
        military = military;
        techPoints = tech;
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Which civilization would you like to lead? Choose a number:\n1. American (George Washington)\n2. Zulu (Shaka)\n3. English (Queen Elizabeth 1)\n4. Chinese (Wu Zetian)" );
        int civ = keyboard.nextInt();
        while (playing) {

            playing = false;
        }
    }

    public void turn() {

    }
}