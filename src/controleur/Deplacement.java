package controleur;

public class Deplacement {

    private Orientation mOrientation;

    public Deplacement(Orientation tOrientation){
        this.mOrientation = tOrientation;
    }

    public String choisirPorte( Piece tPiece){
        char choixPorte;
        String texte = "";
        if ( tPiece.getNbPortes()>1){
            texte += "Vous avez maintenant le choix entre plusieurs portes. Le choix est rude. Quelle porte décidez-vous de pousser ? Derrière elle, le mystère reste entier ...";
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
            

        }
        else{
            texte += "Cette fois-ci, vous n'avez pas le choix. Vous devez pousser cette porte...\n";
            texte += tPiece.getPortes().afficherPorte();
        }
        return texte;

        
    }

    public String afficherPortes(Piece tPiece){
        String texte ="";
        texte += "Cher combattant, " + tPiece.getNbPortes() +" porte(s) s'offre(nt) à vous .\n";
        texte += "Voici: \n";
        texte += tPiece.getPortes();
        return texte;
    }
    
}