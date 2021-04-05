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

    public int getPointDeVie() {
        return this.mPointsDeVie;
    }

    public String getName() {
        return this.mName;
    }

    public boolean isVivant() {
        return this.mPointsDeVie > 0;
    }

    public String mourir() {
        String texte = "";
        return texte;
    }

    public String subirAttaque(int tDegats) {
        String texte = "";

        if (tDegats >= 0) {
            this.mPointsDeVie -= tDegats;
        }

        return texte;
    }

    public String recupererVie(int tPointsDeVie) {
        String texte = "";

        if (tPointsDeVie > 0) {
            this.mPointsDeVie = tPointsDeVie;
        }

        return texte;
    }
}