package model;

class Egypt extends Civilization {

    private Desert desert = new Desert();

    public Egypt() {
        super("Ancient Egypt");
    }

    public Desert getDesert() {
        return desert;
    }

    @Override
    public String explore() {
        int coinsEarned = getDesert().findTreasure();
        getTreasury().earn(coinsEarned);
        return "You explore your surroundings and acquire " + coinsEarned
               + " coins!";
    }

    @Override
    public RangedUnit getRangedUnit() {
        return new WarChariot(this);
    }

    @Override
    public Landmark getLandmark() {
        return new Pyramid(this);
    }
}
