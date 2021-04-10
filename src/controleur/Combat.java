/**
 * File : Combat.java
 * Code source de la classe Combat
 * 
 * @author Alexandre Coulais, Noëmie Suere, Perrine Mortier
 * @version 2021-4-9
 */
package controleur;

import java.util.Random;

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

    public boolean choixContinuer() {}

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
        int victime;
        Random rand = new Random();
        String texte = "";

        if (!this.choixContinuer()) {
            return "Vous avez décidé de fuir !\n";
        }

        victime = rand.nextInt(2);

        switch (victime) {
            case 0:
                texte += this.mPersonnage.attaquer();
                break;
            case 1:
                texte += this.mMonstre.attaquer();
                break;
        }

        return texte;
    }
}