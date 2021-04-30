package controleur;

import java.util.List;

import environnement.Labyrinthe;
import environnement.Piece;
import environnement.Porte;
import protagonistes.Personnage;

/**
 * @author Perrine MORTIER
 * @version 2021/04/28
 */

public class Deplacement {

    private static Orientation mOrientation;

    /**
     * 
     * @param tPiece
     * @return une chaine de caractères : 
     * affichage des portes disponibles de la pièce 
     * où se trouve le personnage + choix de la porte à ouvrir
     */

    public static String choisirPorte( Piece tPiece){

        String choixPorte;
        Porte porteDisponible;
        Orientation orientationPorteDisponible;
        String texte = "";
        List <String> listePortesDisponibles = tPiece.getOrientation();


        System.out.println(afficherPortes(tPiece));
        //Personnalisation du script en fonction du nb de portes accessibles depuis la pièce où se trouve le joueur
        if ( tPiece.getNbPortes()>1){

            System.out.println("Vous avez maintenant le choix entre plusieurs portes. Le choix est rude. Quelle porte décidez-vous de pousser ? Derrière elle, le mystère reste entier ...\n");
            // Test sur la saisie Utilisateur restreinte aux options proposées
            do{

                System.out.println("Tapez N pour NORD, E pour EST, S pour SUD et O pour OUEST : \n");

                choixPorte = Clavier.entrerClavierString() ;

            }while ( ((!choixPorte.equals("N"))  &&  (!choixPorte.equals("E")) &&  (!choixPorte.equals("S")) &&  (!choixPorte.equals("O"))) || (!listePortesDisponibles.contains(choixPorte)));

            
            switch (choixPorte){

                case "N" :
                    mOrientation = Orientation.NORD;
                    break;

                case "E" :
                    mOrientation = Orientation.EST;
                    break;

                case "S" :
                    mOrientation = Orientation.SUD;
                    break;

                case "O" :
                    mOrientation = Orientation.OUEST;
                    break;

                 default :
                    System.out.println("Merci de faire un choix réaliste ... Ouvrez les yeux ! \n");
                    break;
            }// Fin switch


        }// Fin If

        else{
            System.out.println("Cette fois-ci, vous n'avez pas le choix. Vous devez pousser cette porte....\n");

            for(int i = 0 ; i < tPiece.getPortes().size(); i++){

                orientationPorteDisponible =  tPiece.getPortes().get(i).getOrientationPorte();
                porteDisponible = tPiece.getPortes().get(i);

                texte += porteDisponible.getOrientationPorte() + " s'ouvre...";

                switch (orientationPorteDisponible){

                    case NORD :
                        mOrientation = Orientation.NORD;
                        break;

                    case SUD :
                        mOrientation = Orientation.SUD;
                        break;

                    case EST :
                        mOrientation = Orientation.EST;
                        break;

                    case OUEST :
                        mOrientation = Orientation.OUEST;
                        break;
                }// Fin switch
            }
        }//Fin Else

        return texte;
    }

    /**
     * 
     * @param tPersonnage
     * @param tLabyrinthe
     * @return chaine de caractères décrivant portes dispo + choix personnage & ouverture de la porte choisie
     * 
     */
    public static String deplacerVers(Personnage tPersonnage, Labyrinthe tLabyrinthe) {
        String texte = "";
        Piece pieceActuelle, nouvellePiece;
        int ligne, colonne;

        pieceActuelle = tPersonnage.getPiece();

        ligne = pieceActuelle.getLigne();
        colonne = pieceActuelle.getColonne();

        texte += choisirPorte(pieceActuelle);

        switch (mOrientation){
            case NORD :
                ligne--;
                break;

            case SUD :
                ligne++;
                break;

            case EST :
                colonne++;
                break;

            case OUEST :
                colonne--;
                break;
        }

        nouvellePiece = tLabyrinthe.getPiece(ligne, colonne);
        texte += tPersonnage.ouvrirPorte(nouvellePiece);

        return texte;
    }


    /**
     * 
     * @param tPiece
     * @return chaine de caractères décrivant les postes disponibles en fonction de la pièce renseignée en paramètre
     */
    public static String afficherPortes(Piece tPiece){
        String texte ="";
        int nbPortes = tPiece.getNbPortes();

        texte += "Cher combattant, " + tPiece.getNbPortes() +" porte(s) s'offre(nt) à vous .\n";
        texte += "Voici: \n";

        // Faire une boucle qui récupère tous les éléments de la liste et qui les affiche
        // getPortes() retournant une liste des orientations de portes disponibles


        for(int i = 0 ; i < nbPortes; i++){
            texte += tPiece.getPortes().get(i) +"\n" ;
        }

        return texte;
    }
}