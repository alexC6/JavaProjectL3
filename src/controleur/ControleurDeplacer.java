package controleur;

import java.util.List;

import environnement.Labyrinthe;
import environnement.Piece;
import environnement.Porte;
import protagonistes.Personnage;

public class ControleurDeplacer {

    private Labyrinthe mLabyrinthe;
    private Orientation mOrientation;
    private Personnage mPersonnage;

    public ControleurDeplacer(Labyrinthe tLabyrinthe) {
        this.mLabyrinthe = tLabyrinthe;
        this.mPersonnage = tLabyrinthe.getPersonnage();
    }

    // Suppression de afficherPortes et transfert dans le boundary

    public int getNbPortes() {
        return this.getPieceActuelle().getNbPortes();
    }

    public List<Porte> getPortes() {
        return this.getPieceActuelle().getPortes();
    }

    public List<String> getPortesChaines() {
        return this.getPieceActuelle().getOrientation();
    }

    public Piece getPieceActuelle() {
        return this.mLabyrinthe.getPersonnage().getPiece();
    }

    public String getPosition() {
        int ligne = this.getPieceActuelle().getLigne();
        int colonne = this.getPieceActuelle().getColonne();
        String position;
        
        if (ligne == 0 && colonne == 0) {
            position = "dans l'entrée, avec le centre commercial à côté";
        } else {
            position = "en position (" + ligne + " ; " + colonne + ")";
        }

        return position;
    }

    public boolean isEntree() {
        return this.mLabyrinthe.isEntree(this.getPieceActuelle());
    }

    public void setLabyrinthe(Labyrinthe tLabyrinthe) {
        this.mLabyrinthe = tLabyrinthe;
        this.mPersonnage = tLabyrinthe.getPersonnage();
    }

    /**
     * 
     * @param tPiece
     * @return une chaine de caractères : affichage des portes disponibles de la
     *         pièce où se trouve le personnage + choix de la porte à ouvrir
     */

    public String porteChoisie(String choixPorte) {

        String txt = "";

        switch (choixPorte) {

            case "N":
                txt += "Vous avez choisi d'ouvrir la porte Nord.\n";
                this.mOrientation = Orientation.NORD;
                break;

            case "E":
                txt += "Vous avez choisi d'ouvrir la porte Est.\n";
                this.mOrientation = Orientation.EST;
                break;

            case "S":
                txt += "Vous avez choisi d'ouvrir la porte Sud.\n";
                this.mOrientation = Orientation.SUD;
                break;

            case "O":
                txt += "Vous avez choisi d'ouvrir la porte Ouest.\n";
                this.mOrientation = Orientation.OUEST;
                break;

            default:
                System.out.println("Merci de faire un choix réaliste ... Ouvrez les yeux ! \n");
                break;
        }// Fin switch

        return txt;
    }

    /**
     * 
     * @param tPersonnage
     * @param tLabyrinthe
     * @return
     */
    public String deplacerVers(String tChoix) {
        String texte = "";
        Piece pieceActuelle, nouvellePiece;
        int ligne, colonne;

        pieceActuelle = mPersonnage.getPiece();

        ligne = pieceActuelle.getLigne();
        colonne = pieceActuelle.getColonne();

        texte += porteChoisie(tChoix);

        switch (this.mOrientation) {
            case NORD:
                ligne--;
                break;

            case SUD:
                ligne++;
                break;

            case EST:
                colonne++;
                break;

            case OUEST:
                colonne--;
                break;
        }

        nouvellePiece = mLabyrinthe.getPiece(ligne, colonne);
        texte += mPersonnage.ouvrirPorte(nouvellePiece);

        return texte;
    }

}
