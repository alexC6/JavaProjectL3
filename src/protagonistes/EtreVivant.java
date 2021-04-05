package protagonistes;

import controleur.Combat;

public abstract class EtreVivant {
    private String mName;
    private int mPointsDeVie;
    private Combat mCombat;

    protected EtreVivant(String tName, int tPointsDeVie) {
        this.mName = tName;
        this.mPointsDeVie = tPointsDeVie;
        this.mCombat = null;
    }
}