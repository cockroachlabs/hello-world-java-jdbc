package example.app;

import java.sql.ResultSet;
import java.sql.Connection;
import org.postgresql.ds.PGSimpleDataSource;

public class App {

    public static void main(String[] args) {

        try {
            PGSimpleDataSource ds = new PGSimpleDataSource();
            ds.setServerNames(new String[]{"{host}"});
            ds.setPortNumbers(new int[]{26257});
            ds.setDatabaseName("{database}");
            ds.setSsl(true);
            ds.setUser("{username}");
            ds.setPassword("{password}");
            ds.setSslMode("verify-full");
            // on Windows set this to "%APPDATA%/.postgresql/root.crt"
            ds.setSslRootCert(System.getenv("$HOME/.postgresql/root.crt"));
            ds.setApplicationName("App");
            Connection connection = ds.getConnection();
            String message = "";
            ResultSet res = connection.createStatement()
                    .executeQuery("SELECT message FROM messages");
            if(!res.next()) {
                System.out.printf("Error retrieving message.");
            } else {
              message = res.getString("message");
            }
            System.out.println(message);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
