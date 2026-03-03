package SQLServer;

import Database.DatabaseConnection;
import Database.DatabaseFactory;

public class SQLServerFactory extends DatabaseFactory {

    @Override
    public DatabaseConnection createConnection() {
        return new SQLServerConnection();
    }
}