package equipement;
import protagonistes.Personnage;
public class Armure {
    private int mProtection;
    private int PROTECT_MIN=1;
    private int PROTECT_MAX=5;
    private Personnage mProprietaire;
    private int mEtatInitial;

   
    public Armure() {
           //calcul du nombre de point d'armure (entre 1 et 5)
          this.mProtection =(int) (Math.random() * ( PROTECT_MAX - PROTECT_MIN ));
          this.mEtatInitial = this.mProtection;
    }

    public Armure(Personnage tProprietaire, final int ... args) {
        this.mProprietaire = tProprietaire;
        if(args.length>0){
           mProtection =args[0];
           this.mEtatInitial = mProtection;
        }else{
            this.mProtection =(int) (Math.random() * ( PROTECT_MAX - PROTECT_MIN ));
            this.mEtatInitial = this.mProtection;

        }
    }
     

    public int getEtatInitial(){

        return this.mEtatInitial;

    }



    public Personnage getProprietaire() {
        return mProprietaire;
    }

    public void setProprietaire(Personnage tProprietaire) {
        if(/*Si le personnage est deja proprietaire d'une arme alors: ne rien faire */){
       
        }else{
        this.mProprietaire = tProprietaire;
        }
    }
   
    public String encaisserDegat(int tDegat){

        String texte1="Votre armure est cassé";
        String texte2="Votre armure a subit"+tDegat;

       if(tDegat<this.mProtection){
        this.mProtection= this.mProtection-tDegat;
        return texte2;
       }else if(tDegat>this.mProtection){

        this.casser();
        return texte1;
       }
       return null;
    }

    public void casser(){
        this.mProtection = 0;
    }

    public String reparer(){
        String texte="";

        if(this.mProtection< this.mEtatInitial){
            this.mProtection = this.mEtatInitial;
            texte=" Votre armure est réparée.";
        }else if (this.mProtection == this.mEtatInitial ) {
            texte="Vous n'avez besoin de réparer votre armure";
        }       
        return texte;
    }
}