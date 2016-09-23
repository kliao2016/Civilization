public class Treasury {

    private int coins;

    public Treasury() {
        coins = 200;
    }

    public int getCoins() {
        return coins;
    }

    public boolean spend(int cost) {
        if (coins >= cost) {
            coins -= cost;
            return true;
        } else {
            return false;
        }
    }

    public void earn(int earned) {
        coins += earned;
    }
}