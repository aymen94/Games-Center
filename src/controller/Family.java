package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbconnection.ConnectDB;
import dbconnection.Query;

public class Family {
	User user;
	boolean changed;
	public Family(int family, User user) throws SQLException,IllegalArgumentException
	{
	   PreparedStatement count= ConnectDB.getConnection().prepareStatement(Query.getFamilyID);
        PreparedStatement update= ConnectDB.getConnection().prepareStatement(Query.setFamilyID);
		if(family!=user.getFamily())
		{
			if(family!=0)
			{
				count.setInt(1, family);
				ResultSet res=count.executeQuery();
				if(!(res.next() && res.getInt(1)<4))
					throw new IllegalArgumentException();
			}
			update.setInt(1, family);
			update.setInt(2, user.getId());
			Session.getUser().setFamily(family);
			changed=update.executeUpdate()>0;
		}
	}
	public boolean getChanged() {
		return changed;
	}
}
