package FoodDelivery;
import java.sql.*;

public class BazaDeDate {
    private static BazaDeDate instanta;
    private Connection connection;
    private AuditService auditService;

    private BazaDeDate(String url){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url);
            this.auditService= AuditService.getInstanta();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    private BazaDeDate(String url, String user, String password){
        try {
            this.connection = DriverManager.getConnection(url, user, password);
            this.auditService= AuditService.getInstanta();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static BazaDeDate getInstanta(String url){
        if (instanta == null){
            instanta = new BazaDeDate(url);
        }
        return instanta;
    }

    public static BazaDeDate getInstanta(String url, String user, String password){
        if (instanta == null){
            instanta = new BazaDeDate(url, user, password);
        }
        return instanta;
    }

    // CRUD operations for client

    public void insereazaClient(Client client) {
        try {
            String query = "INSERT INTO clients (email, nume, prenume, numar_telefon, parola) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, client.getEmail());
            statement.setString(2, client.getNume());
            statement.setString(3, client.getPrenume());
            statement.setString(4, client.getNumarTelefon());
            statement.setString(5, client.getParola());
            statement.executeUpdate();

            auditService.inregistreazaActiune("insereazaClient");
        } catch(SQLException e){
            System.out.println("A aparut o problema la inserare client");
            e.printStackTrace();
        }
    }

    public void afiseazaClient(String email) {
        try {
            String query = "SELECT * FROM clients WHERE email = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                System.out.println("Client: ");
                System.out.println("Nume: " + rs.getString("nume"));
                System.out.println("Prenume: " + rs.getString("prenume"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Numar Telefon: " + rs.getString("numar_telefon"));
                System.out.println("Parola: " + rs.getString("parola"));

                auditService.inregistreazaActiune("afiseazaClient");

            } else {
                System.out.println("Nu s-a gasit niciun client cu email-ul: " + email);
            }
        } catch(SQLException e){
            System.out.println("A aparut o problema la citirea clientului");
            e.printStackTrace();
        }
    }

    public void actualizeazaClient(Client client) {
        try {
            String query = "UPDATE clients SET nume = ?, prenume = ?, numar_telefon = ?, parola = ? WHERE email = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, client.getNume());
            statement.setString(2, client.getPrenume());
            statement.setString(3, client.getNumarTelefon());
            statement.setString(4, client.getParola());
            statement.setString(5, client.getEmail());
            statement.executeUpdate();

            auditService.inregistreazaActiune("actualizeazaClient");

        } catch(SQLException e){
            System.out.println("A aparut o problema la actualizarea clientului");
            e.printStackTrace();
        }
    }

    public void stergeClient(String email) {
        try {
            String query = "DELETE FROM clients WHERE email = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);
            statement.executeUpdate();

            auditService.inregistreazaActiune("stergeClient");

        } catch(SQLException e){
            System.out.println("A aparut o problema la stergerea clientului");
            e.printStackTrace();
        }
    }


    // CRUD operations for Locals
    public void insereazaLocal(Local local) {
        try {
            String query = "INSERT INTO locals (nume, adresa, numar_contact, rating) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, local.getNume());
            statement.setString(2, local.getAdresa());
            statement.setString(3, local.getNumarContact());
            statement.setDouble(4, local.getRating());
            statement.executeUpdate();

            auditService.inregistreazaActiune("insereazaLocal");

        }
        catch(SQLException e){
            System.out.println("A aparut o problema la inserare local");
            e.printStackTrace();
        }
    }

    public void afiseazaLocal(String nume) {
        try {
            String query = "SELECT * FROM locals WHERE nume = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nume);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                System.out.println("Local: ");
                System.out.println("Nume: " + rs.getString("nume"));
                System.out.println("Adresa: " + rs.getString("adresa"));
                System.out.println("Numar Contact: " + rs.getString("numar_contact"));
                System.out.println("Rating: " + rs.getDouble("rating"));

                auditService.inregistreazaActiune("afiseazaLocal");

            } else {
                System.out.println("Nu s-a gasit niciun local cu numele: " + nume);
            }
        } catch(SQLException e){
            System.out.println("A aparut o problema la citirea localului");
            e.printStackTrace();
        }
    }

    public void actualizeazaLocal(Local local) {
        try {
            String query = "UPDATE locals SET adresa = ?, numar_contact = ?, rating = ? WHERE nume = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, local.getAdresa());
            statement.setString(2, local.getNumarContact());
            statement.setDouble(3, local.getRating());
            statement.setString(4, local.getNume());
            statement.executeUpdate();

            auditService.inregistreazaActiune("actualizeazaLocal");
        } catch(SQLException e){
            System.out.println("A aparut o problema la actualizarea localului");
            e.printStackTrace();
        }
    }

    public void stergeLocal(String nume) {
        try {
            String query = "DELETE FROM locals WHERE nume = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nume);
            statement.executeUpdate();

            auditService.inregistreazaActiune("stergeLocal");

        } catch(SQLException e){
            System.out.println("A aparut o problema la stergerea localului");
            e.printStackTrace();
        }
    }

    // CRUD operations for Menus
    public void insereazaMeniu(Meniu meniu) {
        try {
            String query = "INSERT INTO menus (local_nume) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, meniu.getLocalNume());
            statement.executeUpdate();

            auditService.inregistreazaActiune("insereazaMeniu");

        }
        catch(SQLException e){
            System.out.println("A aparut o problema la inserare meniu");
            e.printStackTrace();
        }
    }

    public void afiseazaMeniu(String localNume) {
        try {
            String query = "SELECT * FROM menus WHERE local_nume = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, localNume);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                System.out.println("Meniu pentru localul: " + localNume);
                // Afișarea detaliilor meniului
                System.out.println("Numele localului: " + rs.getString("local_nume"));

                auditService.inregistreazaActiune("afiseazaMeniu");

            } else {
                System.out.println("Nu s-a gasit niciun meniu pentru localul: " + localNume);
            }
        } catch(SQLException e){
            System.out.println("A aparut o problema la citirea meniului");
            e.printStackTrace();
        }
    }

    public void actualizeazaMeniu(Meniu meniu) {
        try {
            String query = "UPDATE menus SET local_id = ? WHERE local_nume = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, meniu.getLocalNume());
            statement.executeUpdate();

            auditService.inregistreazaActiune("actualizeazaMeniu");

        } catch(SQLException e){
            System.out.println("A aparut o problema la actualizarea meniului");
            e.printStackTrace();
        }
    }

    public void stergeMeniu(String localNume) {
        try {
            String query = "DELETE FROM menus WHERE local_nume = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, localNume);
            statement.executeUpdate();

            auditService.inregistreazaActiune("stergeMeniu");

        } catch(SQLException e){
            System.out.println("A aparut o problema la stergerea meniului");
            e.printStackTrace();
        }
    }

    // CRUD operations for Categories
    public void insereazaCategorie(CategorieProduse categorie, String meniuLocalNume) {
        try {
            String query = "INSERT INTO categories (nume, menu_local_nume) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, categorie.getNume());
            statement.setString(2, meniuLocalNume);
            statement.executeUpdate();

            auditService.inregistreazaActiune("insereazaCategorie");


            // Obține ID-ul generat
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int generatedId = generatedKeys.getInt(1);
                categorie.setId(generatedId);
            }
        } catch(SQLException e) {
            System.out.println("A aparut o problema la inserare categorie");
            e.printStackTrace();
        }
    }


    public void afiseazaCategorie(int id) {
        try {
            String query = "SELECT * FROM categories WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                System.out.println("Categorie ID: " + rs.getInt("id"));
                System.out.println("Nume: " + rs.getString("nume"));
                System.out.println("Menu Local Nume: " + rs.getString("menu_local_nume"));

                auditService.inregistreazaActiune("afiseazaCategorie");

            } else {
                System.out.println("Nu s-a gasit nicio categorie cu ID-ul: " + id);
            }
        } catch(SQLException e){
            System.out.println("A aparut o problema la citirea categoriei");
            e.printStackTrace();
        }
    }

    public void actualizeazaCategorie(CategorieProduse categorie) {
        try {
            String query = "UPDATE categories SET nume = ?, menu_local_nume = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, categorie.getNume());
            statement.setInt(2, categorie.getId());
            statement.executeUpdate();

            auditService.inregistreazaActiune("actualizeazaCategorie");

        } catch(SQLException e){
            System.out.println("A aparut o problema la actualizarea categoriei");
            e.printStackTrace();
        }
    }

    public void stergeCategorie(int id) {
        try {
            String query = "DELETE FROM categories WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();

            auditService.inregistreazaActiune("stergeCategorie");

        } catch(SQLException e){
            System.out.println("A aparut o problema la stergerea categoriei");
            e.printStackTrace();
        }
    }

    public void preiaIdCategorie(CategorieProduse categorie, String meniuLocalNume) {
        try {
            String query = "SELECT id FROM categories WHERE nume = ? AND menu_local_nume = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, categorie.getNume());
            statement.setString(2, meniuLocalNume);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                categorie.setId(id);
            } else {
                System.out.println("Nu s-a gasit categoria " + categorie.getNume() + " pentru localul " + meniuLocalNume);
            }
        } catch (SQLException e) {
            System.out.println("A aparut o problema la preluarea ID-ului categoriei");
            e.printStackTrace();
        }
    }


    // CRUD operations for Products
    public void insereazaProdus(Produs produs) {
        try {
            String query = "INSERT INTO products (nume, pret, gramaj, categorie_id) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, produs.getNume());
            statement.setDouble(2, produs.getPret());
            statement.setDouble(3, produs.getGramaj());
            statement.setInt(4, produs.getCategorieId());
            statement.executeUpdate();

            auditService.inregistreazaActiune("insereazaProdus");

        } catch(SQLException e) {
            System.out.println("A aparut o problema la inserare produs");
            e.printStackTrace();
        }
    }



    public void afiseazaProdus(int id) {
        try {
            String query = "SELECT * FROM products WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                System.out.println("Produs: ");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nume: " + rs.getString("nume"));
                System.out.println("Pret: " + rs.getDouble("pret"));
                System.out.println("Gramaj: " + rs.getDouble("gramaj"));
                System.out.println("Categorie ID: " + rs.getInt("categorie_id"));

                auditService.inregistreazaActiune("afiseazaProdus");

            } else {
                System.out.println("Nu s-a gasit niciun produs cu ID-ul: " + id);
            }
        } catch(SQLException e){
            System.out.println("A aparut o problema la citirea produsului");
            e.printStackTrace();
        }
    }

    public void actualizeazaProdus(Produs produs) {
        try {
            String query = "UPDATE products SET nume = ?, pret = ?, gramaj = ?, categorie_id = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, produs.getNume());
            statement.setDouble(2, produs.getPret());
            statement.setDouble(3, produs.getGramaj());
            statement.setInt(4, produs.getCategorieId());
            statement.setInt(5, produs.getId());
            statement.executeUpdate();

            auditService.inregistreazaActiune("actualizeazaProdus");

        } catch(SQLException e){
            System.out.println("A aparut o problema la actualizarea produsului");
            e.printStackTrace();
        }
    }

    public void stergeProdus(int id) {
        try {
            String query = "DELETE FROM products WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();

            auditService.inregistreazaActiune("stergeProdus");

        } catch(SQLException e){
            System.out.println("A aparut o problema la stergerea produsului");
            e.printStackTrace();
        }
    }

    // Methods to display data from the tables
    public void afiseazaClienti() {
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM clients";
            ResultSet rs = statement.executeQuery(query);
            System.out.println("\nCLIENTI:");
            while (rs.next()) {
                System.out.println(
                        "Email: " + rs.getString("email") +
                                " | Nume: " + rs.getString("nume") +
                                " | Prenume: " + rs.getString("prenume") +
                                " | Numar Telefon: " + rs.getString("numar_telefon") +
                                " | Parola: " + rs.getString("parola")
                );


            }
            auditService.inregistreazaActiune("afiseazaClienti");

        } catch (SQLException e) {
            System.out.println("A aparut o problema la afisarea clientilor");
            e.printStackTrace();
        }
    }

    public void afiseazaLocaluri() {
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM locals";
            ResultSet rs = statement.executeQuery(query);
            System.out.println("\nLOCALURI:");
            while (rs.next()) {
                System.out.println(
                        "Nume: " + rs.getString("nume") +
                                " | Adresa: " + rs.getString("adresa") +
                                " | Numar Contact: " + rs.getString("numar_contact") +
                                " | Rating: " + rs.getDouble("rating")
                );
            }
            auditService.inregistreazaActiune("afiseazaLocaluri");

        } catch (SQLException e) {
            System.out.println("A aparut o problema la afisarea localurilor");
            e.printStackTrace();
        }
    }

    public void afiseazaMeniuri() {
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM menus";
            ResultSet rs = statement.executeQuery(query);
            System.out.println("\nMENIURI:");
            while (rs.next()) {
                System.out.println(
                        "Nume Local: " + rs.getString("local_nume")
                );
            }
            auditService.inregistreazaActiune("afiseazaMeniuri");

        } catch (SQLException e) {
            System.out.println("A aparut o problema la afisarea meniurilor");
            e.printStackTrace();
        }
    }

    public void afiseazaCategorii() {
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM categories";
            ResultSet rs = statement.executeQuery(query);
            System.out.println("\nCATEGORII:");
            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("id") +
                                " | Nume: " + rs.getString("nume") +
                                " | Meniul localului: " + rs.getString("menu_local_nume")
                );
            }
            auditService.inregistreazaActiune("afiseazaCategorii");

        } catch (SQLException e) {
            System.out.println("A aparut o problema la afisarea categoriilor");
            e.printStackTrace();
        }
    }

    public void afiseazaProduse() {
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM products";
            ResultSet rs = statement.executeQuery(query);
            System.out.println("\nPRODUSE:");
            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("id") +
                                " | Nume: " + rs.getString("nume") +
                                " | Pret: " + rs.getDouble("pret") +
                                " | Gramaj: " + rs.getDouble("gramaj") +
                                " | Categorie ID: " + rs.getInt("categorie_id")
                );
            }
            auditService.inregistreazaActiune("afiseazaProduse");

        } catch (SQLException e) {
            System.out.println("A aparut o problema la afisarea produselor");
            e.printStackTrace();
        }
    }
}