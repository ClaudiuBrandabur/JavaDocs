package ro.teamnet.zth.api.database;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Claudiu.Brandabur on 13-Jul-17.
 */
public class DBManagerTest {

    public static void main(String[] args) {
        DBManager.registerDriver();
        Connection conn = DBManager.getConnection();
        DBManager.checkConnection(conn);
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error: Connection can`t close!");
            System.exit(1);
        }
    }
}
