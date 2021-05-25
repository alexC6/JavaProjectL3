package environnement;

/**
 * 
 * @author Noëmie Suere
 * @version 2021-05-25
 */
public enum TypeObjetVendu {
    POTION("potion"),
    ARME("arme"),
    ARMURE("armure");

    private String mNom;

    TypeObjetVendu(String tNom) {
        this.mNom =tNom;
    }

    public String toString() {
        return this.mNom;
    }
}