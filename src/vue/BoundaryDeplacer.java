package vue;

import controleur.ControleurDeplacer;

public class BoundaryDeplacer {

    ControleurDeplacer mControleur;

    public BoundaryDeplacer(ControleurDeplacer tControleur) {
        this.mControleur = tControleur;
    }
        
    public void deplacer(){

        private String choixPorte;
        private String listePortesDisponibles;

        listePortesDisponibles = this.mControleur.afficherPortes();


        do{

            System.out.println("Quelle porte choisissez vous de pousser ?");
            System.out.println("N - Porte Nord");
                    System.out.println("S - Porte Sud");
                    System.out.println("E - Porte Est");
            System.out.println("O - Porte Ouest");


            choixPorte = Clavier.entrerClavierString();


        }while(((!choixPorte.equals("N"))  &&  (!choixPorte.equals("E")) &&  (!choixPorte.equals("S")) &&  (!choixPorte.equals("O"))) || (!listePortesDisponibles.contains(choixPorte)));

        switch (choixPorte){

        
    }// Fin switch


}
    



}
