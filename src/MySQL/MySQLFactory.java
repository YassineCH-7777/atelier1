package MySQL;

import Database.DatabaseConnection;
import Database.DatabaseFactory;

public class MySQLFactory extends DatabaseFactory {

    @Override
    public DatabaseConnection createConnection() {
        return new MySQLConnection();
    }
}