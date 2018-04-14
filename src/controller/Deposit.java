package controller;


import dbconnection.ConnectDB;
import dbconnection.Query;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Deposit {
    private BigDecimal coin;
    public Deposit(Double coin){
      this.coin=new BigDecimal(coin);
    }

    public Boolean insert() throws SQLException {
        Connection conn= ConnectDB.getConnection();
        int n=0;
        if(this.coin.intValue()<=0.00)
            return false;
        else
            {
                PreparedStatement ps=conn.prepareStatement(Query.buyCoin);
                ps.setDouble(1,this.coin.doubleValue());
                ps.setInt(2,Session.getUser().getId());
                n=ps.executeUpdate();
            }
        return n>0;
    }

    public Double getDeposit(){
        return this.coin.doubleValue();
    }


}
