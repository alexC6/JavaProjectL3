package environnement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import controleur.Combat;
import equipement.Arme;
import equipement.Armure;
import protagonistes.Monstre;
import protagonistes.Personnage;

/**
 * <p> File : Piece.java
 * <br>Code source de la classe Piece </p>
 * 
 * @author Alexandre Coulais
 * @version 2021-4-16
 */

public class Piece {
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
    private Labyrinthe mLabyrinthe;

    /**
     * Le monstre de la salle
     */
    private Monstre mMonstre;

    /**
     * Le type du contenu du trésor de la salle
     */
    private TypeTresor mTypeTresor;

    /**
     * <p>Les différents trésors possibles.
     * <br>Afin d'éviter les types sans paramètre de généricité, il a été décidé
     * de créer un membre par contenu possible, et d'effectuer des switch sur les
     * TypeTresor pour connaitre les actions a effectuer.</p>
     * 
     * @see Piece#genererTresor(int...)
     * @see Piece#recupererTresor()
     */
    private Tresor<Arme> mTresorArme;
    private Tresor<Armure> mTresorArmure;
    private Tresor<Integer> mTresorOr;
    private Tresor<Potion> mTresorPotion;

    /**
     * Le combat de la salle associant le monstre de la salle et le personnage
     */
    private Combat mCombat;

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
        Random rand = new Random();
        int tresorType = rand.nextInt(4);
        
        this.mNbPortes = tPortes.size();
        this.mLigne = tLigne;
        this.mColonne = tColonne;
        this.mPortes = tPortes;
        this.mLabyrinthe = tLabyrinthe;
        this.mMonstre = new Monstre();
        this.mCombat = new Combat(mLabyrinthe.getPersonnage(), this.mMonstre);
        this.mTresorArme = null;
        this.mTresorArmure = null;
        this.mTresorOr = null;
        this.mTresorPotion = null;

        switch (tresorType) {
            case 0:
                this.mTypeTresor = TypeTresor.ARME;
                genererTresor();
                break;
            case 1:
                this.mTypeTresor = TypeTresor.ARMURE;
                genererTresor();
                break;
            case 2:
                int piecesOr = rand.nextInt(151) + 50;
                this.mTypeTresor = TypeTresor.PIECE_OR;
                genererTresor(piecesOr);
            case 3:
                this.mTypeTresor = TypeTresor.POTION;
                genererTresor();
        }
    }

    /**
     * Fonction de génération d'un trésor dont le contenu dépend du type fixé précédemment
     * 
     * @param tPieces Paramètre optionnel dans le cas d'un trésor contenant des pièces d'or
     */
    private void genererTresor(final int... tPieces) {
        switch (this.mTypeTresor) {
            case ARME:
                this.mTresorArme = new Tresor<Arme>(new Arme(), this.mTypeTresor, this);
                break;
            case ARMURE:
                this.mTresorArmure = new Tresor<Armure>(new Armure(), this.mTypeTresor, this);
                break;
            case PIECE_OR:
                this.mTresorOr = new Tresor<Integer>(tPieces[0], this.mTypeTresor, this);
                break;
            case POTION:
                this.mTresorPotion = new Tresor<Potion>(new Potion(), this.mTypeTresor, this);
        }
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
     * Getter du labyrinthe de la pièce
     * 
     * @return Labyrinthe   Le labyrinthe de la pièce
     */
    public Labyrinthe getLabyrinthe() {
        return this.mLabyrinthe;
    }

    /**
     * <p>Fonction de récupération du trésor de la pièce
     * <br>En fonction du type du contenu du trésor, on passe en paramètre
     * de la fonction obtenirTresor() le bon trésor</p>
     * 
     * @see Personnage#obtenirTresor(Tresor)
     * 
     * @return String   Le texte à afficher
     */
    public String recupererTresor() {
        String texte = "";
        Personnage personnage = this.mLabyrinthe.getPersonnage();

        switch (this.mTypeTresor) {
            case ARME:
                texte += personnage.obtenirTresor(this.mTresorArme);
                this.mTresorArme = null;
                break;
            case ARMURE:
                texte += personnage.obtenirTresor(this.mTresorArmure);
                this.mTresorArmure = null;
                break;
            case PIECE_OR:
                texte += personnage.obtenirTresor(this.mTresorOr);
                this.mTresorOr = null;
        }

        return texte;
    }
}