package vue;

import java.util.Random;

import controleur.ControleurCombat;
import protagonistes.Monstre;

/**
 * File : BoundaryCombat.java Code source de entrées sorties du Combat
 * 
 * @author Thomas Chabert, Alexandre Coulais, Noëmie Suere, Perrine Mortier
 * @version 2021-5-27
 */

public class BoundaryCombat {

    /**
     * Le controleur qui manipule et accède à l'objet Combat
     *
     * @see ControleurCombat
     */
    private ControleurCombat mCtrl;

    /**
     * Constructeur de boundary
     * 
     * @param tCtrl Le controleur de combat
     */
    public BoundaryCombat(ControleurCombat tCtrl) {
        this.mCtrl = tCtrl;
    }

    /**
     * Méthode qui introduit un combat
     */
    public void scenar() {
        Random rand = new Random();
        int randNumber = rand.nextInt(2);

        switch (randNumber) {
            case 0:
                System.out.println("Vous vous sentez observé dans cette pièce étroite quand, soudain : ");
                System.out
                        .println(ConsoleColors.YELLOW_BOLD + "Un monstre surgit des ténèbres !" + ConsoleColors.RESET);

                break;
            case 1:
                System.out.println("Votre torche éclaire une créature diforme et affamée");
                System.out.println("Le monstre veut votre peau !");
                break;
        }
    }

    /**
     * Méthode qui propose de combattre ou de fuir
     * 
     */
    public boolean choixCombatreFuir() {
        boolean r = Clavier.demanderChoix("Combattre ou fuir ? (C/F)", "C", "F");
        if (r == false) {
            System.out.println("Vous avez choisi de fuir");
            return r;
        } else {
            return r;
        }
    }

    public void donnerSante() {
        int pv = this.mCtrl.donnerPVperso();

        if (pv <= 2) {
            System.out.println(ConsoleColors.RED + "Vous êtes dans un état critique et votre jambe vous fais souffrir."
                    + ConsoleColors.RESET);
            System.out.println("Il vous reste " + pv + " points de vie.");
        }
    }

    public boolean checkVainc() {
        boolean isDead = this.mCtrl.checkVainc();

        if (isDead && this.mCtrl.getVainqueur() instanceof Monstre) {
            this.mort();
        }

        return isDead;
    }

    public void pieceVide() {
        System.out.println("La pièce est vide. Il n'y a que le corps sans vie du monstre et le coffre vide.");
    }

    // A finir
    public void demarrerCombat() {
        System.out.println("Vous avez décidé de combattre !");
        this.demanderPotion();
    }

    public void lancerTour() {
        this.donnerSante();
        System.out.println(this.mCtrl.lancerTour());
    }

    public void demanderPotion() {
        System.out.println("Vous possédez " + this.mCtrl.donnerPVperso() + " points de vie.");

        if (this.mCtrl.possedePotions()) {
            String question = "Avant de combattre, voulez-vous boire une potion (O/N) ?";

            if (Clavier.demanderChoix(question, "O", "N")) {
                this.mCtrl.boirePotion();
            } else {
                System.out.println("Vous décidez de combattre sans vous restaurer !");
            }
        }
    }

    private void mort() {
        System.out.println(ConsoleColors.RED_BOLD + "GAME OVER" + ConsoleColors.RESET);
        System.out.println("En relançant le jeu, vous pourrez reprendre à votre dernière sauvegarde"
                + " ou commencer une nouvelle partie");
        System.exit(0);
    }
}