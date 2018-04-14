package controller;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbconnection.ConnectDB;
import dbconnection.Query;


public class Invoice {

	private String product;
	private BigDecimal price;
	private int number;
	private Date date;

	public static Invoice mysqlInvoice(int user,int product) throws SQLException
	{
		Connection conn=ConnectDB.getConnection();
		PreparedStatement st= conn.prepareStatement(Query.getInvoice);
		st.setInt(1,user);
		st.setInt(2, product);
		ResultSet rs=st.executeQuery();
		if(rs.next())
			return new Invoice(rs.getString("titolo"), rs.getBigDecimal("prezzo"), rs.getInt("n_fattura"), rs.getDate("_data"));
		return null;
	}
	
	public Invoice(String title, BigDecimal price, int number, Date date) {
		super();
		this.product = title;
		this.price = price;
		this.number = number;
		this.date = date;
	}
	
	public String getProduct() {
		return product;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public int getNumber() {
		return number;
	}
	public Date getDate() {
		return date;
	}
	
}
