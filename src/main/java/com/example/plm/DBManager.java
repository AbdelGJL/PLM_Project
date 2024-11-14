package com.example.plm;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import static java.sql.Types.NULL;

public class DBManager {
     public Connection Connector(){
        try {
            Connection connection =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/shopwomen?serverTimezone=Europe%2FParis", "root","Abdeljijel18!");
            return connection;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
        try{
            if(myStmt!=null)
                myStmt.close();
            if(myRs!=null)
                myRs.close();
            if(myConn!=null)
                myConn.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}