package ro.teamnet.zth.api.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static ro.teamnet.zth.api.database.DBProperties.PASS;
import static ro.teamnet.zth.api.database.DBProperties.USER;

/**
 * Created by Claudiu.Brandabur on 13-Jul-17.
 */
public class DBManager {

    final static String CONNECTION_STRING = "jdbc:oracle:thin:@" + DBProperties.IP + ":" + DBProperties.PORT + ":xe";

    private DBManager() throws UnsupportedOperationException{
    }

    public static void registerDriver() {
        try {
            Class.forName(DBProperties.DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            //System.out.println("Exceptie la registerDriver: " + e);
            System.out.println("Error: Unable to load driver class!");
            System.exit(1);
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING, USER, PASS);
        } catch (SQLException e) {
            //System.out.println("Exceptie la getConnection: " + e);
            System.out.println("Error: Unable to create connection!");
            System.exit(1);
        }
        return conn;
    }

    public static void checkConnection(Connection connection) {
        try (Statement stmt = connection.createStatement()) {
            stmt.execute("SELECT * FROM JOBS");
        } catch (SQLException e) {
            System.out.println("Error: Unable to connect!");
            System.exit(1);
        }
    }

}