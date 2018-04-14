package controller;



import dbconnection.ConnectDB;
import dbconnection.Query;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class BuyGame {
    private Game g;

    public BuyGame(Game g) throws SQLException {
        this.g=g;
        buy();
    }

    private void buy() throws SQLException {

            ConnectDB.getConnection().setAutoCommit(false);

            PreparedStatement ps=  ConnectDB.getConnection().prepareStatement(Query.buyGame);
            ps.setInt(1,Session.getUser().getId());
            ps.setInt(2,this.g.getId());
            ps.setInt(3,new Random().nextInt(10000)+100);
            ps.setBigDecimal(4,g.getPrice());

            PreparedStatement ps2=  ConnectDB.getConnection().prepareStatement(Query.withdraw);
            ps2.setBigDecimal(1,this.g.getPrice());
            ps2.setInt(2, Session.getUser().getId());

            PreparedStatement ps3=  ConnectDB.getConnection().prepareStatement(Query.product);
            ps3.setInt(1,g.getId());

            ps.executeUpdate();
            ps2.executeUpdate();
            ps3.executeUpdate();
            ConnectDB.getConnection().commit();
            ConnectDB.getConnection().setAutoCommit(false);
    }

}
