package environnement;

import protagonistes.Personnage;

import java.util.ArrayList;
import java.util.List;

import environnement.*;

public class Labyrinthe {

    // Voir avec Alex codage vecteur en java + vérifier l attribut personnage
   
    private List<Piece> mPieces = new ArrayList<Piece>();
    private int mNbPieces;
    private int mNbBoutiques;
    private Piece mSortie;
    private Piece mEntree;
    private Personnage mPersonnage;

    public Labyrinthe(int tNbPieces, List<Piece> tPieces,int tNbBoutiques,Piece tEntree , Piece tSortie){
        this.mNbPieces = tNbPieces;
        this.mPieces = tPieces;
        this.mNbBoutiques = tNbBoutiques;
        this.mEntree = tEntree;
        this.mSortie = tSortie;
        this.mPersonnage = null;

    }

    // A VOIR AVEC ALEX : selon moi, c'est le personnage qui change de pièce donc pourquoi cette methode ds class Labyrinthe ?
    public String changerDePiece(){
        String texte ="";
        return texte;
    }

    public String chargerLabyrinthe(int tLigne, int tCol){
        String texte ="";
        texte += "Le labyrinthe est en cours de création. Veuillez patienter, noble combattant ! \n";
        // VOIR AVEC ALEX COMMENT INTEGRER UN DELAI D ATTENTE
        this.mNbPieces = tLigne * tCol;
        texte += "Vous allez voyager au sein d'un labyrinthe composé de " + this.getNbPieces() + ".\n";       
        return texte;
    }

    String genererPiece(){
        
        String texte ="";
        
        return texte;
    }

    public boolean isEntree(Piece tPiece){
        return( tPiece == this.mEntree);
    }

    public boolean isSortie(Piece tPiece){
       return ( tPiece == this.mSortie);
    }

    public int getNbPieces(){
        return this.mNbPieces;
    }

    public int getNbBoutiques(){
        return this.mNbBoutiques;
    }

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