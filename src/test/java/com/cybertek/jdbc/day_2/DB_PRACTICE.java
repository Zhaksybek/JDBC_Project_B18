package com.cybertek.jdbc.day_2;

import com.cybertek.utilities.DB_Utility;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DB_PRACTICE {

    public static void main(String[] args) throws SQLException {

        DB_Utility.createConnection();
        ResultSet rs = DB_Utility.runQuery("SELECT * FROM JOBS");


//        rs.next();
//        System.out.println( rs.getString(1)+" "+rs.getString(2) );

        while (rs.next() == true){
            System.out.println(  rs.getString("job_id"));
        }

//        ResultSetMetaData rsmd = rs.getMetaData();
//        int colCount = rsmd.getColumnCount();


        System.out.println("colCount = " + DB_Utility.getColumnCNT());



        //  what is if we want to print out everything in the resultset
        // without knowing the column names
        //

        // get the first row data

        int colCount = DB_Utility.getColumnCNT();
        rs.first();  //  moving to the first row
        for (int i=1; i<= colCount; i++){
            System.out.print( rs.getString( i )+ "\t");
        }

        System.out.println( "=====================");





    }
}
