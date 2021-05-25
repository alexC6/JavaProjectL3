package environnement;

import java.io.Serializable;

/**
 * <p>
 * File : Tresor.java <br>
 * Code source de la classe générique Tresor
 * </p>
 * 
 * @author Alexandre Coulais
 * @version 2021-5-25
 */

public class Tresor<T> implements Serializable {
    /**
     * L'objet contenu dans le trésor
     * 
     * @see Tresor#getContenu()
     */
    private T mContenu;

    /**
     * Le type de contenu du trésor (Arme, Armure, Potion)
     * 
     * @see Tresor#afficherContenu()
     * @see Tresor#getType()
     */
    private TypeTresor mType;

    /**
     * Constructeur des trésors
     * 
     * @param tContenu Le contenu du trésor
     * @param tType    Le type de contenu
     * @param tPiece   La pièce où il se trouve
     */
    public Tresor(T tContenu, TypeTresor tType, Piece tPiece) {
        this.mContenu = tContenu;
        this.mType = tType;
    }

    /**
     * Getter du contenu du trésor
     * 
     * @return La référence sur l'objet contenu dans le trésor
     */
    public T getContenu() {
        return this.mContenu;
    }

    /**
     * Getter sur le type du contenu du trésor
     * 
     * @return Le type de l'objet contenu
     */
    public TypeTresor getType() {
        return this.mType;
    }

    /**
     * Affecte null à toutes les variables membres pour indiquer que le trésor est
     * vide
     */
    public void viderTresor() {
        this.mContenu = null;
        this.mType = null;
    }

    /**
     * Retourne la string indiquant le contenu du coffre
     * 
     * @return La chaine indiquant le contenu
     */
    public String afficherContenu() {
        String texte = "";

        texte += "Ce coffre contient " + this.mType + ".\n";

        return texte;
    }
}