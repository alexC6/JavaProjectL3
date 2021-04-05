package environnement;

import controleur.Orientation;

public class Porte {

    private Orientation mOrientationP;

    public Porte ( Orientation tOrientationP){
        this.mOrientationP = tOrientationP;   
    }

    public String afficherPorte(){
        String texte ="";
        texte += "La porte " + this.mOrientationP + " " ;
        return texte;
    }

}