package bibliotheque.utilitaires;


import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.TypeOuvrage;

import java.time.LocalDate;
import java.util.Scanner;

public  abstract class OuvrageFactory {
   protected Scanner sc= new Scanner(System.in);
   public Ouvrage create() throws Exception {

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
       return addDetail(titre, ageMin,dp,ploc, langue,  genre);
    }

    public abstract Ouvrage addDetail(String titre, int ageMin, LocalDate dateParution, double prixLocation, String langue, String genre) throws Exception;
}