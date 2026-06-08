package dao;

import bd.BancoDados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import pojo.CadastroProdutos;

public class CadastroProdutosDao {
    private final String SQL_INCLUIR = "INSERT INTO CADASTROPRODUTOS VALUES (?, ?, ?, ?, ?)";
    private final String SQL_ALTERAR = "UPDATE CADASTROPRODUTOS SET NOME = ?, QTDEESTQ = ?, PRECOCOMPRA = ?, PRECOVENDA = ? WHERE CODPROD = ?";
    private final String SQL_EXCLUIR = "DELETE FROM CADASTROPRODUTOS WHERE CODPROD = ?";
    private final String SQL_CONSULTAR = "SELECT * FROM CADASTROPRODUTOS WHERE CODPROD = ?";
    public static final String SQL_PESQUISAR = "SELECT CODPROD, NOME FROM CADASTROPRODUTOS ORDER BY CADASTROPRODUTOS.NOME";
    
    public static final String SQL_COMBOBOX = "SELECT CODPROD, NOME FROM CADASTROPRODUTOS ORDER BY NOME";
    private CadastroProdutos cadastroProdutos;
    
    public CadastroProdutosDao (CadastroProdutos cadastroProdutos) {
        this.cadastroProdutos = cadastroProdutos;
    }
    
    public boolean inserir() {
        try {
            PreparedStatement ps = BancoDados.getConexao().prepareStatement(SQL_INCLUIR);
            ps.setInt(1, cadastroProdutos.getCodProd());
            ps.setString(2, cadastroProdutos.getNome());
            ps.setString(3, cadastroProdutos.getQtdeEstq());
            ps.setString(4, cadastroProdutos.getPrecoCompra());
            ps.setString(5, cadastroProdutos.getPrecoVenda());
            ps.executeUpdate();
            return true;
        }catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Não foi possível incluir o Produto."); 
           return false;
        }
    }
    
    public boolean alterar() {
        try {
            PreparedStatement ps = BancoDados.getConexao().prepareStatement(SQL_ALTERAR);
            ps.setString(1, cadastroProdutos.getNome());
            ps.setString(2, cadastroProdutos.getQtdeEstq());
            ps.setString(3, cadastroProdutos.getPrecoCompra());
            ps.setString(4, cadastroProdutos.getPrecoVenda());
            ps.setInt(5, cadastroProdutos.getCodProd());
            ps.executeUpdate();
            return true;
        }catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Não foi possível alterar o Produto."); 
           return false;
        }
    }
    
    public boolean excluir() {
        try {
            PreparedStatement ps = BancoDados.getConexao().prepareStatement(SQL_EXCLUIR);
            ps.setInt(1, cadastroProdutos.getCodProd());
            ps.executeUpdate();
            return true;
        }catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Não foi possível excluir o Produto."); 
           return false;
        }
    }
    
    public boolean consultar() {
        try {
            PreparedStatement ps = BancoDados.getConexao().prepareStatement(SQL_CONSULTAR);
            ps.setInt(1, cadastroProdutos.getCodProd());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cadastroProdutos.setNome(rs.getString("NOME"));
                cadastroProdutos.setQtdeEstq(rs.getString("QTDEESTQ"));
                cadastroProdutos.setPrecoCompra(rs.getString("PRECOCOMPRA"));
                cadastroProdutos.setPrecoVenda(rs.getString("PRECOVENDA"));
                
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Produto não encontrado (" + cadastroProdutos.getCodProd() + ")."); 
                return false;
            }
        }catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Não foi possível consultar o Produto"); 
           return false;
        }
    }
}
