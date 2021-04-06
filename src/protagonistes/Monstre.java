package protagonistes;

public class Monstre extends EtreVivant {
    public Monstre() {
        super(5);
    }

    public String attaquer(Personnage tPersonnage) {
        String texte = "";
        return texte;
    }

    public String mourir() {
        return "Bravo, vous avez terrassé le terrible monstre !\n";
    }
}