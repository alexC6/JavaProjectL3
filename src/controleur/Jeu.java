package controleur;

import environnement.Labyrinthe;

public class Jeu {

    private Labyrinthe mLabyrinthe;
    private String mPartie;
    private int mNbSauvegarde;

    public Jeu(Labyrinthe tLabyrinthe, String tPartie, int tSauveGarde){
        this.mLabyrinthe = tLabyrinthe;
        this.mPartie = tPartie;
        this.mNbSauvegarde = tSauveGarde;
    }


    public void lancerJeu(){

    }


    public void creerPartie(){
            

    }
    
    public void reprendrePartie(){

    }

    public void sauvegarderPartie(){
    }

    public void effacerPartie(){
        if (this.mPartie != null){
            this.mPartie = null;
        }
    }

    //Accesseur au nbre de sauvegarde(s) 
    public int getNbSauvegarde(){
        return this.mNbSauvegarde;

    }

    public String afficherRegles(){
        String texte="";
        return texte;

    }
}