package DAO;

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDAO {
    
    public Connection conectaBanco() {
        Connection con = null;
        
    
   try{ 
       String url = "jdbc:mysql:// localhost:3306/banco?user=root&passoword=";
       con = DriverManager.getConnection(url); 
   
   
   }catch(SQLException erro) {
      JOptionPane.showMessageDialog(null, "ConexaoDAO"+ erro.getMessage()); 
   }
   
    return con;    
        
    }
    
}
