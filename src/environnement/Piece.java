package environnement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import controleur.Combat;
import controleur.Orientation;
import equipement.Arme;
import equipement.Armure;
import protagonistes.Monstre;

public class Piece {
    private int mNbPortes, mLigne, mColonne;
    private List<Orientation> mPortes = new ArrayList<Orientation>();
    private Labyrinthe mLabyrinthe;
    private Monstre mMonstre;
    private Tresor mTresor;
    private Combat mCombat;

    private final int NB_MAX_PORTES = 1, NB_MIN_PORTES = 4;

    public Piece(List<Orientation> tPortes, int tLigne, int tColonne, Labyrinthe tLabyrinthe) {
        Random rand = new Random();
        int tresorType = rand.nextInt(3);
        
        this.mNbPortes = tPortes.size();
        this.mLigne = tLigne;
        this.mColonne = tColonne;
        this.mPortes = tPortes;
        this.mLabyrinthe = tLabyrinthe;
        this.mMonstre = new Monstre();
        this.mCombat = new Combat(mLabyrinthe.getPersonnage(), this.mMonstre);

        switch (tresorType) {
            case 0:
                this.mTresor = new Tresor<Arme>(new Arme(), TypeTresor.ARME, this);
                break;
            case 1:
                this.mTresor = new Tresor<Armure>(new Armure(), TypeTresor.ARMURE, this);
                break;
            case 2:
                int piecesOr = rand.nextInt(100) + 1;
                this.mTresor = new Tresor<Integer>(piecesOr, TypeTresor.PIECE_OR, this);
        }
    }

    public int getNbPortes() {
        return this.mNbPortes;
    }

    public List<Orientation> getPortes() {
        return this.mPortes;
    }

    public void supprimerTresor() {
        this.mTresor = null;
    }
}