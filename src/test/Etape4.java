package test;

import controleur.Combat;
import controleur.ControleurCombat;
import controleur.Deplacement;
import environnement.Boutique;
import environnement.Entree;
import environnement.Labyrinthe;
import environnement.PieceCombat;
import protagonistes.Personnage;
import vue.BoundaryCombat;
import vue.Clavier;

public class Etape4  {
    public static void main(String args[]){
        Labyrinthe labyrinthe = new Labyrinthe();
        Personnage personnage = new Personnage("Alice", labyrinthe);

        System.out.println(labyrinthe.ajouterPersonnage(personnage));

        for (int i = 0 ; i < 5 && personnage.isVivant(); i++){
            System.out.println(Deplacement.deplacerVers(personnage, labyrinthe));

            if (!labyrinthe.isEntree(personnage.getPiece())) {
                String question = "Combattre ou fuir ? (C/F)";
                PieceCombat piecette = (PieceCombat) personnage.getPiece();

                // Le contrôleur des combats doit être capable de récupérer le combat où se trouve le personnage par lui même
                // On ne doit pas non plus avoir d'interaction avec le contrôleur, seul le boundary interagit avec lui
                Combat combat = piecette.getCombat();

                ControleurCombat crtlCmb = new ControleurCombat(personnage, combat.getMonstre(), combat);
                BoundaryCombat bndCmb = new BoundaryCombat(crtlCmb);

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
                int choixBoutique;

                do {
                    choixBoutique = Clavier.entrerClavierInt("Choisir une boutique (entier entre 1 et 3)");
                } while (choixBoutique < 1 || choixBoutique > 3);

                Entree entree = (Entree) labyrinthe.getPiece(0, 0);
                Boutique<?> boutique = entree.getBoutique(choixBoutique);

                boutique.visiter(personnage);
                System.out.println(boutique.acheterArticle(boutique.choisirArticle()));
            }
        }
    }
}