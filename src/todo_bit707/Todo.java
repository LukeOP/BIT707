package todo_bit707;
import java.sql.*;

public class Todo {

    /**
     * The main method of this program. Creates an instance of the Todo class and calls the selectAll() method.
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new UI_Login().setVisible(true);
//            }
//        });
    }
    
}
