package controleur;

public enum Orientation {

    NORD ("NORD"),
    SUD ("SUD"),
    EST("EST"),
    OUEST("OUEST");

    private String nomOrientation;

    Orientation(String nomOrientation){

        this.nomOrientation = nomOrientation;
    }

    public String toString(){
        
        return nomOrientation;
    }

    
}// FIN CLASS ENUM ORIENTATION