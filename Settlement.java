public class Settlement {
    private String name;
    private Building[] buildingArr = new Building[0];
    private int arrayPos = buildingArr.length;

    public Settlement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addBuilding(Building b) {
        if (arrayPos == buildingArr.length) {
            expandSettlement();
        }
        buildingArr[arrayPos] = b;
    }

    public boolean build(int allottedMoney, Population population, int cost,
                         int workersRequired) {
        if (cost < allottedMoney
            && population.canWork(workersRequired)) {
            addBuilding(new Building(cost, workersRequired));
            return true;
        } else {
            return false;
        }
    }

    public void expandSettlement() {
        Building[] result = new Building[(buildingArr.length) * 2];
        for (int i = 0; i < buildingArr.length; i++) {
            result[i] = buildingArr[i];
        }
        buildingArr = result;
    }
}