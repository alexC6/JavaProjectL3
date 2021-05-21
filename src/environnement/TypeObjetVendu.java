package environnement;

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