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
 * File :
 * 
 * @author Perrine Mortier
 * @version 2021/05/13
 *
 */

public class Labyrinthe implements Serializable {
    
    private int mNbPieces;
    private Piece mMatricePieces [][] ;
    private Piece mSortie;
    private Entree mEntree;
    private Personnage mPersonnage;
    private static final int NB_LIGNES_MIN  = 3;
    private static final int NB_LIGNES_MAX = 6 ;


    /**
     * constructeur du Labyrinthe
     * 
     */
    public Labyrinthe() {

        // Etape 1 : Generer nb aleatoire entre 3 et 6 bornes incluses

        Random rand = new Random();

        int nbAleatoire = rand.nextInt(NB_LIGNES_MAX - NB_LIGNES_MIN + 1) + NB_LIGNES_MIN;

        //Etape 2 : generer un tableau à 2 dimensions  avec comme param le nb aleatoire précédemment généré

        this.mMatricePieces = new Piece [nbAleatoire] [nbAleatoire];
        this.genererPieces();

        // Etape 3 : paramétrer les coordonnees des pièces particulières : Entrée & Sortie

        this.mEntree = (Entree) this.mMatricePieces[0] [0];
        genererBoutiques();
        this.mSortie = this.mMatricePieces[nbAleatoire - 1] [nbAleatoire - 1];

        // Etape 5 : config player avatar

        this.mPersonnage = null;

    }

    
    /**
     * @role : génère les pièces en fonction de la taille de la matrice
     *         En fonction des coordonnées de la pièce, les portes compatibles seront créées 
     */
    public void genererPieces(){

        // Indices de parcours de la matrice carrée : i pour ligne & j pour colonne
        int i,j;
        int sizeOfTab = this.mMatricePieces.length;

        // Création des portes pour chaque cardinalité
        Orientation orientationPN = Orientation.NORD;
        Porte porteN = new Porte(orientationPN);

        Orientation orientationPS = Orientation.SUD;
        Porte porteS = new Porte(orientationPS);

        Orientation orientationPE = Orientation.EST;
        Porte porteE = new Porte(orientationPE);

        Orientation orientationPO = Orientation.OUEST;
        Porte porteO = new Porte(orientationPO);

        String texte ="";

        for ( i = 0; i<sizeOfTab; i++){

            for ( j = 0; j< sizeOfTab; j++){
                // Initialisation de la liste des portes disponibles
                List<Porte> portes = new ArrayList <Porte>();

                // List which contains all the doors
                portes.add(porteN);
                portes.add(porteS);
                portes.add(porteE);
                portes.add(porteO);

                // Remove the door according to the coord of the room

                if ( i == 0) {
                    // If first line of Matrix so not North Door
                    portes.remove(porteN);
                }

                // If last line of Matrix so not South Door
                else  if ( i == (sizeOfTab-1)) {
                    portes.remove(porteS);
                }

                // If first column of Matrix so not West Door
                if ( j == 0 ){
                    portes.remove(porteO);
                }

                // If last Column of Matrix so not East Door
                else if ( j == (sizeOfTab - 1)){
                    portes.remove(porteE);

                }

                // Add to the Lab the room that contains compatible doors
                if ( i == 0 && j == 0 ){

                    this.mMatricePieces[i][j] = new Entree(portes,this);
                }
                else{
                    this.mMatricePieces[i][j] = new PieceCombat(portes,i,j,this);
                }
            }// End of pathway column

        } // End of pathway line

        
    }

    /** 
     * @role : ajoute les 3 types de boutiques possibles à la pièce correspondant à l'entrée du labyrinthe
     */
    private void genererBoutiques(){

        // Step 1 : create one Shop by Type
        Boutique<Arme> boutiqueArmes = new Boutique<Arme>(TypeObjetVendu.ARME);
        Boutique<Potion> boutiquePotions = new Boutique<Potion>(TypeObjetVendu.POTION);
        Boutique<Armure> boutiqueArmures = new Boutique<Armure>(TypeObjetVendu.ARMURE); 

        // Step 2 : Add Shop to entry
        this.mEntree.ajouterBoutique(boutiqueArmes,TypeObjetVendu.ARME);
        this.mEntree.ajouterBoutique (boutiquePotions, TypeObjetVendu.POTION);
        this.mEntree.ajouterBoutique(boutiqueArmures,TypeObjetVendu.ARMURE);



    }

    /**
     * 
     * @param tPiece
     * @return teste si la pièce en paramètre correspond à l'entrée du labyrinthe
     */
    public boolean isEntree(Piece tPiece){
        return( tPiece == this.mEntree);
    }

    /**
     * 
     * @param tPiece
     * @return teste si la pièce en paramètre correspond à la sortie du labyrinthe
     */
    public boolean isSortie(Piece tPiece){
       return ( tPiece == this.mSortie);
    }

    /**
     * Getter du nombre de pièces
     * 
     * @return int  Nombre de pièces du labyrinthe
     */
    public int getNbPieces(){
        return this.mNbPieces;
    }

    /**
     * Getter du personnage
     * 
     * @return Personnage personnage relié au Labyrinthe
     */
    public Personnage getPersonnage(){
        return this.mPersonnage;
    }

    /**
     * Retourne la référence de la pièce correspondant aux coordonnées passées en paramètres
     * 
     * @param tLigne    Numero de ligne de la pièce
     * @param tColonne  Numero de colonne de la pièce
     * @return La référence de la pièce
     */
    public Piece getPiece(int tLigne, int tColonne) {
        return this.mMatricePieces[tLigne][tColonne];
    }


    /**
     * @return chaine de caractères 
     */
    public String ajouterPersonnage ( Personnage tPersonnage){
        String texte ="";
        // Ajout du personnage au labyrinthe
        this.mPersonnage = tPersonnage;
        // Phrase d'information auprès du user
        texte += "Vous avez choisi un nom délicieux pour votre avatar. félicitations ! Oubliez votre passé ! Vous êtes maintenant " + tPersonnage.getNom() + " le seul et l'unique.\n";
        texte += "Prenez soin de vous, valeureux guerrier ...Vous disposez de  " + tPersonnage.getPointDeVie() + " points de vie. Tâchez de les preserver ...\n";
        texte += "Vous pénétrez maintenant LE LABYRINTHE . Je vous souhaite d'en sortir...un jour...peut-être...";

        texte += tPersonnage.ouvrirPorte(mEntree);

        return texte;

    }
}