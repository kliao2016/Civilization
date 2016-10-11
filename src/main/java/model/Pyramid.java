package model;

public class Pyramid extends Landmark {

    public Pyramid(Civilization owner) {
        super(owner);
    }

    @Override
    public void invest() {
        super.invest();
        getOwner().getTechnology().philosophize();
    }

    @Override
    public String toString() {
        return "Pyramid. " + super.toString();
    }
}