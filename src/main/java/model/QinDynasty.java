package model;

public class QinDynasty extends Civilization {

    private Hills hills = new Hills();

    public QinDynasty() {
        super("Qin Dynasty");
    }

    public Hills getHills() {
        return hills;
    }

    @Override
    public String explore() {
        hills.replenishGame();
        int foodIncrease = hills.hunt().getHealth();
        makeFood(foodIncrease);
        return "You explore your surroundings and increased your food supply by"
                + " " + foodIncrease;
    }

    @Override
    public SiegeUnit getSiegeUnit() {
        return new BlackPowderUnit(this);
    }

    @Override
    public Landmark getLandmark() {
        return new GreatWall(this);
    }
}
