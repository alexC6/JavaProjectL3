package environnement;

<<<<<<< HEAD
import test.test;
import environnement.Piece;
public class Tresor<T> {
    private T mType;
    private TypeTresor mContenue;
    private Piece mPiece;
    

=======
import java.util.Random;

/**
 * <p> File : Tresor.java
 * <br>Code source de la classe Tresor </p>
 * 
 * @author Alexandre Coulais
 * @version 2021-4-13
 */

public class Tresor<T> {
    private T mContenu;
    private TypeTresor mType;
    private Piece mPiece;

    public Tresor(T tContenu, TypeTresor tType, Piece tPiece) {
        this.mContenu = tContenu;
        this.mType = tType;
        this.mPiece = tPiece;
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
>>>>>>> fc6ce33665d6d22cf9c64780481dc56e5992ad28
}