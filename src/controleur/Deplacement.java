package controleur;

import environnement.Piece;

public class Deplacement {

    private Orientation mOrientation;

    public Deplacement(Orientation tOrientation){
        this.mOrientation = tOrientation;
    }

    public String choisirPorte( Piece tPiece){
        int choixPorte;
        String texte = "";

        texte += afficherPortes(tPiece);
        //Personnalisation du script en fonction du nb de portes accessibles dans la pièce où se trouve le joueur 
        
        if ( tPiece.getNbPortes()>1){
            
            texte += "Vous avez maintenant le choix entre plusieurs portes. Le choix est rude. Quelle porte décidez-vous de pousser ? Derrière elle, le mystère reste entier ...";
            // Test sur la saisie Utilisateur restreinte aux chars proposés
            
            do{
		
                System.out.println("Tapez N pour NORD, E pour EST, S pour SUD et O pour OUEST : ");
            
                choixPorte = Clavier.entrerClavierInt() ;
            
            }while ( (choixPorte != 'N')  ||  (choixPorte != 'E') ||  (choixPorte != 'S') ||  (choixPorte != 'O'));
            
            switch (choixPorte){
                
                case 'N' :
                    this.mOrientation = Orientation.NORD;
                    break;
                    
                case 'E' : 
                    this.mOrientation = Orientation.EST;
                    break;
                
                case 'S' :
                    this.mOrientation = Orientation.SUD;
                    break;	

                case 'O' :
                    this.mOrientation = Orientation.OUEST;
                 break;	

                 default :
                    System.out.println("Merci de faire un choix réaliste ... Ouvrez les yeux ! \n");
                    break;
            }// Fin switch
            

        }// Fin If

        else{
            texte += "Cette fois-ci, vous n'avez pas le choix. Vous devez pousser cette porte....\n";
            for(int i = 0 ; i < tPiece.getPortes().size(); i++){
                this.mOrientation = tPiece.getPortes().get(i);
            }
        }//Fin Else
        
        return texte;

        
    }

    public String afficherPortes(Piece tPiece){
        String texte ="";
        texte += "Cher combattant, " + tPiece.getNbPortes() +" porte(s) s'offre(nt) à vous .\n";
        texte += "Voici: \n";

        // Faire une boucle qui récupère tous les éléments de la liste et qui les affiche
        // getPortes() retournant une liste des orientations de portes disponibles
        
       
        for(int i = 0 ; i < tPiece.getPortes().size(); i++){
            texte += tPiece.getPortes().get(i) +"\n" ;
        }
    
        return texte;
    }
    
}