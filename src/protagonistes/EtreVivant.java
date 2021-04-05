package protagonistes;

import controleur.Combat;

public abstract class EtreVivant {
    private int mPointsDeVie;
    private Combat mCombat;

    protected EtreVivant(int tPointsDeVie) {
        this.mPointsDeVie = tPointsDeVie;
        this.mCombat = null;
    }

    public int getPointDeVie() {
        return this.mPointsDeVie;
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