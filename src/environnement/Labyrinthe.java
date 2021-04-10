import protagonistes.Personnage;

public class Labyrinthe {

    // Voir avec Alex codage vecteur en java + vérifier l attribut personnage
   
    private int mNbPieces;
    private int mNbBoutiques;
    private Piece mSortie;
    private Piece mEntree;
    private Personnage mPersonnage;

    public Labyrinthe(int tNbpieces, int tNbBoutiques,Piece tEntree , Piece tSortie){
        // Ajouter le vecteur voir avec Alex
        this.mNbPieces = tNbpieces;
        this.mNbBoutiques = tNbBoutiques;
        this.mEntree = tEntree;
        this.mSortie = tSortie;
        this.mPersonnage = null;

    }

    public String changerDePiece(){
        String texte ="";
        return texte;
    }

    public String chargerLabyrinthe(int tLigne, int tCol){
        String texte ="";
        return texte;
    }

    String genererPiece(){
        String texte ="";
        return texte;
    }

    public boolean isEntree(){
        return();
    }

    public boolean isSortie(){
        // Retourne vraie quand 
        return ( );
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
        texte += "Vous avez choisi un nom délicieux pour votre avatar. félicitations ! Oubliez votre passé ! Vous êtes maintenant " + tPersonnage.getName() + " le seul et l'unique.\n";
        texte += "Prenez soin de vous, valeureux guerrier ...Vous disposez de  " + tPersonnage.getPointDeVie() + " points de vie. Tâchez de les preserver ...\n";
        texte += "Vous pénétrez maintenant LE LABYRINTHE . Je vous souhaite d'en sortir...un jour...peut-être...";

        return texte;

    }


    


}