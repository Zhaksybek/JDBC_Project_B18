package com.cybertek.TRAIN_MINE.day_2;

import com.cybertek.utilities.DB_Utility;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DB_PracriceMine {
    public static void main(String[] args) throws SQLException {

        DBUtil_MINE.createConnection();
        ResultSet rs = DBUtil_MINE.runQuery("SELECT * FROM JOBS");

        // iterate over the resultset

        while (rs.next() == true){
            System.out.println(  rs.getString(1));
        }

        System.out.println("colCount = " + DBUtil_MINE.getColumnCNT());


        //========================================

         // get the first row data  without knowing the column names

        int colCount = DBUtil_MINE.getColumnCNT();
        rs.first(); // moving to the first row
        for (int i = 1; i <= colCount; i++ ){
            System.out.print(rs.getString( i ) +"\t");
        }
        System.out.println();



//        while (rs.next() == true){
//            System.out.println( rs.getString(rs)+  );
//        }




//        ResultSetMetaData rsmd = rs.getMetaData();
//        int colCount =  DBUtil_MINE.getColumnCNT();
//
//        System.out.println("colCount = " + colCount);


        //  what if we want print out everything in the resultset
        // without knowing the column names



        DB_Utility.destroy();

    }
}
