package controleur;

import environnement.Labyrinthe;
import protagonistes.Personnage;

/**
 * <p>File : ControleurLancement.java
 * <br>Code source de la classe ControleurLancement
 * <br>Cette classe permet de contrôler le processus de lancement des parties
 * et de faire appel au système de sauvegarde</p>
 * 
 * @author Alexandre Coulais
 * @version 2021-5-21
 */

public class ControleurLancement {
    /**
     * Fait appel au système de sauvegarde pour connaître l'existence d'une sauvegarde
     * 
     * @return Vrai si une sauvegarde existe, faux sinon
     */
    public static boolean partieExistante() {
        return SystemeSauvegarde.exists();
    }

    /**
     * Création d'une nouvelle partie
     * 
     * @param tNom Le nom du personnage
     * @return La référence du labyrinthe pour le jeu
     */
    public static Labyrinthe nouvellePartie(String tNom) {
        // Création des objets nécessaires
        Labyrinthe labyrinthe = new Labyrinthe();
        Personnage personnage = new Personnage(tNom);

        // Ajout du personnage au labyrinthe
        labyrinthe.ajouterPersonnage(personnage);

        return labyrinthe;
    }

    /**
     * Fait appel au système de sauvegarde afin de récupérer la référence
     * du labyrinthe d'une partie existante
     * 
     * @return Référence d'un labyrinthe, null si problème
     */
    public static Labyrinthe lancerPartieExistante() {
        return SystemeSauvegarde.recupererPartie();
    }
}