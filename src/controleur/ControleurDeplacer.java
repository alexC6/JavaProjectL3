package controleur;

import java.util.List;

import environnement.Labyrinthe;
import environnement.Piece;
import environnement.Porte;
import protagonistes.Personnage;

/**
 * <p>
 * File : ControleurDeplacer.java<br>
 * Code source du contrôleur des déplacements
 * </p>
 * 
 * @author Perrine Mortier
 * @version 2021-5-28
 */

public class ControleurDeplacer {
    /**
     * Le labyrinthe dans lequel évolue le personnage
     */
    private Labyrinthe mLabyrinthe;

    /**
     * L'orientation permettant de mémoriser, entre deux fonctions,
     * où souhaite se rendre le personnage
     */
    private Orientation mOrientation;

    /**
     * Personnage évoluant dans le labyrinthe
     */
    private Personnage mPersonnage;

    /**
     * Constructeur du contrôleur de déplacement
     * 
     * @param tLabyrinthe Le labyrinthe dans lequel se déroule la partie
     */
    public ControleurDeplacer(Labyrinthe tLabyrinthe) {
        this.mLabyrinthe = tLabyrinthe;
        this.mPersonnage = tLabyrinthe.getPersonnage();
    }

    /**
     * Getter du nombre de portes de la salle dans laquelle se trouve le personnage
     * 
     * @return Nombre de portes
     */
    public int getNbPortes() {
        return this.getPieceActuelle().getNbPortes();
    }

    /**
     * Getter de la liste des portes disponibles dans la salle actuelle du personnage
     * 
     * @return Liste de portes
     */
    public List<Porte> getPortes() {
        return this.getPieceActuelle().getPortes();
    }

    /**
     * <p>
     * Retourne la liste des portes disponibles sous forme de lettre indiquant une orientation<br>
     * N pour nord, S pour sud, E pour est et O pour ouest
     * </p>
     * 
     * @return La liste de caractères
     */
    public List<String> getPortesChaines() {
        return this.getPieceActuelle().getOrientation();
    }

    /**
     * Getter sur la pièce actuelle où se trouve le personnage
     * 
     * @return La pièce actuelle
     */
    public Piece getPieceActuelle() {
        return this.mLabyrinthe.getPersonnage().getPiece();
    }

    /**
     * Getter sur la position de la pièce actuelle dans le labyrinthe
     * sous forme de chaine de caractères
     * 
     * @return La chaine à afficher
     */
    public String getPosition() {
        // On récupère les coordonnées de la pièce actuelle
        int ligne = this.getPieceActuelle().getLigne();
        int colonne = this.getPieceActuelle().getColonne();
        String position;

        if (ligne == 0 && colonne == 0) {
            // Si le personnage se trouve dans l'entrée
            position = "dans l'entrée, avec le centre commercial à côté";
        } else {
            // S'il se trouve dans une salle de combat
            position = "en position (" + ligne + " ; " + colonne + ")";
        }

        return position;
    }

    /**
     * Permet de savoir si la pièce dans laquelle est le personnage est l'entrée du labyrinthe
     * 
     * @return Vrai si le personnage est dans l'entrée, faux sinon
     */
    public boolean isEntree() {
        return this.mLabyrinthe.isEntree(this.getPieceActuelle());
    }

    /**
     * Permet de changer de labyrinthe, lors d'un game over par exemple
     * 
     * @param tLabyrinthe Le nouveau labyrinthe dans lequel se déroule la partie
     */
    public void setLabyrinthe(Labyrinthe tLabyrinthe) {
        this.mLabyrinthe = tLabyrinthe;
        this.mPersonnage = tLabyrinthe.getPersonnage();
    }

    /**
     * Retourne sous forme de string pour affichage la porte choisie par le joueur<br>
     * Mémorise également dans la variable membre l'orientation choisie pour la suite
     * 
     * @param choixPorte Le choix de la porte
     * @return La string à afficher
     */
    public String porteChoisie(String choixPorte) {
        String txt = "";

        // Selon la chaine passée en paramètre, on donne la porte choisie
        // et on affecte l'orientation correspondante
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
        }// Fin switch

        return txt;
    }

    /**
     * Fonction de déplacement du personnage dans une autre salle
     * 
     * @param tChoix Le choix de la porte
     * @return Du texte à afficher
     */
    public String deplacerVers(String tChoix) {
        String texte = "";
        Piece pieceActuelle = getPieceActuelle(), nouvellePiece;
        int ligne, colonne;

        // On récupère les coordonnées de la pièce actuelle
        ligne = pieceActuelle.getLigne();
        colonne = pieceActuelle.getColonne();

        texte += porteChoisie(tChoix);

        // En fonction de l'orientation choisie dans la fonction porteChoisie,
        // on change les coordonnées pour pouvoir appeler la nouvelle pièce
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

        // On récupère la nouvelle pièce et on déplace le personnage dedans
        nouvellePiece = mLabyrinthe.getPiece(ligne, colonne);
        texte += mPersonnage.ouvrirPorte(nouvellePiece);

        return texte;
    }

}
