package vue;

import java.util.List;

import controleur.ControleurDeplacer;
import environnement.Piece;
import environnement.Porte;

/**
 * <p>
 * File : BoundaryDeplacer.java<br>
 * Code source du boundary de gestion des déplacements
 * </p>
 * 
 * @author Perrine Mortier
 * @version 2021-5-28
 */

public class BoundaryDeplacer {

    /**
     * Controleur des déplacements rattaché au boundary
     */
    private ControleurDeplacer mControleur;

    /**
     * Constructeur du boundary des déplacements
     * 
     * @param tControleur Le controleur à rattacher au boundary
     */
    public BoundaryDeplacer(ControleurDeplacer tControleur) {
        this.mControleur = tControleur;
    }

    /**
     * Fonction principale pour les déplacements du personnage<br Chaque fois que
     * celui-ci bouge, cette fonction est appelée, et fait l'ensemble des appels de
     * fonctions nécessaires pour déplacer le personnage
     */
    public void deplacer() {
        // Affichage au joueur de son emplacement actuel
        String question = "Vous êtes actuellement " + this.mControleur.getPosition() + ".\n"
                + "Souhaitez-vous rester (R) dans cette salle ou en changer (C) ?";

        if (Clavier.demanderChoix(question, "R", "C")) {
            // Si le joueur ne souhaite pas changer de salle, on stop la fonction ici
            return;
        }

        // Sinon, on récupère les portes de la salle pour qu'il choisisse sa direction
        // et on les affiche
        String choixPorte;
        int nbPortes = this.mControleur.getNbPortes();
        List<Porte> listePortesDispo = this.mControleur.getPortes();

        this.afficherPortes();

        System.out.println("Vous avez maintenant le choix entre " + nbPortes + " portes. Le choix est rude."
                + " Quelle porte décidez-vous de pousser ? Derrière elles, le mystère reste entier ...\n");

        String questionPortes = "Tapez ";

        // On construit la chaine avec les portes disponibles
        for (int i = 0; i < nbPortes; i++) {
            // toSelect() renvoie une chaine indiquant l'orientation d'une porte
            // On l'appel sur toutes les portes disponibles
            questionPortes += listePortesDispo.get(i).toSelect();

            if (i < nbPortes - 2) {
                questionPortes += ", ";
            } else if (i == nbPortes - 2) {
                questionPortes += " ou ";
            }
        }

        // La boucle est effectuée tant que le joueur n'a pas saisi une lettre
        // correspondante aux orientations proposées
        do {
            // On demande ensuite au joueur quelle porte il souhaite emprunter
            choixPorte = Clavier.entrerClavierString(questionPortes).toUpperCase();
        } while (((!choixPorte.equals("N")) && (!choixPorte.equals("E")) && (!choixPorte.equals("S"))
                && (!choixPorte.equals("O"))) || (!this.mControleur.getPortesChaines().contains(choixPorte)));

        // On appelle ensuite la fonction de déplacement du personnage à proprement
        // parler
        System.out.println(this.mControleur.deplacerVers(choixPorte));
    }

    /**
     * Fonction d'affichage des portes disponibles dans la salle où est le
     * personnage
     */
    public void afficherPortes() {
        // Récupération des portes et de la pièce actuelle
        int nbPortes = this.mControleur.getNbPortes();
        Piece piece = this.mControleur.getPieceActuelle();

        // Affichage du nombre de portes
        System.out.print("\nCher combattant, ");
        System.out.print(nbPortes);
        System.out.println(" portes s'offrent à vous. Voici : ");

        // Affichage de toutes les portes disponibles
        for (int i = 0; i < nbPortes; i++) {
            System.out.println("\t" + ConsoleColors.BLUE_BOLD + piece.getPortes().get(i) + ConsoleColors.RESET);
        }

        System.out.println();
    }

    /**
     * Fonction pour demander au joueur s'il souhaite rentrer dans les boutiques pour faire des achats
     * 
     * @return Vrai s'il souhaite aller dans les boutiques, faux sinon
     */
    public boolean faireBoutique() {
        String question = "Vous êtes devant le centre commercial, souhaitez-vous y rentrer (O/N) ?";

        return Clavier.demanderChoix(question, "O", "N");
    }
}