package environnement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import protagonistes.Personnage;
import vue.Clavier;

/**
 *
 * @author Noëmie Suere
 * @version 2021-4-28
 */

public class Boutique<T> implements Serializable {
    /**
     * Constructeur de Boutique
     */
    private int mNbObjets, mArticle;
    private Piece mPiece;
    private TypeObjetVendu mType;
    private Personnage mVisiteur;
    private List<T> mArticles = new ArrayList<T>();
    private List<Integer> mPrix = new ArrayList<Integer>();

    /**
     *
     * @param tArticle
     * @param tType
     */
    public Boutique(TypeObjetVendu tType){
        this.mType= tType;
        mPrix.add(250);
        mPrix.add(500);
        mPrix.add(1000);
        mPrix.add(2000);
        mPrix.add(5000);
    }

    public void ajouterArticle(List<T> tArticles){
       this.mArticles = tArticles;
       this.mNbObjets = tArticles.size();
    }

    /**
     *
     * @param tArticle
     * @return un boolean qui indique si l'article existe ou non
     */
    public boolean acheterArticle(T tArticle){
        if(mArticles.size()>0){
            mArticles.remove(tArticle);
            return true;
        }else{
            return false;
        }
    }


    public String reparerArmure(){
       String question="Voulez-vous réparer votre armure? (O pour réparer et N si vous êtes trop radin";
       String txt ="";
    
        // Si le perso choisit de réparer 
        if(Clavier.demanderChoix(question, "O", "N")){
            this.mVisiteur.reparerArmure();
            txt+="Votre armure est réparée. Retournez au combat valeureux guerrier!";
        }
        else{
          
            txt+="Merci d'être passé, revenez nous voir quand vous aurez de l'argent à dépenser ! On ne fait pas crédit Combattant !";
        }
        return txt;
    }

    public String articleAAcheter(){
        //choix de l'article a acheter
        //appeler en fonction de ce qu'il achete equiperarme ou armure ou potion
        

    }

}