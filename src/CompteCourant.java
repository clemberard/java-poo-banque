public class CompteCourant extends Compte {
    public double decouvert;

    CompteCourant(Personne proprio, double solde, double decouvert) {
        super(proprio, solde);
        this.decouvert = decouvert;
    }

    public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }

    @Override
    public void retirer(double montant) {
        if (montant > this.getSolde() + decouvert) {
            System.out.println("Retrait impossible, solde insuffisant.");
        } else {
            new Transaction(this, montant, "Retrait");
            this.setSolde(this.getSolde() - montant);
        }
    }

    public String toString() {
        return "Compte courant de " + this.getProprietaire() + " : " + this.getSolde() + "€, découvert autorisé : " + this.decouvert + "€";
    }
}
