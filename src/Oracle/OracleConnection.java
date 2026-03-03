package Oracle;

import java.sql.*;

import Database.DatabaseConnection;

public class OracleConnection implements DatabaseConnection {

    private Connection connection;

    @Override
    public void connect() {
        try {
            connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/XEPDB1",
                "system",
                "oracle123"
            );
            System.out.println("Connected to Oracle");
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
            System.out.println("Disconnected from Oracle");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getCurrentTimestampQuery() {
        return "SELECT SYSDATE FROM DUAL";
    }
}