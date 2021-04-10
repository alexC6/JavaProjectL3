/**
 * File : Combat.java
 * Code source de la classe Combat
 * 
 * @author Alexandre Coulais, Noëmie Suere, Perrine Mortier
 * @version 2021-4-9
 */
package controleur;

import protagonistes.EtreVivant;
import protagonistes.Monstre;
import protagonistes.Personnage;
import protagonistes.TypeEtreVivant;

public class Combat {
    private int mNbTours;
    private Personnage mPersonnage;
    private Monstre mMonstre;

    public Combat(Personnage tPersonnage, Monstre tMonstre) {
        this.mNbTours = 0;
        this.mPersonnage = tPersonnage;
        this.mMonstre = tMonstre;
    }

    public Personnage getPersonnage() {
        return this.mPersonnage;
    }

    public Monstre getMonstre() {
        return this.mMonstre;
    }

    public String rejointCombat(EtreVivant tEtreVivant) {
        String texte = "";

        switch (tEtreVivant.getType()) {
            case PERSONNAGE:
                this.mPersonnage = (Personnage) tEtreVivant;
                break;
            case MONSTRE:
                this.mMonstre = (Monstre) tEtreVivant;
                break;
        }

        return texte;
    }

    public EtreVivant vainqueur() {
        EtreVivant vainqueur;

        if (mPersonnage.isVivant()) {
            vainqueur = this.mPersonnage;
            this.mMonstre = null;
        } else {
            vainqueur = this.mMonstre;
            this.mPersonnage = null;
        }

        return vainqueur;
    }

    public String itererTour() {
        String texte = "";
        return texte;
    }
}