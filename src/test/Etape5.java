package test;

import controleur.ControleurCombat;
import controleur.ControleurDeplacer;
import environnement.Entree;
import environnement.Labyrinthe;
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
        ControleurDeplacer ctrlDeplacement = new ControleurDeplacer(labyrinthe);
        BoundaryDeplacer bdyDeplacement = new BoundaryDeplacer(ctrlDeplacement);
        boolean quitter = false;

        while (!quitter) {
            bdyDeplacement.deplacer();

            if (!labyrinthe.isEntree(personnage.getPiece())) {
                ControleurCombat ctrlCombat = new ControleurCombat(personnage);
                BoundaryCombat bdyCombat = new BoundaryCombat(ctrlCombat);

                if (bdyCombat.checkVainc() == false) {
                    bdyCombat.scenar();

                    if (bdyCombat.choixCombatreFuir()) {
                        bdyCombat.demarrerCombat();

                        // Gestion des potions par le boundary/controleur de combat
                        if (personnage.possedePotions()) {
                            String questionPotion = "Mais avant, voulez-vous boire une potion (O/N) ?";

                            if (Clavier.demanderChoix(questionPotion, "O", "N")) {
                                System.out.println(personnage.boirePotion());
                            }
                        }

                        bdyCombat.lancerTour();

                        while (bdyCombat.checkVainc() == false && bdyCombat.choixCombatreFuir()) {
                            bdyCombat.lancerTour();
                        }
                    }
                } else {
                    bdyCombat.pieceVide();
                }
            } else if (bdyDeplacement.faireBoutique()) {
                BoundaryBoutique.entrerCentreCommercial();
            }

            quitter = BoundaryLancement.sauvegarderPartie(labyrinthe);
        }
    }
}