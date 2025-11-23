package DAO;

import DTO.ProdutoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProdutoDAO {

    Connection con;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<ProdutoDTO>lista = new ArrayList<>();

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

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "ProdutoDAO cadastrar" + erro);
        }
        
    }
    
    public ArrayList<ProdutoDTO>PesquisarProduto(){
        String sql = "select * from materiais";
        
        con = new ConexaoDAO().conectaBanco();
        try {
            
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                ProdutoDTO objprodutodto = new ProdutoDTO();
                objprodutodto.setId_material(rs.getInt("id"));
                objprodutodto.setNome_material(rs.getString("nome"));
                objprodutodto.setDescricao_material(rs.getString("descricao"));
                objprodutodto.setQuantidade_material(rs.getInt("unidade"));
                
                lista.add(objprodutodto);
            }
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null,"ProdutoDAO pesquisar" + erro);
        }
        return lista;
    }
    
    public void alterarProduto(ProdutoDTO objprodutodto){
        String sql = "update materiais set nome = ?, descricao = ?, unidade = ? where id = ?";
        
        con = new ConexaoDAO().conectaBanco();
        
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, objprodutodto.getNome_material());
            pstm.setString(2, objprodutodto.getDescricao_material());
            pstm.setInt(3,objprodutodto.getQuantidade_material());
            pstm.setInt(4, objprodutodto.getId_material());
            
            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "ProdutoDAO Alterar" + erro);
        }
        
        
    }
    
    public void excluirProduto(ProdutoDTO objprodutodto){
        String sql = "delete from materiais  where id = ?";
        
        con = new ConexaoDAO().conectaBanco();
        
        try {
            pstm = con.prepareStatement(sql);
            
            pstm.setInt(1, objprodutodto.getId_material());
            
            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "ProdutoDAO Excluir" + erro);
        }
        
    }
    
    public void adicionarProduto(ProdutoDTO dto){
        
        String sql = "update materiais set unidade = unidade + ?";
        
        
        con = new ConexaoDAO().conectaBanco();

        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, dto.getNome_material());
            pstm.setInt(3,dto.getQuantidade_material());
            
            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "ProdutoDAO Entrada" + erro);
        }
        
       
        
        
        
    }
}
