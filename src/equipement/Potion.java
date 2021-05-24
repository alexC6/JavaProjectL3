package equipement;

import java.io.Serializable;

import protagonistes.Personnage;

public class Potion implements Serializable {

    private Personnage mProprietaire;
    private int mRecuperation;
    private int FORCE_POTION_MIN = 1;
    private int FORCE_POTION_MAX = 10;

    public Potion(final int... args) {
        this.mProprietaire = null;
        if (args.length > 0) {
            mRecuperation = args[0];
        } else {
            // calcul du nombre de point de vie récuperés (entre 1 et 10)
            this.mRecuperation = (int) (Math.random() * (FORCE_POTION_MAX - FORCE_POTION_MIN));
        }
    }

    public Potion(Personnage tProprietaire, final int... args) {
        this.mProprietaire = tProprietaire;
        // calcul du nombre de point de vie récuperés (entre 1 et 10)

        if (args.length > 0) {
            mRecuperation = args[0];
        } else {
            this.mRecuperation = (int) (Math.random() * (FORCE_POTION_MAX - FORCE_POTION_MIN));
        }
    }

    public void viderPotion() {
        this.mProprietaire = null;
    }

    public int getRecuperation() {
        return mRecuperation;
    }

    public String afficherRecuperation() {
        return "Vous avez récupéré " + this.mRecuperation + " point(s) de vie.\n";
    }

    public String toString() {
        return "potion de force " + this.mRecuperation;
    }
}