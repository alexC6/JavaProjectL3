package equipement;
import protagonistes.Personnage;
public class Armure {
    private int mProtection;
    private int PROTECT_MIN=1;
    private int PROTECT_MAX=5;
    private Personnage mProprietaire;

    public Armure(Personnage mProprietaire) {
        this.mProprietaire = mProprietaire;
          //calcul du nombre de point d'armure (entre 1 et 5)
          this.mProtection =(int) (Math.random() * ( PROTECT_MAX - PROTECT_MIN ));
    }

    public Personnage getmProprietaire() {
        return mProprietaire;
    }

    public void setmProprietaire(Personnage mProprietaire) {
        this.mProprietaire = mProprietaire;
    }
   
    public String encaisserDegat(){



    }

    public String casser(){
        

        
    }

    public String reparer(){


        
    }



}