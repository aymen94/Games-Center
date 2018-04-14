package controller;

import dbconnection.ConnectDB;
import dbconnection.Query;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public  class User {
    private int id,family;
    private BigDecimal coin;
    private String name,lastName,email,password;
    public User(int id){
        this.id=id;
        this.getData();
    }

    private void getData(){
        Connection conn= ConnectDB.getConnection();
        try {
            PreparedStatement ps=conn.prepareStatement(Query.user);
            ps.setInt(1,this.id);
            ResultSet res =ps.executeQuery();
            if(res.next()){
                this.name=res.getString("nome");
                this.lastName=res.getString("cognome");
                this.email=res.getString("email");
                this.coin=res.getBigDecimal("saldo");
                this.password=res.getString("password");
                this.family=res.getInt("family_id");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public  int getId() {
        return id;
    }

    public BigDecimal getCoin() {
        return coin;
    }

    public void setCoin(BigDecimal coin) {
        this.coin = coin;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword(){
        return password;
    }

    public int getFamily() {
        return family;
    }

    public void setFamily(int family) {
        this.family = family;
    }
}
