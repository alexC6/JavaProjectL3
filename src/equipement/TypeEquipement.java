package equipement;

public enum TypeEquipement {

    ARME ("ARME"),
    ARMURE ("ARMURE");

    private String mTypeEquipement;

    TypeEquipement(String tTypeEquipement){
        this.mTypeEquipement =tTypeEquipement;
    }

    public String toString(){

        return this.mTypeEquipement;
    }
}

