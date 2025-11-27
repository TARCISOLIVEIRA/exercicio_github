package Sistema;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoBancoRelatorio {

    final private String driver = "com.mysql.jdbc.Driver";
    final private String url = "jdbc:mysql://localhost/controle_materiais";
    final private String usuario = "root";
    final private String senha = "123456";

    private Connection conexao;
    public Statement statement;
    public ResultSet resultSet;

    public boolean conecta() {
        boolean resultado = true;
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, usuario, senha);

        } catch (ClassNotFoundException Driver) {
            JOptionPane.showMessageDialog(null, "Encontrado" + Driver);
            resultado = false;
        } catch (SQLException fonte) {

            JOptionPane.showMessageDialog(null, "Encontrado" + fonte.getMessage());
        }
        return resultado;

    }
    
    
    public void desconecta(){
       boolean resultado = true;
       try{
           conexao.close();
            JOptionPane.showMessageDialog(null, "banco fechado");
       } catch(SQLException e ){
         JOptionPane.showMessageDialog(null, "erro no banco de dados"+ e);
         resultado = false;
    }
       
   }
    
    public void executeSQL(String sql){
        try{
        statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        resultSet = statement.executeQuery(sql);
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null, "Erro SQL"+ e.getMessage());
        }
    }
            
            
            
        
    

}
