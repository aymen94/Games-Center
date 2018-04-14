package controller;

import dbconnection.ConnectDB;
import dbconnection.Query;
import handlererror.LoginError;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Login {
    private String email;
    private GPassword pass;
    private int id=0;

    public Login(String email, char[] password) throws LoginError {
            this.email = email;
            this.pass = new GPassword(password);
            this.check();
    }

    private void check(){
        try {

            Connection conn = ConnectDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(Query.login);
            ps.setString(1, email.toLowerCase());
            ps.setString(2,this.pass.getHash());
            ResultSet result = ps.executeQuery();
            if(result.next()) {
                id = result.getInt(1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "DB not Connected ", "Error DB", 0);
        }
    }

    public Boolean launch() throws LoginError {
        if(id!=0) {
            new Thread(new Session(this.id),"session").start();
            return true;
        }
        else
            throw new LoginError();

    }
}
