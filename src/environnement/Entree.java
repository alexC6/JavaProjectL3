package environnement;

import java.util.ArrayList;
import java.util.List;

import equipement.Arme;
import equipement.Armure;
import equipement.Potion;

/**
 * <p> File : Entree.java
 * <br>Code source de la classe Entree héritée de Piece</p>
 * 
 * @author Alexandre Coulais
 * @version 2021-5-14
 */

public class Entree extends Piece {
    /**
     * <p>Les différentes boutiques situées à l'entrée
     * <br>A l'image des Trésor, il y a une boutique par type d'objet vendu</p>
     * 
     * @see Entree#ajouterBoutique(Boutique, TypeObjetVendu)
     */
    private Boutique<Arme> mBoutiqueArme;
    private Boutique<Armure> mBoutiqueArmure;
    private Boutique<Potion> mBoutiquePotion;

    private int mNbBoutique;

    public Entree(List<Porte> tPortes, Labyrinthe tLabyrinthe) {
        super(tPortes, 0, 0, tLabyrinthe);
        this.mNbBoutique = 0;
    }

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

    public int getNbBoutique() {
        return this.mNbBoutique;
    }

    public void ajouterBoutique(Boutique<?> tBoutique, TypeObjetVendu tType) {
        switch (tType) {
            case ARME:
                List<Arme> listeArmes = new ArrayList<Arme>();

                for (int i = 0; i < 5; i++) {
                    listeArmes.add(new Arme(i+1));
                }

                this.mBoutiqueArme = (Boutique<Arme>) tBoutique;
                this.mBoutiqueArme.ajouterArticle(listeArmes);
                break;
            case ARMURE:
                List<Armure> listeArmures = new ArrayList<Armure>();

                for (int i = 0; i < 5; i++) {
                    listeArmures.add(new Armure(i+1));
                }

                this.mBoutiqueArmure = (Boutique<Armure>) tBoutique;
                this.mBoutiqueArmure.ajouterArticle(listeArmures);
                break;
            case POTION:
                List<Potion> listePotions = new ArrayList<Potion>();

                for (int i = 0; i < 5; i++) {
                    listePotions.add(new Potion((i+1)*2));
                }

                this.mBoutiquePotion = (Boutique<Potion>) tBoutique;
                this.mBoutiquePotion.ajouterArticle(listePotions);
        }

        this.mNbBoutique++;
    }
}