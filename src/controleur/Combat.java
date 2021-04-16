package controleur;

import java.util.Random;

import protagonistes.EtreVivant;
import protagonistes.Monstre;
import protagonistes.Personnage;

/**
 * File : Combat.java
 * Code source de la classe Combat
 * 
 * @author Alexandre Coulais, Noëmie Suere, Perrine Mortier
 * @version 2021-4-16
 */

public class Combat {
    /**
     * Nombre de tours joués du combat
     * 
     * @see Combat#itererTour()
     */
    private int mNbTours;

    /**
     * Le personnage lié au combat
     * 
     * @see Combat#getPersonnage()
     * @see Combat#itererTour()
     * @see Combat#rejointCombat(EtreVivant)
     * @see Combat#vainqueur()
     */
    private Personnage mPersonnage;

    /**
     * Le monstre lié au combat
     * 
     * @see Combat#getMonstre()
     * @see Combat#itererTour()
     * @see Combat#rejointCombat(EtreVivant)
     * @see Combat#vainqueur()
     */
    private Monstre mMonstre;

    /**
     * Constructeur par défaut
     * A voir si vraiment nécessaire
     */
    public Combat() {
        this.mNbTours = 0;
        this.mPersonnage = null;
        this.mMonstre = null;
    }

    /**
     * Constructeur de combat avec passage direct des participants
     * 
     * @param tPersonnage   Le personnage combattant
     * @param tMonstre      Le monstre combattu
     */
    public Combat(Personnage tPersonnage, Monstre tMonstre) {
        this.mNbTours = 0;
        this.mPersonnage = tPersonnage;
        this.mMonstre = tMonstre;
    }

    /**
     * Getter du personnage du combat
     * @author Alexandre Coulais
     * 
     * @return Personnage   Le personnage combattant
     */
    public Personnage getPersonnage() {
        return this.mPersonnage;
    }

    /**
     * Getter du monstre du combat
     * @author Alexandre Coulais
     * 
     * @return Monstre  Le monstre combattu
     */
    public Monstre getMonstre() {
        return this.mMonstre;
    }

    public boolean choixContinuer() {}

    /**
     * Permet à un être vivant de rejoindre le combat
     * A voir si vraiment nécessaire
     * @author Alexandre Coulais
     * 
     * @param tEtreVivant L'être vivant rejoignant le combat
     * 
     * @return String   Le texte à afficher
     */
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

    /**
     * Fonction retournant un être vivant si l'un des deux a gagné
     * @author Alexandre Coulais
     * 
     * @return EtreVivant   L'être vivant ayant gagné le combat, null si pas de gagnant
     */
    public EtreVivant vainqueur() {
        EtreVivant vainqueur = null;

        if (mPersonnage.isVivant() && !(mMonstre.isVivant())) {
            vainqueur = this.mPersonnage;
            this.mMonstre = null;
        } else if (!(mPersonnage.isVivant()) && mMonstre.isVivant()) {
            vainqueur = this.mMonstre;
            this.mPersonnage = null;
        }

        return vainqueur;
    }

    /**
     * Fonction d'itération d'un tour du combat
     * @author Alexandre Coulais
     * 
     * @return String   Le texte à afficher
     */
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

        this.mNbTours++;

        return texte;
    }
}