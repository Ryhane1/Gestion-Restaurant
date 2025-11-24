package models;

public class ServeurVIP extends Serveur {
    private double reduction;

    public ServeurVIP(int id, String nom, double reduction) {
        super(id, nom);
        this.reduction = reduction;
    }
    @Override
    public double getReduction() {
        return reduction;
    }
}