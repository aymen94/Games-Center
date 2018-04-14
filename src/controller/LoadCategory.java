package controller;

import dbconnection.ConnectDB;
import dbconnection.Query;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LoadCategory {
    private ArrayList<Category> list;

    public LoadCategory(){
        list= new ArrayList<Category>();
        addCategory();
    }


    private void addCategory(){
        try {

            Connection conn = ConnectDB.getConnection();
            Statement st = conn.createStatement();
            st.executeQuery(Query.category);
            ResultSet res= st.getResultSet();
            while(res.next())
                list.add(new Category(res.getInt("id"),res.getString("nome")));
        }catch (SQLException e){

        }
    }

    public ArrayList<Category> getList(){
        return list;
    }

}


