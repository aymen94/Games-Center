package controller;

import java.sql.*;
import java.util.ArrayList;

import dbconnection.ConnectDB;


public class LoadGames {
	private ResultSet res;
	private String query;
	private PreparedStatement ps;
	private ArrayList<Game> list;
	
	public LoadGames(PreparedStatement ps) throws SQLException {
		this.ps=ps;
		this.query();
		this.load();
	}
	
	public LoadGames(String st){
		this.query=st;
		this.query2();
		this.load();
	}

	private void query2(){
        try {
            Connection conn = ConnectDB.getConnection();
            Statement st = conn.createStatement();
            this.res = st.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	private void query() throws SQLException{
		res = ps.executeQuery();
	}

	public void load() {
		list = new ArrayList<>();
		try {
			while(res.next())
				list.add(new Game(
						res.getInt("cod_prodotto"),
						res.getString("titolo"),
						res.getString("cover"),
						res.getBigDecimal("prezzo"),
						res.getInt("copie_disponibili"))
						);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<Game> getList(){
		return list;
	}
}