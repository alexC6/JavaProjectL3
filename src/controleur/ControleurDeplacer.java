package controleur;

import java.util.ArrayList;
import java.util.List;

import controleur.Deplacement;
import environnement.Piece;
import protagonistes.Personnage;


public class ControleurDeplacer {

    private Personnage mPersonnage;
    private Piece pieceActuelle;
    private String listePortes;


    public String afficherPortes() {

		pieceActuelle = this.mPersonnage.getPiece();

        listePortes = Deplacement.afficherPortes(pieceActuelle);


        return listePortes;
	}


public void deplacerVers(String choixPorte){

    Deplacement.deplacerVers(mPersonnage, pieceActuelle.getLabyrinthe());


}









    
}
