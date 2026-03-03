package MySQL;

import java.sql.*;

import Database.DatabaseConnection;

public class MySQLConnection implements DatabaseConnection {

    private Connection connection;

    @Override
    public void connect() {
        try {
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test_at1",
                "root",
                "0000"
            );
            System.out.println("Connected to MySQL");
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
            System.out.println("Disconnected from MySQL");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getCurrentTimestampQuery() {
        return "SELECT NOW()";
    }
}