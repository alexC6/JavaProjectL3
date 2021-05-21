package controleur;

import protagonistes.Personnage;
import protagonistes.Monstre;
import environnement.Piece;
import environnement.PieceCombat;

public class ControleurCombat {
    private Personnage mBilly;
    private Monstre mMonstre;
    private Combat mCombat;
    
    public ControleurCombat(Personnage tBilly) {
        this.mBilly = tBilly;

        PieceCombat piecette = (PieceCombat) mBilly.getPiece();
        this.mCombat = piecette.getCombat();

        this.mMonstre = this.mCombat.getMonstre();
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

    // A finir
    public String demarrerCombat() {
        if(this.mCombat.vainqueur() == null) {}
        return null;
    }
}
