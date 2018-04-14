package dbconnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB extends Thread{
    private static Connection conn=null;
    public ConnectDB(){
        setName("Connection Thread");
    }
    @Override
    public void run() {
        try {
            if(conn==null){
                Class.forName(Config.DB_DRIVER);
                conn = DriverManager.getConnection(Config.DB_URL + Config.DB_PORT + Config.DB_NAME, Config.USERNAME, Config.PASSWORD);
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null,"Connection with DB Failed","Error Connection",JOptionPane.ERROR_MESSAGE);
        }
    }


    public static Connection getConnection() {
        return conn;
    }
}
