package com.example.aykanberkesandal;
import java.io.IOException;
import java.sql.*;
import java.util.Set;

public class DB {
    public  static Connection conn = null;

    public  void connect() {
        try {
            // db parameters
            String url = "jdbc:sqlite:C:\\Users\\Aykan\\IdeaProjects\\190503012_AykanBerkeSandal\\sqlite3\\DB.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM Person");
            while(res.next()){
                System.out.println("PersonID: "+res.getString("PersonID"));
            }

        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
