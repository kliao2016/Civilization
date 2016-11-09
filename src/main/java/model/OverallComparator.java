package model;

import java.util.Comparator;

class OverallComparator implements Comparator<Civilization> {

    @Override
    public int compare(Civilization a, Civilization b) {
        if (a.getNumSettlements() - b.getNumSettlements() == 0) {
            return a.compareTo(b);
        }
        return a.getNumSettlements() - b.getNumSettlements();
    }
}