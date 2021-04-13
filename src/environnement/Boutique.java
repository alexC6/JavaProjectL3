package environnement;
import java.lang.ProcessBuilder.Redirect.Type;
import java.util.ArrayList;
import java.util.List;
import equipement.*;
import environnement.TypeObjetVendu;
public class Boutique<T> {
    private int mPiece, mNbObjets;
    private Type mType;
    private List<T> mArticles = new ArrayList<T>();

    public Boutique(T tType){
       this.mType= tType;

    }

    public String acheterArticle(){

    }

    public String reparerArmure(){


    }


}