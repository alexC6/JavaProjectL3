package controleur;

import java.io.Serializable;
import java.util.Random;

import environnement.PieceCombat;
import protagonistes.EtreVivant;
import protagonistes.Monstre;
import protagonistes.Personnage;

/**
 * <p>
 * File : Combat.java<br>
 * Code source de la classe Combat
 * </p>
 * 
 * @author Alexandre Coulais, Noëmie Suere, Perrine Mortier, Thomas Chabert
 * @version 2021-5-28
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
     * Constructeur par défaut A voir si vraiment nécessaire
     */
    public Combat() {
        this.mNbTours = 0;
        this.mPersonnage = null;
        this.mMonstre = null;
    }

    /**
     * Constructeur de combat avec passage direct des participants
     * 
     * @param tPersonnage Le personnage combattant
     * @param tMonstre    Le monstre combattu
     */
    public Combat(Personnage tPersonnage, Monstre tMonstre) {
        this.mNbTours = 0;
        this.mPersonnage = tPersonnage;
        this.mMonstre = tMonstre;
        this.mMonstre.rejointCombat(this);
    }

    /**
     * Getter du personnage du combat
     * 
     * @return Personnage Le personnage combattant
     */
    public Personnage getPersonnage() {
        return this.mPersonnage;
    }

    /**
     * Getter du monstre du combat
     * 
     * @return Monstre Le monstre combattu
     */
    public Monstre getMonstre() {
        return this.mMonstre;
    }

    /**
     * Getter sur l'attribut mNbTours
     * 
     * @return Integer Nombre de tours écoulés depuis le début du combat
     */
    public int getNbTours() {
        return this.mNbTours;
    }

    /**
     * Affiche le nième tour en cours
     * 
     * @return String Le texte à afficher
     */
    public String afficherTour() {
        String texte = "";

        switch (this.mNbTours) {
            case 1:
                texte = "premier tour\n";
                break;
            default:
                texte = this.mNbTours + "ème tour\n";
        }

        return texte;
    }

    /**
     * Quitter le combat
     * 
     * @return String Le texte à afficher
     */
    public String eliminer() {
        String texte = "";

        this.mMonstre = null;
        this.mPersonnage = null;

        return texte;
    }

    /**
     * Permet à un être vivant de rejoindre le combat A voir si vraiment nécessaire
     * 
     * @param tEtreVivant L'être vivant rejoignant le combat
     */
    public void rejointCombat(EtreVivant tEtreVivant) {
        // Utilisation du type de la victime pour déterminer quelle affectation
        // effectuer
        switch (tEtreVivant.getType()) {
            case PERSONNAGE:
                this.mPersonnage = (Personnage) tEtreVivant;
                break;
            case MONSTRE:
                this.mMonstre = (Monstre) tEtreVivant;
                break;
        }
    }

    /**
     * Fonction retournant un être vivant si l'un des deux a gagné
     * 
     * @return EtreVivant L'être vivant ayant gagné le combat, null si pas de
     *         gagnant
     */
    public EtreVivant vainqueur() {
        EtreVivant vainqueur = null;

        if (this.mMonstre == null) {
            // Dans le cas où le personnage a déjà tué le monstre de la salle
            vainqueur = this.mPersonnage;
        } else if (mPersonnage.isVivant() && !(mMonstre.isVivant())) {
            // Si le personnage est vivant mais que le monstre est mort
            vainqueur = this.mPersonnage;
            // On récupère la pièce où se trouve le personnage et on récupère le coffre qui
            // s'y trouve
            PieceCombat piece = (PieceCombat) this.mPersonnage.getPiece();
            System.out.println(piece.recupererTresor());
            System.out.println(this.mPersonnage.recupererVie(10 - this.mPersonnage.getPointDeVie()));
            this.mMonstre = null;
        } else if (!(mPersonnage.isVivant()) && mMonstre.isVivant()) {
            // Si le personnage est mort mais que le monstre est vivant
            vainqueur = this.mMonstre;
            System.out.println(this.mMonstre.recupererVie(5 - this.mMonstre.getPointDeVie()));
            // this.mPersonnage = null;
        }

        return vainqueur;
    }

    /**
     * Fonction d'itération d'un tour du combat <br>
     * La victime (et donc l'attaquant par extension) est tirée au sort à chaque
     * tour
     * 
     * @return String Le texte à afficher
     */
    public String itererTour() {
        int victime;
        Random rand = new Random();
        String texte = "";

        this.mNbTours++;

        /**
         * Affichage du numéro du tour et tirage au sort de la victime Si victime == 0
         * alors la victime est le monstre Sinon la victime est le personnage
         */
        texte += this.afficherTour();
        victime = rand.nextInt(2);

        // En fonction de la victime, on fait attaquer le monstre ou le personnage
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