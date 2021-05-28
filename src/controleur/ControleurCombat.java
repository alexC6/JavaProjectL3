package controleur;

import environnement.PieceCombat;
import protagonistes.EtreVivant;
import protagonistes.Personnage;

/**
 * <p>
 * File : ControleurCombat.java<br>
 * Code source du controleur des combats
 * </p>
 * 
 * @author Thomas Chabert
 * @version 2021-5-28
 */

public class ControleurCombat {
    /**
     * Personnage principal de la partie
     */
    private Personnage mBilly;

    /**
     * Le combat en cours à gérer
     */
    private Combat mCombat;

    /**
     * Constructeur du controleur de combat
     * 
     * @param tBilly Le personnage participant
     */
    public ControleurCombat(Personnage tBilly) {
        this.mBilly = tBilly;
        PieceCombat piecette = (PieceCombat) mBilly.getPiece();
        this.mCombat = piecette.getCombat();
    }

    /**
     * fonction pour savoir s'il y a un vainqueur dans le combat
     * 
     * @return Vrai si l'un des deux combattants a gagné
     */
    public boolean checkVainc() {
        return this.mCombat.vainqueur() != null;
    }

    /**
     * Récupère le vainqueur du combat s'il y en a un
     * 
     * @return Une référence sur un EtreVivant s'il y a un vainqueur, null sinon
     */
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

    /**
     * Getter des points de vie du personnage
     * 
     * @return Points de vie du personnage
     */
    public int donnerPVperso() {
        return this.mBilly.getPointDeVie();
    }

    /**
     * Fonction d'appel des itérations de tours du combat en cours
     * 
     * @return Une string à afficher
     */
    public String lancerTour() {
        return this.mCombat.itererTour();
    }

    /**
     * Getter pour savoir si le personnage possède des potions
     * 
     * @return Vrai si le personnage a des potions, faux sinon
     */
    public boolean possedePotions() {
        return this.mBilly.possedePotions();
    }

    /**
     * Appel la fonction pour demander au joueur quelle potion il souhaite consommer
     * 
     * @return La string à afficher
     */
    public String boirePotion() {
        return this.mBilly.boirePotion();
    }
}