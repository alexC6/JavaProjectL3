/**
 * File : Personnage.java
 * Code source de la classe Personnage
 * 
 * @author Alexandre Coulais, Noëmie Suere, Perrine Mortier
 * @version 2021-4-9
 */
package protagonistes;

import environnement.Porte;
import environnement.Tresor;
import equipement.Potion;

public class Personnage extends EtreVivant {
    private String mName;

    public Personnage(String tName) {
        super(10);
        this.mName = tName;
    }

    public String getName() {
        return this.mName;
    }

    String obtenirTresor(Tresor tTresor) {
        String texte = "";
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
        return texte;
    }

    public String mourir() {
        String texte = "";

        texte += this.quitteCombat();
        texte += "Hélas, le monstre vous a terrassé ...\n";

        return texte;
    }
}