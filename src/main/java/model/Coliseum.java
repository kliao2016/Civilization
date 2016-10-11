package model;

public class Coliseum extends Landmark {

    public Coliseum(Civilization owner) {
        super(owner);
    }

    @Override
    public void invest() {
        super.invest();
        getOwner().increaseHappiness(50);
    }

    @Override
    public String toString() {
        return "Coliseum. " + super.toString();
    }
}