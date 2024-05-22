package FoodDelivery;
import java.util.ArrayList;
import java.util.List;
public class CategorieProduse {
    private int id;
    private String nume;
    private List<Produs> listaProduse;

    public CategorieProduse(String nume){
        this.nume = nume;
        this.listaProduse = new ArrayList<>();
    }

    public int getId(){return id;}

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setId(int id){this.id = id;}

    public void adaugaProdus(Produs produs){
        listaProduse.add(produs);
    }

    public List<Produs> getListaProduse() {
        return listaProduse;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Categoria de produse: ").append(nume).append(":\n");
        for (Produs produs : listaProduse) {
            stringBuilder.append(produs.toString()).append("\n");
        }
        return stringBuilder.toString();
    }

}
