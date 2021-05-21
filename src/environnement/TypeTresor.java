package environnement;

public enum TypeTresor {
    ARME("une arme"),
    ARMURE("une armure"),
    PIECE_OR("des pièces d'or"),
    POTION("une potion");

    private String mNom;

    TypeTresor(String tNom) {
        this.mNom = tNom;
    }

    public String toString() {
        return this.mNom;
    }
}