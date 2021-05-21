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
    
    private ControleurCombat mCrtl;
    public boolean checkVanic;
    
    public BoundaryCombat(ControleurCombat tCtrl) {
        this.mCrtl = tCtrl;
    }

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

    public boolean choixCombatreFuir () {
        return Clavier.demanderChoix("Combattre ou fuir ? (C/F)", "C", "F");
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

    public void demarrerCombat() {
        if()
        this.scenar();
        System.out.println(this.mCrtl.demarrerCombat());
    }

    public void lancerTour() {
        this.donnerSante();
        boolean choixCF = this.choixCombatreFuir();
        System.out.println(this.mCrtl.lancerTour());
    }


}
