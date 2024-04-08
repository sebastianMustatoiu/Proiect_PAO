package FoodDelivery;
import java.util.ArrayList;
import java.util.List;
public class Local {
    private String nume;
    private String adresa;
    private String numarContact;
    private Meniu meniu;
    private List<Recenzie> recenzii;
    private double rating;

    public Local(String nume, String adresa, String numarContact){
        this.nume = nume;
        this.adresa = adresa;
        this.numarContact = numarContact;
        this.meniu = new Meniu();
        this.recenzii = new ArrayList<>();
        this.rating = 0.0;
    }

    public void adaugaRecenzie(Recenzie recenzie){
        recenzii.add(recenzie);
        recalculareRating();
    }

    private void recalculareRating(){
        if(recenzii.isEmpty()){
            rating = 0.0;
            return;
        }
        double suma = 0;
        for(Recenzie recenzie : recenzii){
            suma += recenzie.getRating();
        }
        rating = suma / recenzii.size();
    }

    public Meniu getMeniu() {
        return meniu;
    }

    public void setMeniu(Meniu meniu) {
        this.meniu = meniu;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getNumarContact() {
        return numarContact;
    }

    public void setNumarContact(String numarContact) {
        this.numarContact = numarContact;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Nume local: ").append(nume).append("\n");
        stringBuilder.append("Adresa: ").append(adresa).append("\n");
        stringBuilder.append("Numar de contact: ").append(numarContact).append("\n\n");
        stringBuilder.append("Meniu:\n\n");
        stringBuilder.append(meniu.toString()).append("\n");
        stringBuilder.append("Recenzii:\n");
        for (Recenzie recenzie : recenzii) {
            stringBuilder.append(recenzie.toString()).append("\n");
        }
        // Formatarea rating-ului mediu cu două zecimale
        stringBuilder.append("Rating mediu: ").append(String.format("%.2f", rating)).append("\n");
        return stringBuilder.toString();
    }


}
