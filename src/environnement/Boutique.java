package environnement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import equipement.Arme;
import equipement.Armure;
import equipement.Potion;
import protagonistes.Personnage;
import vue.Clavier;

/**
 *
 * @author Noëmie Suere
 * @version 2021-5-26
 */

public class Boutique<T> implements Serializable {
    /**
     * Constructeur de Boutique
     */
    private int mNbArticles;
    private TypeObjetVendu mType;
    private Personnage mVisiteur;
    private List<T> mArticles = new ArrayList<T>();
    private List<Integer> mPrix = new ArrayList<Integer>();

    /**
     *
     * @param tArticle
     * @param tType
     */
    public Boutique(TypeObjetVendu tType) {
        this.mType = tType;
        mPrix.add(100);
        mPrix.add(250);
        mPrix.add(500);
        mPrix.add(1000);
        mPrix.add(2000);
    }

    public int getNbArticles() {
        return this.mNbArticles;
    }

    public int getPrix(int tIndex) {
        return this.mPrix.get(tIndex);
    }

    /**
     * Fonction servant à ajouter les articles dans la boutique selon la
     * boutique(générécité)
     * 
     * @param tArticles
     */
    public void ajouterArticle(List<T> tArticles) {
        this.mArticles = tArticles;
        this.mNbArticles = tArticles.size();
    }

    /**
     * Fonction permettant d'avoir le personnage dans la boutique
     *
     * @param tPersonnage Le personnage qui visite
     */
    public void visiter(Personnage tPersonnage) {
        this.mVisiteur = tPersonnage;
    }

    /**
     * Fonction d'achat faisant appel aux fonctions du personnage
     *
     * @param tArticle L'index de l'article à acheter
     * @return Le texte à afficher
     */
    public String acheterArticle(int tArticle) {
        String texte = "";

        if (this.mVisiteur.acheter(this.mPrix.get(tArticle - 1))) {
            switch (this.mType) {
                case ARME:
                    texte += this.mVisiteur.prendreArme((Arme) this.mArticles.get(tArticle - 1));
                    break;
                case ARMURE:
                    texte += this.mVisiteur.equiperArmure((Armure) this.mArticles.get(tArticle - 1));
                    break;
                case POTION:
                    texte += this.mVisiteur.stockerPotion((Potion) this.mArticles.get(tArticle - 1));
            }
        } else {
            texte += "Vous n'avez pas assez d'argent pour cet article !";
        }

        return texte;
    }

    /**
     * Fonction de réparation, vérifie la réponse (O ou N) (la verification de la
     * bourse se fait dans personnage)
     * 
     * @return Le texte à afficher
     */
    public String reparerArmure() {
        String question = "Voulez-vous réparer votre armure? (O pour réparer et N si vous êtes trop radin)";
        String txt = "";

        // Si le perso choisit de réparer
        if (Clavier.demanderChoix(question, "O", "N")) {
            this.mVisiteur.reparerArmure();
            txt += "Votre armure est réparée. Retournez au combat valeureux guerrier!";
        } else {

            txt += "Merci d'être passé, revenez nous voir quand vous aurez de l'argent à dépenser ! On ne fait pas crédit Combattant !";
        }
        return txt;
    }

    /**
     *
     * @return Le texte à afficher
     */
    public String afficherArticles() {
        int i = 0;
        String texte = "";

        for (T article : this.mArticles) {
            i++;
            texte += i + ") " + article + "\t" + getPrix(i - 1) + " pièces d'Or\n";
        }

        return texte;
    }
}