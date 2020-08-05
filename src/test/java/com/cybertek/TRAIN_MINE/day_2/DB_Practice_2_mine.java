package com.cybertek.TRAIN_MINE.day_2;

import com.cybertek.jdbc.day_1.Db_connection;
import com.cybertek.utilities.DB_Utility;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DB_Practice_2_mine {
    public static void main(String[] args) throws SQLException {

        DBUtil_MINE.createConnection();
        ResultSet rs = DBUtil_MINE.runQuery("SELECT * FROM REGIONS");

        DBUtil_MINE.displayAllData();
//        System.out.println();
//        //   move resultSet cursor to second row
//        rs.absolute(2);
//        DBUtil_MINE.displayAllData();

        System.out.println();

      //  DBUtil_MINE.runQuery("SELECT * FROM EMPLOYEES where salary > 15000");

        DBUtil_MINE.displayAllData();

        System.out.println();

        System.out.println("DBUtil_MINE.getColumnDataAtRow(3,2) = "
                + DBUtil_MINE.getColumnDataAtRow(3, 2));  // Asia

        System.out.println("DBUtil_MINE.getColumnDataAtRow(3, \"REGION_NAME\") = "
                + DBUtil_MINE.getColumnDataAtRow(3, "REGION_NAME"));


        DBUtil_MINE.runQuery("SELECT * FROM EMPLOYEES");
        System.out.println("DBUtil_MINE.getRowDataAsList(4) = " +
                DBUtil_MINE.getRowDataAsList(4));

        System.out.println();

       // System.out.println("DBUtil_MINE.getColumnDataASList(4) = " + DBUtil_MINE.getColumnDataASList(4));

        DBUtil_MINE.runQuery("SELECT * FROM REGIONS");

        System.out.println("DBUtil_MINE.getColumnDataASList(\"REGION_NAME\") = "
                + DBUtil_MINE.getColumnDataASList("REGION_NAME"));




//        int colCount = DBUtil_MINE.getColumnCNT();
//        //rs.first(); // moving to the first row
//        while (rs.next()==true){ // row iteration
//            for (int rowNum = 1; rowNum <= colCount; rowNum++ ){  // column iteration
//                System.out.print(rs.getString( rowNum ) +"\t");
//            }
//            System.out.println(); // adding
//
//        }


        // ==================================
        //rs.next();
      // rs.beforeFirst();



//    while (rs.next()==true) {
//        int colCount = DBUtil_MINE.getColumnCNT();
//        for (int rowNum = 1; rowNum <= colCount; rowNum++) {
//
//            System.out.print(rs.getString(rowNum) + "\t");
//        }
//        System.out.println();
//    }




//        DBUtil_MINE.createConnection();
//
//        ResultSet rs =  DBUtil_MINE.runQuery("SELECT * FROM DEPARTMENTS");




//
//            rs.next();
////        System.out.println(rs.getString(1));
//
//        int colCount = DBUtil_MINE.getColumnCNT();
//
//        rs.beforeFirst();
//        while (rs.next()==true){
//
//            for (int rowNum = 1 ; rowNum<=colCount; rowNum++){
//            System.out.print(rs.getString(rowNum) +"\t");
//            }
//            System.out.println();
//        }










        DB_Utility.destroy();

    }

}
