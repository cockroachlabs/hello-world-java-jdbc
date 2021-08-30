package example.app;

import org.postgresql.ds.PGSimpleDataSource;

public class App {

    public static void main(String[] args) {
        
        try {
            PGSimpleDataSource ds = new PGSimpleDataSource();
            ds.setServerNames(new String[]{"localhost"});
            ds.setPortNumbers(new int[]{26257});
            ds.setDatabaseName("defaultdb");
            ds.setUser("root");
            ds.setSsl(false);
            ds.setSslMode("disable");
            ds.setApplicationName("App");
            System.out.println("Hey! You connected to your CockroachDB cluster.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
