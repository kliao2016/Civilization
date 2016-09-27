public class QinDynasty {
    private Hills qhills;
    private Population qPop;
    private Treasury qTreasury;
    private CoalMine cMine;
    private River river;
    private Technology tech;
    private Strategy strat;
    private Settlement[] settleArr;
    private int settlePos;

    public QinDynasty() {
        qhills = new Hills();
        qPop = new Population();
        qTreasury = new Treasury();
        cMine = new CoalMine();
        river = new River("Yellow");
        tech = new Technology();
        strat = new Strategy();
        settleArr = new Settlement[10];
        settlePos = 0;
    }

    public Hills getHills() {
        return qhills;
    }

    public Population getPopulation() {
        return qPop;
    }

    public Treasury getTreasury() {
        return qTreasury;
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

    public boolean buildWall(Settlement wSettle) {
        boolean build = false;
        if (wSettle.build(qTreasury.getCoins(), qPop, 1000, 100)) {
            build = true;
            qTreasury.spend(1000);
            tech.increaseExperience(10);
        } else {
            build = false;
        }
        return build;
    }

    public boolean buildHouse(Settlement hSettle) {
        boolean build = false;
        if (hSettle.build(qTreasury.getCoins(), qPop, 30, 8)) {
            build = true;
            qTreasury.spend(30);
            tech.increaseExperience(10);
        } else {
            build = false;
        }
        return build;
    }

    public void establishLegalism() {
        if (qPop.getHappiness() >= 20) {
            tech.philosophize();
            qPop.decreaseHappiness(20);
        }
    }
}