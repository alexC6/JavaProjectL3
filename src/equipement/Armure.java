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

    public Personnage getProprietaire() {
        return mProprietaire;
    }

    public void setProprietaire(Personnage mProprietaire) {
        this.mProprietaire = mProprietaire;
    }
   //voir pourquoi ici encaissser, pourquoi pas dans personnage
    public String encaisserDegat(int degat){
        
       if(degat<this.mProtection){
        
       }else if(degat>this.mProtection){
        this.casser();
       }

    }

    public String casser(){
        
        this.mProprietaire = null;
        return "armure casser";
    }
/*je sais pas encore comment m'y prendre
    public String reparer(){


        
    }
*/


}