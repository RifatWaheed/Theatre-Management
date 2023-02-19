
package com.mycompany.test111;

import java.sql.*;
public class ConnectionSQL {
   
   public static Connection con;
    
    public static void main (String []args){
    
        
        
        try{
     
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Register_Login;user=root;password=root");
            Statement stmt = con.createStatement();
       
                 
                   
        }catch (Exception e){
        
            System.out.println(e);
        }
    
    
    }
    
    
    
}
