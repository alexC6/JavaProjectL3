/**
 * File : Personnage.java
 * Code source de la classe Personnage
 * 
 * @author Alexandre Coulais, Noëmie Suere, Perrine Mortier
 * @version 2021-4-9
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
    private String mName;
    private Arme mArme;
    private Armure mArmure;
    private List<Potion> mPotions = new ArrayList<Potion>();
    private Labyrinthe mLabyrinthe;

    public Personnage(String tName) {
        super(10);
        this.mBourse = 0;
        this.mName = tName;
        this.mArme = null;
        this.mArmure = null;
        this.mLabyrinthe = null;
    }

    public String attaquer(){
        //mcombat de etre vivant +combat methode get monstre 
    
        // TODO
    }
    public String getName() {
        return this.mName;
    }

    String obtenirTresor(Tresor tTresor) {
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
                this.mBourse += (int) tTresor.getContenu();
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

    public String boirePotion(Potion tPotion) {
        int pointsRecup = tPotion.getRecuperation();
        String texte = "";

        texte += this.recupererVie(pointsRecup);

        return texte;
    }

    String ouvrirPorte(Porte tPorte) {
        String texte = "";
        // TODO
        return texte;
    }

    public String mourir() {
        String texte = "";

        texte += this.quitteCombat();
        texte += "Hélas, le monstre vous a terrassé ...\n";

        return texte;
    }
}