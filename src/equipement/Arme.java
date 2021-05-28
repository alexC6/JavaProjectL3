package equipement;
import java.io.Serializable;
import java.util.Random;

import protagonistes.Monstre;
import protagonistes.Personnage;

/**
 *
 * @author Noëmie Suere
 * @version 2021-5-28
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
        setDommage(args);
    }

    /**
     *
     * @param tProprietaire
     * @param args
     */
    public Arme(Personnage tProprietaire, final int... args) {
        this.mProprietaire = tProprietaire;
        this.mProprietaire.prendreArme(this);
        setDommage(args);
    }

    /**
     * Setter des dommages
     * @param args
     *
     */
    private void setDommage(int args[]) {
        // calcul du nombre de point de dommage (entre 1 et 5)
        if (args.length > 0) {
            this.mPointDommage = args[0];
        } else {
            Random rand = new Random();
            this.mPointDommage = rand.nextInt(DOMMAGES_MAX) + DOMMAGES_MIN;
        }
    }

    /**
     * Getter du proprietaire
     * @return le proprietaire
     */
    public Personnage getProprietaire() {
        return mProprietaire;
    }

    /**
    *Fonction qui attribut le propriétaire de l'arme
    * @param tProprietaire
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
     * Fonction d'attaque du personnage avec une arme
     *
     * @param tMonstre le monstre de la salle
     * @return Les dégats subit par le monstre apres l'attaque
     */
    public String attaquer(Monstre tMonstre) {
        return tMonstre.subirAttaque(this.mPointDommage);
    }

    /**
     * Getter des dommage arme
     * @return
     */
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