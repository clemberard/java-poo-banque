public class Personne {
    public String nom;
    public String prenom;
    public enum etatCivil {
        MARIE, CELIBATAIRE, DIVORCE, VEUF, CONCUBINAGE
    }

    Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    Personne() {
        this.nom = "";
        this.prenom = "";
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String toString() {
        return nom + ' ' + prenom;
    }
}
