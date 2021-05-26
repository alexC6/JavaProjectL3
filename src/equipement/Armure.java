package equipement;

import java.io.Serializable;

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
        if (args.length > 0) {
            mProtection = args[0];
            this.mEtatInitial = mProtection;
        } else {
            // calcul du nombre de point d'armure (entre 1 et 5)
            this.mProtection = (int) (Math.random() * (PROTECT_MAX - PROTECT_MIN));
            this.mEtatInitial = this.mProtection;
        }
    }

    /**
     *
     * @param tProprietaire
     * @param args
     */
    public Armure(Personnage tProprietaire, final int... args) {
        this.mProprietaire = tProprietaire;
        this.mProprietaire.equiperArmure(this);
        if (args.length > 0) {
            mProtection = args[0];
            this.mEtatInitial = mProtection;
        } else {
            this.mProtection = (int) (Math.random() * (PROTECT_MAX - PROTECT_MIN));
            this.mEtatInitial = this.mProtection;

        }
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
        
        if (tDegat <= this.mProtection) {
            this.mProtection = this.mProtection - tDegat;
            texte = "Votre armure est cassé";
        } else if (tDegat > this.mProtection) {
            this.casser();
            texte = "Votre armure a subit " + tDegat;
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

        if (this.mProtection < this.mEtatInitial) {
            this.mProtection = this.mEtatInitial;
            texte = " Votre armure est réparée.";
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