package com.cybertek.jdbc.day_3;

import com.cybertek.utilities.DB_Utility;
import static  com.cybertek.utilities.DB_Utility.*;

import java.sql.*;

public class SpartanDB_Practice {
    public static void main(String[] args) throws SQLException {

//        String url = "jdbc:oracle:thin:@54.161.111.195:1521:XE";
//        String username = "SP";
//        String password = "SP";
//
//        DB_Utility.createConnection(url,username,password);
        createConnection();

        ResultSet rs = DB_Utility.runQuery("SELECT * FROM SPARTANS");

        // all data


        //
        //    Run query "SELECT * FROM EMPLOYEES"

        //    1. Display all data in console
        //displayAllData();
        //    2. Print column count
        System.out.println("COLUMN COUNT IS: ==>> " + getColumnCNT());
        //    3. Print row count
        System.out.println("Print row count ==>> " + getRowCount());
        //    4. Print out 3rd row data as a list
        System.out.println("Print out 3rd row data as a list ==>> " + getRowDataAsList(3));
        //    5. Print out 2nd column data as a list
        System.out.println("Print out 2nd column data as a list ==>> " + getColumnDataAsList(2));
        //    6, Print out Name column data as a list
        System.out.println("Print out Name column data as a list ==>> " + getColumnDataAsList("NAME"));
        //    7, Print out 4th row as a Map
        System.out.println("Print out 4th row as a Map ==>> " + getRowMap(4));
        //    8, Print out the data at row 5, column 1
        System.out.println("Print out the data at row 5, column 1 ==>> " + getColumnDataAtRow(5, 1));
        //    9, Print out the data at row 53, phone column
        System.out.println("Print out the data at row 53, phone column ==>> " + getColumnDataAtRow(53, "phone"));
        //    10. Print out all the data as List of Map
        System.out.println();
        // each row is represented as a map
        // and we want to get List of each row data as map
        //
        System.out.println( DB_Utility.getAllDataAsListOfMap());

        //  we are storing each row as object
        // and we have 100 row , so we can store this 100 map object into one Collection
        // --->>  List of these object List< Map<String, String>  >




//        System.out.println();
//        System.out.println("Print out 4th row as a Map ==>> " + getRowMap(4));
//










    }

}
