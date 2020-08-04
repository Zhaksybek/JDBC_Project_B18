package com.cybertek.TRAIN_MINE.day_1_JDBS_intro;

import java.sql.*;

public class DB_Connection {
    public static void main(String[] args) throws SQLException {

        // String connectionStr = "jdbc:oracle:thin:@54.161.111.195:1521:XE";
        String connectionStr ="jdbc:oracle:thin:@54.161.111.195:1521:XE";
        String username = "hr";
        String password = "hr";
        Connection conn = DriverManager.getConnection(connectionStr,username,password);
        Statement stmnt = conn.createStatement();
        // ResultSet object is what we use to store the actual result we get from query
        ResultSet rs = stmnt.executeQuery("SELECT * FROM REGIONS");

        rs.next();

        System.out.println("First column value : ==> "+  rs.getString(1));
        System.out.println( "First column value column_name : ==> "+ rs.getString("REGION_ID")   );

        System.out.println("First column value : ==> "+  rs.getString(2));
        System.out.println( "First column value column_name : ==> "+ rs.getString("REGION_NAME")   );

        rs.next();
        System.out.println("Second column value : ==> "+  rs.getString(1));
        System.out.println( "Second column value column_name : ==> "+ rs.getString("REGION_ID")   );

        System.out.println("Second column value : ==> "+  rs.getString(2));
        System.out.println( "Second column value column_name : ==> "+ rs.getString("REGION_NAME")   );



        rs.close();
        stmnt.close();
        conn.close();






        System.out.println("SUCCESS!!!");






    }
}
