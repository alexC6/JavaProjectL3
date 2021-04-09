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

    public String attaquer() {
        String texte = "";
        Personnage victime = this.mCombat.getPersonnage();

        if (victime != null) {
            texte += "Vous êtes attaqué par le monstre !\n";
            texte += victime.subirAttaque(1);
        } else {
            texte += "Oups ! Vous êtes mort, le monstre ne peut pas vous attaquer.\n";
        }

        return texte;
    }

    public String mourir() {
        String texte = "";
        
        texte += this.quitteCombat();
        texte += "Bravo, vous avez terrassé le terrible monstre !\n";

        return texte;
    }
}