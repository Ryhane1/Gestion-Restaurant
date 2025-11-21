import java.util.ArrayList;
import java.util.List;

    public class Clients {
        private int clientID;
        private String nom;
        private List<Commande> commandes;

        public Clients(int clientID, String nom) {
            this.clientID= clientID;
            this.nom = nom;
            this.commandes = new ArrayList<>();
        }

        public void ajouterCommande(Commande c) {
            commandes.add(c);
        }

        public String getNom() { return nom; }
    }

