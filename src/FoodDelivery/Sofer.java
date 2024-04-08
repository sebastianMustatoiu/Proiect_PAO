package FoodDelivery;
import java.util.ArrayList;
import java.util.List;
public class Sofer extends Cont{
    private String nrMasina;
    private List<Comanda> istoricComenzi;

    public Sofer(String nume, String prenume, String email, String numarTelefon, String parola, String nrMasina){
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.numarTelefon = numarTelefon;
        this.parola = parola;
        this.nrMasina = nrMasina;
        this.istoricComenzi = new ArrayList<>();
    }

    @Override
    public String getEmail(){
        return email;
    }

    public String getNume(){
        return nume;
    }

    public String getPrenume(){
        return prenume;
    }

    public void adaugaComanda(Comanda comanda){
        istoricComenzi.add(comanda);
    }


    public void afisareIstoricComenzi(){
        if(istoricComenzi.isEmpty()){
            System.out.println("Acest sofer nu are comenzi efectuate.");
        }
        else{
            System.out.println("Istoricul comenzilor pentru soferul " + nume + " " + prenume + " este: ");
            for(Comanda comanda : istoricComenzi){
                System.out.println(comanda);
            }
        }
    }

    @Override
    public String toString() {
        return "Sofer: " + nume + " " + prenume + ", email: " + email + ", telefon: " + numarTelefon + ", nrMasina: " + nrMasina;
    }



}
