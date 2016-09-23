import java.util.Random;

public class River {
    private static Random rand = new Random();

    private String name;
    private Fish[] fishArray = {new Fish(rand.nextInt(5)),
                                new Fish(rand.nextInt(5)),
                                new Fish(rand.nextInt(5)),
                                new Fish(rand.nextInt(5)),
                                new Fish(rand.nextInt(5))};
    private int pos;

    public River(String name) {
        this.name = name;
        pos = 0;
    }

    public String getName() {
        return name;
    }

    public int getPos() {
        return pos;
    }

    public void posIncrease() {
        pos += 1;
    }

    public Fish getFish() {
        Fish fishTrip;
        if (pos < 5) {
            fishTrip = fishArray[++pos];
        } else {
            fishTrip = null;
        }
        return fishTrip;
    }

    public boolean replenishFish() {
        Fish test = getFish();
        if (test == null) {
            for (Fish fish: fishArray) {
                fish = new Fish(rand.nextInt(5));
            }
            pos = 0;
            return true;
        } else {
            return false;
        }
    }
}