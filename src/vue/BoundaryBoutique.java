package vue;

import controleur.ControleurBoutique;
import jdk.javadoc.internal.doclets.formats.html.resources.standard;
import vue.Clavier;

public class BoundaryBoutique {

    public static void choixBoutique(){ 

        int choix;

        do {
            choix = Clavier.entrerClavierInt("Choisir une boutique (entier entre 1 et 3 + 4= quitter)");
        } while (choix < 1 || choix > 4);

        if(choix!=4){

            ControleurBoutique.choixDeLaBoutique(choix);
        }   

    }


    public static void choixPrecis(){
        int choix2;

        do {
            choix2 = Clavier.entrerClavierInt("Choisir une boutique (entier entre 1 (achat) et 2 (réparation))");
        } while (choix2 < 1 || choix2 > 2);

            ControleurBoutique.choixBoutiqueArmure(choix2);

    }

    public static void choixArticle(){

        System.out.println(boutique.acheterArticle(boutique.choisirArticle()));


        
    }
}
