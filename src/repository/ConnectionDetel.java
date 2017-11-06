package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Here, when put singleton pattern have a problem, see later, otherwise this class use for connection with database
public class ConnectionDetel {

    private ConnectionDetel() {
    }

    private static Connection conn;

    public static Connection getConnection(String serverName, String databaseName, String user, String pass) throws SQLException {

        setConn(DriverManager.getConnection("jdbc:mysql://" + serverName + "/" + databaseName, user, pass));

        return getConn();
    }

    /**
     * @return the conn
     */
    public static Connection getConn() {
        return conn;
    }

    /**
     * @param aConn the conn to set
     */
    public static void setConn(Connection aConn) {
        conn = aConn;
    }

}
