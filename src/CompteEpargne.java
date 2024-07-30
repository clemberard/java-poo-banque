public class CompteEpargne extends Compte {
    public double interet;

    CompteEpargne(Personne proprio, double solde, double interet) {
        super(proprio, solde);
        this.interet = interet;
    }

    public double getinteret() {
        return interet;
    }

    public void setInteret(double interet) {
        this.interet = interet;
    }

    public String toString() {
        return "Compte épargne de " + this.getProprietaire() + " : " + this.getSolde() + "€, taux d'intérêt : " + this.interet + "%";
    }
}
