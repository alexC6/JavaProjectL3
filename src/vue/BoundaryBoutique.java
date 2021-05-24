package vue;

import controleur.ControleurBoutique;
import environnement.Entree;

public class BoundaryBoutique {
    private static Entree mEntree;

    public static void setEntree(Entree tEntree) {
        mEntree = tEntree;
    }

    public static void entrerCentreCommercial() { 
        int choix;

        do {
            System.out.println("Bienvenue au centre commercial. Vous avez le choix parmi trois boutiques :");
            System.out.println("1) Boutique d'armes\n2) Boutique d'armures\n3) Boutique de potions\n");
            choix = Clavier.entrerClavierInt("Choisissez une boutique (entier entre 1 et 3, 4 pour quitter)");
        } while (choix < 1 || choix > 4);

        if (choix != 4) {
            ControleurBoutique.setBoutique(choix, mEntree);
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

    public static void choixPrecis(){
        int choix;

        do {
            choix = Clavier.entrerClavierInt("Choisir une option pour la boutique d'armure (1 (achat) ou 2 (réparation))");
        } while (choix < 1 || choix > 2);

        ControleurBoutique.choixBoutiqueArmure(choix);
    }

    public static void choixArticle(){
        int choix = 0, nbArticles = ControleurBoutique.getNbArticles();

        System.out.println(ControleurBoutique.afficherArticles());

        do {
            choix = Clavier.entrerClavierInt("Choisir l'article (entier entre 1 et " + nbArticles + ")");
        } while (choix < 1 || choix > nbArticles);

        System.out.println(ControleurBoutique.acheterArticle(choix));
    }
}