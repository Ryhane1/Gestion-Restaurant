package models;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private int clientID;
    private String nom;
    private List<Commande> commandes;
    public Client(int clientID, String nom) {
        this.clientID = clientID;
        this.nom = nom;
        this.commandes = new ArrayList<>();
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void passCommande(Commande commande){
        this.commandes.add(commande);
    }

    public void AfficherMenu(Restaurant r){
        r.afficheMenu();
    }


    @Override
    public String toString() {
        return "Client{" +
                "clientID=" + clientID +
                ", nom='" + nom + '\'' +
                ", commandes=" + commandes +
                '}';
    }
}
