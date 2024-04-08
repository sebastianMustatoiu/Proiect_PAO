import FoodDelivery.FoodDeliveryService;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        FoodDeliveryService service = new FoodDeliveryService();

        //creez localuri
        service.creeazaLocal("Casa MYT", "Drumul Taberei nr.10", "0765123456");
        service.creeazaLocal("Atlantic", "Drumul Sarii nr.34", "021345678");

        //le caut dupa nume
        //System.out.println(service.cautaLocalDupaNume("Casa MYT"));
        //System.out.println(service.cautaLocalDupaNume("Atlantic"));

        //creez clienti
        service.creeazaContClient("Mustatoiu", "Sebastian", "sebic.ms@gmail.com", "0756836289",
                            "jnfiernvre");
        service.creeazaContClient("Prioteasa", "Rares", "rares.prioteasa@gmail.com", "0739876109",
                                  "kjgfgjhkjlh");

        //ii caut dupa email
        //System.out.println(service.cautaClientDupaEmail("sebic.ms@gmail.com") + "\n");
        //System.out.println(service.cautaClientDupaEmail("rares.prioteasa@gmail.com") + "\n");


        //creez soferi
        service.creeazaContSofer("Dumitru", "Bogdan", "dumitru.bogdan@gmail.com", "0757499789",
                                 "kehgibou", "IF 12 BAD");
        service.creeazaContSofer("Tanasescu", "Bogdan", "tanasescu.bogdan@gmail.com", "0757476589",
                "jtdsyetrd", "TL 34 NOM");

        //ii caut dupa email
        //System.out.println(service.cautaSoferDupaEmail("dumitru.bogdan@gmail.com") + "\n");
        //System.out.println(service.cautaSoferDupaEmail("tanasescu.bogdan@gmail.com") + "\n");

        //le afisez pe toate
        service.afiseazaConturiClienti();
        service.afiseazaConturiSoferi();

        //creez produse pentru restaurantul 1
        FoodDelivery.Produs produs1 = service.creeazaProdus("Quatro Staggioni", 30.0, 400.0);
        FoodDelivery.Produs produs2 = service.creeazaProdus("Quatro Formaggi", 28.0, 350.0);

        FoodDelivery.Produs produs3 = service.creeazaProdus("Pepsi", 6.0, 500.0);
        FoodDelivery.Produs produs4 = service.creeazaProdus("Fanta", 5.0, 500.0);

        //creez categorii de produse pentru restaurantul 1
        FoodDelivery.CategorieProduse categorie1 = service.creeazaCategorie("Pizza");
        FoodDelivery.CategorieProduse categorie2 = service.creeazaCategorie("Bauturi");

        //adaug produse la categorii pentru restaurantul 1
        service.adaugaProdusLaCategorie(produs1, categorie1);
        service.adaugaProdusLaCategorie(produs2, categorie1);
        service.adaugaProdusLaCategorie(produs3, categorie2);
        service.adaugaProdusLaCategorie(produs4, categorie2);

        //creez un meniu pentru restaurantul 1
        FoodDelivery.Meniu meniu1 = service.creeazaMeniu();

        //adaug categoriile la meniu
        service.adaugaCategorieLaMeniu(categorie1, meniu1);
        service.adaugaCategorieLaMeniu(categorie2, meniu1);

        //setez meniul pentru restaurant
        FoodDelivery.Local local1 = service.cautaLocalDupaNume("Casa MYT");
        service.adaugaMeniuLaLocal(meniu1, local1);

        //afisez restaurantul 1
        //System.out.println(local1);

        //creez produse pentru restaurantul 2
        FoodDelivery.Produs produs5 = service.creeazaProdus("Cesar", 25.0, 300.0);
        FoodDelivery.Produs produs6 = service.creeazaProdus("Bulgareasca", 28.0, 350.0);

        FoodDelivery.Produs produs7 = service.creeazaProdus("Cola", 6.0, 500.0);
        FoodDelivery.Produs produs8 = service.creeazaProdus("Sprite", 5.0, 500.0);

        //creez categorii de produse pentru restaurantul 2
        FoodDelivery.CategorieProduse categorie3 = service.creeazaCategorie("Salate");
        FoodDelivery.CategorieProduse categorie4 = service.creeazaCategorie("Bauturi");

        //adaug produse la categorii pentru restaurantul 2
        service.adaugaProdusLaCategorie(produs5, categorie3);
        service.adaugaProdusLaCategorie(produs6, categorie3);
        service.adaugaProdusLaCategorie(produs7, categorie4);
        service.adaugaProdusLaCategorie(produs8, categorie4);

        //creez un meniu pentru restaurantul 2
        FoodDelivery.Meniu meniu2 = service.creeazaMeniu();

        //adaug categoriile la meniu
        service.adaugaCategorieLaMeniu(categorie3, meniu2);
        service.adaugaCategorieLaMeniu(categorie4, meniu2);

        //setez meniul pentru restaurant
        FoodDelivery.Local local2 = service.cautaLocalDupaNume("Atlantic");
        service.adaugaMeniuLaLocal(meniu2, local2);

        //afisez restaurantul 2
        //System.out.println(local2);

        //afisez localurile
        //service.afiseazaLocaluri();

        //creez recenzii pentru restaurantul 1 si le adaug
        FoodDelivery.Recenzie recenzie1 = service.creeazaRecenzie("Excelent!", 5);
        FoodDelivery.Recenzie recenzie2 = service.creeazaRecenzie("Prea scump", 3);

        service.adaugaRecenzieLocal(local1, recenzie1);
        service.adaugaRecenzieLocal(local1, recenzie2);

        //creez recenzii pentru restaurantul 2 si le adaug
        FoodDelivery.Recenzie recenzie3 = service.creeazaRecenzie("Foarte bun, voi reveni!!", 5);
        FoodDelivery.Recenzie recenzie4 = service.creeazaRecenzie("Ospatarii sunt nepoliticosi", 2);

        service.adaugaRecenzieLocal(local2, recenzie3);
        service.adaugaRecenzieLocal(local2, recenzie4);

        service.afiseazaLocaluri();

        //creez o comanda
        FoodDelivery.Client client = service.cautaClientDupaEmail("sebic.ms@gmail.com");
        FoodDelivery.Sofer sofer = service.cautaSoferDupaEmail("dumitru.bogdan@gmail.com");

        List<FoodDelivery.Produs> cos= new ArrayList<>();
        cos.add(produs1);
        cos.add(produs3);
        cos.add(produs5);

        service.creazaComanda(client, "Strada Piatra nr 375", cos, sofer);

        service.afiseazaComenzi();

        //client.afisareIstoricComenzi();


    }
}
