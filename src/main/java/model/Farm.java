package model;

public class Farm extends Building {

    public Farm(Civilization owner) {
        super(200, owner, 0, 0, 10, 0, 0, 10);
    }

    @Override
    public void invest() {
        setFoodGeneration(getFoodGeneration() + 2);
    }

    @Override
    public char symbol() {
        return '+';
    }

    @Override
    public String toString() {
        return "Farm. " + super.toString();
    }
}