public class Transaction {
    private final int numero;

    public Compte compte;
    public double montant;
    public String type;
    public String date;

    static int compteur = 1;
    static Transaction[] transactions = new Transaction[100];

    Transaction(Compte compte, double montant, String type) {
        this.numero = compteur++;
        this.compte = compte;
        this.montant = montant;
        this.type = type;
        this.date = java.time.LocalDate.now().toString();

        addTransaction();
    }

    Transaction() {
        this.numero = compteur++;
    }

    @Override public String toString() {
        return "Transaction{" +
                "numero=" + numero +
                ", compte=" + compte +
                ", montant=" + montant +
                ", type='" + type + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public int getNumero() {
        return numero;
    }

    public Compte getCompte() {
        return compte;
    }

    public double getMontant() {
        return montant;
    }

    public String getType() {
        return type;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void addTransaction() {
        transactions[compteur] = this;
    }

    public static void historique() {
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                System.out.println(transaction.toString());
            }
        }
    }
}
