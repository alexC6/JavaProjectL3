package vue;

import controleur.ControleurLancement;
import controleur.SystemeSauvegarde;
import environnement.Labyrinthe;

/**
 * <p>
 * File : BoundaryLancement.java <br>
 * Code source de la classe BoundaryLancement <br>
 * Cette classe s'occupe de l'affichage des informations liées au lancement ou à
 * la création d'une partie
 * </p>
 *
 * @author Alexandre Coulais
 * @version 2021-5-28
 */

public class BoundaryLancement {
    /**
     * Gestion de l'affichage au lancement d'une partie
     *
     * @return La référence du labyrinthe pour le jeu, null si problème
     */
    public static Labyrinthe lancerPartie() {
        Labyrinthe labyrinthe = null;

        if (ControleurLancement.partieExistante()) {
            // Si une partie existe, on demande à l'utilisateur ce qu'il souhaite faire
            String questionPartie = "Vous souhaitez lancer une nouvelle partie (N)" + " ou la partie existante (E) ?";

            /**
             * S'il souhaite reprendre une partie on récupère le labyrinthe dans le fichier
             * de sauvegarde
             */
            if (Clavier.demanderChoix(questionPartie, "E", "N")) {
                labyrinthe = retourDerniereSauv();
            }
        }

        /**
         * Si le labyrinthe est null, par initialisation ou par échec de récupération,
         * on crée une nouvelle partie
         */
        if (labyrinthe == null) {
            labyrinthe = nouvellePartie();
        }

        return labyrinthe;
    }

    /**
     * Pour récupérer les données de la dernière sauvegarde
     * 
     * @return Une référence sur le labyrinthe qui permettra au joueur de reprendre sa partie
     */
    public static Labyrinthe retourDerniereSauv () {
        Labyrinthe labyrinthe = null;
        boolean choix = true;

        while (choix && (labyrinthe = ControleurLancement.lancerPartieExistante()) == null) {
            /**
             * Si une erreur se produit, on le signale et on demande à l'utilisateur ce
             * qu'il souhaite faire
             */
            System.err.println("Une erreur semble s'être produite ...");
            String questionPartie = "Souhaitez-vous lancer une nouvelle partie (N) ou réessayer"
                    + " de lancer la partie existante (R) ?";
            choix = Clavier.demanderChoix(questionPartie, "R", "N");
        }

        if (labyrinthe == null) {
            labyrinthe = nouvellePartie();
        }

        return labyrinthe;
    }

    /**
     * Création d'une nouvelle partie
     * 
     * @return La référence du labyrinthe pour le jeu
     */
    public static Labyrinthe nouvellePartie() {
        // Demande du nom du personnage et appel de la création de partie du contrôleur
        String questionNom = "Quel nom souhaitez-vous donner à votre personnage ?";
        String nom = Clavier.entrerClavierString(questionNom);

        return ControleurLancement.nouvellePartie(nom);
    }

    /**
     * Demande au joueur s'il veut sauvegarder sa partie <br>
     * Dans ce cas là, on demande aussi s'il veut quitter la partie
     * 
     * @param tLabyrinthe Le labyrinthe du jeu à sauvegarder
     * @return Vrai si le joueur veut quitter la partie après sa sauvegarde, faux sinon
     */
    public static boolean sauvegarderPartie(Labyrinthe tLabyrinthe) {
        String question = "Voulez-vous sauvegarder votre partie (O/N) ?";

        if (ControleurLancement.partieExistante()) {
            // S'il existe une partie, on en informe l'utilisateur
            question += ConsoleColors.RED_BOLD + "\nAttention ! Cette action effacera la sauvegarde précédente ..."
                    + ConsoleColors.RESET;
        }

        if (Clavier.demanderChoix(question, "O", "N")) {
            // Si l'utilisateur veut sauvegarder sa partie, on la sauvegarde,
            // puis on lui demande s'il souhaite quitter la partie
            if (!(SystemeSauvegarde.sauvegarderPartie(tLabyrinthe))) {
                // Si une erreur se produit pendant la sauvegarde, on informe le joueur
                System.err.println("Oups ! Une erreur s'est produite pendant la sauvegarde ...");
            }

            return demanderQuitter();
        }

        return false;
    }

    /**
     * Demander au joueur s'il veut quitter le jeu après une sauvegarde
     * 
     * @return Vrai si le joueur veut quitter, faux sinon
     */
    public static boolean demanderQuitter() {
        String question = "Voulez-vous quitter la partie (O/N) ?";

        return Clavier.demanderChoix(question, "O", "N");
    }
}