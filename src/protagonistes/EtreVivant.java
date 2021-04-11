package protagonistes;

import controleur.Combat;

/**
 * File : EtreVivant.java
 * Code source de la classe EtreVivant
 * La classe EtreVivant n'ayant pas à être instanciée, nous avons décidé de la qualifier abstraite
 * Cela nous permet de plus de pouvoir mettre la méthode mourir() en abstraite
 * 
 * @author Alexandre Coulais
 * @version 2021-4-11
 */

public abstract class EtreVivant {
    private int mPointsDeVie;
    private TypeEtreVivant mType;

    protected Combat mCombat;

    /**
     * Constructeur de la classe EtreVivant
     * 
     * @param tPointsDeVie  Le nombre de points de vie de l'EtreVivant
     */
    protected EtreVivant(int tPointsDeVie) {
        this.mPointsDeVie = tPointsDeVie;
        this.mCombat = null;
        
        if (this instanceof Personnage) {
            this.mType = TypeEtreVivant.PERSONNAGE;
        } else {
            this.mType = TypeEtreVivant.MONSTRE;
        }
    }

    /**
     * Getter du nombre de points de vie d'un EtreVivant
     * 
     * @return int  Le nombre de points de vie restants à l'EtreVivant
     */
    public int getPointDeVie() {
        return this.mPointsDeVie;
    }

    /**
     * Getter du type d'EtreVivant
     * 
     * @return TypeEtreVivant   Le type de l'EtreVivant
     */
    public TypeEtreVivant getType() {
        return this.mType;
    }

    /**
     * Permet de savoir si un EtreVivant est en vie ou non
     * 
     * @return boolean  Vrai si l'EtreVivant a encore des points de vie, faux sinon
     */
    public boolean isVivant() {
        return this.mPointsDeVie > 0;
    }

    /**
     * Méthode abstraite implémentée dans les classe Personnage et Monstre
     * 
     * @see Personnage#mourir()
     * @see Monstre#mourir()
     */
    public abstract String mourir();

    /**
     * Permet à un EtreVivant de subir une attaque
     * Le nombre de dégâts est passé en paramètre
     * 
     * @param tDegats Le nombre de dégâts de l'attaque
     * 
     * @return Le texte à afficher
     */
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

    /**
     * Fonction de récupération de points de vie pour un EtreVivant
     * 
     * @param tPointsDeVie Nombre de points de vie à récupérer
     * 
     * @return Le texte à afficher
     */
    public String recupererVie(int tPointsDeVie) {
        String texte = "";

        if (tPointsDeVie > 0) {
            this.mPointsDeVie = tPointsDeVie;
            texte += "Le " + this.mType + " récupère " + tPointsDeVie + " points de vie.\n";
        }

        return texte;
    }

    /**
     * Fonction permettant de joindre un combat à un EtreVivant
     * 
     * @param tCombat Le combat que doit rejoindre l'EtreVivant
     * 
     * @return Le texte à afficher
     */
    public String rejointCombat(Combat tCombat) {
        this.mCombat = tCombat;

        return "Vous vous lancez dans un combat contre le monstre !\n";
    }

    /**
     * Permet à un EtreVivant de quitter un combat
     * 
     * @return Le texte à afficher
     */
    public String quitteCombat() {
        this.mCombat = null;

        return "Le " + this.mType + " quitte le combat.\n";
    }
}