package com.cybertek.TRAIN_MINE.day_2;

import com.cybertek.utilities.DB_Utility;

import java.sql.ResultSet;

public class DB_utilMethodCall {
    public static void main(String[] args) {


        DBUtil_MINE.createConnection();
        ResultSet rs = DBUtil_MINE.runQuery("SELECT * FROM JOBS");


      //  DBUtil_MINE.displayAllData();
        System.out.println();
        System.out.println("Column count is  " + DBUtil_MINE.getColumnCNT());
        System.out.println("Row count is "+      DBUtil_MINE.getRowCount() );


        System.out.println("Getter the data at 3rd row as Map :  \n"+
                DBUtil_MINE.getRowMap(3));

        DB_Utility.destroy();


    }
}
