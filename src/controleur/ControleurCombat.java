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

    /**
     * Retourne un booléen concernant l'état du monstre
     * 
     * @return Vrai si le vainqueur est le Personnage, faux sinon
     */
    public boolean isMonsterDead() {
        return this.mCombat.getMonstre() == null;
    }

    /**
     * Retourne un booléen concernant l'état du personnage
     * 
     * @return Vrai si le vainqueur est le Monstre, faux sinon
     */
    public boolean isPersonnageDead() {
        return !(this.mCombat.getPersonnage().isVivant());
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