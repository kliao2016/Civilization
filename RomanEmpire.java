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
        river = new River("Tiber");
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
        boolean build = false;
        if (aSettle.build(rTreasury.getCoins(), rPop, 250, 130)) {
            build = true;
            rTreasury.spend(250);
        } else {
            build = false;
        }
        tech.increaseExperience(10);
        return build;
    }

    public boolean buildBathHouse(Settlement bSettle) {
        boolean build = false;
        if (bSettle.build(rTreasury.getCoins(), rPop, 110, 20)) {
            build = true;
            rTreasury.spend(110);
        } else {
            build = false;
        }
        tech.increaseExperience(10);
        return build;
    }

    public boolean buildVilla(Settlement vSettle) {
        boolean build = false;
        if (vSettle.build(rTreasury.getCoins(), rPop, 80, 15)) {
            build = true;
            rTreasury.spend(80);
        } else {
            build = false;
        }
        tech.increaseExperience(5);
        return build;
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