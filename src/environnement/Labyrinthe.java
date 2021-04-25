package environnement;

import protagonistes.Personnage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import controleur.Orientation;
import environnement.*;

public class Labyrinthe {

    // Voir avec Alex codage vecteur en java + vérifier l attribut personnage
   
    private Piece mMatricePieces [][] ;
    private int mNbPieces;
    private int mNbBoutiques;
    private Piece mSortie;
    private Piece mEntree;
    private Personnage mPersonnage;

    private static final int NB_LIGNES_MIN  = 3;
    private static final int NB_LIGNES_MAX = 6 ;

    public Labyrinthe() {

        // Etape 1 : Generer nb aleatoire entre 3 et 6 bornes incluses

        Random rand = new Random();
        
        int nbAleatoire = rand.nextInt(NB_LIGNES_MAX - NB_LIGNES_MIN + 1) + NB_LIGNES_MIN;

        //Etape 2 : generer un tableau à 2 dimensions  avec comme param le nb aleatoire précédemment généré

        this.mMatricePieces = new Piece [nbAleatoire] [nbAleatoire];

        // Etape 3 : paramétrer le nb de boutiques soit 4 au total :  arme, armure, potions, reparation 
        
        this.mNbBoutiques = 4;

        // Etape 4 : paramétrer les coordonnees des pièces particulières : Entrée & Sortie
        
        this.mEntree = this.mMatricePieces[0] [0];

        this.mSortie = this.mMatricePieces[nbAleatoire - 1] [nbAleatoire - 1];

        // Etape 5 : config player avatar 

        this.mPersonnage = null;

    }

    // A VOIR AVEC ALEX : selon moi, c'est le personnage qui change de pièce donc pourquoi cette methode ds class Labyrinthe ?
    // C'est au labyrinthe de faire appel a la crea piece en fonction de la position du perso a ce moment là
    public String changerDePiece(){
        String texte ="";

        return texte;


    }
    // Pas de traitement de cette méthode pr le moment 
    public String chargerLabyrinthe(int tLigne, int tCol){

        String texte ="";

        texte += "Le labyrinthe est en cours de création. Veuillez patienter, noble combattant ! \n";

        // VOIR AVEC ALEX COMMENT INTEGRER UN DELAI D ATTENTE
        this.mNbPieces = tLigne * tCol;

        texte += "Vous allez voyager au sein d'un labyrinthe composé de " + this.getNbPieces() + ".\n";    

        return texte;

    }

    
    public String genererPieces(){

        // Indices de parcours de la matrice carrée : i pour ligne & j pour colonne 
        int i,j;
        int sizeOfTab = this.mMatricePieces.length;
        // Initialisation de la liste des portes disponibles
        List<Porte> portes = new ArrayList <Porte>();

        // Création des portes pour chaque cardinalité
        Orientation orientationPN = Orientation.NORD;
        Porte porteN = new Porte(orientationPN);

        Orientation orientationPS = Orientation.SUD;
        Porte porteS = new Porte(orientationPS);

        Orientation orientationPE = Orientation.EST;
        Porte porteE = new Porte(orientationPE);

        Orientation orientationPO = Orientation.OUEST;
        Porte porteO = new Porte(orientationPO);

        // List which contains all the doors 
        portes.add(porteN);
        portes.add(porteS);
        portes.add(porteE);
        portes.add(porteO);
        
        String texte ="";

        for ( i = 0; i<sizeOfTab; i++){

            for ( j = 0; j< sizeOfTab; j++){


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
                this.mMatricePieces[i][j] = new Piece(portes,i,j,this);
            }// End of pathway column
            
        } // End of pathway line

        return texte;
    }

    
    /**
     * 
     * @param tPiece
     * @return
     */
    public boolean isEntree(Piece tPiece){
        return( tPiece == this.mEntree);
    }

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
     * Getter du nombre de boutiques
     * 
     * @return int  Nombre de boutiques du labyrinthe 
     */

    public int getNbBoutiques(){
        return this.mNbBoutiques;
    }

    /**
     * Getter du personnage
     * 
     * @return Personnage personnage relié au Labyrinthe
     */
    public Personnage getPersonnage(){
        return this.mPersonnage;
    }

    public String ajouterPersonnage ( Personnage tPersonnage){
        String texte ="";
        // Ajout du personnage au labyrinthe
        this.mPersonnage = tPersonnage;
        // Phrase d'information auprès du user
        texte += "Vous avez choisi un nom délicieux pour votre avatar. félicitations ! Oubliez votre passé ! Vous êtes maintenant " + tPersonnage.getNom() + " le seul et l'unique.\n";
        texte += "Prenez soin de vous, valeureux guerrier ...Vous disposez de  " + tPersonnage.getPointDeVie() + " points de vie. Tâchez de les preserver ...\n";
        texte += "Vous pénétrez maintenant LE LABYRINTHE . Je vous souhaite d'en sortir...un jour...peut-être...";

        return texte;

    }


    


}