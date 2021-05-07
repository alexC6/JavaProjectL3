package environnement;
import java.lang.ProcessBuilder.Redirect.Type;
import java.util.ArrayList;
import java.util.List;
import equipement.*;
import environnement.TypeObjetVendu;
/**
 *
 * @author Noëmie Suere
 * @version 2021-4-28
 */



public class Boutique<T> {
    /**
     * Constructeur de Boutique
     */
    private int mPiece, mNbObjets;
    private TypeObjetVendu mType;
    private List<T> mArticles = new ArrayList<T>();
    private List<Integer> mPrix = new ArrayList<Integer>();
    mPrix.add(250);
    mPrix.add(500);
    mPrix.add(1000);
    mPrix.add(2000);
    mPrix.add(5000);
   
    /**
     *
     * @param tArticle
     * @param tType
     */
    public Boutique(List<T> tArticle, TypeObjetVendu tType){
        mArticles=tArticle;
        this.mType= tType;

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
        texte="";
       //TODO
        return texte;
    }


    private void genererArticle(){

           switch(mType){

            case POTION: 
                for(int i=0; i<5; i++ ) {
                    this.mArticles.add(new Potion());
                }
            case ARME: 
                for(int i=0; i<5; i++ ) {
                    this.mArticles.add(new Arme());
                }
            case ARMURE: 
                for(int i=0; i<5; i++ ) {
                    this.mArticles.add(new Armure());
                }           
        
        
        }
    }




}