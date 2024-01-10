package gestiondeboutique.actions;

import gestiondeboutique.main.GestionDeBoutique;

import java.util.Scanner;
import java.sql.*;

import static gestiondeboutique.actions.AddArticle.trouverCode;
import static gestiondeboutique.actions.Recherche.rechercheArticle;
import static gestiondeboutique.main.GestionDeBoutique.connect;
import static gestiondeboutique.main.GestionDeBoutique.start;

public class ModifyArticle {
    public static void modificationType(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("MODIFIER UN ARTICLE");
        System.out.println(
                "1 \tpour modifier le libellé d'un article\n"
              + "2 \tpour modifier le prix d'un article\n"
              + "3 \tpour modifier le quantité en stock d'un article\n"
              + "4 \tretour");
        int choix;
        while (!scanner.hasNextInt()){
            System.out.println("Ce choix n'est pas valide !");
            System.out.print("Veuillez réessayer : ");
            scanner.next();
        }

        choix = scanner.nextInt();
        switch (choix) {
            case 1:
                modifyName();
                break;
            case 2:
                modifyPrice();
                break;
            case 3:
                modifyQuantity();
                break;
            case 4:
                start();
                break;
            default:
                modificationType();
                break;
        }
    }

    public static void modifyName(){

        String SQL = "UPDATE article " +
                     "SET libelle_article = ? " +
                     "WHERE code_article = ?";
        Scanner scannerNewName = new Scanner(System.in);

        String code = trouverCode();
        System.out.println(" ");
        System.out.print("Entrez le nouveau libellé de l'article : ");
        String libelle = scannerNewName.nextLine();

        try(Connection conn = connect();
            PreparedStatement pst = conn.prepareStatement(SQL)){
            pst.setString(1, libelle);
            pst.setString(2, code);

            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Le libellé a été modifié avec succes !");
            }
            try{
                rechercheArticle(code);
            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        }catch(SQLException ex){
            System.out.println("Erreur : " + ex.getMessage());
        }
    }

    public static void modifyPrice(){
        String SQL = "UPDATE article " +
                "SET prix_unitaire = ? " +
                "WHERE code_article = ?";

        Scanner scanner = new Scanner(System.in);

        String code = trouverCode();
        System.out.println(" ");
        System.out.print("Entrez le nouveau prix de l'article : ");
        int prix = scanner.nextInt();

        try(Connection conn = connect();
            PreparedStatement pst = conn.prepareStatement(SQL)){
            pst.setInt(1, prix);
            pst.setString(2, code);

            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Le prix a été modifié avec succes !");
            }
            try{
                rechercheArticle(code);
            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        }catch(SQLException ex){
            System.out.println("Erreur : " + ex.getMessage());
        }
    }

    public static void modifyQuantity(){
        String SQL = "UPDATE article " +
                "SET qte_stock = ? " +
                "WHERE code_article = ?";

        Scanner scanner = new Scanner(System.in);

        String code = trouverCode();
        System.out.println(" ");
        System.out.print("Entrez la quantité en stock  de l'article : ");
        int quantite = scanner.nextInt();

        try(Connection conn = connect();
            PreparedStatement pst = conn.prepareStatement(SQL)){
            pst.setInt(1, quantite);
            pst.setString(2, code);

            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("La quantité a été modifiée avec succes !");
            }
            try{
                rechercheArticle(code);
            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        }catch(SQLException ex){
            System.out.println("Erreur : " + ex.getMessage());
        }
    }
}
