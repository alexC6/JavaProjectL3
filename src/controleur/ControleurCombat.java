package controleur;

import protagonistes.Personnage;
import environnement.PieceCombat;

public class ControleurCombat {
    private Personnage mBilly;
    private Combat mCombat;
    
    public ControleurCombat(Personnage tBilly) {
        this.mBilly = tBilly;

        PieceCombat piecette = (PieceCombat) mBilly.getPiece();
        this.mCombat = piecette.getCombat();
    }

    public boolean checkVainc() {
        if(this.mCombat.vainqueur() == null) {
            return false;
        }
        else {
            return true;
        }
    }

    public int donnerPVperso () {
        return this.mBilly.getPointDeVie();
    }

    public String lancerTour() {
        String texte = this.mCombat.itererTour();
        return texte;
    }
}