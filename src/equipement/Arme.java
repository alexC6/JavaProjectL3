package equipement;
import protagonistes.Monstre;
import protagonistes.Personnage;

public class Arme {
	private int mPointDommage; 
    private int DOMMAGES_MIN =1;
    private int DOMMAGES_MAX =5;
    private Personnage mProprietaire;

    public Arme(Personnage tProprietaire) {
        this.mProprietaire = tProprietaire; 
        //calcul du nombre de point de dommage (entre 1 et 5)
        this.mPointDommage = (int) (Math.random() * ( DOMMAGES_MAX - DOMMAGES_MIN ));
    }

    public Arme() {
        this.mProprietaire = null; 
        //calcul du nombre de point de dommage (entre 1 et 5)
        this.mPointDommage = (int) (Math.random() * ( DOMMAGES_MAX - DOMMAGES_MIN ));
    }

    public Personnage getProprietaire() {
        return mProprietaire;
    }

    public void setProprietaire(Personnage tProprietaire) {
        this.mProprietaire = tProprietaire;

    }

    public void lacher () {
        this.mProprietaire = null;
    }

    public String attaquer(Monstre tMonstre)
    { 
        return tMonstre.subirAttaque(this.mPointDommage);
    }

    
}