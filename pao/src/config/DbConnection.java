package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static Connection connection;

    private DbConnection() {

    }

    public static Connection getInstance() throws SQLException {
        if(connection == null) {
            String url = "jdbc:mysql://dblocalhost:3306/paodb";
            String userName = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, userName, password);
        }
        return connection;
    }

    
}
