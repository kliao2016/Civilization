public class RomanEmpire {
    private Hills rhills;
    private Population rPop;
    private Treasury rTreasury;
    private CoalMine cMine;
    private River river;
    private Technology tech;
    private Strategy strat;
    private Settlement[] settleArr;
    private int settlePos;

    public RomanEmpire() {
        rhills = new Hills();
        rPop = new Population();
        rTreasury = new Treasury();
        cMine = new CoalMine();
        river = new River("Tiber River");
        tech = new Technology();
        strat = new Strategy();
        settleArr = new Settlement[10];
        settlePos = 0;
    }

    public Hills getHills() {
        return rhills;
    }

    public Population getPopulation() {
        return rPop;
    }

    public Treasury getTreasury() {
        return rTreasury;
    }

    public CoalMine getCoalMine() {
        return cMine;
    }

    public River getRiver() {
        return river;
    }

    public Technology getTechnology() {
        return tech;
    }

    public Strategy getStrategy() {
        return strat;
    }

    public Settlement[] getSettlements() {
        return settleArr;
    }

    public boolean settle(Settlement tbsettled) {
        if (settlePos < 10) {
            settleArr[settlePos] = tbsettled;
            settlePos++;
            return true;
        } else {
            return false;
        }
    }

    public int getNumSettlements() {
        int index = 0;
        while (index < settleArr.length && settleArr[index] != null) {
            index++;
        }
        return index;
    }

    public boolean buildAqueduct(Settlement aSettle) {
        tech.increaseExperience(10);
        return aSettle.build(rTreasury.getCoins(), rPop, 250, 130);
    }

    public boolean buildBathHouse(Settlement bSettle) {
        tech.increaseExperience(10);
        return bSettle.build(rTreasury.getCoins(), rPop, 110, 20);
    }

    public boolean buildVilla(Settlement vSettle) {
        tech.increaseExperience(5);
        return vSettle.build(rTreasury.getCoins(), rPop, 80, 15);
    }

    public void studyPhilosophy() {
        if (rPop.getHappiness() >= 10) {
            tech.philosophize();
            rPop.decreaseHappiness(10);
        } else {
            rPop.decreaseHappiness(0);
        }
    }
}