package bibliotheque.utilitaires;

import bibliotheque.metier.Livre;
import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.TypeLivre;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LivreFactoryBeta {
    protected Scanner sc= new Scanner(System.in);
    public Ouvrage create() {

        System.out.println("titre");
        String titre= sc.nextLine();
        System.out.println("age minimum");
        int ageMin= 7;

        try{
            ageMin= sc.nextInt();
            sc.skip("\n");
        }catch(Exception e){
            System.out.println("Age invalide");
        }

        System.out.println("date de parution");
        LocalDate dp= Utilitaire.lecDate();
        System.out.println("prix de location");
        double ploc = 0.0;

        try{
            ploc = sc.nextDouble();
            sc.skip("\n");
        }catch(Exception e){
            System.out.println("Prix invalide");
        }
        System.out.println("langue");
        String langue=sc.nextLine();
        System.out.println("genre");
        String genre=sc.nextLine();

        //détails propres à la classe Livre
        System.out.println("isbn ");
        String isbn = sc.next();
        System.out.println("pages ");
        int nbrePages = 0;

        try{
            nbrePages = sc.nextInt();
            sc.skip("\n");
        }catch(Exception e){
            System.out.println("Nombre de pages invalide");
        }
        TypeLivre[] ttl = TypeLivre.values();
        List<TypeLivre> ltl = new ArrayList<>(Arrays.asList(ttl));
        int choix = Utilitaire.choixListe(ltl);
        TypeLivre tl = ttl[choix-1];
        System.out.println("résumé du livre :");
        String resume = sc.nextLine();
        Livre l=new Livre(titre,ageMin,dp,ploc,langue,genre,isbn,nbrePages,tl,resume);
        return l;
    }
}
