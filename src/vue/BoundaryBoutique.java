package vue;

import controleur.ControleurBoutique;
import environnement.Entree;

public class BoundaryBoutique {
    public static void setEntree(Entree tEntree) {
        ControleurBoutique.setEntree(tEntree);
    }

    /**
     * Entrée dans la boutique
     */
    public static void entrerCentreCommercial() { 
        int choix;
        int piecesOrPerso = ControleurBoutique.getPiecesOr();

        System.out.println("Bienvenue au centre commercial. Vous possédez actuellement " + piecesOrPerso + " pièces d'Or.");
        System.out.println("Vous avez le choix parmi trois boutiques :");
        System.out.println("1) Boutique d'armes\n2) Boutique d'armures\n3) Boutique de potions\n");

        do {
            choix = Clavier.entrerClavierInt("Choisissez une boutique (entier entre 1 et 3, 4 pour quitter)");
        } while (choix < 1 || choix > 4);

        if (choix != 4) {
            ControleurBoutique.setBoutique(choix);
        }

        switch (choix) {
            case 1:
            case 3:
                choixArticle();
                break;
            case 2:
                choixPrecis();
        }
    }

    /**
     * La boutique d'armure possède 2 choix et cela nous permet de damnder au joueur si il veux reparer ou acheter des armures
     */
    public static void choixPrecis(){
        int choix;

        do {
            choix = Clavier.entrerClavierInt("Choisir une option pour la boutique d'armure (1 (achat) ou 2 (réparation))");
        } while (choix < 1 || choix > 2);

        ControleurBoutique.choixBoutiqueArmure(choix);
    }

    /**
     * Choix des articles disponible dans la boutique
     */
    public static void choixArticle(){
        int choix = 0, nbArticles = ControleurBoutique.getNbArticles();

        System.out.println(ControleurBoutique.afficherArticles());

        do {
            choix = Clavier.entrerClavierInt("Choisir l'article (entier entre 1 et " + nbArticles + ")");
        } while (choix < 1 || choix > nbArticles);

        System.out.println(ControleurBoutique.acheterArticle(choix));
    }
}