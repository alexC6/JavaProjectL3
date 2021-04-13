/**
 * <p> File : Personnage.java
 * <br>Code source de la classe Personnage </p>
 * 
 * @author Alexandre Coulais, Noëmie Suere, Perrine Mortier
 * @version 2021-4-13
 */
package protagonistes;

import java.util.ArrayList;
import java.util.List;

import environnement.Labyrinthe;
import environnement.Porte;
import environnement.Tresor;
import environnement.TypeTresor;
import equipement.Arme;
import equipement.Armure;
import equipement.Potion;

public class Personnage extends EtreVivant {
    private int mBourse;
    private String mNom;
    private Arme mArme;
    private Armure mArmure;
    private List<Potion> mPotions = new ArrayList<Potion>();
    private Labyrinthe mLabyrinthe;

    /**
     * <p>Constructeur de la classe Personnage</p>
     * @author Alexandre Coulais
     * 
     * @param tNom Le nom du personnage
     */
    public Personnage(String tNom) {
        super(10);
        this.mBourse = 0;
        this.mNom = tNom;
        this.mArme = null;
        this.mArmure = null;
        this.mLabyrinthe = null;
    }

    public String attaquer(){
        //mcombat de etre vivant +combat methode get monstre 
    
        // TODO
    }

    /**
     * <p>Getter du nom du personnage</p>
     * @author Alexandre Coulais
     * 
     * @return String   Le nom du personnage
     */
    public String getNom() {
        return this.mNom;
    }

    /**
     * <p>Fonction permettant au personnage de récupérer le contenu d'un coffre</p>
     * @author Alexandre Coulais
     * 
     * @param tTresor Le trésor à ouvrir
     * 
     * @return String   Le texte à afficher
     */
    public String obtenirTresor(Tresor tTresor) {
        String texte = "";
        TypeTresor type = tTresor.getType();

        switch (type) {
            case ARME:
                texte += this.prendreArme((Arme) tTresor.getContenu());
                break;
            case ARMURE:
                texte += this.equiperArmure((Armure) tTresor.getContenu());
                break;
            case PIECE_OR:
                int piecesOr = (int) tTresor.getContenu();
                texte += "Vous avez obtenu " + piecesOr + " pièce(s) d'or !\n";
                this.mBourse += piecesOr;
                break;
        }

        tTresor.viderTresor();

        return texte;
    }

    public String prendreArme(Arme tArme) {
        String texte = "";
        // TODO
        return texte;
    }

    public String equiperArmure(Armure tArmure) {
        String texte = "";
        // TODO
        return texte;
    }

    /**
     * <p> Fonction permettant au personnage de boire une potion
     * <br>afin de récupérer des points de vie </p>
     * @author Alexandre Coulais
     * 
     * @param tPotion   La potion à boire
     * 
     * @return String   Le texte à afficher
     */
    public String boirePotion(Potion tPotion) {
        int pointsRecup = tPotion.getRecuperation();
        String texte = "";

        texte += this.recupererVie(pointsRecup);

        return texte;
    }

    public String ouvrirPorte(Porte tPorte) {
        String texte = "";
        // TODO
        return texte;
    }

    /**
     * <p> Définition de la fonction mourir d'EtreVivant
     * <br>Fait quitter le combat au personnage </p>
     * @author Alexandre Coulais
     * 
     * @see EtreVivant#mourir()
     * 
     * @return String   Le texte à afficher
     */
    @Override
    public String mourir() {
        String texte = "";

        texte += this.quitteCombat();
        texte += "Hélas, le monstre vous a terrassé ...\n";

        return texte;
    }

    /**
     * <p> Redéfinition de la fonction subirAttaque d'EtreVivant
     * <br>Calcul les degats réellement subits par le personnage
     * <br>et ceux à soustraire à son armure </p>
     * @author Alexandre Coulais
     * 
     * @see EtreVivant#subirAttaque(int)
     * 
     * @param tDegats   Les degats de l'attaque par le monstre
     * 
     * @return String   Le texte à afficher
     */
    @Override
    public String subirAttaque(int tDegats) {
        String texte = "";
        int pointsArmure = this.mArmure.getPointsProtection();
        int degatsRestants = tDegats - pointsArmure;

        texte += this.mArmure.encaisserDegat(tDegats);

        if (degatsRestants > 0) {
            texte += super.subirAttaque(degatsRestants);
        }

        return texte;
    }
}