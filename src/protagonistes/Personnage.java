package protagonistes;

import environnement.Porte;
import environnement.Tresor;
import equipement.Potion;

public class Personnage extends EtreVivant {
    private String mName;

    public Personnage(String tName) {
        super(10);
        this.mName = tName;
    }

    public String getName() {
        return this.mName;
    }

    String obtenirTresor(Tresor tTresor) {
        String texte = "";
        return texte;
    }

    String boirePotion(Potion tPotion) {
        String texte = "";
        return texte;
    }

    String ouvrirPorte(Porte tPorte) {
        String texte = "";
        return texte;
    }
}