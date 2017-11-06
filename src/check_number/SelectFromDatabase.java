package check_number;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import repository.ConnectionDetel;
import repository.Server;

public class SelectFromDatabase {

    static Server zevs = new Server("80.246.226.62", "bulkCreateUser", "root", "clrn10");

    static Server server253 = new Server("192.168.10.253", "inlife", "root", "clrn10");

    static Server server251 = new Server("192.168.10.251", "c5_core", "root", "clrn10");

    public static void selectFromBulkCreateUser_SviKreirani(String numberForCheck) throws SQLException {

        ConnectionDetel.getConnection(zevs.getServerName(), zevs.getDatabaseName(), zevs.getRoot(), zevs.getPass());
        String query = "SELECT * FROM bulkCreateUser.SviKreirani where concat(countryCode, cityCode, phoneNumber) like ?;";
        executeQuery(query, numberForCheck, zevs, "SviKreirani");
    }

    public static void selectFromDev(String numberForCheck) throws SQLException {

        ConnectionDetel.getConnection(zevs.getServerName(), zevs.getDatabaseName(), zevs.getRoot(), zevs.getPass());
        String query = "SELECT * FROM teles.dev where sipUri like ?;";
        executeQuery(query, numberForCheck + "%", zevs, "teles.dev");
    }

    public static void selectFromDetelip(String numberForCheck) throws SQLException {

        ConnectionDetel.getConnection(server253.getServerName(), server253.getDatabaseName(), server253.getRoot(), server253.getPass());
        String query = "SELECT * FROM inlife.detelip where TelSt = ?;";
        executeQuery(query, numberForCheck, server253, "detelip");
    }

    public static void selectFromNumbers(String numberForCheck) throws SQLException {

        ConnectionDetel.getConnection(server253.getServerName(), server253.getDatabaseName(), server253.getRoot(), server253.getPass());
        String query = "SELECT * FROM inlife.numbers where Stevilka = ?;";
        executeQuery(query, numberForCheck, server253, "numbers");
    }

    public static void selectFromRegistracije(String numberForCheck) throws SQLException {

        ConnectionDetel.getConnection(server251.getServerName(), server251.getDatabaseName(), server251.getRoot(), server251.getPass());
        String query = "SELECT * FROM c5_core.Registracije where number = ?;";
        executeQuery(query, numberForCheck, server251, "Registracije");
    }

    static void executeQuery(String query, String numberForCheck, Server server, String tableName) throws SQLException {
        PreparedStatement ps = ConnectionDetel.getConn().prepareStatement(query);
        ps.setString(1, numberForCheck);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            System.out.println("Number " + numberForCheck + " is in: " + server.getDatabaseName() + "." + tableName);
        } else {
            System.out.println("NO NUMBER IN " + server.getServerName() + " " + server.getDatabaseName() + "." + tableName);
        }

    }

}
