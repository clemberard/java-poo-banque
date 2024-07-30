public abstract class Compte {
    private Personne proprietaire;
    private final long numero;
    private double solde;

    static int compteur = 0;

    public Compte(Personne proprio, double solde) {
        compteur++;
        this.proprietaire = proprio;
        this.numero = compteur;
        this.solde = solde;
    }

    public Personne getProprietaire() {
        return proprietaire;
    }

    public double getSolde() {
        return solde;
    }

    public void setProprietaire(Personne proprietaire) {
        this.proprietaire = proprietaire;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public void retirer(double montant) {
        if (montant > solde) {
            System.out.println("Retrait impossible, solde insuffisant.");
        } else {
            new Transaction(this, montant, "Retrait");
            solde -= montant;
        }
    }

    public void crediter(double montant) {
        new Transaction(this, montant, "Crédit");
        solde += montant;
    }

    public void virement(Compte destination, double montant) {
        if (montant > solde) {
            System.out.println("Virement impossible, le solde est insuffisant.");
        } else {;
            this.retirer(montant);
            destination.crediter(montant);
        }
    }
}
