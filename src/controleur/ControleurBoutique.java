package controleur;

import environnement.Boutique;
import environnement.Entree;
import vue.BoundaryBoutique;

public class ControleurBoutique {
    private static Boutique<?> mBoutique;

    public static void setBoutique(int tChoix, Entree tEntree){
        mBoutique = tEntree.getBoutique(tChoix);
        mBoutique.visiter(tEntree.getLabyrinthe().getPersonnage());
    }

    public static String choixBoutiqueArmure(int tChoix){
        String texte = "";

        if (tChoix == 1) {
            BoundaryBoutique.choixArticle();
        } else {
            texte += mBoutique.reparerArmure();
        }

        return texte;
    }

    public static int getNbArticles() {
        return mBoutique.getNbArticles();
    }

    public static String afficherArticles() {
        return mBoutique.afficherArticles();
    }

    public static String acheterArticle(int tChoix) {
        return mBoutique.acheterArticle(tChoix);
    }
}
