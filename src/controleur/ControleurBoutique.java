package controleur;

import environnement.Boutique;
import environnement.Entree;
import vue.BoundaryBoutique;

public class ControleurBoutique {
    private static Boutique<?> mBoutique;
    private static Entree mEntree;


    public static void setEntree(Entree tEntree) {
        mEntree = tEntree;
    }


    public static void setBoutique(int tChoix){
        mBoutique = mEntree.getBoutique(tChoix);
        mBoutique.visiter(mEntree.getLabyrinthe().getPersonnage());
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

    /**
     * Permet de recuperer le nombre d'article de la boutique
     * @return le nombre d'article de la boutique
     */
    public static int getNbArticles() {
        return mBoutique.getNbArticles();
    }

    /**
     *  Permet d'afficher les articles de la boutique
     * @return l'affichage des articles
     */
    public static String afficherArticles() {
        return mBoutique.afficherArticles();
    }

    /**
     * Achat de l'article choisis
     * @param tChoix
     * @return L'achat de l'article choisis
     */
    public static String acheterArticle(int tChoix) {
        return mBoutique.acheterArticle(tChoix);
    }

    /**
     * 
     * @return
     */
    public static int getPiecesOr() {
        return mEntree.getLabyrinthe().getPersonnage().getPiecesOr();
    }
}