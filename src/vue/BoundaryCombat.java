package vue;

import java.util.Random;

import controleur.ControleurCombat;
import protagonistes.Monstre;

/**
 * File : BoundaryCombat.java
 * Code source de entrées sorties du Combat
 * 
 * @author Thomas Chabert
 * @version 2021-5-28
 */

public class BoundaryCombat {

    /**
     * Le controleur qui manipule et accède à l'objet Combat
     *
     * @see ControleurCombat
     */
    private ControleurCombat mCtrl;

    /**
     * Si le joueur meurt, indique une volonté de reprendre la dernière sauvegarde (true)
     * @see mort()
     */
    private boolean needSauvegarde;

    /**
     * Constructeur de boundary
     * 
     * @param tCtrl Le controleur de combat
     */
    public BoundaryCombat(ControleurCombat tCtrl) {
        this.mCtrl = tCtrl;
    }

    /**
     * Méthode qui introduit un combat et utilise l'objet Random
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
     * @return boolean faux si il décide de fuir true si c'est uv vrai guerrier
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

    /**
     * Méthode qui affiche un avertissement en rouge quand les Points de Vie sont bas
     */
    public void donnerSante() {
        int pv = this.mCtrl.donnerPVperso();

        if (pv <= 2) {
            System.out.println(ConsoleColors.RED + "Vous êtes dans un état critique et votre jambe vous fais souffrir."
                    + ConsoleColors.RESET);
            System.out.println("Il vous reste " + pv + " points de vie.");
        }
    }

    /**
     * Méthode qui affiche un avertissement en rouge quand les Points de Vie sont bas
     * @return boolean true si les pv sont à 0
     */
    public boolean checkVainc() {
        boolean isDead = this.mCtrl.checkVainc();

        if (isDead && this.mCtrl.getVainqueur() instanceof Monstre) {
            this.mort();
        }

        return isDead;
    }

    /**
     * Retourne un booléen concernant l'état du monstre
     * 
     * @return Vrai si le vainqueur est le Personnage, faux sinon
     */
    public boolean isMonsterDead() {
        return this.mCtrl.isMonsterDead();
    }

    /**
     * Retourne un booléen concernant l'état du personnage
     * 
     * @return Vrai si le vainqueur est le Monstre, faux sinon
     */
    public boolean isPersonnageDead() {
        return this.mCtrl.isPersonnageDead();
    }

    /**
     * Méthode qui affiche une phrase quand la pièce est vide
     */
    public void pieceVide() {
        System.out.println("Vous êtes déjà passé par là, il n'y a plus rien à voir !");
        System.out.println("La pièce est vide. Il n'y a que le corps sans vie du monstre et le coffre vide.");
    }

    /**
     * Méthode qui indique qu'un combat est engagé et propose de boire une potion
     */
    public void demarrerCombat() {
        System.out.println("Vous avez décidé de combattre !");
        this.demanderPotion();
    }

    /**
     * Méthode qui afiche le déroulement d'un tour : compteur tour, instance qui attaque, points de vie
     */
    public void lancerTour() {
        this.donnerSante();
        System.out.println(this.mCtrl.lancerTour());
    }

    /**
     * Méthode qui propose de boire une potion au joueur si il en poscède une
     */
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

    /**
     * Méthode qui récupère les dernières volontés du joueur : dernière sauvegarde ou nouvelle partie
     */
    private void mort() {
        System.out.println(ConsoleColors.RED_BOLD + "GAME OVER" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + "En relançant le jeu, vous pourrez reprendre à votre dernière sauvegarde"
                + " ou commencer une nouvelle partie (R/N)" + ConsoleColors.RESET);
        boolean r = Clavier.demanderChoix("", "R", "N");
        if (r == false) {
            this.needSauvegarde = false;
        } else {
            this.needSauvegarde = true;
        }
    }

    /**
     * @return boolean need attribut getteur sur needSauvegarde
     */
    public boolean getNeedSv () {
        return this.needSauvegarde;
    }

}