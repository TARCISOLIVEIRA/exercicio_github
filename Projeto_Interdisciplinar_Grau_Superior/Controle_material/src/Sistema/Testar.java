
package Sistema;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author tarci
 */
public class Testar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
        new ConexaoBancoRelatorio().conecta();
        JOptionPane.showMessageDialog(null, "Sucesso");
    }catch (HeadlessException erro) {
       JOptionPane.showMessageDialog(null, "Erro SQL"+ erro.getMessage());
    }
    }
}
