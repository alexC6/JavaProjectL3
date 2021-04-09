package protagonistes;

public enum TypeEtreVivant {
    MONSTRE("mosntre"),
    PERSONNAGE("personnage");

    private String mNom;

    TypeEtreVivant(String tNom) {
        this.mNom = tNom;
    }

    public String toString() {
        return this.mNom;
    }
}
