/**
 * File : EtreVivant.java
 * Code source de la classe EtreVivant
 * 
 * @author Alexandre Coulais
 * @version 2021-4-6
 */
package protagonistes;

import controleur.Combat;

public abstract class EtreVivant {
    private int mPointsDeVie;
    private TypeEtreVivant mType;

    protected Combat mCombat;

    protected EtreVivant(int tPointsDeVie) {
        this.mPointsDeVie = tPointsDeVie;
        this.mCombat = null;
        
        if (this instanceof Personnage) {
            this.mType = TypeEtreVivant.PERSONNAGE;
        } else {
            this.mType = TypeEtreVivant.MONSTRE;
        }
    }

    public int getPointDeVie() {
        return this.mPointsDeVie;
    }

    public boolean isVivant() {
        return this.mPointsDeVie > 0;
    }

    public abstract String mourir();

    public String subirAttaque(int tDegats) {
        String texte = "";

        texte += "Le " + this.mType + "subit une violente attaque, ";

        if (tDegats >= 0) {
            this.mPointsDeVie -= tDegats;
        }
        
        if (this.mPointsDeVie > 0) {
            texte += "mais parvient à se relever.\n";
        } else {
            texte += "il n'y survit pas.\n";
            texte += this.mourir();
        }

        return texte;
    }

    public String recupererVie(int tPointsDeVie) {
        String texte = "";

        if (tPointsDeVie > 0) {
            this.mPointsDeVie = tPointsDeVie;
            texte += "Le " + this.mType + " récupère " + tPointsDeVie + " points de vie.\n";
        }

        return texte;
    }

    public String rejointCombat(Combat tCombat) {
        this.mCombat = tCombat;

        return "Vous vous lancez dans un combat contre le monstre !\n";
    }

    public String quitteCombat() {
        this.mCombat = null;

        return "Le " + this.mType + " quitte le combat.\n";
    }
}