package controleur;

import environnement.Boutique;
import environnement.Entree;
import vue.BoundaryBoutique;

public class ControleurBoutique {
    private static Boutique<?> mBoutique;
    private static Entree mEntree;

    /**
     * Setter d'entrée
     * @param tEntree
     */
    public static void setEntree(Entree tEntree) {
        mEntree = tEntree;
    }

    /**
     * Setter de boutique
     * @param tChoix
     */
    public static void setBoutique(int tChoix){
        mBoutique = mEntree.getBoutique(tChoix);
        mBoutique.visiter(mEntree.getLabyrinthe().getPersonnage());
    }

    /**
     * Fonction qui nous envoie sur le choix ( soit reparation soit achat) dans la boutique armure
     * @param tChoix
     * @return du texte
     */
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
     * Getter piece d'or
     * @return la quantité de pieces d'or du personnage
     */
    public static int getPiecesOr() {
        return mEntree.getLabyrinthe().getPersonnage().getPiecesOr();
    }
}