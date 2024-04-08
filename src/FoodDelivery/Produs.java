package FoodDelivery;

public class Produs {
    private String nume;
    private double pret;
    private double gramaj;

    public Produs(String nume, double pret, double gramaj){
        this.nume = nume;
        this.pret = pret;
        this.gramaj = gramaj;
    }

    public String getNume(){
        return nume;
    }
    public double getPret(){
        return pret;
    }

    public void setPret(double pret){
        if(pret >= 0){
            this.pret = pret;
        }
        else{
            System.out.println("Pretul nu poate fi mai mic decta 0.");
        }
    }
    public double getGramaj(){
        return gramaj;
    }

    public void setGramaj(double gramaj){
        if(gramaj >= 0){
            this.gramaj = gramaj;
        }
        else{
            System.out.println("Gramajul nu poate fi mai mic decat 0.");
        }
    }

    @Override
    public String toString() {
        return "Produs: " + nume + ", " +
                "pret = " + pret + ", " +
                "gramaj = " + gramaj + "g";
    }


}
