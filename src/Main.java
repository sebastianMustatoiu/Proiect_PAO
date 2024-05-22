import FoodDelivery.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Conectare la baza de date
        BazaDeDate bazaDeDate = BazaDeDate.getInstanta("jdbc:mysql://localhost:3306/fooddelivery", "root", "");

        // Creez localuri
        Local local1 = new Local("Casa MYT", "Drumul Taberei nr.10", "0765123456");
        //bazaDeDate.insereazaLocal(local1);

        Local local2 = new Local("Atlantic", "Drumul Sarii nr.34", "021345678");
        //bazaDeDate.insereazaLocal(local2);

        // Afisez localurile
        bazaDeDate.afiseazaLocaluri();

        // Creez clienti
        Client client1 = new Client("Mustatoiu", "Sebastian", "sebic.ms@gmail.com", "0756836289", "jnfiernvre");
        //bazaDeDate.insereazaClient(client1);

        Client client2 = new Client("Prioteasa", "Rares", "rares.prioteasa@gmail.com", "0739876109", "kjgfgjhkjlh");
        //bazaDeDate.insereazaClient(client2);

        // Afisez clientii
        bazaDeDate.afiseazaClienti();

        Meniu meniu1 = new Meniu("Casa MYT");
        //bazaDeDate.insereazaMeniu(meniu1);

        Meniu meniu2 = new Meniu("Atlantic");
        //bazaDeDate.insereazaMeniu(meniu2);

        bazaDeDate.afiseazaMeniuri();

        // Creez categorii de produse pentru localul 1
        CategorieProduse categorie1 = new CategorieProduse("Pizza");
        //bazaDeDate.insereazaCategorie(categorie1, "Casa MYT");
        bazaDeDate.preiaIdCategorie(categorie1, "Casa MYT");

        CategorieProduse categorie2 = new CategorieProduse("Bauturi");
        //bazaDeDate.insereazaCategorie(categorie2, "Casa MYT");
        bazaDeDate.preiaIdCategorie(categorie2, "Casa MYT");

        // Creez categorii de produse pentru localul 2
        CategorieProduse categorie3 = new CategorieProduse("Salate");
        //bazaDeDate.insereazaCategorie(categorie3, "Atlantic");
        bazaDeDate.preiaIdCategorie(categorie3, "Atlantic");

        CategorieProduse categorie4 = new CategorieProduse("Bauturi");
        //bazaDeDate.insereazaCategorie(categorie4, "Atlantic");
        bazaDeDate.preiaIdCategorie(categorie4, "Atlantic");

        bazaDeDate.afiseazaCategorii();

        /*System.out.println("Categorie 1 ID: " + categorie1.getId());
        System.out.println("Categorie 2 ID: " + categorie2.getId());
        System.out.println("Categorie 3 ID: " + categorie3.getId());
        System.out.println("Categorie 4 ID: " + categorie4.getId());*/

        //bazaDeDate.afiseazaCategorie(1);

        // Creez produse pentru localul 1
        Produs produs1 = new Produs("Quatro Staggioni", 30.0, 400.0, categorie1.getId());
        //bazaDeDate.insereazaProdus(produs1);

        Produs produs2 = new Produs("Quatro Formaggi", 28.0, 350.0, categorie1.getId());
        //bazaDeDate.insereazaProdus(produs2);

        Produs produs3 = new Produs("Pepsi", 6.0, 500.0, categorie2.getId());
        //bazaDeDate.insereazaProdus(produs3);

        Produs produs4 = new Produs("Fanta", 5.0, 500.0, categorie2.getId());
        //bazaDeDate.insereazaProdus(produs4);

        // Creez produse pentru localul 2
        Produs produs5 = new Produs("Cesar", 25.0, 300.0, categorie3.getId());
        //bazaDeDate.insereazaProdus(produs5);

        Produs produs6 = new Produs("Bulgareasca", 28.0, 350.0, categorie3.getId());
        //bazaDeDate.insereazaProdus(produs6);

        Produs produs7 = new Produs("Cola", 6.0, 500.0, categorie4.getId());
        //bazaDeDate.insereazaProdus(produs7);

        Produs produs8 = new Produs("Sprite", 5.0, 500.0, categorie4.getId());
        //bazaDeDate.insereazaProdus(produs8);

        // Afisez produsele
        bazaDeDate.afiseazaProduse();



    }
}




