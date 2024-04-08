package FoodDelivery;

public class Recenzie {
    private String comentariu;
    private int rating;

    public Recenzie(String comentariu, int rating){
        this.comentariu = comentariu;
        if(rating >= 1 && rating <= 5){
            this.rating = rating;
        }
        else{
            System.out.println("Rating-ul trebuie sa fie intre 1 si 5.");
        }
    }

    public String getComentariu(){
        return comentariu;
    }
    public void setComentariu(String comentariu) {
        this.comentariu = comentariu;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if(rating >= 1 & rating < 6){
            this.rating = rating;
        }
        else{
            System.out.println("Rating-ul trebuie sa fie intre 1 si 5.");
        }
    }

    @Override
    public String toString(){
        return  rating + " " + comentariu + ";";
    }
}
