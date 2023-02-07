package bibliotheque;

import java.time.LocalDate;
import java.util.Objects;

public class Livre extends Ouvrage {

    private String isbn;
    private int nombrePages;
    private TypeLivre typeLivre;
    private String resume;

    public Livre(String titre, byte ageMin, String dateParution, TypeOuvrage typeOuvrage, double prixLocation, String langue, String genre, String isbn, int nombrePages, TypeLivre typeLivre, String resume) {
        super(titre, ageMin, dateParution, typeOuvrage, prixLocation, langue, genre);
        this.isbn = isbn;
        this.nombrePages = nombrePages;
        this.typeLivre = typeLivre;
        this.resume = resume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livre livre = (Livre) o;
        return Objects.equals(isbn, livre.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}
