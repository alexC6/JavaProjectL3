package environnement;

import java.io.Serializable;

/**
 * <p> File : Tresor.java
 * <br>Code source de la classe Tresor </p>
 * 
 * @author Alexandre Coulais
 * @version 2021-4-13
 */

public class Tresor<T> implements Serializable {
    private T mContenu;
    private TypeTresor mType;

    public Tresor(T tContenu, TypeTresor tType, Piece tPiece) {
        this.mContenu = tContenu;
        this.mType = tType;
    }

    public T getContenu() {
        return this.mContenu;
    }

    public TypeTresor getType() {
        return this.mType;
    }

    public void viderTresor() {
        this.mContenu = null;
        this.mType = null;
    }

    public String afficherContenu() {
        String texte = "";

        texte += "Ce coffre contient " + this.mType + ".\n";

        return texte;
    }
}