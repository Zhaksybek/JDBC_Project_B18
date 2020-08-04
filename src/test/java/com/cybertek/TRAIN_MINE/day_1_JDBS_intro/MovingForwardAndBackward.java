package com.cybertek.TRAIN_MINE.day_1_JDBS_intro;

import java.sql.*;

public class MovingForwardAndBackward {
    public static void main(String[] args) throws SQLException {

       // String connectionStr = "jdbc:oracle:thin:@54.161.111.195:1521:XE";

        String connectionStr = "jdbc:oracle:thin:@54.161.111.195:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection conn = DriverManager.getConnection(connectionStr,username,password);
       // Statement   stmnt = conn.createStatement();
        Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmnt.executeQuery("SELECT *FROM COUNTRIES");

        rs.next();
        System.out.println(rs.getString("COUNTRY_ID") + " " + rs.getString("COUNTRY_NAME"));

        rs.next();
        System.out.println(rs.getString("COUNTRY_ID") + " " + rs.getString("COUNTRY_NAME"));
        // HOW DO I GO BACK TO PREVIOUS ROW
        rs.previous();
        System.out.println(rs.getString("COUNTRY_ID") + " " + rs.getString("COUNTRY_NAME"));

        rs.last();
        System.out.println(rs.getString("COUNTRY_ID") + " " + rs.getString("COUNTRY_NAME"));

        rs.first();
        System.out.println(rs.getString("COUNTRY_ID") + " " + rs.getString("COUNTRY_NAME"));


        rs.absolute(5);  // this how we can move to specific row ; here 5 is row number
        System.out.println(rs.getString("COUNTRY_ID") + " " + rs.getString("COUNTRY_NAME"));

        // how to move to before first row location
        rs.beforeFirst();

        // how to move to after last row location
        rs.afterLast();






        // MOVING THE CURSOR FREELY between rows
//        rs.previous();  we are at first row , this will move us to beforefirst location
//        System.out.println(rs.getString("COUNTRY_ID") + " " + rs.getString("COUNTRY_NAME"));

        //  moving to the last row directly
//        rs.last();   // this will move the cursor to the last row location
//        System.out.println(rs.getString("COUNTRY_ID") + " " + rs.getString("COUNTRY_NAME"));
//        rs.first();  // this will move the cursor to the first row location
//        System.out.println(rs.getString("COUNTRY_ID") + " " + rs.getString("COUNTRY_NAME"));
//        rs.absolute(5) ; // this will move the cursor directly to the 5 th row
//        System.out.println(rs.getString("COUNTRY_ID") + " " + rs.getString("COUNTRY_NAME"));

        // how to move to before first row location
//        rs.beforeFirst();
//        // how to move to after last row location
//        rs.afterLast();

//------ cleaning up -----
        rs.close();
        stmnt.close();
        conn.close();




//        while (rs.next() == true){
//            System.out.println(  rs.getString(1)+" "+
//                    rs.getString(2)+" "+
//                    rs.getString(3));
//        }
//
//        rs.previous();
//        System.out.println(  rs.getString(1)+" "+
//                rs.getString(2)+" "+
//                rs.getString(3));







//        while (rs.next()==true){
//            System.out.println( rs.getString("Country_id")+" "+
//                    rs.getString("country_name")+
//                    " "+ rs.getString("region_id"));
//        }
//
//        rs.previous();
//        System.out.println( rs.getString("Country_id")+" "+ rs.getString("country_name")+
//                " "+ rs.getString("region_id"));




    }
}
