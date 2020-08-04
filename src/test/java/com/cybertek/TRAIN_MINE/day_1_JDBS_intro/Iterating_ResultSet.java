package com.cybertek.TRAIN_MINE.day_1_JDBS_intro;

import java.sql.*;

public class Iterating_ResultSet {
    public static void main(String[] args) throws SQLException {
         String connectionStr = "jdbc:oracle:thin:@54.161.111.195:1521:XE";
         String username = "hr";
         String password = "hr";

        Connection conn = DriverManager.getConnection(connectionStr,username,password);
        Statement stmnt = conn.createStatement();

        //------------
        ResultSet rs = stmnt.executeQuery("SELECT *FROM COUNTRIES");

        while (rs.next()==true){

            System.out.println(  rs.getString("COUNTRY_ID")+" "
            +"COUNTRY_NAME"+" "
                    + "REGION_ID");
        }
        //-----------



//        ResultSet rs = stmnt.executeQuery("SELECT * FROM REGIONS");
//
//        while (rs.next() == true){
//            System.out.println(  rs.getString("REGION_ID")+" " + rs.getString("REGION_NAME") );
//        }





//        rs.next();
//        System.out.println(  rs.getString(1)+" " + rs.getString(2) );
//
//        rs.next();
//        System.out.println(  rs.getString(1)+" " + rs.getString(2) );


//        rs.next();
//        System.out.println(  rs.getString("REGION_ID")+" " + rs.getString("REGION_NAME") );
//
//        rs.next();
//        System.out.println(  rs.getString("REGION_ID")+" " + rs.getString("REGION_NAME") );
//
//        rs.next();
//        System.out.println(  rs.getString(1)+" " + rs.getString(2) );
//
//        rs.next();
//        System.out.println(  rs.getString(1)+" " + rs.getString(2) );
//
//
//        System.out.println(  rs.next() );
        //System.out.println(  rs.getString(1)+" " + rs.getString(2) );






    }
}
