package protagonistes;

import java.util.ArrayList;
import java.util.List;

import environnement.Labyrinthe;
import environnement.Tresor;
import equipement.Arme;
import equipement.Armure;
import equipement.Potion;

public class Personnage extends EtreVivant {
    private int mBourse;
    private Arme mArme;
    private Armure mArmure;
    private List<Potion> mPotions;
    private Labyrinthe mLabyrinthe;

    public Personnage(String tName) {
        super(tName, 10);
        this.mArme = null;
        this.mArmure = null;
        this.mPotions = new ArrayList<Potion>();
        this.mLabyrinthe = null;
    }

    public String obtenirTresor(Tresor tTresor) {
        String texte = "";

        switch (tTresor.getType()) {
            case ARME:
                this.prendreArme(tTresor.getContenu());
                break;
            case ARMURE:
                this.equiperArmure(tTresor.getContenu());
                break;
            case PIECE_OR:
                this.mBourse += tTresor.getContenu();
                break;
            default:
        }

        return texte;
    }
}