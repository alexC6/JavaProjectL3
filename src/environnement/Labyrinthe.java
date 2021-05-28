package environnement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import controleur.Orientation;
import equipement.Arme;
import equipement.Armure;
import equipement.Potion;
import protagonistes.Personnage;

/**
 * <p>
 * File : Labyrinthe.java<br>
 * Code source du labyrinthe
 * </p>
 * 
 * @author Perrine Mortier
 * @version 2021-5-28
 */

public class Labyrinthe implements Serializable {
    /**
     * Nombre de pièces de la matrice
     */
    private int mNbPieces;

    /**
     * Matrice contenant les salles
     */
    private Piece mMatricePieces[][];

    /**
     * L'entrée du labyrinthe, avec le centre commercial
     */
    private Entree mEntree;

    /**
     * Le personnage qui se déplace dans le labyrinthe
     */
    private Personnage mPersonnage;

    /**
     * Tailles minimum et maximum de la matrice des salles
     */
    private static final int NB_LIGNES_MIN = 3;
    private static final int NB_LIGNES_MAX = 6;

    /**
     * Constructeur du Labyrinthe
     */
    public Labyrinthe() {
        // Etape 1 : Generer nb aleatoire entre 3 et 6 bornes incluses
        Random rand = new Random();
        int nbAleatoire = rand.nextInt(NB_LIGNES_MAX - NB_LIGNES_MIN + 1) + NB_LIGNES_MIN;

        // Etape 2 : generer un tableau à 2 dimensions avec comme param le nb aleatoire
        // précédemment généré
        this.mMatricePieces = new Piece[nbAleatoire][nbAleatoire];
        this.genererPieces();

        // Etape 3 : paramétrer les coordonnees des pièces particulières : Entrée &
        // Sortie
        this.mEntree = (Entree) this.mMatricePieces[0][0];
        genererBoutiques();

        // Etape 4 : config player avatar
        this.mPersonnage = null;
    }

    /**
     * Génère les pièces en fonction de la taille de la matrice<br>
     * En fonction des coordonnées de la pièce, les portes compatibles seront créées
     */
    public void genererPieces() {
        // Indices de parcours de la matrice carrée : i pour ligne & j pour colonne
        int i, j;
        int sizeOfTab = this.mMatricePieces.length;

        // Création des portes pour chaque orientation
        Orientation orientationPN = Orientation.NORD;
        Porte porteN = new Porte(orientationPN);

        Orientation orientationPS = Orientation.SUD;
        Porte porteS = new Porte(orientationPS);

        Orientation orientationPE = Orientation.EST;
        Porte porteE = new Porte(orientationPE);

        Orientation orientationPO = Orientation.OUEST;
        Porte porteO = new Porte(orientationPO);

        for (i = 0; i < sizeOfTab; i++) {
            for (j = 0; j < sizeOfTab; j++) {
                // Initialisation de la liste des portes disponibles
                List<Porte> portes = new ArrayList<Porte>();

                // Ajout de toutes les portes à la liste
                portes.add(porteN);
                portes.add(porteS);
                portes.add(porteE);
                portes.add(porteO);

                /** 
                 * Suppression des portes en fonction de la position de la salle
                 * Si la salle est sur la première ou la dernière ligne, on supprime
                 * respectivement les portes nord ou sud
                 * Si la salle est sur la première ou la dernière colonne, on supprime
                 * respectivement les portes ouest ou est
                 */
                if (i == 0) {
                    portes.remove(porteN);
                } else if (i == (sizeOfTab - 1)) {
                    portes.remove(porteS);
                }

                if (j == 0) {
                    portes.remove(porteO);
                } else if (j == (sizeOfTab - 1)) {
                    portes.remove(porteE);
                }

                if (i == 0 && j == 0) {
                    // Si la salle en cours de création est en position (0;0), on crée l'entrée
                    this.mMatricePieces[i][j] = new Entree(portes, this);
                } else {
                    // Dans tous les autres cas, on crée une salle de combat
                    this.mMatricePieces[i][j] = new PieceCombat(portes, i, j, this);
                }
            }
        }
    }

    /**
     * Ajoute les 3 types de boutiques possibles à l'entrée du labyrinthe
     */
    private void genererBoutiques() {
        // Création des types de boutiques
        Boutique<Arme> boutiqueArmes = new Boutique<Arme>(TypeObjetVendu.ARME);
        Boutique<Potion> boutiquePotions = new Boutique<Potion>(TypeObjetVendu.POTION);
        Boutique<Armure> boutiqueArmures = new Boutique<Armure>(TypeObjetVendu.ARMURE);

        // Ajout des boutiques à l'entrée
        this.mEntree.ajouterBoutique(boutiqueArmes, TypeObjetVendu.ARME);
        this.mEntree.ajouterBoutique(boutiquePotions, TypeObjetVendu.POTION);
        this.mEntree.ajouterBoutique(boutiqueArmures, TypeObjetVendu.ARMURE);
    }

    /**
     * Teste si la pièce testée est l'entrée
     * 
     * @param tPiece La pièce à tester
     * @return Vrai si la pièce est l'entrée, faux sinon
     */
    public boolean isEntree(Piece tPiece) {
        return (tPiece == this.mEntree);
    }

    /**
     * Getter du nombre de pièces
     * 
     * @return Nombre de pièces du labyrinthe
     */
    public int getNbPieces() {
        return this.mNbPieces;
    }

    /**
     * Getter du personnage
     * 
     * @return personnage relié au Labyrinthe
     */
    public Personnage getPersonnage() {
        return this.mPersonnage;
    }

    /**
     * Retourne la référence de la pièce correspondant aux coordonnées passées en
     * paramètres
     * 
     * @param tLigne   Numero de ligne de la pièce
     * @param tColonne Numero de colonne de la pièce
     * @return La référence de la pièce
     */
    public Piece getPiece(int tLigne, int tColonne) {
        return this.mMatricePieces[tLigne][tColonne];
    }

    /**
     * Permet d'ajouter le personnage qui va évoluer dans le labyrinthe à ce dernier
     * 
     * @return Chaine de caractères à afficher
     */
    public String ajouterPersonnage(Personnage tPersonnage) {
        String texte = "";

        // Ajout du personnage au labyrinthe
        this.mPersonnage = tPersonnage;

        // Phrase d'information auprès du user
        texte += "Vous avez choisi un nom délicieux pour votre avatar. Félicitations ! Oubliez votre passé ! Vous êtes maintenant "
                + tPersonnage.getNom() + " le seul et l'unique.\n";
        texte += "Prenez soin de vous, valeureux guerrier ... Vous disposez de " + tPersonnage.getPointDeVie()
                + " points de vie. Tâchez de les preserver ...\n";
        texte += "Vous pénétrez maintenant LE LABYRINTHE. Je vous souhaite d'en sortir ... un jour ... peut-être ...";

        // Déplacement initiale du personnage dans l'entrée (nouvelle partie)
        tPersonnage.ouvrirPorte(mEntree);

        return texte;

    }
}