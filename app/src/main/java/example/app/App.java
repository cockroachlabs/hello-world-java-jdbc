package example.app;

import org.postgresql.ds.PGSimpleDataSource;

public class App {

    public static void main(String[] args) {

        try {
            PGSimpleDataSource ds = new PGSimpleDataSource();
            ds.setServerNames(new String[]{"{globalhost}"});
            ds.setPortNumbers(new int[]{26257});
            ds.setDatabaseName("{cluster_name}.defaultdb");
            ds.setSsl(true);
            ds.setUser("{username}");
            ds.setPassword("{password}");
            ds.setSslMode("verify-full");
            ds.setSslRootCert(System.getenv("$HOME/.postgresql/root.crt"));
            ds.setApplicationName("App");
            System.out.println("Hey! You connected to your CockroachDB cluster.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
