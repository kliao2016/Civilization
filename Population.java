import java.util.Random;

public class Population {

    private int warriors;
    private int civilians;
    private int happiness;
    private Random rand = new Random();

    public Population() {
        warriors = 50;
        civilians = 50;
        happiness = 200;
    }

    public boolean canBattle() {
        if (warriors > rand.nextInt(100)) {
            warriors -= rand.nextInt(20);
            return true;
        }
        return false;
    }

    public int getWarriors() {
        return warriors;
    }

    public int getCivilians() {
        return civilians;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setWarriors(int newWarriors) {
        warriors = newWarriors;
    }

    public void increaseHappiness(int happyIncrease) {
        happiness += happyIncrease;
    }

    public void decreaseHappiness(int happyDecrease) {
        happiness -= happyDecrease;
    }

    public boolean canWork(int workNeeded) {
        if (civilians >= workNeeded) {
            civilians -= workNeeded;
            return true;
        }
        return false;
    }

    public Game hunt(Hills h) {
        return h.hunt();
    }

    public Fish fish(River r) {
        return r.getFish();
    }

    public boolean canCook(Game g, CoalMine c) {
        int index = 0;
        while (c.getCoal() >= 10 && index < 4) {
            c.burn();
        }
        if (index >= 4) {
            warriors += 40;
            civilians += 60;
            return true;
        } else {
            return false;
        }
    }

    public boolean canCook(Fish f, CoalMine c1) {
        int index = 0;
        while (c1.getCoal() >= 10 && index < 4) {
            c1.burn();
        }
        if (index >= 4) {
            warriors += 10;
            civilians += 15;
            return true;
        } else {
            return false;
        }
    }
}