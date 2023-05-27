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
public class UserController {
    
    private static UserController instance;
    private User loggedInUser;
    
    public static UserController getInstance(){
        if(instance == null){
            instance = new UserController();
        }
        return instance;
    }
    
    public Boolean login(String userName, String password){
        User user = getUserByUserName(userName);
        
        if (user != null && user.login(password)) {
            loggedInUser = user;
            return true;
        } else {
            return false;
        }
    }
    
    private User getUserByUserName(String userName){
        try{
            Connection conn = DbConnection.ConnectionDB();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Users WHERE userName = ?");
            stmt.setString(1, userName);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("userId"));
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                // Set other properties of the User object if needed
                return user;
            }

        }
        catch(Exception e){
            System.out.println("Error: " + e);
        }
        return null;
    }
    
    public void logout(){
        loggedInUser = null;
    }
    
}
