import java.util.Scanner;

import Database.DatabaseFactory;
import Database.DatabaseConnection;
import MySQL.MySQLFactory;
import Oracle.OracleFactory;
import SQLServer.SQLServerFactory;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose Database: mysql | oracle | sqlserver");
        String choice = scanner.nextLine();

        DatabaseFactory factory = null;

        switch (choice.toLowerCase()) {
            case "mysql":
                factory = new MySQLFactory();
                break;
            case "oracle":
                factory = new OracleFactory();
                break;
            case "sqlserver":
                factory = new SQLServerFactory();
                break;
            default:
                System.out.println("Invalid choice");
                System.exit(0);
        }

        DatabaseConnection db = factory.createConnection();

        db.connect();
        db.executeQuery(db.getCurrentTimestampQuery());
        db.disconnect();
    }
}