package example.app;

import java.util.Scanner;
import javax.sql.DataSource;
import org.postgresql.ds.PGSimpleDataSource;

public class App {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the demo password: ");
        String password = scan.nextLine();

        try {
            PGSimpleDataSource ds = new PGSimpleDataSource();
            ds.setServerNames(new String[]{"localhost"});
            ds.setPortNumbers(new int[]{26257});
            ds.setUser("demo");
            ds.setPassword(password);
            ds.setSsl(true);
            ds.setSslMode("require");
            ds.setApplicationName("App");
            System.out.println("Hey! You connected to your CockroachDB cluster.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
