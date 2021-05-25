package environnement;
/**
 * 
 * @author Noëmie Suere
 * @version 2021-05-25
 */
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