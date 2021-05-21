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


    public void donnerSante() {
        int pv = this.mCrtl.donnerPVperso();

        if(pv <= 2) {
            System.out.println(ConsoleColors.RED + "Vous êtes dans un état critique et votre jambe vous fais souffrir." + ConsoleColors.RESET);
        }
    }

    public void monstreAttaque() {
        System.out.println(this.mCrtl.monstreAttaque());
    }

    public void lancerTour() {
        System.out.println(this.mCrtl.lancerTour());
    }


}
