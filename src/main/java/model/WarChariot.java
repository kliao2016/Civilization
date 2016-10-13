package model;

public class WarChariot extends RangedUnit {

    public WarChariot(Civilization owner) {
        super(owner);
        setBaseEndurance(super.getBaseEndurance() * 2);
    }

    @Override
    public char symbol() {
        return 'W';
    }

    @Override
    public String toString() {
        return "War Chariot Unit. " + super.toString();
    }
}