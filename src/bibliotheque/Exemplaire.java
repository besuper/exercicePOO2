package bibliotheque;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Exemplaire {

    private Long matricule;
    private String descriptionEtat;
    private Rayon rayon;
    private Ouvrage ouvrage;

    private List<Location> locations = new ArrayList<>();

    public Exemplaire(long matricule, String descriptionEtat, Rayon rayon, Ouvrage ouvrage) {
        this.matricule = matricule;
        this.descriptionEtat = descriptionEtat;
        this.rayon = rayon;
        this.ouvrage = ouvrage;
        this.ouvrage.getExemplaires().add(this);
    }

    public Long getMatricule() {
        return matricule;
    }

    public void setMatricule(Long matricule) {
        this.matricule = matricule;
    }

    public String getDescriptionEtat() {
        return descriptionEtat;
    }

    public void setDescriptionEtat(String descriptionEtat) {
        this.descriptionEtat = descriptionEtat;
    }

    public Rayon getRayon() {
        return rayon;
    }

    public void setRayon(Rayon rayon) {
        if(this.rayon != null) {
            this.rayon.getExemplaires().remove(this);
        }

        this.rayon = rayon;
        this.rayon.getExemplaires().add(this);
    }

    public Ouvrage getOuvrage() {
        return ouvrage;
    }

    public void setOuvrage(Ouvrage ouvrage) {
        this.ouvrage = ouvrage;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exemplaire that = (Exemplaire) o;
        return Objects.equals(matricule, that.matricule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricule);
    }

    @Override
    public String toString() {
        return "Exemplaire{" +
                "matricule=" + matricule +
                ", descriptionEtat='" + descriptionEtat + '\'' +
                ", rayon=" + rayon +
                ", ouvrage=" + ouvrage +
                ", locations=" + locations +
                '}';
    }
}
