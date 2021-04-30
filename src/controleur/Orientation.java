package controleur;

/**
@author Perrine Mortier
@version 01/04/29
 * énumération des 4 points cardinaux accessibles également en type String
 */
public enum Orientation {

    NORD ("NORD"),
    SUD ("SUD"),
    EST("EST"),
    OUEST("OUEST");

    private String mNomOrientation;

    Orientation(String tNomOrientation){

        this.mNomOrientation = tNomOrientation;
    }

    public String toString(){

        return this.mNomOrientation;
    }


}// FIN CLASS ENUM ORIENTATION