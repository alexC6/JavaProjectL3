package environnement;

import java.util.List;
import java.util.Random;

import controleur.Combat;
import equipement.Arme;
import equipement.Armure;
import equipement.Potion;
import protagonistes.Monstre;
import protagonistes.Personnage;

/**
 * <p> File : PieceCombat.java
 * <br>Code source de la classe PieceCombat héritée de Piece</p>
 * 
 * @author Alexandre Coulais
 * @version 2021-5-14
 */

public class PieceCombat extends Piece {
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
     * @see PieceCombat#genererTresor(int...)
     * @see PieceCombat#recupererTresor()
     */
    private Tresor<Arme> mTresorArme;
    private Tresor<Armure> mTresorArmure;
    private Tresor<Integer> mTresorOr;
    private Tresor<Potion> mTresorPotion;

    /**
     * Le combat de la salle associant le monstre de la salle et le personnage
     */
    private Combat mCombat;

    public PieceCombat(List<Porte> tPortes, int tLigne, int tColonne, Labyrinthe tLabyrinthe) {
        super(tPortes, tLigne, tColonne, tLabyrinthe);

        Random rand = new Random();
        int tresorType = rand.nextInt(4);

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
                break;
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

    public Combat getCombat() {
        return this.mCombat;
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
                break;
            case POTION:
                texte += personnage.obtenirTresor(this.mTresorPotion);
                this.mTresorPotion = null;
        }

        return texte;
    }
}