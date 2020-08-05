package com.cybertek.TRAIN_MINE.day_2;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtil_MINE {
    // adding field so we can access in all static methods
   private static  Connection conn ;
   private static Statement stmnt;
   private static ResultSet rs;

   public static void destroy(){
      try {


       if (rs!=null){
          rs.close();
      }

          if (stmnt!=null){
              rs.close();
          }

          if (conn!=null){
              rs.close();
          }


      }catch (SQLException e){
          e.printStackTrace();
      }
   }


    /**
     * We wan to store certain row data as a map
     * give me number 3 row ==>> Map<String, String > {region_id: 3 , region_name : Asia }
     */
    public static Map<String,String> getRowMap(int rowNum){
        Map<String , String> rowMap = new HashMap<>();

        try {
            rs.absolute(rowNum);

            ResultSetMetaData rsmd = rs.getMetaData();
            for (int colNum = 0; colNum <=getColumnCNT() ; colNum++) {
                String colName = rsmd.getColumnName(colNum);
                String colValue = rs.getString(colName);
                rowMap.put(colName, colValue);
            }

        }catch (SQLException e){
            System.out.println("ERROR AT ROW MAP FUNCTION");
        }
        return rowMap;
    }






    /**
     *
     * @param columnName the column you want to get a list out of
     * @return List of String that contains entire column data 1st row to last row
     */

    public static List<String> getColumnDataASList(String columnName){

        List<String> columnDataList = new ArrayList<>();
        try {
            rs.beforeFirst();
            while (rs.next()){

                String data = rs.getString(columnName);
                // getting the data from column and adding to the list
                columnDataList.add( data );
            }
            rs.beforeFirst();
        } catch (SQLException e) {
            System.out.println("ERROR WHILE getColumnDataAsList");
            e.printStackTrace();
        }

        return  columnDataList;
    }



    /**
     *
     * @param columnIndex the column you want to get a list out of
     * @return List of String that contains entire column data 1st row to last row
     */

  public static List<String> getColumnDataASList(int columnIndex){

      List<String> columnDataList = new ArrayList<>();
          try {
              rs.beforeFirst();
                  while (rs.next()){

                      String data = rs.getString(columnIndex);
                      // getting the data from column and adding to the list
                      columnDataList.add( data );
                  }
               rs.beforeFirst();
          } catch (SQLException e) {
              System.out.println("ERROR WHILE getColumnDataAsList");
              e.printStackTrace();
          }

      return  columnDataList;
      }


    /**
     * Get the row count of the resultSet
     * @return the row number of the ResultSet given
     */
   public static int getRowCount(){
       int rowCount = 0 ;

       try {
           rs.last();
           rowCount = rs.getRow();
           // moving back the cursor to before first location just in case
           rs.beforeFirst();


       } catch (SQLException e) {
           e.printStackTrace();
       }
       return rowCount;

   }





   // get the entire row as List<String>

    /**
     *
     * @param rowNum  the number you want the list from
     * @return List of String that contains the row data
     */
    public static List<String> getRowDataAsList(int rowNum){
        List<String> rowDataList = new ArrayList<>();
        // how to move that Row with rowNum
        try {
            rs.absolute(rowNum);
            //  iterate over each and every column and the valie to the list
            for (int i =1; i<= getColumnCNT(); i++){
                rowDataList.add( rs.getString(i) );
            }
            // moving the cursor back to before first location just in case
            rs.beforeFirst();

        } catch (SQLException e) {
            System.out.println("ERROR WHILE getRowDataAsList ");
            e.printStackTrace();
        }

        return  rowDataList;


    }





    /**
     *  OVERLOADED METHOD
     * @param rowNum  row number we want to get data from
     * @param columnName column index we want to get the data from
     * @return the data in String
     */
    public static String getColumnDataAtRow(int rowNum, String columnName){


        String result="";
        try {
            rs.absolute(rowNum);
            result = rs.getString(columnName);
        } catch (SQLException e) {
            System.out.println("ERROR WHILE getColumnDataRow");
            e.printStackTrace();
        }
        return result;

    }





    /**
     * Geting single column cell value at certain row
     * row 2 column 3 ==>> the data
     */

    /**
     *  OVERLOADED METHOD
     * @param rowNum  row number we want to get data from
     * @param columnIndex column index we want to get the data from
     * @return the data in String
     */
   public static String getColumnDataAtRow(int rowNum, int columnIndex){


       String result="";
       try {
           rs.absolute(rowNum);
           result = rs.getString(columnIndex);
       } catch (SQLException e) {
           System.out.println("ERROR WHILE getColumnDataRow");
           e.printStackTrace();
       }
    return result;

   }



    /**
     * a method to display all the data in the result set
     */

    public static void displayAllData(){
        int colCount = DBUtil_MINE.getColumnCNT();
        //rs.first(); // moving to the first row

    try {
        rs.beforeFirst(); // this is below loop to work
        while (rs.next()==true){ // row iteration
            for (int rowNum = 1; rowNum <= colCount; rowNum++ ){  // column iteration
                System.out.print(rs.getString( rowNum ) +"\t");
            }
            System.out.println(); // adding
        }
        // now the cursor is at after last location
        // move it back
        rs.beforeFirst(); // this is for method that might
    }catch (SQLException e){
        System.out.println("ERROR WHILE GETTING ALL DATA");
        e.printStackTrace();
    }


    }




    /**
     * a method get the column count of the current Resultset
     *
     * getColumnCount()
     */

    public static int getColumnCNT(){
        int colCount = 0;

        try {
            ResultSetMetaData rsmd= rs.getMetaData();
             colCount = rsmd.getColumnCount();
        } catch (SQLException e) {
            System.out.println("ERROR WHILE COUNTING THE COLUMNS");
            e.printStackTrace();
        }
        return colCount;
    }



    /**
     * a static method to get the ResultSet object
     * with valid connection by executing query
     */
    public static ResultSet runQuery(String query){

        try {
             stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stmnt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }




    /**
     * a static method to create connection
     * with valid url and username password
     */

    public static void createConnection(){
         String connectionStr = "jdbc:oracle:thin:@54.161.111.195:1521:XE";
                String username = "hr";
                String password = "hr";

        try {
             conn = DriverManager.getConnection(connectionStr,username,password);
            System.out.println("CONNECTION SUCCESSFUL!");
        } catch (SQLException e) {
            System.out.println("CONNECTION HAS FAILED!!!");
            e.printStackTrace();
        }
    }











}
