package controleur;

import protagonistes.EtreVivant;
import protagonistes.Monstre;
import protagonistes.Personnage;

public class Combat {
    private int mNbTours;
    private Personnage mPersonnage;
    private Monstre mMonstre;

    public Combat(Personnage tPersonnage, Monstre tMonstre) {
        this.mNbTours = 0;
        this.mPersonnage = tPersonnage;
        this.mMonstre = tMonstre;
    }

    public String rejointCombat(EtreVivant tEtreVivant) {
        String texte = "";
        return texte;
    }

    public EtreVivant vainqueur() {
        return this.mPersonnage.isVivant() ? (EtreVivant) this.mPersonnage : (EtreVivant) this.mMonstre;
    }

    public String itererTour() {
        String texte = "";
        return texte;
    }
}