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
        BoundaryDeplacer bdyDeplacement = new BoundaryDeplacer(ctrlDeplacement);
        BoundaryBoutique.setEntree((Entree) labyrinthe.getPiece(0, 0));
        
        while (!(quitter)) {
            bdyDeplacement.deplacer();
            
            if (!labyrinthe.isEntree(personnage.getPiece())) {
                ControleurCombat ctrlCombat = new ControleurCombat(personnage);
                BoundaryCombat bdycombat = new BoundaryCombat(ctrlCombat);
                // Appels boundary combat
            } else {
                BoundaryBoutique.entrerCentreCommercial();
            }

            quitter = BoundaryLancement.sauvegarderPartie(labyrinthe);
        }
    }
}