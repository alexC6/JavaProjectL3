package environnement;

import java.io.Serializable;

import controleur.Orientation;

/**
 * <p>
 * File : Porte.java Code source de la classe de gestion des portes des salles
 * </p>
 * 
 * @author Perrine Mortier
 * @version 2021-5-28
 */

public class Porte implements Serializable {
    /**
     * L'orientation de la porte
     */
    private Orientation mOrientationP;

    /**
     * Constructeur de la porte
     * 
     * @param tOrientationP Son orientation
     */
    public Porte(Orientation tOrientationP) {
        this.mOrientationP = tOrientationP;
    }

    /**
     * Getter sur l'orientation de la porte
     * 
     * @return Son orientation
     */
    public Orientation getOrientationPorte() {
        return this.mOrientationP;
    }

    /**
     * Retourne une string qui contient la lettre à saisir pour indiquer
     * l'orientation de porte que l'on souhaite emprunter
     * 
     * @see BoundaryDeplacer#deplacer()
     * 
     * @return String à afficher
     */
    public String toSelect() {
        switch (this.mOrientationP) {
            case NORD:
                return "N pour Nord";
            case SUD:
                return "S pour Sud";
            case OUEST:
                return "O pour Ouest";
            case EST:
                return "E pour Est";
            default:
                return "orientation inconnue";
        }
    }
}