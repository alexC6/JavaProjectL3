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

/**
 * <p>
 * File : Jeu.java
 * <br>Code source de la classe principale du jeu
 * </p>
 * 
 * @author Alexandre Coulais, Noëmie Suere, Perrine Mortier, thomas Chabert
 * 
 * @version 2021-5-28
 */

public class Jeu {
    public static void main(String args[]) {
        boolean quitter = false;

        // Récupération des objets nécessaires à l'utilisation des boundaries
        Labyrinthe labyrinthe = BoundaryLancement.lancerPartie();
        Personnage personnage = labyrinthe.getPersonnage();
        // Création des boundaries de déplacement
        ControleurDeplacer ctrlDeplacement = new ControleurDeplacer(labyrinthe);
        BoundaryDeplacer bdyDeplacement = new BoundaryDeplacer(ctrlDeplacement);
        BoundaryBoutique.setEntree((Entree) labyrinthe.getPiece(0, 0));

        while (!(quitter)) {
            // Tant que le joueur ne veut pas quitter le jeu
            // Appel du déplacement du personnage
            bdyDeplacement.deplacer();

            if (!labyrinthe.isEntree(personnage.getPiece())) {
                // Dans le cas où la salle est une pièce de combat
                // On initialise les coundary et controleur de combat
                ControleurCombat ctrlCombat = new ControleurCombat(personnage);
                BoundaryCombat bdyCombat = new BoundaryCombat(ctrlCombat);

                if (bdyCombat.checkVainc() == false) {
                    // S'il n'y a pas de vainqueur, on lance le combat
                    bdyCombat.scenar();

                    if (bdyCombat.choixCombatreFuir()) {
                        // Si le joueur choisit de combattre, on lance le combat
                        bdyCombat.demarrerCombat();
                        bdyCombat.lancerTour();

                        while (bdyCombat.checkVainc() == false && bdyCombat.choixCombatreFuir()) {
                            // Tant qu'il n'y a pas de mort et que le joueur veut continuer
                            // On continue d'effectuer des tours de combat
                            bdyCombat.lancerTour();
                        }
                        
                        if (bdyCombat.isPersonnageDead()) {
                            // Si le joueur mort décide de recharger la dernière sauvegarde
                            if (bdyCombat.getNeedSv() == true) {
                                labyrinthe = BoundaryLancement.retourDerniereSauv();
                            } else {
                                labyrinthe = BoundaryLancement.nouvellePartie();
                            }
        
                            personnage = labyrinthe.getPersonnage();
                            ctrlDeplacement.setLabyrinthe(labyrinthe);
                            bdyDeplacement = new BoundaryDeplacer(ctrlDeplacement);
                        }
                    }
                } else if (bdyCombat.isMonsterDead()) {
                    // Si le monstre est mort, on indique au joueur que la pièce est vide
                    bdyCombat.pieceVide();
                }
            } else if (bdyDeplacement.faireBoutique()) {
                // Si le joueur souhaite faire les boutiques
                BoundaryBoutique.entrerCentreCommercial();
            }

            // On demande au personnage s'il veut sauvegarder sa partie
            // Et dans ce cas, s'il souhaite quitter la partie
            quitter = BoundaryLancement.sauvegarderPartie(labyrinthe);
        }
    }
}