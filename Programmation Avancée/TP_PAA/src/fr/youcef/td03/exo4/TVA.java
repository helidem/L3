package fr.youcef.td03.exo4;

public enum TVA {
    normal, intermediaire, reduit, particulier;

public double getTaux() {
        switch (this) {
            case normal:
                return 0.2;
            case intermediaire:
                return 0.1;
            case reduit:
                return 0.05;
            case particulier:
                return 0.021;
            default:
                return 0;
        }
    }
}
