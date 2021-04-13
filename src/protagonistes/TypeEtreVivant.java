package protagonistes;

/**
 * <p>File : TypeEtreVivant.java
 * <br>Code source de l'énumération TypeEtreVivant</p>
 * 
 * @author Alexandre Coulais
 * @version 2021-04-13
 */

public enum TypeEtreVivant {
    MONSTRE("monstre"),
    PERSONNAGE("personnage");

    private String mString;

    /**
     * <p>Constructeur de l'énumération</p>
     * 
     * @param tString Chaîne associée à un élément de l'énumération
     */
    TypeEtreVivant(String tString) {
        this.mString = tString;
    }

    /**
     * <p>Permet d'obtenir la chaîne associée à un élément de l'énumération</p>
     * 
     * @return String   La chaîne d'un élément
     */
    public String toString() {
        return this.mString;
    }
}
