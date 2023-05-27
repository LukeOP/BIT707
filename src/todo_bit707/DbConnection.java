/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package todo_bit707;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

/**
 *
 * @author noble
 */
public class DbConnection {
    Connection conn = null;
    
    public static Connection ConnectionDB(){
        
        try{
            Connection conn = DriverManager.getConnection("jdbc:sqlite:ToDo.db");
            System.out.println("Connection Succeeded!!");
                                 
            return conn;
        }
        catch(Exception e){
            System.out.println("Connection failed " + e);
            return null;
        }
        
    }
}
