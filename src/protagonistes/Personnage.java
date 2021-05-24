package protagonistes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import environnement.Labyrinthe;
import environnement.Piece;
import environnement.PieceCombat;
import environnement.Tresor;
import environnement.TypeTresor;
import equipement.Arme;
import equipement.Armure;
import equipement.Potion;
import vue.Clavier;

/**
 * <p>File : Personnage.java
 * <br>Code source de la classe Personnage</p>
 *
 * @author Alexandre Coulais, Noëmie Suere, Perrine Mortier
 * @version 2021-5-21
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
     * La labyrinthe dans lequel se déplace le personnage
     */
    private Labyrinthe mLabyrinthe;

    /**
     * La pièce actuelle où se trouve le personnage
     */
    private Piece mPiece;

    /**
     * <p>Constructeur de la classe Personnage</p>
     * @author Alexandre Coulais
     *
     * @param tNom Le nom du personnage
     */
    public Personnage(String tNom, Labyrinthe tLabyrinthe) {
        super(10);
        this.mNom = tNom;
        this.mLabyrinthe = tLabyrinthe;
        this.mBourse = 0;
    }

    /**
     * <p>Getter du nom du personnage</p>
     * @author Alexandre Coulais
     *
     * @return String   Le nom du personnage
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
     * @author Alexandre Coulais
     *
     * @return int  Nombre de pièces d'or possédées par le personnage
     */
    public int getPiecesOr() {
        return this.mBourse;
    }

    public boolean possedePotions() {
        return this.mPotions.size() != 0;
    }

    /**
     * <p>Fonction permettant au personnage de récupérer le contenu d'un coffre</p>
     * @author Alexandre Coulais
     *
     * @param tTresor
     *          <p>Le trésor dont on va récupérer le contenu.
     *          <br>Ici, le paramètre de généricité est laissé vide, cela ne présentant pas
     *          pas de problème apparent, l'action effectuée par la suite dépendant d'un autre
     *          paramètre</p>
     *
     * @return String   Le texte à afficher
     */
    public String obtenirTresor(Tresor<?> tTresor) {
        String texte = "";
        TypeTresor type = tTresor.getType();

        switch (type) {
            case ARME:
                texte += this.prendreArme((Arme) tTresor.getContenu());
                break;
            case ARMURE:
                texte += this.equiperArmure((Armure) tTresor.getContenu());
                break;
            case PIECE_OR:
                int piecesOr = (int) tTresor.getContenu();
                texte += "Vous avez obtenu " + piecesOr + " pièce(s) d'or !\n";
                this.mBourse += piecesOr;
                break;
            case POTION:
                texte += this.stockerPotion((Potion) tTresor.getContenu());

        }

        tTresor.viderTresor();

        return texte;
    }

    public boolean acheter(int tPrix) {
        boolean achat = this.mBourse >= tPrix;

        if (achat) {
            this.mBourse -= tPrix;
        }

        return achat;
    }

    /**
     * <p>Affiche la liste des potions, demande au joueur quelle potion doit boire son personnage
     * <br>et lui fait récupérer des points de vie </p>
     * @author Alexandre Coulais
     *
     * @return String   Le texte à afficher
     */
    public String boirePotion() {
        int i = 0, pointsRecup;
        Potion potionChoisie;
        String texte = "";

        for (Potion potion: this.mPotions) {
            i++;
            System.out.println(i + ") " + potion + "\n");
        }

        potionChoisie = this.mPotions.get(Clavier.entrerClavierInt("Quelle potion souhaitez-vous boire ?")-1);
        pointsRecup = potionChoisie.getRecuperation();
        texte += this.recupererVie(pointsRecup);

        return texte;
    }

    /**
     * Fonction d'ajout d'une potion à la liste de celles que possède le personnage
     * @author Alexandre Coulais
     *
     * @param tPotion La potion à ajouter
     * @return Le texte à afficher
     */
    public String stockerPotion(Potion tPotion) {
        String texte = "";

        if (tPotion != null) {
            this.mPotions.add(tPotion);
            texte += "Vous avez récupéré une potion de force " + tPotion.getRecuperation() + " !\n";
        }

        return texte;
    }

    /**
     * 
     * @author
     * 
     * @param tArme
     * @return
     */
    public String prendreArme(Arme tArme) {
        String texte = "";

        if (this.mArme == null) {
            texte += "Vous avez obtenu et équipé une arme de " + tArme.getDommageArme() + " points de dommage !\n";
            tArme.setProprietaire(this);
        } else {
            String question = "Vous possédez déjà une arme, souhaitez-vous la garder (G) ou la remplacer (R) ?";
            if (Clavier.demanderChoix(question, "G", "R")) {
                texte += "Vous conservez votre arme actuelle.\n";
            } else {
                texte += this.lacherArme();
                tArme.setProprietaire(this);
                texte += "Vous équipez l'arme que vous venez d'obtenir !\n";
                this.mArme = tArme;
            }
        }

        return texte;
    }

    /**
     * 
     * @author
     * 
     * @param tArmure
     * @return
     */
    public String equiperArmure(Armure tArmure) {
        String texte = "";

        if(this.mArmure == null){
            this.mArmure=tArmure;
            tArmure.setProprietaire(this);
            texte="Vous équipez votre armure.\n";
        }else{
            String question = "Vous possédez déjà une armure, souhaitez-vous la garder (G) ou la remplacer (R) ?";
            if (Clavier.demanderChoix(question, "G", "R")) {
                texte += "Vous conservez votre armure actuelle.\n";
            } else {
                texte += this.perdreArmure();
                tArmure.setProprietaire(this);
                texte += "Vous équipez l'armure que vous venez d'obtenir !\n";
                this.mArmure = tArmure;
            }
        }

        return texte;
    }

    /**
     * 
     * @author
     * 
     * @return
     */
    public String lacherArme() {
        if(this.mArme!=null){
            this.mArme = null;
        }
        return "Vous avez décidé de lâcher votre arme.\n";
    }

    /**
     * 
     * @author
     */
    public String perdreArmure() {
        if(this.mArmure!=null) {
            this.mArmure = null;
        }

        return "Vous retirez votre armue.\n";
    }

    /**
     * 
     * @return
     */
    public String reparerArmure() {
        String texte = "";
            if(this.mBourse < 250 ){
                texte=" Votre personnage n'as pas assez d'argent pour faire cela.";
                return texte;
            }else{
                if(mArmure!=null){ 
                    this.mArmure.reparer();
                    this.mBourse-=250;
                }else{
                    texte=" Vous ne possédez pas d'armure.";
                }
                
                return texte;
            }
        }    

    /**
     * Fonction de changement de pièce du personnage
     * @author Alexandre Coulais
     *
     * @param tPiece La nouvelle pièce
     * @return Le texte à afficher
     */
    public String ouvrirPorte(Piece tPiece) {
        String texte = "";
        int ligne = tPiece.getLigne();
        int colonne = tPiece.getColonne();

        if (tPiece instanceof PieceCombat) {
            PieceCombat piece = (PieceCombat) tPiece;
            piece.getCombat().rejointCombat(this);
            this.rejointCombat(piece.getCombat());
        }

        texte += "Vous changez de pièce, vous êtes désormais en position (" + ligne + " ; " + colonne + ").\n";

        this.mPiece = tPiece;

        return texte;
    }

    public String attaquer(){
        String txt="";
        int healthDamage = 1;
       
        // Step : create & init sentences List
        List<String> listOfSentences = new ArrayList<String>();
        listOfSentences.add("Vous lancez une attaque super saiyan divin !\n");
        listOfSentences.add("En toi la Force grandit. Avec courage, tes ennemis tu combats.\n");
        listOfSentences.add("Sois assez fort pour être quelqu'un que même les démons craindraient. \n");
        listOfSentences.add( "Si j'y vais ce n'est pas pour mourir, mais pour me prouver à moi-même que je suis encore vivant.Alors j'y vais ,et BIM !\n");
        listOfSentences.add( "Montjoie st denis, que je trépasse si je faiblis!\n");

        // Step : Generate random Number
        Random rand = new Random();
        int listOfSentencesSize = listOfSentences.size();

        int randNumber = rand.nextInt(listOfSentencesSize);

        if (this.mArme != null){
             healthDamage = this.mArme.getDommageArme();       
        }

    
        // Display one of List's sentences
        txt += listOfSentences.get((randNumber));

        EtreVivant monstreCombat = this.mCombat.getMonstre();
        txt += monstreCombat.subirAttaque(healthDamage);

        return txt;
    }

    /**
     * <p> Définition de la fonction mourir d'EtreVivant
     * <br>Fait quitter le combat au personnage </p>
     * @author Alexandre Coulais
     *
     * @see EtreVivant#mourir()
     *
     * @return String   Le texte à afficher
     */
    @Override
    public String mourir() {
        String texte = "";

        this.quitteCombat();
        texte += "Hélas, le monstre vous a terrassé ...\n";

        return texte;
    }

    /**
     * <p> Redéfinition de la fonction subirAttaque d'EtreVivant
     * <br>Calcul les degats réellement subits par le personnage
     * <br>et ceux à soustraire à son armure </p>
     * @author Alexandre Coulais
     *
     * @see EtreVivant#subirAttaque(int)
     *
     * @param tDegats   Les degats de l'attaque par le monstre
     *
     * @return String   Le texte à afficher
     */
    @Override
    public String subirAttaque(int tDegats) {
        String texte = "";
        
        if (this.mArmure != null) {
            int pointsArmure = this.mArmure.getPointsProtection();
            int degatsRestants = tDegats - pointsArmure;

            texte += this.mArmure.encaisserDegat(tDegats);

            if (degatsRestants > 0) {
                texte += super.subirAttaque(degatsRestants);
            }
        } else {
            texte += super.subirAttaque(tDegats);
        }

        return texte;
    }
}