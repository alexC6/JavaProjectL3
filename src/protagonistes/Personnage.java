package protagonistes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import environnement.Piece;
import environnement.PieceCombat;
import environnement.Tresor;
import environnement.TypeTresor;
import equipement.Arme;
import equipement.Armure;
import equipement.Potion;
import vue.Clavier;
import vue.ConsoleColors;

/**
 * <p>
 * File : Personnage.java <br>
 * Code source de la classe Personnage
 * </p>
 *
 * @author Alexandre Coulais, Noëmie Suere, Perrine Mortier, Thomas Chabert
 * @version 2021-5-28
 */

public class Personnage extends EtreVivant {
    /**
     * La quantité de pièces d'or possédées par le personnage
     *
     * @see Personnage#getPiecesOr()
     */
    private int mBourse;

    /**
     * Nom du personnage
     *
     * @see Personnage#getNom()
     */
    private String mNom;

    /**
     * Arme possédée par le personnage
     *
     * @see Personnage#prendreArme(Arme)
     * @see Personnage#lacherArme()
     */
    private Arme mArme;

    /**
     * Armure possédée par le personnage
     *
     * @see Personnage#equiperArmure(Armure)
     * @see Personnage#perdreArmure()
     * @see Personnage#reparerArmure()
     */
    private Armure mArmure;

    /**
     * Les potions possédées par le personnage
     *
     * @see Personnage#boirePotion()
     */
    private List<Potion> mPotions = new ArrayList<Potion>();

    /**
     * La pièce actuelle où se trouve le personnage
     * 
     * @see Personnage#getPiece()
     */
    private Piece mPiece;

    /**
     * Constructeur de la classe Personnage
     *
     * @param tNom Le nom du personnage
     */
    public Personnage(String tNom) {
        super(10);
        this.mNom = tNom;
        this.mBourse = 0;
    }

    /**
     * Getter du nom du personnage
     *
     * @return String Le nom du personnage
     */
    public String getNom() {
        return this.mNom;
    }

    /**
     * Retourne la pièce dans laquelle se trouve le personnage
     *
     * @return Piece actuelle du personnage
     */
    public Piece getPiece() {
        return this.mPiece;
    }

    /**
     * Getter de la bourse du personnage
     *
     * @return int Nombre de pièces d'or possédées par le personnage
     */
    public int getPiecesOr() {
        return this.mBourse;
    }

    public boolean possedePotions() {
        return this.mPotions.size() != 0;
    }

    /**
     * Fonction permettant au personnage de récupérer le contenu d'un coffre
     *
     * @param tTresor Le trésor dont on va récupérer le contenu
     * @return String Le texte à afficher
     */
    public String obtenirTresor(Tresor<?> tTresor) {
        String texte = "";
        TypeTresor type = tTresor.getType();

        /**
         * Actions effectuées en fonction du type récupéré précédemment On construit le
         * texte à afficher à l'aide du retour des fonctions appelées On utilise les
         * fonctions déjà construites de récupération d'objets par le personnage pour
         * récupérer le contenu des trésors
         */
        switch (type) {
            case ARME:
                texte += ConsoleColors.YELLOW_BOLD_BRIGHT + this.prendreArme((Arme) tTresor.getContenu())
                        + ConsoleColors.RESET;
                break;
            case ARMURE:
                texte += ConsoleColors.YELLOW_BOLD_BRIGHT + this.equiperArmure((Armure) tTresor.getContenu())
                        + ConsoleColors.RESET;
                break;
            case PIECE_OR:
                int piecesOr = (int) tTresor.getContenu();
                texte += "Vous avez obtenu " + ConsoleColors.YELLOW_BOLD_BRIGHT + piecesOr + " pièce(s) d'or !\n"
                        + ConsoleColors.RESET;
                this.mBourse += piecesOr;
                break;
            case POTION:
                texte += ConsoleColors.YELLOW_BOLD_BRIGHT + this.stockerPotion((Potion) tTresor.getContenu())
                        + ConsoleColors.RESET;

        }

        tTresor.viderTresor();

        return texte;
    }

    /**
     * 
     * @param tPrix
     * @return un boolean
     */
    public boolean acheter(int tPrix) {
        boolean achat = this.mBourse >= tPrix;

        if (achat) {
            this.mBourse -= tPrix;
        }

        return achat;
    }

    /**
     * <p>
     * Affiche la liste des potions, demande au joueur quelle potion doit boire son
     * personnage <br>
     * et lui fait récupérer des points de vie
     * </p>
     *
     * @return String Le texte à afficher
     */
    public String boirePotion() {
        int i = 0, pointsRecup;
        Potion potionChoisie;
        String texte = "";

        // Affichage de la liste des potions pour savoir laquelle boire
        for (Potion potion : this.mPotions) {
            i++;
            System.out.println(i + ") " + potion + "\n");
        }

        // Utilisation de la fonction de demande à l'utilisateur
        // puis de récupération de points de vie des être vivants
        potionChoisie = this.mPotions.get(Clavier.entrerClavierInt("Quelle potion souhaitez-vous boire ?") - 1);
        pointsRecup = potionChoisie.getRecuperation();
        texte += this.recupererVie(pointsRecup);

        return texte;
    }

    /**
     * Fonction d'ajout d'une potion à la liste de celles que possède le personnage
     *
     * @param tPotion La potion à ajouter
     * @return Le texte à afficher
     */
    public String stockerPotion(Potion tPotion) {
        String texte = "";

        // Ajout de la potion passée en paramètre et construction du texte à afficher
        if (tPotion != null) {
            this.mPotions.add(tPotion);
            texte += "Vous avez récupéré une potion de force " + tPotion.getRecuperation() + " !\n";
        }

        return texte;
    }

    /**
     * Fonction qui permet d'équiper une arme et vérifie si il y en a deja une
     * d'équipé en demandant si le joueur veux la changer
     * 
     * @param tArme L'arme a équiper
     * @return Texte à afficher
     */
    public String prendreArme(Arme tArme) {
        String texte = "";

        if (this.mArme == null) {
            // Si le personnage ne possède pas d'arme, on l'équipe
            this.mArme = tArme;
            texte += "Vous avez obtenu et équipé une arme de " + tArme.getDommageArme() + " points de dommage !\n";
            tArme.setProprietaire(this);
        } else {
            // Sinon, on demande au joueur ce qu'il souhaite faire
            String question = "Vous possédez déjà une arme de force " + this.mArme.getDommageArme()
                    + ", souhaitez-vous la garder (G) ou la remplacer (R) par une arme de force "
                    + tArme.getDommageArme() + " ?";

            if (Clavier.demanderChoix(question, "G", "R")) {
                // S'il souhaite garder son arme actuelle, on ne fait rien
                texte += "Vous conservez votre arme actuelle.\n";
            } else {
                // Sinon, on lache l'arme précédente et on récupère la nouvelle
                texte += this.lacherArme();
                tArme.setProprietaire(this);
                texte += "Vous équipez l'arme que vous venez d'obtenir !\n";
                this.mArme = tArme;
            }
        }

        return texte;
    }

    /**
     * Fonction qui équipe une armure, vérfie si il y a deja une armure,
     * demande si le joueur veut la remplacer ou non.
     * 
     * @param tArmure L'armure à équiper
     * @return le texte 
     */
    public String equiperArmure(Armure tArmure) {
        String texte = "";

        if (this.mArmure == null) {
            // Si le personnage ne possède pas d'armure, on l'équipe
            this.mArmure = tArmure;
            tArmure.setProprietaire(this);
            texte = "Vous équipez votre armure (protection " + tArmure.getPointsProtection() + ").\n";
        } else {
            // Sinon, on demande au joueur ce qu'il souhaite faire
            String question = "Vous possédez déjà une armure de protection " + this.mArmure.getPointsProtection()
                    + ", souhaitez-vous la garder (G) ou la remplacer (R) par une armure de protection "
                    + tArmure.getPointsProtection() + " ?";

            if (Clavier.demanderChoix(question, "G", "R")) {
                // S'il souhaite garder son armure actuelle, on ne fait rien
                texte += "Vous conservez votre armure actuelle.\n";
            } else {
                // Sinon, on lache l'armure précédente et on récupère la nouvelle
                texte += this.perdreArmure();
                tArmure.setProprietaire(this);
                texte += "Vous équipez l'armure que vous venez d'obtenir !\n";
                this.mArmure = tArmure;
            }
        }

        return texte;
    }

    /**
     * Fonction qui fait lacher l'arme a son propriétaire
     * 
     * @return texte 
     */
    public String lacherArme() {
        if (this.mArme != null) {
            this.mArme = null;
        }

        return "Vous avez décidé de lâcher votre arme.\n";
    }

    /**
     * Fonction qui retire l'armure
     * 
     * @return Le texte
     */
    public String perdreArmure() {
        if (this.mArmure != null) {
            this.mArmure = null;
        }

        return "Vous retirez votre armue.\n";
    }

    /**
     * Fonction qui vérifie la bourse et qui appèle la fontion réparation si tout est bon (argent + existance de l'armure)
     * 
     * @return Le texte à afficher
     */
    public String reparerArmure() {
        String texte;

        if (mArmure == null) {
            // Si le personnage ne possède pas d'arme
            texte = "Vous n'avez pas d'armure à réparer ...";
        } else if (this.mBourse < 250) {
            // Si le personnage ne possède pas assez d'argent pour réparer son armure
            texte = "Vous n'avez pas assez d'argent pour faire cela.";
        } else {
            // Sinon, on répare l'armure et on retire au personnage le cout de la réparation
            texte = this.mArmure.reparer();
            this.mBourse -= 250;
        }

        return texte;
    }

    /**
     * Fonction de changement de pièce du personnage
     *
     * @param tPiece La nouvelle pièce
     * @return Le texte à afficher
     */
    public String ouvrirPorte(Piece tPiece) {
        String texte = "";
        int ligne = tPiece.getLigne();
        int colonne = tPiece.getColonne();

        // Si la pièce est une pièce de combat, on récupère cette salle, son combat, et
        // on le rejoint
        if (tPiece instanceof PieceCombat) {
            PieceCombat piece = (PieceCombat) tPiece;
            piece.getCombat().rejointCombat(this);
            this.rejointCombat(piece.getCombat());
        }

        // Construction du texte à afficher et affectation de la nouvelle pièce
        texte += "Vous changez de pièce, vous êtes désormais en position (" + ligne + " ; " + colonne + ").\n";

        this.mPiece = tPiece;

        return texte;
    }

    /**
     * Fontion qui permet d'infliger des dégats avec un Random
     * 
     * @return Un texte parmis ceux proposé
     */
    public String attaquer() {
        String txt = "";
        int healthDamage = 1;

        // Step : create & init sentences List
        List<String> listOfSentences = new ArrayList<String>();
        listOfSentences.add("Vous lancez une attaque super saiyan divin !\n");
        listOfSentences.add("En toi la Force grandit. Avec courage, tes ennemis tu combats.\n");
        listOfSentences.add("Sois assez fort pour être quelqu'un que même les démons craindraient. \n");
        listOfSentences.add(
                "Si j'y vais ce n'est pas pour mourir, mais pour me prouver à moi-même que je suis encore vivant.Alors j'y vais ,et BIM !\n");
        listOfSentences.add("Montjoie st denis, que je trépasse si je faiblis!\n");

        // Step : Generate random Number
        Random rand = new Random();
        int listOfSentencesSize = listOfSentences.size();

        int randNumber = rand.nextInt(listOfSentencesSize);

        if (this.mArme != null) {
            healthDamage = this.mArme.getDommageArme();
        }

        // Display one of List's sentences
        txt += listOfSentences.get((randNumber));

        EtreVivant monstreCombat = this.mCombat.getMonstre();
        txt += monstreCombat.subirAttaque(healthDamage);

        return txt;
    }

    /**
     * <p>
     * Définition de la fonction mourir d'EtreVivant <br>
     * Fait quitter le combat au personnage
     * </p>
     *
     * @see EtreVivant#mourir()
     *
     * @return String Le texte à afficher
     */
    @Override
    public String mourir() {
        String texte = "";

        this.quitteCombat();
        texte += "Hélas, le monstre vous a terrassé ...\n";

        return texte;
    }

    /**
     * <p>
     * Redéfinition de la fonction subirAttaque d'EtreVivant <br>
     * Calcul les degats réellement subits par le personnage <br>
     * et ceux à soustraire à son armure
     * </p>
     *
     * @see EtreVivant#subirAttaque(int)
     *
     * @param tDegats Les degats de l'attaque par le monstre
     * @return String Le texte à afficher
     */
    @Override
    public String subirAttaque(int tDegats) {
        String texte = "";

        if (this.mArmure != null && !(this.mArmure.estCassee())) {
            // Si le personnage possède une armure, on lui fait subir des degats
            // puis on fait subir au personnage ce que l'armure n'a pas pu encaisser
            int pointsArmure = this.mArmure.getPointsProtection();
            int degatsRestants = tDegats - pointsArmure;

            texte += this.mArmure.encaisserDegat(tDegats);

            if (degatsRestants > 0) {
                texte += super.subirAttaque(degatsRestants);
            }
        } else {
            // Sinon, le personnage subit tous les degats
            texte += super.subirAttaque(tDegats);
        }

        return texte;
    }
}