package equipement;

import protagonistes.Personnage;
public class Potion { 

    private Personnage mProprietaire;
    private int mRecuperation;
    private int FORCE_POTION_MIN =1;
    private int FORCE_POTION_MAX =10;

    public Potion() {
        this.mProprietaire = mProprietaire;
        //calcul du nombre de point de vie récuperés (entre 1 et 10)
        this.mRecuperation =(int) (Math.random() * ( FORCE_POTION_MAX - FORCE_POTION_MIN ));
    }

    public Potion(Personnage mProprietaire, final int ... args) {
        this.mProprietaire = mProprietaire;
        //calcul du nombre de point de vie récuperés (entre 1 et 10)
       
        if(args.length>0){
            mProtection=args[0];
         }else{
            this.mRecuperation =(int) (Math.random() * ( FORCE_POTION_MAX - FORCE_POTION_MIN ));
         }
    }
    
    public void viderPotion(){
        this.mProprietaire = null;
    }


    public int getRecuperation() {
        return mRecuperation;
    }

    public String afficherRecuperation(){
        text="";

        return texte;
        //TODO
    }

}