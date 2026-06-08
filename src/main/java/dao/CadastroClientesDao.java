package dao;

import bd.BancoDados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import pojo.CadastroClientes;

public class CadastroClientesDao {
    private final String SQL_INCLUIR = "INSERT INTO CADASTROCLIENTES VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String SQL_ALTERAR = "UPDATE CADASTROCLIENTES SET NOME = ?, CPF = ?, RG = ?, LOGRADOURO = ?, NUMERO = ?,"
            + " COMPLEMENTO = ?, BAIRRO = ?, CIDADE = ?, ESTADO = ?, TELEFONE = ?, EMAIL = ? WHERE CODIGOCLIENTE = ?";
    private final String SQL_EXCLUIR = "DELETE FROM CADASTROCLIENTES WHERE CODIGOCLIENTE = ?";
    private final String SQL_CONSULTAR = "SELECT * FROM CADASTROCLIENTES WHERE CODIGOCLIENTE = ?";
    public static final String SQL_PESQUISAR = "SELECT * FROM CADASTROCLIENTES ORDER BY CODIGOCLIENTE";
    public static final String SQL_COMBOBOX = "SELECT CODIGOCLIENTE, NOME FROM CADASTROCLIENTES ORDER BY NOME";
    private CadastroClientes cadastroClientes;
    
    public CadastroClientesDao (CadastroClientes cadastroClientes) {
        this.cadastroClientes = cadastroClientes;
    }
    
    public boolean inserir() {
        try {
            PreparedStatement ps = BancoDados.getConexao().prepareStatement(SQL_INCLUIR);
            ps.setInt(1, cadastroClientes.getCodigoCliente());
            ps.setString(2, cadastroClientes.getNome());
            ps.setString(3, cadastroClientes.getCpf());
            ps.setString(4, cadastroClientes.getRg());
            ps.setString(5, cadastroClientes.getLogradouro());
            ps.setInt(6, cadastroClientes.getNumero());
            ps.setString(7, cadastroClientes.getComplemento());
            ps.setString(8, cadastroClientes.getBairro());
            ps.setString(9, cadastroClientes.getCidade());
            ps.setString(10, cadastroClientes.getEstado());
            ps.setString(11, cadastroClientes.getTelefone());
            ps.setString(12, cadastroClientes.getEmail());
            ps.executeUpdate();
            return true;
        }catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Não foi possível incluir o Cliente."); 
           return false;
        }
    }
    
    public boolean alterar() {
        try {
            PreparedStatement ps = BancoDados.getConexao().prepareStatement(SQL_ALTERAR);
            ps.setString(1, cadastroClientes.getNome());
            ps.setString(2, cadastroClientes.getCpf());
            ps.setString(3, cadastroClientes.getRg());
            ps.setString(4, cadastroClientes.getLogradouro());
            ps.setInt(5, cadastroClientes.getNumero());
            ps.setString(6, cadastroClientes.getComplemento());
            ps.setString(7, cadastroClientes.getBairro());
            ps.setString(8, cadastroClientes.getCidade());
            ps.setString(9, cadastroClientes.getEstado());
            ps.setString(10, cadastroClientes.getTelefone());
            ps.setString(11, cadastroClientes.getEmail());
            ps.setInt(12, cadastroClientes.getCodigoCliente());
            ps.executeUpdate();
            return true;
        }catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Não foi possível alterar o Cliente."); 
           return false;
        }
    }
    
    public boolean excluir() {
        try {
            PreparedStatement ps = BancoDados.getConexao().prepareStatement(SQL_EXCLUIR);
            ps.setInt(1, cadastroClientes.getCodigoCliente());
            ps.executeUpdate();
            return true;
        }catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Não foi possível excluir o Cliente."); 
           return false;
        }
    }
    
    public boolean consultar() {
        try {
            PreparedStatement ps = BancoDados.getConexao().prepareStatement(SQL_CONSULTAR);
            ps.setInt(1, cadastroClientes.getCodigoCliente());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cadastroClientes.setNome(rs.getString("NOME"));
                cadastroClientes.setCpf(rs.getString("CPF"));
                cadastroClientes.setRg(rs.getString("RG"));
                cadastroClientes.setLogradouro(rs.getString("LOGRADOURO"));
                cadastroClientes.setNumero(rs.getInt("NUMERO"));
                cadastroClientes.setComplemento(rs.getString("COMPLEMENTO"));
                cadastroClientes.setBairro(rs.getString("BAIRRO"));
                cadastroClientes.setCidade(rs.getString("CIDADE"));
                cadastroClientes.setEstado(rs.getString("ESTADO"));
                cadastroClientes.setTelefone(rs.getString("TELEFONE"));
                cadastroClientes.setEmail(rs.getString("EMAIL"));
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado (" + cadastroClientes.getCodigoCliente() + ")."); 
                return false;
            }
        }catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Não foi possível consultar o Cliente"); 
           return false;
        }
    }
}
