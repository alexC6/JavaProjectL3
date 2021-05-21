package controleur;
import javax.print.attribute.standard.QueuedJobCount;

import environnement.Boutique;

public class ControleurBoutique {
  
    
    public static void choixDeLaBoutique(int choix){

        
        Entree entree = (Entree) labyrinthe.getPiece(0, 0);
        Boutique<?> boutique = entree.getBoutique(choix);
        boutique.visiter(personnage);

        if(choix!=1){

            BoundaryBoutique.choixArticle();

        }else{

            ControleurBoutique.choixBoutiqueArmure();
        }

       
        
    }


    public static void choixBoutiqueArmure(int choix2){
        //choix 1=reparer et choix 2 = achat
        if(choix2!=1){

            BoundaryBoutique.choixArticle();


        }else{
            
            boutique.reparerArmure();

        }

    }

}
