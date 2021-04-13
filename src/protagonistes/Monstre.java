package protagonistes;

/**
 * <p>File : Monstre.java
 * <br>Code source de la classe Monstre</p>
 * 
 * @author Alexandre Coulais
 * @version 2021-4-13
 */

public class Monstre extends EtreVivant {
    /**
     * <p>Constructeur de la classe Monstre</p>
     */
    public Monstre() {
        super(5);
    }

    /**
     * <p>Fonction permettant au monstre d'attaquer un personnage</p>
     * 
     * @return String   Le texte à afficher
     */
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

    /**
     * <p>Définition de la méthode abstraite mourir() d'EtreVivant
     * <br>Permet à un monstre mort de quitter le combat</p>
     * 
     * @see EtreVivant#mourir()
     * 
     * @return String   Le texte à afficher
     */
    @Override
    public String mourir() {
        String texte = "";
        
        texte += this.quitteCombat();
        texte += "Bravo, vous avez terrassé le terrible monstre !\n";

        return texte;
    }
}