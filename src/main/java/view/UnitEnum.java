package view;

public enum UnitEnum {

    MELEE {
        @Override
        public String toString() {
            return "Melee Unit";
        }
    },
    RANGED {
        @Override
        public String toString() {
            return "Ranged Unit";
        }
    },
    HYBRID {
        @Override
        public String toString() {
            return "Hybrid Unit";
        }
    },
    SIEGE {
        @Override
        public String toString() {
            return "Siege Unit";
        }
    },
    SETTLE {
        @Override
        public String toString() {
            return "Settlers";
        }
    },
    FARMERS {
        @Override
        public String toString() {
            return "Farmers";
        }
    },
    COALS {
        @Override
        public String toString() {
            return "Coal Miners";
        }
    },
    ANGLERS {
        @Override
        public String toString() {
            return "Anglers";
        }
    },
    MASTERS {
        @Override
        public String toString() {
            return "Master Builders";
        }
    }
}