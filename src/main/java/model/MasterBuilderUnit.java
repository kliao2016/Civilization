package model;

public class MasterBuilderUnit extends Unit implements Convertable {

    public MasterBuilderUnit(Civilization owner) {
        super(owner);
    }

    @Override
    public Building convert() {
        return new Landmark(getOwner());
    }

    @Override
    public boolean canConvert(TileType type) {
        if (type.getSymbol() == 'P') {
            return true;
        }
        return false;
    }

    @Override
    public char symbol() {
        return 'm';
    }

    @Override
    public String toString() {
        return "Master Builders. " + super.toString();
    }
}