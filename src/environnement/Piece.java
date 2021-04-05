package environnement;

import java.util.List;

import controleur.Combat;
import controleur.Orientation;
import protagonistes.Monstre;

public class Piece {
    private int mNbPortes, mLigne, mColonne;
    private List<Orientation> mPortes;
    private Monstre mMonstre;
    private Tresor mTresor;
    private Combat mCombat;

    private final int NB_MAX_PORTES, NB_MIN_PORTES;

    public Piece() {}

    public int getNbPortes() {
        return this.mNbPortes;
    }

    public List<Orientation> getPortes() {
        return this.mPortes;
    }

    public String genererMonstre() {
        String texte = "";
        return texte;
    }

    public String genererTresor() {
        String texte = "";
        return texte;
    }

    public String supprimerTresor() {
        String texte = "";
        return texte;
    }
}