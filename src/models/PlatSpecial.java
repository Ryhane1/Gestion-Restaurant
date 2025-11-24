package models;

import models.Plat;

public class PlatSpecial extends Plat {
    private  String typeSpecial;
    public PlatSpecial(String nom, double prix, String typeSpecial) {
        super(nom, prix);
        this.typeSpecial=typeSpecial;

    }

    public String getTypeSpecial() {
        return typeSpecial;
    }

    public void setTypeSpecial(String typeSpecial) {
        this.typeSpecial = typeSpecial;
    }


    @Override
    public String toString() {
        return "PlatSpecial{" +
                "typeSpecial='" + typeSpecial + '\'' +
                '}';
    }
}
