package environnement;

import java.util.ArrayList;
import java.util.List;

import equipement.Arme;
import equipement.Armure;
import equipement.Potion;

/**
 * <p>
 * File : Entree.java <br>
 * Code source de la classe Entree héritée de Piece
 * </p>
 * 
 * @author Alexandre Coulais
 * @version 2021-5-25
 */

public class Entree extends Piece {
    /**
     * <p>
     * Les différentes boutiques situées à l'entrée <br>
     * A l'image des Trésor, il y a une boutique par type d'objet vendu
     * </p>
     * 
     * @see Entree#getBoutique(int)
     * @see Entree#ajouterBoutique(Boutique, TypeObjetVendu)
     */
    private Boutique<Arme> mBoutiqueArme;
    private Boutique<Armure> mBoutiqueArmure;
    private Boutique<Potion> mBoutiquePotion;

    /**
     * Nombre de boutiques dans l'entrée
     * 
     * @see Entree#getNbBoutique()
     */
    private int mNbBoutique;

    /**
     * Constructeur de la classe
     * 
     * @param tPortes     La liste des portes de la salle, construite par le
     *                    labyrinthe
     * @param tLabyrinthe Le labyrinthe d'appartenance de l'entrée
     */
    public Entree(List<Porte> tPortes, Labyrinthe tLabyrinthe) {
        super(tPortes, 0, 0, tLabyrinthe);
        this.mNbBoutique = 0;
    }

    /**
     * Retourne une boutique en fonction du numéro passé en paramètre
     * 
     * @param tBoutique L'index de la boutique que l'on veut
     * @return La boutique correspondante à l'index en paramètre, null si index
     *         inconnu
     */
    public Boutique<?> getBoutique(int tBoutique) {
        switch (tBoutique) {
            case 1:
                return this.mBoutiqueArme;
            case 2:
                return this.mBoutiqueArmure;
            case 3:
                return this.mBoutiquePotion;
            default:
                return null;
        }
    }

    /**
     * Getter du nombre de boutique dans l'entrée
     * 
     * @return Le nombre de boutiques dans l'entrée
     */
    public int getNbBoutique() {
        return this.mNbBoutique;
    }

    /**
     * Fonction d'ajout d'une boutique à l'entrée <br>
     * Au vu du caractère générique de la classe boutique, il a été entendu que
     * l'entrée fournissait les articles de chaque boutique
     * 
     * @param tBoutique La boutique que l'on ajoute
     * @param tType     Le type d'objet qu'elle vend
     */
    @SuppressWarnings("unchecked")
    public void ajouterBoutique(Boutique<?> tBoutique, TypeObjetVendu tType) {
        /**
         * On se base sur le type d'objet vendu pour savoir quelle affectation effectuer
         * Pour chaque type, on construit une liste d'article qui sera ajoutée aux
         * boutiques
         */
        switch (tType) {
            case ARME:
                List<Arme> listeArmes = new ArrayList<Arme>();

                for (int i = 0; i < 5; i++) {
                    listeArmes.add(new Arme(i + 1));
                }

                this.mBoutiqueArme = (Boutique<Arme>) tBoutique;
                this.mBoutiqueArme.ajouterArticle(listeArmes);
                break;
            case ARMURE:
                List<Armure> listeArmures = new ArrayList<Armure>();

                for (int i = 0; i < 5; i++) {
                    listeArmures.add(new Armure(i + 1));
                }

                this.mBoutiqueArmure = (Boutique<Armure>) tBoutique;
                this.mBoutiqueArmure.ajouterArticle(listeArmures);
                break;
            case POTION:
                List<Potion> listePotions = new ArrayList<Potion>();

                for (int i = 0; i < 5; i++) {
                    listePotions.add(new Potion((i + 1) * 2));
                }

                this.mBoutiquePotion = (Boutique<Potion>) tBoutique;
                this.mBoutiquePotion.ajouterArticle(listePotions);
        }

        this.mNbBoutique++;
    }
}