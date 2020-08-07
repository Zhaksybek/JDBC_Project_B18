package com.cybertek.jdbc.day_3;

import com.cybertek.utilities.DB_Utility;

import java.sql.ResultSet;

public class Env_Practice {

    public static void main(String[] args) {
        DB_Utility.createConnection("dev");

        ResultSet rs = DB_Utility.runQuery("SELECT * FROM SPARTANS");

      //  DB_Utility.displayAllData();

        System.out.println("DB_Utility.getAllDataAsListOfMap() = " + DB_Utility.getAllDataAsListOfMap());


    }
}
