package vue;

import java.util.List;

import controleur.ControleurDeplacer;
import environnement.Piece;
import environnement.Porte;

public class BoundaryDeplacer {

    private ControleurDeplacer mControleur;

    public BoundaryDeplacer(ControleurDeplacer tControleur) {

        this.mControleur = tControleur;

    }

    public void deplacer() {
        String question = "Vous êtes actuellement " + this.mControleur.getPosition() + ".\n"
                + "Souhaitez-vous rester (R) dans cette salle ou en changer (C) ?";

        if (Clavier.demanderChoix(question, "R", "C")) {
            return;
        }

        String choixPorte;
        int nbPortes = this.mControleur.getNbPortes();
        List<Porte> listePortesDispo = this.mControleur.getPortes();

        this.afficherPortes();

        System.out.println("Vous avez maintenant le choix entre " + nbPortes + " portes. Le choix est rude."
                + " Quelle porte décidez-vous de pousser ? Derrière elles, le mystère reste entier ...\n");

        do {
            String questionPortes = "Tapez ";

            for (int i = 0; i < nbPortes; i++) {
                questionPortes += listePortesDispo.get(i).toSelect();

                if (i < nbPortes - 2) {
                    questionPortes += ", ";
                } else if (i == nbPortes - 2) {
                    questionPortes += " ou ";
                }
            }

            choixPorte = Clavier.entrerClavierString(questionPortes).toUpperCase();

        } while (((!choixPorte.equals("N")) && (!choixPorte.equals("E")) && (!choixPorte.equals("S"))
                && (!choixPorte.equals("O"))) || (!this.mControleur.getPortesChaines().contains(choixPorte)));

        System.out.println(this.mControleur.deplacerVers(choixPorte));

    }

    public void afficherPortes() {

        int nbPortes = this.mControleur.getNbPortes();
        Piece piece = this.mControleur.getPieceActuelle();

        System.out.print("\nCher combattant, ");
        System.out.print(nbPortes);
        System.out.println(" portes s'offrent à vous. Voici : ");
        // Faire une boucle qui récupère tous les éléments de la liste et qui les affiche
        // getPortes() retournant une liste des orientations de portes disponibles

        for (int i = 0; i < nbPortes; i++) {
            System.out.println("\t"+ConsoleColors.BLUE_BOLD +piece.getPortes().get(i)+ConsoleColors.RESET);
        }

        System.out.println();
    }

    public boolean faireBoutique() {
        String question = "Vous êtes devant le centre commercial, souhaitez-vous y rentrer (O/N) ?";

        return Clavier.demanderChoix(question, "O", "N");
    }
}