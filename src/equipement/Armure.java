package equipement;

import java.io.Serializable;
import java.util.Random;

import protagonistes.Personnage;

/**
 * 
 * @author Noëmie Suere
 * @version 2021-5-24
 */
public class Armure implements Serializable {
    private int mProtection;
    private int PROTECT_MIN = 1;
    private int PROTECT_MAX = 5;
    private Personnage mProprietaire;
    private int mEtatInitial;

    /**
     *
     * @param args (permet de donnée l'argument que l'ont veux sinon aléatoire)
     */
    public Armure(final int... args) {
        this.mProprietaire = null;
        setProtection(args);
    }

    /**
     *
     * @param tProprietaire
     * @param args
     */
    public Armure(Personnage tProprietaire, final int... args) {
        this.mProprietaire = tProprietaire;
        this.mProprietaire.equiperArmure(this);
        setProtection(args);
    }

    /**
     * Setter de la protection
     * @param args
     */
    private void setProtection(int args[]) {
        // calcul du nombre de point de protection (entre 1 et 5)
        if (args.length > 0) {
            this.mProtection = args[0];
        } else {
            Random rand = new Random();
            this.mProtection = rand.nextInt(PROTECT_MAX) + PROTECT_MIN;
        }

        this.mEtatInitial = this.mProtection;
    }

    public int getEtatInitial() {
        return this.mEtatInitial;
    }

    public int getPointsProtection() {
        return this.mProtection;
    }

    public Personnage getProprietaire() {
        return mProprietaire;
    }

    /**
    *Fonction set qui vérifie si il y a deja un propriétaire ou non, si non : donner a l'armure un proprietaire
    * @param tProprietaire  
    */
    public void setProprietaire(Personnage tProprietaire) {
        if (this.mProprietaire == null) {
            this.mProprietaire = tProprietaire;
        }
    }

    /**
     * Fonction qui verifie l'integrité de l'armure pour savoir si elle encaisse les dégat ou non
     * @param tDegat
     * @return du texte selon si le personnage prend un coup et perd sont armure ou subit et encaisse l'attaque
     */
    public String encaisserDegat(int tDegat) {

        String texte = "";
        //si l'armure possède plus de protection que de dégat infligé alors on lui indique combien de dégats l'armure a subit et on lui retire les point de protection
        if (tDegat < this.mProtection) {
            this.mProtection = this.mProtection - tDegat;
            texte = "Votre armure a subit " + tDegat + " dégâts.";
            //sinon si les degats sotn superieurs ou egals a la protection alors elle se casse
        } else if (tDegat >= this.mProtection) {
            this.casser();
            texte = "Votre armure s'est cassée !";
        }

        return texte;
    }

    /**
     * Fonction qui met la protection de l'armure a 0 si elle est cassé (donc si elle ne fait plus d'effet)
     */
    public void casser() {
        this.mProtection = 0;
    }

    /**
     * Fonction de reparation de l'armure qui la remet a sont etat initial (selon les points de l'armure de base)
     * @return du texte 
     */
    public String reparer() {
        String texte = "";
        //si la protection de l'armure est inferieure a l'état initial alors on la répare et on la met a sont etat initial
        if (this.mProtection < this.mEtatInitial) {
            this.mProtection = this.mEtatInitial;
            texte = " Votre armure est réparée.";
            //sinon l'armure n'as pas besoin de réparation car elle a la meme protection que l'état initial
        } else if (this.mProtection == this.mEtatInitial) {
            texte = "Vous n'avez besoin de réparer votre armure";
        }
        return texte;
    }

    /**
     * Fonction d'affichage de la protection de l'armure
     *
     * @return renvoie du texte avec les point de protection de l'armure
     */
    public String toString() {
        return "armure de protection " + this.mProtection;
    }

    /**
     * 
     * @return un boolean vrai si la protection est a 0
     */
    public boolean estCassee(){
        
      return this.mProtection == 0;
    
    }
}