/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package todo_bit707;
import java.sql.*;

/**
 *
 * @author noble
 */
public class Controller {
    
    /**
     * Creates a connection to the database using the JDBC driver for SQLite.
     * @return a Connection object representing the database connection
     */
    private Connection connect(){
        String url = "jdbc:sqlite:ToDo.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        }
        catch(SQLException e){
            System.out.println("Connection error: " + e);
        }
        return conn;
    }
    
    /**
     * Executes an SQL query to fetch all tasks from the database and prints the results to the console.
     * Uses the connect() method to create a database connection.
     */
    public void selectAll(){
        String sql = "SELECT * FROM Tasks";
        try {
            Connection conn = this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()){
                System.out.println(rs.getInt("taskNumber") +  "\t" + 
                                   rs.getString("taskName"));
            }
            // Close the result set, statement, and connection
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(SQLException e)
        {
            System.out.println("Selection error: " + e);
        }
    }
    
    
}
