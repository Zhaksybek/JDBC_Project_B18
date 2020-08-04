package com.cybertek.TRAIN_MINE.day_1_JDBS_intro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GettingMoreInfoAb_ResultSet {
    public static void main(String[] args) throws SQLException {
        String connectionStr = "jdbc:oracle:thin:@54.161.111.195:1521:XE";
        String username = "hr";
        String password = "hr";
        Connection conn = DriverManager.getConnection(connectionStr,username,password);
        Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmnt.executeQuery("SELECT * FROM EMPLOYEES");

        // ResultSetMetaData is data about the ResultSet like column count , column name
        // any many more info about the ResultSet itself

        ResultSetMetaData rsmd = rs.getMetaData();
        // count how many column
        int columnCount = rsmd.getColumnCount();
//        System.out.println("columnCount = " + columnCount);
//
//        String secondColumnName = rsmd.getColumnName(2);
//
//        System.out.println("secondColumnName = " + secondColumnName);


        for (int i = 1; i <= columnCount; i++){
           // System.out.println( "Number "+i+" ColumnName: => "+ rsmd.getColumnName(i) );

            System.out.print( rsmd.getColumnName(i)+ "\t");
        }

        System.out.println();

        List<String> columnNameList = new ArrayList<>();

        for (int i=1; i<= columnCount;i++){
            columnNameList.add(  rsmd.getColumnName(i) );
        }

        System.out.println("columnNameList = " + columnNameList);


        rs.close();
        stmnt.close();
        conn.close();


    }
}
