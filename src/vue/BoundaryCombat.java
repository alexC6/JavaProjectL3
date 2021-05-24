package vue;

import controleur.ControleurCombat;

import java.util.Random;

/**
 * File : BoundaryCombat.java
 * Code source de entrées sorties du Combat
 * 
 * @author Thomas Chabert, Alexandre Coulais, Noëmie Suere, Perrine Mortier
 * @version 2021-5-7
 */

public class BoundaryCombat {
    
    /**
     * Le controleur qui manipule et accède à l'objet Combat
     *
     * @see ControleurCombat
     */
    private ControleurCombat mCrtl;
    
    /**
     * Constructeur de boundary
     * 
     * @param tCtrl   Le controleur de combat
     */
    public BoundaryCombat(ControleurCombat tCtrl) {
        this.mCrtl = tCtrl;
    }

    /**
     * Méthode qui introduit un combat
     */
    public void scenar() { 
        Random rand = new Random();
        int randNumber = rand.nextInt(1);

        switch (randNumber) {
            case 0 : System.out.println("Vous vous sentez observé dans cette pièce étroite quand, soudain : ");
            System.out.println(ConsoleColors.YELLOW_BOLD + "Un monstre surgit des ténèbres !" + ConsoleColors.RESET);

            break;
            case 1 : System.out.println("Votre torche éclaire une créature diforme et affamée");
            System.out.println("Le monstre veut votre peau !");
            break;      
        } 
    }

    /**
     * Méthode qui propose de combattre ou de fuir
     * 
     */
    public boolean choixCombatreFuir () {
        boolean r = Clavier.demanderChoix("Combattre ou fuir ? (C/F)", "C", "F");
        if(r == false) {
            System.out.println("Vous avez choisi de fuir");
            return r;
        }
        else {
            return r;
        }
    }

    public void donnerSante() {
        int pv = this.mCrtl.donnerPVperso();

        if(pv <= 2) {
            System.out.println(ConsoleColors.RED + "Vous êtes dans un état critique et votre jambe vous fais souffrir." + ConsoleColors.RESET);
        }
    }

    public boolean checkVanic() {
        return this.mCrtl.checkVainc();
    }

    public void pieceVide() {
        System.out.println("La pièce est vide. Il n'y seul le corps sans vie du monstre et le coffre vide.");
    }

    // A finir
    public void demarrerCombat() {
        System.out.println("Vous avez décidé de combattre !");
    }

    public void lancerTour() {
        this.donnerSante();
        System.out.println(this.mCrtl.lancerTour());
    }


}
