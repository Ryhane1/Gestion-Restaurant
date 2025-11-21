package models;

public class Serveur {
    private int serveurId;
    private String nom;
    public boolean estVIP = false;


    public Serveur(int serveurId, String nom) {
        this.serveurId = serveurId;
        this.nom = nom;
    }

    public int getServeurId() {
        return serveurId;
    }

    public void setServeurId(int serveurId) {
        this.serveurId = serveurId;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public double getReduction() {
        return 0;
    }

    public boolean isEstVIP() {
        return estVIP;
    }

    public void setEstVIP(boolean estVIP) {
        this.estVIP = estVIP;
    }


}