package protagonistes;

import java.util.ArrayList;
import java.util.List;

import controleur.Clavier;
import environnement.Labyrinthe;
import environnement.Porte;
import environnement.Tresor;
import environnement.TypeObjetVendu;
import environnement.TypeTresor;
import equipement.Arme;
import equipement.Armure;
import equipement.Potion;
import environnement.Boutique;

/**
 * <p>File : Personnage.java
 * <br>Code source de la classe Personnage</p>
 * 
 * @author Alexandre Coulais, Noëmie Suere, Perrine Mortier
 * @version 2021-4-23
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
     * @see Personnage#acheter(TypeObjetVendu)
     */
    private Arme mArme;

    /**
     * Armure possédée par le personnage
     * 
     * @see Personnage#equiperArmure(Armure)
     * @see Personnage#perdreArmure()
     * @see Personnage#acheter(TypeObjetVendu)
     * @see Personnage#reparerArmure()
     */
    private Armure mArmure;

    /**
     * Les potions possédées par le personnage
     * 
     * @see Personnage#boirePotion()
     * @see Personnage#acheter(TypeObjetVendu)
     */
    private List<Potion> mPotions = new ArrayList<Potion>();

    /**
     * Le labyrinthe dans lequel se déplace le personnage
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
        this.mBourse = 0;
        this.mNom = tNom;
        this.mArme = null;
        this.mArmure = null;
        this.mLabyrinthe = tLabyrinthe;
        this.mPiece = null;
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
        }

        tTresor.viderTresor();

        return texte;
    }

    /**
     * <p>Affiche la liste des potions, demande au joueur quelle potion doit boire son personnage
     * <br>et lui fait récupérer des points de vie </p>
     * @author Alexandre Coulais
     * 
     * @return String   Le texte à afficher
     */
    public String boirePotion() {
        int pointsRecup;
        Potion potionChoisie;
        String texte = "";

        System.out.println("Quelle potion souhaitez-vous boire ?");

        for (int i = 0; i < mPotions.size(); i++) {
            Potion potion = this.mPotions.get(i);

            System.out.println(i+1 + ") " + potion.afficherRecuperation() + "\n");
        }

        potionChoisie = this.mPotions.get(Clavier.entrerClavierInt()-1);
        pointsRecup = potionChoisie.getRecuperation();
        texte += this.recupererVie(pointsRecup);

        return texte;
    }

    public String prendreArme(Arme tArme) {
        String texte = "";
        // TODO
        return texte;
    }

    public String equiperArmure(Armure tArmure) {
        if(true){
            
        }
        String texte = "";
        // TODO mais je sais ce que je vais faire 
        return texte;
    }

    public String lacherArme() {
        String texte = "";
        //TODO
        return texte;
    }

    public String perdreArmure() {
        String texte = "";
        //TODO
        return texte;
    }

    /**
     * Changement de la pièce actuelle où se trouve le personnage
     * 
     * @param tPiece Nouvelle pièce
     */
    public void seDeplacer(Piece tPiece) {
        this.mPiece = tPiece;
    }

    public String acheter(TypeObjetVendu tType) {
        String texte = "";
        //TODO
        if(Boutique.acheterArticle()!=true){
            return"Vous ne pouvez pas acheter cet objet";

        }else{ 
                 
            return"Vous avez acheté "+tType+" et vous payez "/*+this.prix de l'article*/;
           /*this.mBourse-=prix de l'article*/;
        }
        return texte;
    }

    public String attaquer() {
        //mcombat de etre vivant +combat methode get monstre 
    
        String texte = "";
        //TODO
        return texte;
    }

    public String ouvrirPorte(Piece tPiece) {
        String texte = "";

        this.mPiece = tPiece;

        return texte;
    }

    public String reparerArmure() {
    String texte = "";
        if(this.mBourse < 250 ){
            texte=" Votre personnage n'as pas assez d'argent pour faire cela.";
            return texte;
        }else{
            if(mArmure!=null){ 
                mBoutiqueArmure.reparerArmure(mArmure);
                this.mBourse-=250;
                texte=" Votre armure est réparée.";
                return texte;
            }else{
                texte=" Vous ne possédez pas d'armure.";
            }
            
            return texte;
        }
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

        texte += this.quitteCombat();
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
        int pointsArmure = this.mArmure.getPointsProtection();
        int degatsRestants = tDegats - pointsArmure;

        texte += this.mArmure.encaisserDegat(tDegats);

        if (degatsRestants > 0) {
            texte += super.subirAttaque(degatsRestants);
        }

        return texte;
    }
}