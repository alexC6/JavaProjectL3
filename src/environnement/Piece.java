package environnement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p> File : Piece.java
 * <br>Code source de la classe Piece </p>
 * 
 * @author Alexandre Coulais
 * @version 2021-5-14
 */

public abstract class Piece implements Serializable {
    /**
     * Indique le nombre de portes disponibles dans la salle
     * 
     * @see Piece#getNbPortes()
     */
    private int mNbPortes;

    /**
     * Numero de ligne et de colonne dans le damier de la piece
     * 
     * @see Piece#getLigne()
     * @see Piece#getColonne()
     */
    private int mLigne, mColonne;

    /**
     * Liste des portes disponibles dans la salle
     * 
     * @see Piece#getPortes()
     */
    private List<Porte> mPortes = new ArrayList<Porte>();

    /**
     * Le labyrinthe auquel appartient la piece
     * 
     * @see Piece#getLabyrinthe()
     */
    protected Labyrinthe mLabyrinthe;

    /**
     * <p>Constructeur d'une pièce
     * <br>La génération de la liste des portes est laissée à la classe labyrinthe,
     * puisqu'elle peut plus facilement contrôler les portes alentours</p>
     * 
     * @see Labyrinthe#genererPiece()
     * 
     * @param tPortes       La liste des portes possibles
     * @param tLigne        Le numéro de la ligne de la pièce générée
     * @param tColonne      Le numéro de la colonne de la pièce générée
     * @param tLabyrinthe   Le labyrinthe qui contient la pièce
     */
    public Piece(List<Porte> tPortes, int tLigne, int tColonne, Labyrinthe tLabyrinthe) {
        this.mNbPortes = tPortes.size();
        this.mLigne = tLigne;
        this.mColonne = tColonne;
        this.mPortes = tPortes;
        this.mLabyrinthe = tLabyrinthe;
    }

    /**
     * Getter du nombre de portes
     * 
     * @return int  Nombre de portes de la pièce
     */
    public int getNbPortes() {
        return this.mNbPortes;
    }

    /**
     * Getter sur la liste des portes disponibles
     * 
     * @return List<Porte>  Liste des portes disponibles
     */
    public List<Porte> getPortes() {
        return this.mPortes;
    }

    /**
     * Getter des orientations de portes disponibles sous forme de lettres
     * 
     * @return Liste de caractères des orientations
     */
    public List<String> getOrientation() {
        List<String> listOrientation = new ArrayList<String>();

        for (Porte porte : mPortes) {
            switch (porte.getOrientationPorte()) {
                case NORD:
                    listOrientation.add("N");
                    break;
                case SUD:
                    listOrientation.add("S");
                    break;
                case EST:
                    listOrientation.add("E");
                    break;
                case OUEST:
                    listOrientation.add("O");
                    break;
            }
        }

        return listOrientation;
    }

    /**
     * Getter du numéro de ligne de la pièce
     * 
     * @return int  Numéro de ligne
     */
    public int getLigne() {
        return this.mLigne;
    }

    /**
     * Getter du numéro de colonne de la pièce
     * 
     * @return int  Numéro de colonne
     */
    public int getColonne() {
        return this.mColonne;
    }

    /**
     * Getter du labyrinthe de la pièce
     * 
     * @return Labyrinthe   Le labyrinthe de la pièce
     */
    public Labyrinthe getLabyrinthe() {
        return this.mLabyrinthe;
    }
}