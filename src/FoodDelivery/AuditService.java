package FoodDelivery;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditService {
    private static AuditService instanta;
    private static final String FILE_PATH = "audit.csv";
    private PrintWriter writer;

    private AuditService() {
        try {
            FileWriter fileWriter = new FileWriter(FILE_PATH, true);
            writer = new PrintWriter(fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AuditService getInstanta() {
        if (instanta == null) {
            instanta = new AuditService();
        }
        return instanta;
    }

    public void inregistreazaActiune(String numeActiune) {
        LocalDateTime timestamp = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        writer.println(numeActiune + "," + timestamp.format(formatter));
        writer.flush();
    }
}
