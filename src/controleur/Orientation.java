package controleur;

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