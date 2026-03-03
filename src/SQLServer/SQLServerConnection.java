package SQLServer;

import java.sql.*;

import Database.DatabaseConnection;

public class SQLServerConnection implements DatabaseConnection {

    private Connection connection;

    @Override
    public void connect() {
        try {
            connection = DriverManager.getConnection(
                "jdbc:sqlserver://localhost:1433;"
                + "databaseName=master;"
                + "encrypt=true;"
                + "trustServerCertificate=true;",
                "sa",
                "StrongPass123!"
            );
            System.out.println("Connected to SQL Server");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void executeQuery(String query) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println("Result: " + rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void disconnect() {
        try {
            connection.close();
            System.out.println("Disconnected from SQL Server");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getCurrentTimestampQuery() {
        return "SELECT GETDATE()";
    }
}