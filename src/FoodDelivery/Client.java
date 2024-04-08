package FoodDelivery;
import java.util.ArrayList;
import java.util.List;
public class Client extends Cont{
    private List<Comanda> comenzi;

    public Client(String nume, String prenume, String email, String numarTelefon, String parola){
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.numarTelefon = numarTelefon;
        this.parola = parola;
        this.comenzi = new ArrayList<>();
    }

    public String getNume(){
        return nume;
    }

    public String getPrenume(){

        return prenume;
    }

    public void adaugaComanda(Comanda comanda){

        comenzi.add(comanda);
    }

    @Override
    public void afisareIstoricComenzi(){
        if(comenzi.isEmpty()){
            System.out.println("Acest client nu are comenzi efectuate.");
        }
        else{
            System.out.println("Istoricul comenzilor pentru clientul " + nume + " " + prenume + " este: ");
            for(Comanda comanda : comenzi){
                System.out.println(comanda);
            }
        }
    }

    @Override
    public String getEmail(){
        return email;
    }


    @Override
    public String toString() {
        return "Client: " + nume + " " + prenume + ", email: " + email + ", telefon: " + numarTelefon;
    }

}

