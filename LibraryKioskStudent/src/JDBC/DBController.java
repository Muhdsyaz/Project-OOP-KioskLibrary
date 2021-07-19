package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBController {

    private String databaseName = "library";
    private String username = "root";
    private String password = "";

    private String connectionPath = "jdbc:mysql://localhost/" + databaseName + "?" +
            "user=" + username + "&password=" + password;

    /**
     * This method establish connection to RDBMS
     * @return connection object
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Connection getConnection() throws ClassNotFoundException, SQLException {

        // Load database driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Get connection object from the database
        Connection connection = DriverManager.getConnection(connectionPath);

        return connection;

    }

}
