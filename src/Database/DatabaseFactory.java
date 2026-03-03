package Database;

public abstract class DatabaseFactory {
    public abstract DatabaseConnection createConnection();
}