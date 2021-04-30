package environnement;

import controleur.Orientation;

/**
 * @author Perrine Mortier
 * @version 2021/04/29
 */

public class Porte {

    private Orientation mOrientationP;

    /**
     * Constructeur Porte 
     * @param tOrientationP correspondant à un point cardinal 
     */
    public Porte ( Orientation tOrientationP){
        this.mOrientationP = tOrientationP;
    }

    /**
     * @return retourne une chaine de caractères sous la forme " La porte + ORIENTATION"
    */ 
    public String afficherPorte(){
        String texte ="";
        texte += "La porte " + this.mOrientationP + " " ;
        return texte;
    }

    /**
     * Getter sur l'orientation de la porte 
     * @return l'orientation d'une porte 
     */
    public Orientation getOrientationPorte(){
        return this.mOrientationP;
    }

    /**
     * @return sous forme de type String l'orientation de la porte correspondant à un point cardinal
     */   
    public String toString(){
        String txt = "";
        txt += this.mOrientationP;
        return txt;
    }
}