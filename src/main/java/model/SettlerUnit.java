package model;

public class SettlerUnit extends Unit implements Convertable {

    private String townName;

    public SettlerUnit(Civilization owner, String townName) {
        super(owner);
        this.townName = townName;
    }

    @Override
    public Building convert() {
        getOwner().incrementNumSettlements();
        return new Settlement(getOwner(), townName);
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
        return 's';
    }

    @Override
    public String toString() {
        return "Settlers of " + townName + ". " + super.toString();
    }
}