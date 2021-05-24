package test;

import controleur.Combat;
import controleur.ControleurCombat;
import controleur.ControleurDeplacer;
import environnement.Entree;
import environnement.Labyrinthe;
import environnement.PieceCombat;
import protagonistes.Personnage;
import vue.BoundaryBoutique;
import vue.BoundaryCombat;
import vue.BoundaryDeplacer;
import vue.BoundaryLancement;
import vue.Clavier;

public class Etape5 {
    public static void main(String args[]) {
        Labyrinthe labyrinthe = BoundaryLancement.lancerPartie();
        Personnage personnage = labyrinthe.getPersonnage();
        BoundaryBoutique.setEntree((Entree) labyrinthe.getPiece(0, 0));
        ControleurDeplacer controleurDeplacement = new ControleurDeplacer(labyrinthe);
        BoundaryDeplacer deplacement = new BoundaryDeplacer(controleurDeplacement);
        boolean quitter = false;

        while (!quitter) {
            deplacement.deplacer();

            if (!labyrinthe.isEntree(personnage.getPiece())) {
                String question = "Combattre ou fuir ? (C/F)";
                PieceCombat piece = (PieceCombat) personnage.getPiece();
                ControleurCombat crtlCmb = new ControleurCombat(personnage);
                BoundaryCombat bndCmb = new BoundaryCombat(crtlCmb);

                // Le contrôleur des combats doit être capable de récupérer le combat où se
                // trouve le personnage par lui même
                Combat combat = piece.getCombat();

                bndCmb.scenar();

                if (Clavier.demanderChoix(question, "C", "F")) {
                    System.out.println("Vous avez décidé de combattre !");

                    if (personnage.possedePotions()) {
                        String questionPotion = "Mais avant, voulez-vous boire une potion (O/N) ?";

                        if (Clavier.demanderChoix(questionPotion, "O", "N")) {
                            System.out.println(personnage.boirePotion());
                        }
                    }

                    System.out.println(combat.itererTour());

                    while (combat.vainqueur() == null && Clavier.demanderChoix(question, "C", "F")) {
                        bndCmb.donnerSante();
                        System.out.println(combat.itererTour());
                    }
                }
            } else {
                BoundaryBoutique.entrerCentreCommercial();
            }
        }

        quitter = BoundaryLancement.sauvegarderPartie(labyrinthe);
    }
}