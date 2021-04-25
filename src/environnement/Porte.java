package environnement;

import controleur.Orientation;

public class Porte {

    private Orientation mOrientationP;

    public Porte ( Orientation tOrientationP){
        this.mOrientationP = tOrientationP;   
    }

    //@Role : retourne une chaine de caractères sous la forme " La porte + ORIENTATION" 
    public String afficherPorte(){
        String texte ="";
        texte += "La porte " + this.mOrientationP + " " ;
        return texte;
    }

    public Orientation getOrientationPorte(){
        return this.mOrientationP;
    }

    public String toString(){
        String txt = "";
        txt += this.mOrientationP;
        return txt;
    }

}