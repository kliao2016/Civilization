package model;

class MasterBuilderUnit extends Unit implements Convertable {

    public MasterBuilderUnit(Civilization owner) {
        super(owner);
    }

    @Override
    public Building convert() {
        return getOwner().getLandmark();
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
        return 'm';
    }

    @Override
    public String toString() {
        return "Master Builders. " + super.toString();
    }
}