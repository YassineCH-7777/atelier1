package Database;

public interface DatabaseConnection {
    void connect();
    void executeQuery(String query);
    void disconnect();
    String getCurrentTimestampQuery();
}