package bibliotheque;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

public class DVD extends Ouvrage{

    private long code;
    private String dureeTotale;
    private byte nbreBonus;
    private List<String> autresLangues;
    private List<String> sousTitres;

    public DVD(String titre, byte ageMin, String dateParution, TypeOuvrage typeOuvrage, double prixLocation, String langue, String genre, long code, String dureeTotale, byte nbreBonus, List<String> autresLangues, List<String> sousTitres) {
        super(titre, ageMin, dateParution, typeOuvrage, prixLocation, langue, genre);
        this.code = code;
        this.dureeTotale = dureeTotale;
        this.nbreBonus = nbreBonus;
        this.autresLangues = autresLangues;
        this.sousTitres = sousTitres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DVD dvd = (DVD) o;
        return code == dvd.code;
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
