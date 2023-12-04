/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;

/**
 Step 1 : Register the driver class(mysql driver)
 Step 2 : Create the connection
 Step 3 : Creating a statement
 Step 4 : Executing my mysql queries
 Step 5 : Closing the connection (Optional)
 */
import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    Conn(){
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem","root","Anushasn@24");
           s=c.createStatement();
       }
       catch (Exception e){
           e.printStackTrace();
       }
    }
}
