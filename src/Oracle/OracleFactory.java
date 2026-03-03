package Oracle;

import Database.DatabaseConnection;
import Database.DatabaseFactory;

public class OracleFactory extends DatabaseFactory {

    @Override
    public DatabaseConnection createConnection() {
        return new OracleConnection();
    }
}