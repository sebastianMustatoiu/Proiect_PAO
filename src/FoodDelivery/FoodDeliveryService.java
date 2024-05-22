package FoodDelivery;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public final class FoodDeliveryService {
    private List<Client> clienti;
    private List<Local> localuri;
    private List<Comanda> comenzi;
    private List<Sofer> soferi;

    public FoodDeliveryService(){
        this.clienti = new ArrayList<>();
        this.localuri = new ArrayList<>();
        this.comenzi = new ArrayList<>();
        this.soferi = new ArrayList<>();
    }

    //creeaza local
    public void creeazaLocal(String nume, String adresa, String numarContact){
        Local local = new Local(nume, adresa, numarContact);
        localuri.add(local);
    }

    public void creeazaContClient(String nume, String prenume, String email, String numarTelefon, String parola){
        Client client = new Client(nume, prenume, email, numarTelefon, parola);
        clienti.add(client);
    }

    public void creeazaContSofer(String nume, String prenume, String email, String numarTelefon, String parola, String nrMasina){
        Sofer sofer = new Sofer(nume, prenume, email, numarTelefon, parola, nrMasina);
        soferi.add(sofer);
    }

    //adaugare client in sistem
    public void adaugaCont(Client client){
        clienti.add(client);
    }

    //cautare cont dupa email

    public Client cautaClientDupaEmail(String email){
        for(Client client : clienti){
            if(client.getEmail().equals(email)){
                return client;
            }
        }
        return null;
    }

    public Sofer cautaSoferDupaEmail(String email){
        for(Sofer sofer : soferi){
            if(sofer.getEmail().equals(email)){
                return sofer;
            }
        }
        return null;
    }

    //adaugare local in sistem
    public void adaugaLocal(Local local){
        localuri.add(local);
    }

    //cautare local dupa nume
    public Local cautaLocalDupaNume(String nume){
        for(Local local : localuri){
            if(local.getNume().equals(nume)){
                return local;
            }
        }
        return null;
    }


    //adaugare comanda
    public void adaugaComanda(Comanda comanda){
        comenzi.add(comanda);
    }


    public void afiseazaConturiClienti(){
        System.out.println("Lista de clienti: \n");
        for(Client client : clienti){
            System.out.println(client);
            System.out.println();
            System.out.println("------------------------------------------------------------------\n");
        }
    }

    public void afiseazaConturiSoferi(){
        System.out.println("Lista de soferi: \n");
        for(Sofer sofer : soferi){
            System.out.println(sofer);
            System.out.println();
            System.out.println("------------------------------------------------------------------\n");
        }
    }

    //afisare comenzi platforma
    public void afiseazaComenzi() {
        System.out.println("Lista de comenzi: ");
        for (Comanda comanda : comenzi) {
            System.out.println(comanda);
        }
    }

    //afisare comenzi ale unui sofer

    public void afiseazaLocaluri(){
        System.out.println("Lista de localuri: \n");
        for(Local local : localuri){
            System.out.println(local);
            System.out.println("\n------------------------------------------------------\n");
        }
    }

    public Recenzie creeazaRecenzie(String comentariu, int rating){
        return new Recenzie(comentariu, rating);
    }

    public void adaugaRecenzieLocal(Local local, Recenzie recenzie){
        local.adaugaRecenzie(recenzie);
    }

    public void afiseazaDetaliiLocal(Local local){
        System.out.println(local);
    }

    public Produs creeazaProdus(String nume, double pret, double gramaj, int categorieId){
        return new Produs(nume, pret, gramaj, categorieId);
    }

    public CategorieProduse creeazaCategorie(String nume){
        return new CategorieProduse(nume);
    }

    public Meniu creeazaMeniu(){
        return new Meniu();
    }

    public void adaugaProdusLaCategorie(Produs produs, CategorieProduse categorie){
        categorie.adaugaProdus(produs);
    }
    public void adaugaCategorieLaMeniu(CategorieProduse categorie, Meniu meniu){
        meniu.adaugaCategorie(categorie);
    }

    public void adaugaMeniuLaLocal(Meniu meniu, Local local){
        local.setMeniu(meniu);
    }

    public List<Comanda> getComenzi() {
        return comenzi;
    }

    public void creazaComanda(Client client, String adresa, List<Produs> produse, Sofer sofer){
        if(client != null){
            Comanda comanda  = new Comanda(client, adresa, sofer);
            for(Produs produs : produse){
                comanda.adaugaProdus(produs);
            }
            adaugaComanda(comanda);
            client.adaugaComanda(comanda);
            if(sofer!=null){
                sofer.adaugaComanda(comanda);
            }
        }
        else{
            System.out.println("Nu s-a putut gasi clientul cu adresa de email specificata");
        }
    }




}
