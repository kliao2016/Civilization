package model;

class FarmerUnit extends Unit implements Convertable {

    public FarmerUnit(Civilization owner) {
        super(owner);
    }

    @Override
    public Building convert() {
        return getOwner().getFarm();
    }

    @Override
    public boolean canConvert(TileType type) {
        if (type == TileType.PLAINS) {
            return true;
        }
        return false;
    }

    @Override
    public char symbol() {
        return 'f';
    }

    @Override
    public String toString() {
        return "Farmers. " + super.toString();
    }
}