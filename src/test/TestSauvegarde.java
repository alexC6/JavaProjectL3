package test;

import controleur.Combat;
import controleur.ControleurCombat;
import controleur.Deplacement;
import controleur.SystemeSauvegarde;
import environnement.Labyrinthe;
import environnement.PieceCombat;
import protagonistes.Personnage;
import vue.BoundaryCombat;
import vue.Clavier;

public class TestSauvegarde {
    public static void main(String args[]){
        Labyrinthe labyrinthe = null;
        Personnage personnage = null;
        
        if (SystemeSauvegarde.exists()) {
            labyrinthe = SystemeSauvegarde.recupererPartie();
            personnage = labyrinthe.getPersonnage();
        } else {
            labyrinthe = new Labyrinthe();
            personnage = new Personnage("Alexandre", labyrinthe);
            System.out.println(labyrinthe.ajouterPersonnage(personnage));
        }
        
        System.out.println(Deplacement.deplacerVers(personnage, labyrinthe));

        if (!labyrinthe.isEntree(personnage.getPiece())) {
            String question = "Combattre ou fuir ? (C/F)";
            PieceCombat piecette = (PieceCombat) personnage.getPiece();

            // Le contrôleur des combats doit être capable de récupérer le combat où se trouve le personnage par lui même
            // On ne doit pas non plus avoir d'interaction avec le contrôleur, seul le boundary interagit avec lui
            Combat combat = piecette.getCombat();

            ControleurCombat crtlCmb = new ControleurCombat(personnage);
            BoundaryCombat bndCmb = new BoundaryCombat(crtlCmb);

            bndCmb.scenar();

            while (combat.vainqueur() == null && Clavier.demanderChoix(question, "C", "F")) {
                bndCmb.donnerSante();
                System.out.println(combat.itererTour());
            }
        }

        SystemeSauvegarde.sauvegarderPartie(labyrinthe);
    }
}