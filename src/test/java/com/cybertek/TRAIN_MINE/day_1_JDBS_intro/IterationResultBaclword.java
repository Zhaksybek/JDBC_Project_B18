package com.cybertek.TRAIN_MINE.day_1_JDBS_intro;

import java.sql.*;

public class IterationResultBaclword {
    public static void main(String[] args) throws SQLException {

        String connectionStr = "jdbc:oracle:thin:@54.161.111.195:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection conn = DriverManager.getConnection(connectionStr,username,password);
        // Statement   stmnt = conn.createStatement();
        Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmnt.executeQuery("SELECT * FROM REGIONS");

        rs.afterLast();

//        rs.previous();
//        System.out.println(  rs.getString(1)+" "+rs.getString(2)  );
//

        while (rs.previous() == true){
            System.out.println(  rs.getString(1)+" "+rs.getString(2)  );
        }

        System.out.println("======================");

        rs.absolute(2);
        System.out.println(  rs.getString(1)+" "+rs.getString(2)  );

        rs.first();
        System.out.println(  rs.getString(1)+" "+rs.getString(2)  );

        rs.last();
        System.out.println(  rs.getString(1)+" "+rs.getString(2)  );


        // how do i know eich row number I am right now at this location
        // getRow()  method return the row number

        System.out.println("rs.getRow() = " + rs.getRow());


        rs.absolute(2);
        System.out.println("rs.getRow() = " + rs.getRow());


    }
}
