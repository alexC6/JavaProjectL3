package equipement;

import protagonistes.Personnage;
public class Potion {
    private Personnage mProprietaire;
    private int mRecuperation;
    private int FORCE_POTION_MIN =1;
    private int FORCE_POTION_MAX =10;

    public String viderPotion(){
        
       int tPointsDeVie  =(int) (Math.random() * ( FORCE_POTION_MAX - FORCE_POTION_MIN ));
       String texte= "Votre personnage a récupérer"+tPointsDeVie;
        return texte;
    }
    
    
}