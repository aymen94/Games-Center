package controller;

import dbconnection.ConnectDB;
import dbconnection.Query;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Registration {
	private String name,lastName,email,date;
	private char[] pass,passr;

	public Registration(String name, String lastName, String email,String date, char[] pass, char[] passr) {
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.date=date;
		this.pass =pass;
		this.passr = passr;
		if(checkEmail() && checkPass())
			insert();
	}

	private Boolean checkEmail(){
		String valid="^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
		if(email.matches(valid))
			return true;
		else{
			JOptionPane.showMessageDialog(null,"Insert valid Email","Email Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	private Boolean checkPass(){
		if(String.valueOf(pass).equals(String.valueOf(passr)))
			if(pass.length>=6) {
				return true;
			}
			else{
				JOptionPane.showMessageDialog(null,"minimum 6 character for password ","Password length",JOptionPane.ERROR_MESSAGE);
				return false;
			}
		else {
			JOptionPane.showMessageDialog(null,"These Passwords don't match. Try again? ","Password Match",JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	private void insert(){
		GPassword pss= new GPassword(this.pass);
		Connection conn = ConnectDB.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(Query.register);
			ps.setString(1,name.toLowerCase());
			ps.setString(2,lastName.toLowerCase());
			ps.setString(3,email.toLowerCase());
			ps.setString(4,date.toLowerCase());
			ps.setString(5,pss.getHash());
			if(ps.executeUpdate()>0)
				JOptionPane.showMessageDialog(null,"you account has been created, login in you account","success",JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"you are already registred whit this email! login to continue","Error Registration",JOptionPane.ERROR_MESSAGE);
		}

	}


}
