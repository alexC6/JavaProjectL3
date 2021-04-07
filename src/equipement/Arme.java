package equipement;
import protagonistes.Monstre;
import protagonistes.Personnage;

public class Arme {
	private int mPointDommage; 
    private int DOMMAGES_MIN =1;
    private int DOMMAGES_MAX =5;
    private Personnage mProprietaire;

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
       int degat = (int) (Math.random() * ( DOMMAGES_MAX - DOMMAGES_MIN ));
        tMonstre.subirAttaque(degat);
        String texte="Le monstre subit" + degat;
        return texte;
        
    }

}