package equipement;

import protagonistes.Personnage;
public class Potion { 

    private Personnage mProprietaire;
    private int mRecuperation;
    private int FORCE_POTION_MIN =1;
    private int FORCE_POTION_MAX =10;

    public Potion(Personnage mProprietaire) {
        this.mProprietaire = mProprietaire;
        //calcul du nombre de point de vie récuperés (entre 1 et 10)
        this.mRecuperation =(int) (Math.random() * ( FORCE_POTION_MAX - FORCE_POTION_MIN ));
    }

    
    public void viderPotion(){
        this.mProprietaire = null;
    }


    public int getRecuperation() {
        return mRecuperation;
    }

}