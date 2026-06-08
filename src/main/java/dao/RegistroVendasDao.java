package dao;

import bd.BancoDados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import pojo.RegistroVendas;

public class RegistroVendasDao {
    private final String SQL_INCLUIR = "INSERT INTO REGISTROVENDAS VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String SQL_ALTERAR = "UPDATE REGISTROVENDAS SET DATA = ?, CLIENTE = ?, PRODUTO = ?, QTDEVENDIDA = ?, PRECOVENDAU = ?,"
            + " DESCTOTAL = ?, VALORTOTAL = ?, CODIGOCLIENTE = ?, CODPROD = ? WHERE NUMVENDA = ?";
    private final String SQL_EXCLUIR = "DELETE FROM REGISTROVENDAS WHERE NUMVENDA = ?";
    private final String SQL_CONSULTAR = "SELECT * FROM REGISTROVENDAS WHERE NUMVENDA = ?";
    public static final String SQL_PESQUISAR = "SELECT REGISTROVENDAS.NUMVENDA, REGISTROVENDAS.DATA, REGISTROVENDAS.CLIENTE," +
    "REGISTROVENDAS.PRODUTO, REGISTROVENDAS.QTDEVENDIDA, REGISTROVENDAS.PRECOVENDAU, REGISTROVENDAS.DESCTOTAL, REGISTROVENDAS.VALORTOTAL," +
    "CADASTROCLIENTES.CODIGOCLIENTE, CADASTROPRODUTOS.CODPROD FROM REGISTROVENDAS " +
    "INNER JOIN CADASTROCLIENTES ON REGISTROVENDAS.CODIGOCLIENTE = CADASTROCLIENTES.CODIGOCLIENTE " +
    "INNER JOIN CADASTROPRODUTOS ON REGISTROVENDAS.CODPROD = CADASTROPRODUTOS.CODPROD";
    
    public static final String SQL_COMBOBOX = "SELECT REGISTROVENDAS.NUMVENDA, REGISTROVENDAS.CLIENTE FROM REGISTROVENDAS ORDER BY REGISTROVENDAS.CLIENTE";
    private RegistroVendas registroVendas;
    
    public RegistroVendasDao (RegistroVendas registroVendas) {
        this.registroVendas = registroVendas;
    }
    
    public boolean inserir() {
        try {
            PreparedStatement ps = BancoDados.getConexao().prepareStatement(SQL_INCLUIR);
            ps.setInt(1, registroVendas.getNumVenda());
            ps.setString(2, registroVendas.getData());
            ps.setString(3, registroVendas.getCliente());
            ps.setString(4, registroVendas.getProduto());
            ps.setString(5, registroVendas.getQtdeVendida());
            ps.setString(6, registroVendas.getPrecoVendaU());
            ps.setString(7, registroVendas.getDescTotal());
            ps.setString(8, registroVendas.getValorTotal());
            ps.setInt(9, registroVendas.getCodigoCliente());
            ps.setInt(10, registroVendas.getCodProd());
            ps.executeUpdate();
            return true;
        }catch (Exception e) {
           System.out.println("Erro ao incluir a venda: " + e.getMessage());
           JOptionPane.showMessageDialog(null, "Não foi possível incluir a Venda."); 
           return false;
        }
    }
    
    public boolean alterar() {
        try {
            PreparedStatement ps = BancoDados.getConexao().prepareStatement(SQL_ALTERAR);
            ps.setString(1, registroVendas.getData());
            ps.setString(2, registroVendas.getCliente());
            ps.setString(3, registroVendas.getProduto());
            ps.setString(4, registroVendas.getQtdeVendida());
            ps.setString(5, registroVendas.getPrecoVendaU());
            ps.setString(6, registroVendas.getDescTotal());
            ps.setString(7, registroVendas.getValorTotal());
            ps.setInt(8, registroVendas.getCodigoCliente());
            ps.setInt(9, registroVendas.getCodProd());
            ps.setInt(10, registroVendas.getNumVenda());
            ps.executeUpdate();
            return true;
        }catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Não foi possível alterar a Venda."); 
           return false;
        }
    }
    
    public boolean excluir() {
        try {
            PreparedStatement ps = BancoDados.getConexao().prepareStatement(SQL_EXCLUIR);
            ps.setInt(1, registroVendas.getNumVenda());
            ps.executeUpdate();
            return true;
        }catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Não foi possível excluir a Venda."); 
           return false;
        }
    }
    
    public boolean consultar() {
        try {
            PreparedStatement ps = BancoDados.getConexao().prepareStatement(SQL_CONSULTAR);
            ps.setInt(1, registroVendas.getNumVenda());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                registroVendas.setData(rs.getString("DATA"));
                registroVendas.setCliente(rs.getString("CLIENTE"));
                registroVendas.setProduto(rs.getString("PRODUTO"));
                registroVendas.setQtdeVendida(rs.getString("QTDEVENDIDA"));
                registroVendas.setPrecoVendaU(rs.getString("PRECOVENDAU"));
                registroVendas.setDescTotal(rs.getString("DESCTOTAL"));
                registroVendas.setValorTotal(rs.getString("VALORTOTAL"));
                registroVendas.setCodigoCliente(rs.getInt("CODIGOCLIENTE"));
                registroVendas.setCodProd(rs.getInt("CODPROD"));
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Venda não encontrada (" + registroVendas.getNumVenda() + ")."); 
                return false;
            }
        }catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Não foi possível consultar a Venda"); 
           return false;
        }
    }
}
