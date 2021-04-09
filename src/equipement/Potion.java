package equipement;

import protagonistes.Personnage;
public class Potion { 

    private Personnage mProprietaire;
    private int mRecuperation;
    private int FORCE_POTION_MIN =1;
    private int FORCE_POTION_MAX =10;

    public Potion(Personnage mProprietaire) {
        this.mProprietaire = mProprietaire;
        //calcul du nombre de point de vie récuperés
        this.mRecuperation =(int) (Math.random() * ( FORCE_POTION_MAX - FORCE_POTION_MIN ));
    }


    public void lacher() {
        this.mProprietaire = null;
    }
  
    public String viderPotion(){
        this.mProprietaire.boirePotion(this);
        //recuperation des points de vie
        this.mProprietaire.recupererVie(this.mRecuperation);
        String texte= "Votre personnage a récupérer"+this.mRecuperation;
       //permet de retirer la potion apres utilisation
        this.lacher();
        return texte;
    }

   
    
    
}