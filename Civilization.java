import java.util.Scanner;

public class Civilization {
    static boolean playing = true;
    static String[] cityArray = new String[5];
    static int numAttacks = 0;
    static double gold = 20.5;
    static double resources = 30.0;
    static int happiness = 10;
    static int military = 0;
    static int techPoints = 0;

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Which civilization would you like to lead?"
                           + " Choose a number:" + "\n"
                           + "1. American (George Washington)" + "\n"
                           + "2. Zulu (Shaka)" + "\n"
                           + "3. English (Queen Elizabeth 1)" + "\n"
                           + "4. Chinese (Wu Zetian)");
        int civ = keyboard.nextInt();
        System.out.println("");

        switch (civ) {
        case 1:
            System.out.print("Welcome George Washington, leader of America!");
            break;
        case 2:
            System.out.print("Welcome Shaka, leader of Zulu!");
            break;
        case 3:
            System.out.print("Welcome Queen Elizabeth 1, leader of England!");
            break;
        case 4:
            System.out.print("Welcome Wu Zetian, leader of China!");
            break;
        default:
            break;
        }

        System.out.println(" What would you like to name your first city?");
        cityArray[0] = keyboard.next();
        System.out.println("");

        while (playing) {
            displayInfo();
            System.out.println("");
            turn();
            if (techPoints >= 20 || numAttacks >= 10) {
                System.out.println("Congratulations! You won!");
                playing = false;
            }
        }
    }

    public static void displayInfo() {
        resources = resources + 1;
        if (happiness > 20.0) {
            resources = resources + 5 * numCities();
        }
        gold = gold + 3 * numCities();
        if (resources % 2 == 0) {
            happiness = happiness + 1;
        } else {
            happiness = happiness - 3;
        }
        System.out.println("Your Current Information");
        System.out.println("Cities: " + displayCity());
        System.out.printf("Attack Count: " + numAttacks + "\n"
                           + "Gold: %.2f\n" + "Resources: %.2f\n"
                           + "Happiness: " + happiness + "\n"
                           + "Military Units: " + military + "\n"
                           + "Technology Points: " + techPoints
                           + "\n", gold, resources);
    }

    public static String displayCity() { //helper for displayInfo()
        String city = "";
        int index = 0;
        while (index + 1 < cityArray.length && cityArray[index] != null) {
            if (cityArray[index + 1] == null) {
                city += cityArray[index];
            } else {
                city += cityArray[index] + ", ";
            }
            index = index + 1;
            if (index == cityArray.length - 1
                && cityArray[cityArray.length - 1] != null) {
                city += cityArray[cityArray.length - 1];
            }
        }
        return city;
    }

    public static void turn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What would you like to do?"
                           + "\n" + "1. Settle a City" + "\n"
                           + "2. Demolish a City" + "\n" + "3. Build Militia"
                           + "\n" + "4. Research Technology" + "\n"
                           + "5. Attack Enemy City" + "\n" + "6. End Turn");
        int turn = scanner.nextInt();
        System.out.println("");

        switch (turn) {
        case 1:
            if (gold < 15.5) {
                System.out.println("Invalid move: "
                                   + "You do not have enough gold. "
                                   + "Your turn is over.");
                break;
            }
            if (cityArray[cityArray.length - 1] != null) {
                System.out.println("Invalid move: "
                                   + "You already have five cities. "
                                   + "Your turn is over.");
                break;
            } else {
                System.out.println("Your current cities: " + displayCity());
                System.out.println("What would you "
                                   + "like to name your new city?");
                String newName = scanner.next();
                System.out.println("");
                int freeIndex = 0;
                while (freeIndex < 4 && cityArray[freeIndex] != null) {
                    freeIndex = freeIndex + 1;
                }
                cityArray[freeIndex] = newName;
            }
            gold = gold - 15.5;
            break;
        case 2:
            if (cityArray[1] == null) {
                System.out.println("Invalid move: "
                                   + "You must have at least one city. "
                                   + "Your turn is over.");
                break;
            } else {
                System.out.println("Cities you can demolish: "
                                   + displayCity() + "\n"
                                   + "Which one would you like to demolish?");
                String demCity = scanner.next();
                System.out.println("");

                for (int i = 0; i < cityArray.length; i++) {
                    if (cityArray[i] != null && cityArray[i].equals(demCity)) {
                        cityArray[i] = null;
                    }
                }
            }
            String[] newCity = new String[5];
            int index = 0;
            for (int i = 0; i < newCity.length; i++) {
                if (cityArray[i] != null) {
                    newCity[index] = cityArray[i];
                    index += 1;
                }
            }
            cityArray = newCity;
            resources += 1.5;
            break;
        case 3:
            if (gold < 5 && resources < 3) {
                System.out.println("Invalid move: "
                                   + "You do not have "
                                   + "enough gold and resources. "
                                   + "Your turn is over.");
                break;
            } else {
                military += 1;
            }
            break;
        case 4:
            if (gold < 50 && resources < 2) {
                System.out.println("Invalid move: "
                                   + "You do not have "
                                   + "enough gold and resources. "
                                   + "Your turn is over.");
                break;
            } else {
                techPoints += 1;
            }
            break;
        case 5:
            if (military < 6) {
                System.out.println("Invalid move: "
                                   + "You do not have enough military units. "
                                   + "Your turn is over.");
                break;
            } else {
                gold += 10;
                break;
            }
        case 6:
            System.out.println("You have ended your turn.");
            break;
        default:
            break;
        }
    }

    public static int numCities() { //helper for displayInfo()
        int numCities = 0;
        for (int i = 0; i < cityArray.length; i++) {
            if (cityArray[i] != null) {
                numCities = numCities + 1;
            }
        }
        return numCities;
    }
}