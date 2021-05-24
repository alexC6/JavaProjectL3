package equipement;
import java.io.Serializable;

import protagonistes.Monstre;
import protagonistes.Personnage;

/**
 * 
 * @author Noëmie Suere
 * @version 2021-5-12
 */

public class Arme implements Serializable {
	private int mPointDommage; 
    private int DOMMAGES_MIN =1;
    private int DOMMAGES_MAX =5;
    private Personnage mProprietaire;


    /**
     *
     * @param args (permet de donnée l'argument que l'ont veux sinon aléatoire)
     */
    public Arme(final int... args) {
        this.mProprietaire = null;
        // calcul du nombre de point de dommage (entre 1 et 5)
        if (args.length > 0) {
            this.mPointDommage = args[0];
        } else {
            this.mPointDommage = (int) (Math.random() * (DOMMAGES_MAX - DOMMAGES_MIN));
        }
    }

    /**
     *
     * @param tProprietaire
     * @param args
     */
    public Arme(Personnage tProprietaire, final int... args) {
        this.mProprietaire = tProprietaire;
        this.mProprietaire.prendreArme(this);
        if (args.length > 0) {
            this.mPointDommage = args[0];
        } else {
            this.mPointDommage = (int) (Math.random() * (DOMMAGES_MAX - DOMMAGES_MIN));
        }
    }
    
    public Personnage getProprietaire() {
        return mProprietaire;
    }

    /**
    *
    *
    */
    public void setProprietaire(Personnage tProprietaire) {
        this.mProprietaire = tProprietaire;

    }

    /**
     *
     *Fonction permettant de lâcher l'arme porter par le joueur 
     */
    public void lacher () {
        this.mProprietaire = null;
    }

    /**
     * Fonction d'attaque du personnage avec une épée
     *
     * @param tMonstre le monstre de la salle
     * @return Les dégats subit par le monstre apres l'attaque
     */
    public String attaquer(Monstre tMonstre) {
        return tMonstre.subirAttaque(this.mPointDommage);
    }

    
    public int getDommageArme() {
        return this.mPointDommage;
    }

    /**
     * Fonction d'affichage des dommage causé par l'arme
     *
     * @return renvoie du texte avec les point de dommage de l'arme
     */
    public String toString() {
        return "arme de dommage " + this.mPointDommage;
    }
}