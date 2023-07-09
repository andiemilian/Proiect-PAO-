package services;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

public class AuditService {
    FileWriter writer;

    public AuditService() {
        try {
            //File dir = new File("src/file");
            //File file = new File("src/file/file.csv");
            this.writer = new FileWriter("src/file/file.csv",true);
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    public void addAction(String action) throws IOException {
        this.writer = new FileWriter("src/file/file.csv",true);
        long datetime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(datetime);
        this.writer.write((action + ','+ timestamp + '\n'));
        this.writer.close();
    }
}
