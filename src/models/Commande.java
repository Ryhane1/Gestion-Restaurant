package models;

import java.util.ArrayList;
import java.util.List;

public class Commande {
    private int commandeId;
    private double total;
    private Client client;
    private double heure;
    private Serveur serveur;
    private List<Plat> plats = new ArrayList<>();
    private ArrayList<Commande> calcultotal = new ArrayList<>();

    public Commande(int commandeId, double total, double heure ,Client client , Serveur serveur) {
        this.commandeId = commandeId;
        this.total = total;
        this.heure = heure;
        this.client = client;
        this.serveur = serveur;

    }

    public Commande(int commandeId, Client client, Serveur serveur) {

        this.commandeId = commandeId;
        this.client = client;
        this.serveur = serveur;

    }

    public int getCommandeId() {
        return commandeId;
    }

    public void setCommandeId(int commandeId) {
        this.commandeId = commandeId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getHeure() {
        return heure;
    }

    public void setHeure(double heure) {
        this.heure = heure;
    }
    public int getServeurId() {
        return serveur.getServeurId();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Serveur getServeur() {
        return serveur;
    }

    public void setServeur(Serveur serveur) {
        this.serveur = serveur;
    }

    public List<Plat> getPlats() {
        return plats;
    }

    public void ajouterPlat(Plat p) {
        plats.add(p);
    }
    public double calculerTotal() {
        double total = 0;
        for (Plat p : plats) {
            total += p.getPrix();
        }

        System.out.println(total);
        return total;

    }

    public void afficherDetails() {
        System.out.println("Commande # " + commandeId);
        System.out.println("Client : " + client.getNom());
        System.out.println("Serveur : " + serveur.getNom());
        System.out.println("Plats : ");
        for (Plat p : plats)
            System.out.println(" - " + p );

        System.out.println("TOTAL = " + calculerTotal() + "dh");
    }
}