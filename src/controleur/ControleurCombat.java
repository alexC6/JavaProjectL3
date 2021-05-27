package controleur;

import environnement.PieceCombat;
import protagonistes.EtreVivant;
import protagonistes.Personnage;

public class ControleurCombat {
    private Personnage mBilly;
    private Combat mCombat;

    public ControleurCombat(Personnage tBilly) {
        this.mBilly = tBilly;

        PieceCombat piecette = (PieceCombat) mBilly.getPiece();
        this.mCombat = piecette.getCombat();
    }

    public boolean checkVainc() {
        if (this.mCombat.vainqueur() == null) {
            return false;
        } else {
            return true;
        }
    }

    public EtreVivant getVainqueur() {
        return this.mCombat.vainqueur();
    }

    public int donnerPVperso() {
        return this.mBilly.getPointDeVie();
    }

    public String lancerTour() {
        String texte = this.mCombat.itererTour();
        return texte;
    }

    public boolean possedePotions() {
        return this.mBilly.possedePotions();
    }

    public void boirePotion() {
        this.mBilly.boirePotion();
    }
}