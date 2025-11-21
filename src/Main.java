import models.*;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Restaurant restaurant = new Restaurant("Restaurant Beni Mellal");


    public static void main(String[] args) {

        System.out.println("*".repeat(40));
        System.out.println("Welcome in " + restaurant.getNom());
        System.out.println("*".repeat(40));


        int choix;

        do {

            System.out.println("============== List Menu =================");
            System.out.println("1-  Add Plat");
            System.out.println("2-  Add Plat Special");
            System.out.println("3-  Show Menu Plat");
            System.out.println("4-  Add Client");
            System.out.println("5-  Add Serveur");
            System.out.println("6-  enregister Commande");
            System.out.println("7-  Show All Clients");
            System.out.println("8-  Show All Commandes");
            System.out.println("9-  Show All Serveurs");
            System.out.println("0- Exit");

            System.out.print("Enter choice : ");
            choix = sc.nextInt();

            switch (choix) {
                case 1:
                    AddPat();
                    break;
                case 2:
                    AddPatSpeciale();
                    break;
                case 3:
                    ShowMenu();
                    break;
                case 4:
                    AddClient();
                    break;
                case 5:
                    AddServeur();
                    break;
                case 6:
                    AddCommande();
                    break;
                case 7:
                    ShowAllClients();
                    break;
                case 8:
                    PrintAllCommandes();
                    break;
                case 9:
                    ShowAllServeurs();
                    break;
                default:
                    System.out.println("choice not found");



            }


        } while (choix != 0);

    }

    // functions

    public static void AddPat() {
        Plat p = new Plat();
        System.out.print("Nom du plat: ");
        String nomPlat = sc.next();
        p.setNom(nomPlat);
        sc.nextLine();
        System.out.print("Prix: ");
        double prix = sc.nextDouble();
        p.setPrix(prix);
        restaurant.AjouterPlat(p);
        System.out.println("Plat ajoute succefully");
    }

    public static void AddPatSpeciale() {
        System.out.print("Nom du plat: ");
        String nomPlat = sc.next();
        sc.nextLine();
        System.out.print("Prix: ");
        double prix = sc.nextDouble();

        System.out.print("Enter typeSpecial : ");
        String typeSpecial = sc.next();
        sc.nextLine();
        restaurant.AjouterPlat(new PlatSpecial(nomPlat, prix, typeSpecial));
        System.out.println("Plat speacial ajoute succefully");
    }

    public static void ShowMenu() {
        restaurant.afficheMenu();
    }

    public static void AddClient() {
        System.out.print("Client ID: ");
        int cid = sc.nextInt();
        System.out.print("Nom du client: ");
        String cname = sc.next();
        sc.nextLine();
        restaurant.ajouterClient(new Client(cid, cname));
        System.out.println("Client ajoute.");
    }

    public static void AddServeur() {
        System.out.print("id Serveur :");
        int sid = sc.nextInt();
        System.out.print("Nom du serveur: ");
        String sname = sc.next();
        sc.nextLine();

        System.out.print("VIP? (y/n): ");
        String vip = sc.next();

        sc.nextLine();
        if (vip.equalsIgnoreCase("y")) {
            System.out.print("Avantage VIP: ");
            double avantage = sc.nextDouble();
            sc.nextLine();

            restaurant.ajouterServeur(new ServeurVIP(sid, sname, avantage));
        } else {
            restaurant.ajouterServeur(new Serveur(sid, sname));
        }
        System.out.println("Serveur ajoute.");
    }

    public static void AddCommande() {

        System.out.print("Enter id commande: ");
        int commandeId = sc.nextInt();

        System.out.print("Enter id Client: ");
        int clientId = sc.nextInt();


        Client client = null;
        for (Client c : restaurant.getClients()) {
            if (c.getClientID() == clientId) {
                client = c;
                break;
            }
        }

        if (client == null) {
            System.out.println("Client not found");
            return;
        }

        System.out.print("Enter id Serveur: ");
        int serveurId = sc.nextInt();


        Serveur serveur = null;

        for (Serveur s : restaurant.getServeurs()) {
            if (s.getServeurId() == serveurId) {
                serveur = s;
                break;
            }
        }
        if (serveur == null) {
            System.out.println("Serveur not found");
            return;
        }



         Commande cmd = new Commande(commandeId, client, serveur);

        System.out.print("Enter number of plats: ");
        int numberPlat = sc.nextInt();
        sc.nextLine();


        for (int i = 0; i < numberPlat; i++) {
              ShowMenu();
            System.out.print("Nom  plat " + (i + 1) + ": ");
            String nomp = sc.nextLine();


            Plat platF = null;

            for (Plat plat : restaurant.getListesPlats()) {
                if (plat.getNom().equalsIgnoreCase(nomp)) {
                    platF = plat;
                    break;
                }
            }

            if (platF != null) {
                cmd.ajouterPlat(platF);
            } else {
                System.out.println("Plat '" + nomp + "' not found!");
            }
        }

        restaurant.enregistrerCommande(cmd);
        System.out.println("Commande enregistrer succesfelly");
    }

    public static void ShowAllClients() {
        restaurant.afficherClients();
    }

    public static void PrintAllCommandes(){
        restaurant.afficherToutesCommandes();
    }

    public static void ShowAllServeurs() {
        restaurant.afficherServeurs();
    }





}
