import java.util.Scanner;

public class Main {
    static int compteurClients = 1;
    static int compteurComptes = 1;
    static Personne[] clients = new Personne[100];
    static Compte[] comptes = new Compte[100];

    public static void main(String[] args) {
        Scanner menuPrincipal = new Scanner(System.in);
        System.out.println("Que voulez-vous faire : 1: Créer un client, 2: Aller sur un client, 3: Afficher toutes les transactions");
        int number = Integer.parseInt(menuPrincipal.nextLine());
        switch (number) {
            case 1:
                Personne client = creerClient();
                clients[compteurClients] = client;
                compteurClients++;
                main(args);
            case 2:
                int choix_user = detailsClients(args);
                detailClient(clients[choix_user]);
            case 3:
                System.out.println("Voici les transactions :");
                for (int transac = 1; transac < Transaction.compteur; transac++) {
                    System.out.println(Transaction.transactions[transac]);
                }
                main(args);
            default:
                System.out.println("Choix incorrect menu principal");
                break;
        }
    }

    public static Personne creerClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le nom du client : ");
        String nom = scanner.nextLine();
        System.out.println("Entrez le prénom du client : ");
        String prenom = scanner.nextLine();
        Personne personne = new Personne(nom, prenom);
        System.out.println("Le client " + personne.toString() + " a été créée.");
        System.out.println(" ");
        return personne;
    }

    public static int detailsClients(String[] args) {
        Scanner choixClients = new Scanner(System.in);
        System.out.println("Voici les clients :");
        int cptClient;
        for (cptClient = 1; cptClient < compteurClients; cptClient++) {
            System.out.println(cptClient + ": " + clients[cptClient]);
        }
        System.out.println(cptClient + ": Retour");
        int choixClient = Integer.parseInt(choixClients.nextLine());
        if (choixClient == cptClient) {
            main(args);
        }
        return choixClient;
    }

    public static void detailClient(Personne client) {
        Scanner menuDetail = new Scanner(System.in);
        System.out.println("Voici les détails de " + client + " :");
        System.out.println("1: Créer un compte courant, 2: Créer un compte epargne, 3: Voir les comptes, 4: Effectuer une transaction, 5: Retour");
        int number = Integer.parseInt(menuDetail.nextLine());
        switch (number) {
            case 1:
                // Créer un compte courant
                Scanner scannerCourant = new Scanner(System.in);
                System.out.println("Votre solde : ");
                int soldeCourant = Integer.parseInt(scannerCourant.nextLine());
                System.out.println("Votre decouvert : ");
                int decouvert = Integer.parseInt(scannerCourant.nextLine());
                CompteCourant compteCourant = new CompteCourant(client, soldeCourant, decouvert);
                comptes[compteurComptes] = compteCourant;
                compteurComptes++;
                System.out.println("Le compte courant de " + client + " a été créé.");
                System.out.println(" ");
                detailClient(client);
            case 2:
                // Créer un compte épargne
                Scanner scannerEpargne = new Scanner(System.in);
                System.out.println("Votre solde : ");
                int soldeEpargne = Integer.parseInt(scannerEpargne.nextLine());
                System.out.println("Votre taux : ");
                int taux = Integer.parseInt(scannerEpargne.nextLine());
                CompteEpargne compteEpargne = new CompteEpargne(client, soldeEpargne, taux);
                comptes[compteurComptes] = compteEpargne;
                compteurComptes++;
                System.out.println(" ");
                detailClient(client);
            case 3:
                // Voir les comptes
                System.out.println("Voici les comptes de " + client + " :");
                for (int i = 1; i < compteurComptes; i++) {
                    if (comptes[i].getProprietaire() == client) {
                        System.out.println("- " + comptes[i]);
                    }
                }
                System.out.println(" ");
                detailClient(client);
            case 4:
                // Faire une transaction
                Scanner menuTransaction = new Scanner(System.in);
                System.out.println("Que voulez-vous faire : 1: Retirer, 2: Créditer, 3: Virement, 4: Retour");
                int choix = Integer.parseInt(menuTransaction.nextLine());
                switch (choix) {
                    case 1:
                        Scanner menuRetirer = new Scanner(System.in);
                        System.out.println("Quel est le montant du retrait ?");
                        double montantRetrait = Double.parseDouble(menuRetirer.nextLine());

                        System.out.println("Sur quel compte ?");
                        for (int i = 1; i < compteurComptes; i++) {
                            if (comptes[i].getProprietaire() == client) {
                                System.out.println("- " + comptes[i]);
                            }
                        }
                        int choixCompte = Integer.parseInt(menuRetirer.nextLine());

                        comptes[choixCompte].retirer(montantRetrait);
                        System.out.println("Il reste " + comptes[choixCompte].getSolde() + "€ sur le compte.");
                        System.out.println(" ");
                        detailClient(client);
                    case 2:
                        Scanner menuCrediter = new Scanner(System.in);
                        System.out.println("Quel est le montant du crédit ?");
                        double montantCredit = Double.parseDouble(menuCrediter.nextLine());

                        System.out.println("Sur quel compte ?");
                        for (int i = 1; i < compteurComptes; i++) {
                            if (comptes[i].getProprietaire() == client) {
                                System.out.println("- " + comptes[i]);
                            }
                        }
                        int choixCompteCredit = Integer.parseInt(menuCrediter.nextLine());

                        comptes[choixCompteCredit].crediter(montantCredit);
                        System.out.println("Il y a " + comptes[choixCompteCredit].getSolde() + "€ sur le compte.");
                        System.out.println(" ");
                        detailClient(client);
                    case 3:
                        Scanner menuVirement = new Scanner(System.in);
                        System.out.println("Quel est le montant du virement ?");
                        double montantVirement = Double.parseDouble(menuVirement.nextLine());

                        System.out.println("Depuis quel compte ?");
                        for (int i = 1; i < compteurComptes; i++) {
                            if (comptes[i].getProprietaire() == client) {
                                System.out.println(i + ": " + comptes[i]);
                            }
                        }
                        int choixCompteVirement = Integer.parseInt(menuVirement.nextLine());

                        System.out.println("Vers quel compte ?");
                        for (int i = 1; i < compteurComptes; i++) {
                            System.out.println(i + ": " + comptes[i]);
                        }
                        int destination = Integer.parseInt(menuVirement.nextLine());

                        comptes[choixCompteVirement].virement(comptes[destination], montantVirement);
                        System.out.println("Il reste " + comptes[choixCompteVirement].getSolde() + "€ sur le compte.");
                        System.out.println("Il y a maintenant " + comptes[destination].getSolde() + "€ sur le compte de " + comptes[destination].getProprietaire());
                        System.out.println(" ");
                        detailClient(client);
                    case 4:
                        detailClient(client);
                    default:
                        System.out.println("Choix incorrect transaction");
                        break;
                }
            case 5:
                int choix_user = detailsClients(null);
                detailClient(clients[choix_user]);
            default:
                System.out.println("Choix incorrect détail client");
                break;
        }
    }
}