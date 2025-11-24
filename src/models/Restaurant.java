package models;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String nom;
    private List<Plat> listesPlats;
    private List<Commande> listesCommandes;
    private List<Serveur> serveurs;
    private List<Client> clients;

    public Restaurant(String nom) {
        this.nom = nom;
        this.listesPlats = new ArrayList<>();
        this.listesCommandes = new ArrayList<>();
        this.serveurs = new ArrayList<>();
        this.clients = new ArrayList<>();
    }

    public List<Plat> getListesPlats() {
        return listesPlats;
    }

    public List<Commande> getListesCommandes() {
        return listesCommandes;
    }

    public List<Serveur> getServeurs() {
        return serveurs;
    }

    public List<Client> getClients() {
        return clients;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void AjouterPlat(Plat p){
        this.listesPlats.add(p);
    }

    public void enregistrerCommande(Commande c){
        this.listesCommandes.add(c);
    }

    public void ajouterServeur(Serveur serveur) {serveurs.add(serveur);}

    public void ajouterClient(Client client) {clients.add(client);}


    public void afficherServeurs() {
        System.out.println("=== SERVEURS ===");

        if (serveurs.isEmpty()) {
            System.out.println("Aucun serveur");
            return;
        }

        for (Serveur serveur : serveurs) {
            System.out.println("ID : " + serveur.getServeurId());
            System.out.println("Nom : " + serveur.getNom());

            if (serveur instanceof ServeurVIP) {
                System.out.println("Type : VIP");
                System.out.println("Reduction : " + ((ServeurVIP) serveur).getReduction());
            } else {
                System.out.println("Type : Normal");
            }

            System.out.println("------------------------------");
        }
    }


    public void afficherClients() {
        System.out.println("=== CLIENTS ===");
        if (clients.isEmpty()) {
            System.out.println("Aucun client enregistre.");
        } else {
            for (Client client : clients) {
                System.out.println("id Client : "  + client.getClientID() + " Nom : " + client.getNom() + " - Commandes: " + client.getCommandes().size());
            }
        }
    }

    public void afficherToutesCommandes() {
        System.out.println("=== Commandes ===");

        if (listesCommandes.isEmpty()) {
            System.out.println("Aucune commande");
            return;
        }

        for (Commande cmd : listesCommandes) {
            cmd.afficherDetails();
        }

    }



    public void afficheMenu() {
        System.out.println("===== Menu du Restaurant =====");

        for (Plat p : listesPlats) {


            System.out.print(" - Nom :"  + p.getNom() + " - Prix :" + p.getPrix() + " DH");


            if (p instanceof PlatSpecial) {
                PlatSpecial ps = (PlatSpecial) p;
                System.out.print(" - Type spécial : " + ps.getTypeSpecial());
            }

            System.out.println();
        }

        System.out.println("=".repeat(40));
    }


    @Override
    public String toString() {
        return "Restaurant{" +
                "nom='" + nom + '\'' +
                ", listesPlats=" + listesPlats +
                ", listesCommandes=" + listesCommandes +
                ", serveurs=" + serveurs +
                ", clients=" + clients +
                '}';
    }
}
