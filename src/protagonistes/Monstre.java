/**
 * File : Monstr.java
 * Code source de la classe Monstre
 * 
 * @author Alexandre Coulais
 * @version 2021-4-9
 */
package protagonistes;

public class Monstre extends EtreVivant {
    public Monstre() {
        super(5);
    }

    public String attaquer(Personnage tPersonnage) {
        String texte = "";

        texte += "Vous êtes attaqué par le monstre !\n";
        texte += tPersonnage.subirAttaque(1);

        return texte;
    }

    public String mourir() {
        return "Bravo, vous avez terrassé le terrible monstre !\n";
    }
}