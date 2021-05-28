package equipement;

import java.io.Serializable;
import java.util.Random;

/**
 * @author Noëmie Suere
 * @version 2021-5-28
 */
public class Potion implements Serializable {

    private int mRecuperation;
    private int FORCE_POTION_MIN = 1;
    private int FORCE_POTION_MAX = 10;

    /**
     * 
     * @param args (permet de donnée l'argument que l'ont veux, sinon aléatoire)
     */
    public Potion(final int... args) {
        // calcul du nombre de point de dommage (entre 1 et 5)
        if (args.length > 0) {
            this.mRecuperation = args[0];
        } else {
            Random rand = new Random();
            this.mRecuperation = rand.nextInt(FORCE_POTION_MAX) + FORCE_POTION_MIN;
        }
    }

    public int getRecuperation() {
        return mRecuperation;
    }

    /**
     * Fonction qui permet d'afficher les point de vie recuperer apres avoir bu une potion
     * @return du texte
     */
    public String afficherRecuperation() {
        return "Vous avez récupéré " + this.mRecuperation + " point(s) de vie.\n";
    }

    public String toString() {
        return "potion de force " + this.mRecuperation;
    }
}