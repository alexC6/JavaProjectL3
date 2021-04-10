package controleur;

import controleur.Clavier;

import environnement.Labyrinthe;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Jeu {

    private Labyrinthe mLabyrinthe;
    private String mPartie;
    private int mNbSauvegarde;

    public Jeu(Labyrinthe tLabyrinthe, String tPartie, int tSauveGarde){
        this.mLabyrinthe = tLabyrinthe;
        this.mPartie = tPartie;
        this.mNbSauvegarde = tSauveGarde;
    }

    public int getChoix(){
        return ;
    }


    public String lancerJeu(){

        int choixLancementJeu;
        String texte ="Bienvenue Courageux Chevalier \n";
        texte += " Menu : \n";
        texte += "1 : Nouvelle Partie \n";
        texte += "2 : Charger Partie  \n";
        texte += "3 : Supprimer Partie \n";

        // Boucle de contrôle du choix utilisateur devant correspondre aux options proposées dans le menu
        do{

            texte += " Quel est votre choix Chevalier ? \n";

            choixLancementJeu = Clavier.entrerClavierInt() ;
        
            //Le contrôle du type de la saisie est effectué par la class Clavier
            System.out.println("Vous avez saisi : " + choixLancementJeu);

        } while ( choixLancementJeu <1 && choixLancementJeu>3);


        
        switch(choixLancementJeu){

            // Au lancement, l'utilisateur choisit de creer une nvlle partie
            case 1 :
                this.mPartie = creerPartie(tName);
                break;


            // Au lancement, l'utilisateur choisit de reprendre une  partie préalablement sauvegardée
            case 2 :
                
                break;
            
            // Au lancement, l'utilisateur choisit de supprimer une ou des partie(s) préalablement sauvegardée(s)
            case 3 :
                break;

            default :
                break;
        }
            

        return texte;

    }


    public String creerPartie(String tName){
        String texte ="";
        return texte;
    }
    
    public String reprendrePartie(){
        String texte ="";
        return texte;

    }

    public String sauvegarderPartie(){
        String texte ="";
        return texte;
    }

    public String effacerPartie(){
        String texte ="";
        return texte;
        
    }

    //Accesseur au nbre de sauvegarde(s) 
    public int getNbSauvegarde(){
        return this.mNbSauvegarde;

    }

    public String afficherRegles(){
        String texte="";
        return texte;

    }

    public String afficherListeParties(){
        String texte ="";
        int nbSvg;
        
        nbSvg = this.getNbSauvegarde();

        for ( int i = 0 ; i<nbSvg; i++){
            texte += ( (i+1) + ":" + this.mPartie );
        }
        return texte;
    }
}