package equipement;
import protagonistes.Monstre;
import protagonistes.Personnage;

public class Arme {
	private int mPointDommage; 
    private int DOMMAGES_MIN =1;
    private int DOMMAGES_MAX =5;
    private Personnage mProprietaire;

    public Arme(Personnage mProprietaire) {
        this.mProprietaire = mProprietaire; 
        //calcul du nombre de point de dommage (entre 1 et 5)
        this.mPointDommage = (int) (Math.random() * ( DOMMAGES_MAX - DOMMAGES_MIN ));
    }

    public Personnage getmProprietaire() {
        return mProprietaire;
    }

    public void setmProprietaire(Personnage mProprietaire) {
        this.mProprietaire = mProprietaire;
    }

    public void lacher () {
        this.mProprietaire = null;
    }

    public String attaquer(Monstre tMonstre)
    { 
        return tMonstre.subirAttaque(this.mPointDommage);
    }

    
}