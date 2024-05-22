package FoodDelivery;
import java.util.ArrayList;
import java.util.List;
public class Meniu {

    private String localNume;
    private List<CategorieProduse> categorii;

    public Meniu(){
        this.categorii = new ArrayList<>();
    }

    public Meniu(String localNume) {
        this.localNume = localNume;
        this.categorii = new ArrayList<>();
    }

    public String getLocalNume(){
        return localNume;
    }

    public void adaugaCategorie(CategorieProduse categorie){
        categorii.add(categorie);
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (CategorieProduse categorie : categorii) {
            stringBuilder.append(categorie.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}
