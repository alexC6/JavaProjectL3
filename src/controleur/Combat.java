package controleur;

import java.io.Serializable;
import java.util.Random;

import environnement.PieceCombat;
import protagonistes.EtreVivant;
import protagonistes.Monstre;
import protagonistes.Personnage;

/**
 * File : Combat.java
 * Code source de la classe Combat
 * 
 * @author Alexandre Coulais, Noëmie Suere, Perrine Mortier
 * @version 2021-5-13
 */

public class Combat implements Serializable {
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
        this.mMonstre.rejointCombat(this);
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

    /**
     * Getter sur l'attribut mNbTours
     * 
     * @return Integer  Nombre de tours écoulés depuis le début du combat
     */
    public int getNbTours(){
        return this.mNbTours;
    }

    /**
     * Affiche le nième tour en cours
     * @return String  Le texte à afficher
     */
    public String afficherTour(){
        String texte = "";
        switch(this.mNbTours){
            case 1:
                texte = "premier tour\n";
                break;
            default: texte = this.mNbTours + "ème tour\n";
        }
        return texte;
    }

    /**
     * 
     * @return
     */
    public String abandonner() { return "";}

    /**
     * Quitter le combat
     * @return String  Le texte à afficher
     */
    public String eliminer() {
        String texte = "";
        this.mMonstre = null;
        this.mPersonnage = null;
        return texte;
    }

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

        if (this.mMonstre == null) {
            System.out.println("Vous êtes déjà passé par là, il n'y a plus rien à voir !");
            vainqueur = this.mPersonnage;
        } else if (mPersonnage.isVivant() && !(mMonstre.isVivant())) {
            vainqueur = this.mPersonnage;
            PieceCombat piece = (PieceCombat) this.mPersonnage.getPiece();
            System.out.println(piece.recupererTresor());
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

        this.mNbTours++;

        texte += this.afficherTour();
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