package delete_number;

import repository.Server;
import repository.ConnectionDetel;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//in this class we have engine - servers, databases, methods, all logic is here
public class DeleteFromDatabase {

    //information about servers
    static Server zevs = new Server("80.246.226.62", "bulkCreateUser", "root", "clrn10");

    static Server server253 = new Server("192.168.10.253", "inlife", "root", "clrn10");

    static Server server251 = new Server("192.168.10.251", "c5_core", "root", "clrn10");

    // Connect to database and delete from zevs.bulkCreateUser.SviKreirani
    public static void zeusBulkCreateUser(String numberForDelete) throws SQLException {
        //Connection with server
        ConnectionDetel.getConnection(zevs.getServerName(), zevs.getDatabaseName(), zevs.getRoot(), zevs.getPass());
        String query = "DELETE FROM bulkCreateUser.SviKreirani where concat(countryCode, cityCode, phoneNumber) = ?;";
        //execute a query and give information about working process - for details look at the end
        executeQuery(query, numberForDelete, zevs, "SviKreirani");

    }

    // Connect to database and delete from zevs.teles.dev
    public static void dev(String numberForDelete) throws SQLException {
        //Connection with server
        ConnectionDetel.getConnection(zevs.getServerName(), zevs.getDatabaseName(), zevs.getRoot(), zevs.getPass());
        String query = "DELETE FROM teles.dev where sipUri like ?";
        //execute a query and give information about working process - for details look at the end
        executeQuery(query, numberForDelete + "%", zevs, "dev");
    }

    // Connect to database and delete from server253.detelip
    public static void detelip(String numberForDelete) throws SQLException {
        //Connection with server
        ConnectionDetel.getConnection(server253.getServerName(), server253.getDatabaseName(), server253.getRoot(), server253.getPass());
        String query = "DELETE FROM detelip where TelSt = ?";
        //execute a query and give information about working process - for details look at the end
        executeQuery(query, numberForDelete, server253, "detelip");
    }

    // Connect to database and delete from server253.numbers
    public static void numbers(String numberForDelete) throws SQLException {
        //Connection with server
        ConnectionDetel.getConnection(server253.getServerName(), server253.getDatabaseName(), server253.getRoot(), server253.getPass());
        String query = "DELETE FROM numbers where Stevilka = ?";
        //execute a query and give information about working process - for details look at the end
        executeQuery(query, numberForDelete, server253, "numbers");
    }

    // Connect to database and delete from server251.Registracije
    public static void registracije(String numberForDelete) throws SQLException {
        //Connection with server
        ConnectionDetel.getConnection(server251.getServerName(), server251.getDatabaseName(), server251.getRoot(), server251.getPass());
        String query = "DELETE FROM Registracije where number = ?";
        //execute a query and give information about working process - for details look at the end
        executeQuery(query, numberForDelete, server251, "Registracije");
    }

    // start preparedStatemnt and print two case
    public static void executeQuery(String query, String numberForDelete, Server server, String imeTabele) throws SQLException {
        PreparedStatement ps = ConnectionDetel.getConn().prepareStatement(query);
        ps.setString(1, numberForDelete);
        int rs = ps.executeUpdate();
        if (rs > 0) {
            System.out.println("DELETE " + numberForDelete + " FROM " + server.getDatabaseName() + " " + imeTabele);
        } else {
            System.out.println("NO NUMBER IN " + server.getServerName() + "." + server.getDatabaseName() + "." + imeTabele);
        }
    }

}
