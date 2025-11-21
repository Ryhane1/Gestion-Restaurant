package models;

public class Plat {
    private String nom;
    private double prix;


    public Plat() {

    }

    public Plat(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
    @Override
    public String toString(){
        return getNom() + "" + getPrix() + "dh" ;
    }
}