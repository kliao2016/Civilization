package model;

class RomanEmpire extends Civilization {

    private Hills hills = new Hills();

    public RomanEmpire() {
        super("Roman Empire");
    }

    public Hills getHills() {
        return hills;
    }

    @Override
    public String explore() {
        int addResource = hills.mineCoal();
        produceResources(addResource);
        return "You explore your surroundings and acquire " + addResource
               + " resources!";
    }

    @Override
    public MeleeUnit getMeleeUnit() {
        return new LegionUnit(this);
    }

    @Override
    public Landmark getLandmark() {
        return new Coliseum(this);
    }
}
