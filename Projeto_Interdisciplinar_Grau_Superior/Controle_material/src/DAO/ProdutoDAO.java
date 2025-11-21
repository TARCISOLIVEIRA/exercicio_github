package DAO;

import DTO.ProdutoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class ProdutoDAO {

    Connection con;
    PreparedStatement pstm;

    public void cadastrarProduto(ProdutoDTO objprodutodto) {

        String sql = "insert into materiais(nome,descricao, unidade ) values(?,?,?)";

        con = new ConexaoDAO().conectaBanco();

        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, objprodutodto.getNome_material());
            pstm.setString(2, objprodutodto.getDescricao_material());
            pstm.setInt(3,objprodutodto.getQuantidade_material());
            
            pstm.execute();
            pstm.close();

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "ProdutoDAO" + erro);

        }
    }

}
