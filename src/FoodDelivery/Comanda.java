package FoodDelivery;
import java.util.ArrayList;
import java.util.List;

public class Comanda {
    private Client client;
    private List<Produs> produse;
    private String adresaLivrare;
    private Sofer sofer;

    public Comanda(Client client, String adresaLivrare, Sofer sofer){
        this.client = client;
        this.produse = new ArrayList<>();
        this.adresaLivrare = adresaLivrare;
        this.sofer = sofer;
    }

    public Sofer getSofer() {
        return sofer;
    }

    public void setSofer(Sofer sofer){
        this.sofer = sofer;
    }

    public void adaugaProdus(Produs produs) {
        produse.add(produs);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Comanda pentru clientul: ").append(client.getNume()).append(" ").append(client.getPrenume()).append("\n");
        sb.append("Adresa de livrare este: ").append(adresaLivrare).append("\n");
        if(sofer != null){
            sb.append("Comanda este preluata de soferul: \n");
            sb.append(sofer.toString()).append("\n");
        }
        sb.append("Produsele din comanda:\n");
        for (Produs produs : produse) {
            sb.append(produs.getNume()).append(" - ").append(produs.getPret()).append("\n");
        }
        return sb.toString();
    }
}
