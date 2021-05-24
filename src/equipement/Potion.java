package equipement;

import java.io.Serializable;

public class Potion implements Serializable {

    private int mRecuperation;
    private int FORCE_POTION_MIN = 1;
    private int FORCE_POTION_MAX = 10;

    public Potion(final int... args) {
        if (args.length > 0) {
            mRecuperation = args[0];
        } else {
            // calcul du nombre de point de vie récuperés (entre 1 et 10)
            this.mRecuperation = (int) (Math.random() * (FORCE_POTION_MAX - FORCE_POTION_MIN));
        }
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