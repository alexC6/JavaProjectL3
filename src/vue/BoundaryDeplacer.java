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

        String choixPorte;
        int nbPortes = this.mControleur.getNbPortes();
        List<Porte> listePortesDispo = this.mControleur.getPortes();

        this.afficherPortes();

        System.out.println("Vous avez maintenant le choix entre " + nbPortes + " portes. Le choix est rude."
                + " Quelle porte décidez-vous de pousser ? Derrière elles, le mystère reste entier ...");

        do {
            String question = "\nTapez ";

            for (int i = 0; i < nbPortes; i++) {
                question += listePortesDispo.get(i).toSelect();

                if (i < nbPortes - 2) {
                    question += ", ";
                } else if (i == nbPortes - 2) {
                    question += " ou ";
                }
            }

            choixPorte = Clavier.entrerClavierString(question).toUpperCase();

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
            System.out.println(piece.getPortes().get(i));
        }

        System.out.println();
    }
}