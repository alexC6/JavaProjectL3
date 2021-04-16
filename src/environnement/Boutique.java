package environnement;
import java.lang.ProcessBuilder.Redirect.Type;
import java.util.ArrayList;
import java.util.List;
import equipement.*;
import environnement.TypeObjetVendu;
public class Boutique<T> {
    private int mPiece, mNbObjets;
    private TypeObjetVendu mType;
    private List<T> mArticles = new ArrayList<T>();

    public Boutique(T tArticle, TypeObjetVendu tType){
        mArticles.add(tArticle);
       this.mType= tType;
    }

    public boolean acheterArticle(T tArticle){
        if(mArticles.size()>0){
            mArticles.remove(tArticle);
            return true;
        }else{
            return false;
        }

    }

    public String reparerArmure(){
        if(/*personnage ne possède pas d'armure*/){ 
        /*return "on ne peu pas reparer"
        }
        else{
        reparer armure + enlever argent (250 po) return" votre armure est reparer "}
         */

    }


}