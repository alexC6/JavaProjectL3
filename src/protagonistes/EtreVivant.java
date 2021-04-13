package protagonistes;

import controleur.Combat;

/**
 * <p> File : EtreVivant.java
 * <br>Code source de la classe EtreVivant
 * <br>La classe EtreVivant n'ayant pas à être instanciée, nous avons décidé de la qualifier abstraite
 * <br>Cela nous permet de plus de pouvoir mettre la méthode mourir() en abstraite </p>
 * 
 * @author Alexandre Coulais
 * @version 2021-4-13
 */

public abstract class EtreVivant {
    private int mPointsDeVie;
    private TypeEtreVivant mType;

    protected Combat mCombat;

    /**
     * <p>Constructeur de la classe EtreVivant</p>
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
     * <p>Getter du nombre de points de vie d'un EtreVivant</p>
     * 
     * @return int  Le nombre de points de vie restants à l'EtreVivant
     */
    public int getPointDeVie() {
        return this.mPointsDeVie;
    }

    /**
     * <p>Getter du type d'EtreVivant</p>
     * 
     * @return TypeEtreVivant   Le type de l'EtreVivant
     */
    public TypeEtreVivant getType() {
        return this.mType;
    }

    /**
     * <p>Permet de savoir si un EtreVivant est en vie ou non</p>
     * 
     * @return boolean  Vrai si l'EtreVivant a encore des points de vie, faux sinon
     */
    public boolean isVivant() {
        return this.mPointsDeVie > 0;
    }

    /**
     * <p>Méthode abstraite implémentée dans les classe Personnage et Monstre</p>
     * 
     * @see Personnage#mourir()
     * @see Monstre#mourir()
     */
    public abstract String mourir();

    /**
     * <p> Permet à un EtreVivant de subir une attaque
     * <br>Le nombre de dégâts est passé en paramètre </p>
     * 
     * @see Personnage#subirAttaque(int)
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
     * <p>Fonction de récupération de points de vie pour un EtreVivant</p>
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
     * <p>Fonction permettant de joindre un combat à un EtreVivant</p>
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
     * <p>Permet à un EtreVivant de quitter un combat</p>
     * 
     * @return Le texte à afficher
     */
    public String quitteCombat() {
        this.mCombat = null;

        return "Le " + this.mType + " quitte le combat.\n";
    }
}