package environnement;

import java.io.Serializable;

import controleur.Orientation;

public class Porte implements Serializable {

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

    public String toSelect() {
        switch (this.mOrientationP) {
            case NORD:
                return "N pour Nord";
            case SUD:
                return "S pour Sud";
            case OUEST:
                return "O pour Ouest";
            case EST:
                return "E pour Est";
            default:
                return "orientation inconnue";
        }
    }
}