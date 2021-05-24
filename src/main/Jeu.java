package main;

import controleur.ControleurCombat;
import controleur.ControleurDeplacer;
import environnement.Entree;
import environnement.Labyrinthe;
import protagonistes.Personnage;
import vue.BoundaryBoutique;
import vue.BoundaryCombat;
import vue.BoundaryDeplacer;
import vue.BoundaryLancement;

public class Jeu {
    public static void main(String args[]) {
        boolean quitter = false;
        Labyrinthe labyrinthe = BoundaryLancement.lancerPartie();
        Personnage personnage = labyrinthe.getPersonnage();

        ControleurDeplacer ctrlDeplacement = new ControleurDeplacer(labyrinthe);
        ControleurCombat ctrlCombat = new ControleurCombat(personnage);

        BoundaryDeplacer bdyDeplacement = new BoundaryDeplacer(ctrlDeplacement);
        BoundaryCombat bdycombat = new BoundaryCombat(ctrlCombat);

        BoundaryBoutique.setEntree((Entree) labyrinthe.getPiece(0, 0));

        while (!(quitter)) {
            bdyDeplacement.deplacer();

            if (!labyrinthe.isEntree(personnage.getPiece())) {
                // Appels boundary combat
            } else {
                BoundaryBoutique.entrerCentreCommercial();
            }

            quitter = BoundaryLancement.sauvegarderPartie(labyrinthe);
        }
    }
}