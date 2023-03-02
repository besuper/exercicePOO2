package bibliotheque.metier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.time.temporal.ChronoUnit.DAYS;

public class Exemplaire {

    private String matricule;
    private String descriptionEtat;

    private Ouvrage ouvrage;
    private Rayon rayon;

    private List<Location> lloc= new ArrayList<>();


    public Exemplaire(String matricule, String descriptionEtat,Ouvrage ouvrage) {
        this.matricule = matricule;
        this.descriptionEtat=descriptionEtat;
        this.ouvrage = ouvrage;
        this.ouvrage.getLex().add(this);
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

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getDescriptionEtat() {
        return descriptionEtat;
    }

    public void setDescriptionEtat(String descriptionEtat) {
        this.descriptionEtat = descriptionEtat;
    }

     public Ouvrage getOuvrage() {
        return ouvrage;
    }

    public void setOuvrage(Ouvrage ouvrage) {
        if(this.ouvrage!=null) this.ouvrage.getLex().remove(this);
        this.ouvrage = ouvrage;
        this.ouvrage.getLex().add(this);
    }

    public Rayon getRayon() {
        return rayon;
    }

    public void setRayon(Rayon rayon) {
        if(this.rayon!=null) this.rayon.getLex().remove(this);
        this.rayon=rayon;
        this.rayon.getLex().add(this);
    }

    public List<Location> getLloc() {
        return lloc;
    }

    public void setLloc(List<Location> lloc) {
        this.lloc = lloc;
    }

    @Override
    public String toString() {
        return "Exemplaire{" +
                "matricule='" + matricule + '\'' +
                ", descriptionEtat='" + descriptionEtat + '\'' +
                ", ouvrage=" + ouvrage +
                ", rayon=" + rayon +
                '}';
    }

    public void modifierEtat(String etat){
        this.descriptionEtat = etat;
    }

    public Lecteur lecteurActuel(){
        if (this.lloc.size() == 0) {
            return null;
        }

        Location loc = this.lloc.get(this.lloc.size() - 1);

        if(loc.getDateRestitution() == null) {
            return loc.getLoueur();
        }

        return null;
    }
    public List<Lecteur> lecteurs(){
        List<Lecteur> temp_lecteurs = new ArrayList<>();

        for(Location location : this.lloc) {
            temp_lecteurs.add(location.getLoueur());
        }

        return temp_lecteurs;
    }

    public void envoiMailLecteurActuel(Mail mail){
        Lecteur actuel = lecteurActuel();

        if(actuel == null) {
            System.out.println("Aucun lecteur actuel");
            return;
        }

        System.out.println("Envoi mail a " + actuel.getNom());
        System.out.println(mail.getMessage());
    }
    public void envoiMailLecteurs(Mail mail){
        for(Lecteur l : lecteurs()) {
            System.out.println("Envoi mail a " + l.getNom());
            System.out.println(mail.getMessage());
        }
    }

    public boolean enRetard(){
        if(this.lloc.size() == 0) return false;

        Location l = this.lloc.get(this.lloc.size() - 1);

        double days_between = DAYS.between(l.getDateLocation(), l.getDateRestitution());

        boolean retard = switch (this.getOuvrage().getTo()) {
            case LIVRE -> days_between > 15;
            case CD -> days_between > 7;
            case DVD -> days_between > 3;
        };

        return retard;
    }

    public int joursRetard(){
        if(this.lloc.size() == 0) return 0;

        Location l = this.lloc.get(this.lloc.size() - 1);

        LocalDate tempDebut = l.getDateLocation();
        LocalDate end = l.getDateRestitution();

        LocalDate realEnd = switch (this.getOuvrage().getTo()) {
            case LIVRE -> l.getDateLocation().plusDays(15);
            case CD -> l.getDateLocation().plusDays(7);
            case DVD -> l.getDateLocation().plusDays(3);
        };

        int days_between = (int)DAYS.between(end, realEnd);

        if (days_between < 0) {
            return 0;
        }

        return days_between;
    }


    public boolean enLocation(){
        if(this.lloc.size() == 0) return false;

        Location l = this.lloc.get(this.lloc.size() - 1);

        return l.getDateRestitution() == null;
    }

}
