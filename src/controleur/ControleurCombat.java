package controleur;

import protagonistes.Personnage;
import protagonistes.Monstre;

public class ControleurCombat {
    private Personnage mBilly;
    private Monstre mMonstre;
    private Combat mCombat;
    
    public ControleurCombat(Personnage tBilly, Monstre tMonstre, Combat tCombat) {
        this.mBilly = tBilly;
        this.mMonstre = tMonstre;
        this.mCombat = tCombat;
    }

    public int donnerPVperso () {
        return this.mBilly.getPointDeVie();
    }

    public String monstreAttaque() {
        String texte = this.mMonstre.attaquer();
        return texte;
    }

    public String lancerTour() {
        String texte = this.mCombat.itererTour();
        return texte;
    }
}
