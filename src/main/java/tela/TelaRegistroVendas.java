package tela;

import componente.MeuCampoTexto;
import componente.MeuDBComboBox;
import dao.CadastroClientesDao;
import dao.CadastroProdutosDao;
import dao.RegistroVendasDao;
import pojo.RegistroVendas;

public class TelaRegistroVendas extends TelaCadastro {
    public RegistroVendas registroVendas = new RegistroVendas();
    public RegistroVendasDao registroVendasDao = new RegistroVendasDao(registroVendas);
    public MeuCampoTexto jtfNumVenda = new MeuCampoTexto(2, true, "Número da Venda");
    public MeuCampoTexto jtfData = new MeuCampoTexto(6, true, "Data");
    public MeuCampoTexto jtfCliente = new MeuCampoTexto(10, true, "Cliente");
    public MeuCampoTexto jtfProduto = new MeuCampoTexto(10, true, "Produto");
    public MeuCampoTexto jtfQtdeVendida = new MeuCampoTexto(10, true, "Quantidade Vendida");
    public MeuCampoTexto jtfPrecoVendaU = new MeuCampoTexto(10, true, "Preço de Venda Unitário");
    public MeuCampoTexto jtfDescTotal = new MeuCampoTexto(10, true, "Desconto Total");
    public MeuCampoTexto jtfValorTotal = new MeuCampoTexto(10, true, "Valor Total");
    public MeuCampoTexto jtfCodigoCliente = new MeuCampoTexto(3, true, "Código do Cliente");
    public MeuCampoTexto jtfCodProd = new MeuCampoTexto(2, true, "Código do Produto");
    private MeuDBComboBox campoCodigoCliente = new MeuDBComboBox(CadastroClientesDao.SQL_COMBOBOX, true, "CodigoCliente");
    private MeuDBComboBox campoCodProd = new MeuDBComboBox(CadastroProdutosDao.SQL_COMBOBOX, true, "CodProd");
    
    public TelaRegistroVendas() {
        super("Registro de Vendas");
        
        adicionaComponente(1,2,1,1, jtfNumVenda);
        adicionaComponente(2,2,1,1, jtfData);
        adicionaComponente(3,2,1,1, jtfCliente);
        adicionaComponente(3,4,1,1, jtfProduto);
        adicionaComponente(4,2,1,1, jtfQtdeVendida);
        adicionaComponente(4,4,1,1, jtfPrecoVendaU);
        adicionaComponente(5,2,1,1, jtfDescTotal);
        adicionaComponente(5,4,1,1, jtfValorTotal);
        adicionaComponente(1,4,1,1, jtfCodigoCliente);
        adicionaComponente(1,6,1,1, jtfCodProd);
        pack();
        habilitaComponentes(false);
    }
    
    public void setPersistencia() {
        registroVendas.setNumVenda(Integer.parseInt(jtfNumVenda.getText()));
        registroVendas.setData(jtfData.getText());
        registroVendas.setCliente(jtfCliente.getText());
        registroVendas.setProduto(jtfProduto.getText());
        registroVendas.setQtdeVendida(jtfQtdeVendida.getText());
        registroVendas.setPrecoVendaU(jtfPrecoVendaU.getText());
        registroVendas.setDescTotal(jtfDescTotal.getText());
        registroVendas.setValorTotal(jtfValorTotal.getText());
        registroVendas.setCodigoCliente(Integer.parseInt (jtfCodigoCliente.getText()));
        registroVendas.setCodProd(Integer.parseInt(jtfCodProd.getText()));
    }
    
    @Override
     public void incluirBD() {
        setPersistencia();
        registroVendasDao.inserir();
    }
     
    @Override
     public void alterarBD() {
        setPersistencia();
        registroVendasDao.alterar();
     }
      
    @Override
     public void excluirBD() {
         registroVendasDao.excluir();
         super.excluirBD();
     }
    
    @Override
    public void consultar() {
        super.consultar();
        new TelaConsulta(this, "Cosulta de Vendas", new String[] {"NumVenda", "Data", "Cliente", "Produto", "QtdeVendida", "precoVendaU",
            "DescTotal", "ValorTotal, CodigoCliente, CodProd"}, RegistroVendasDao.SQL_PESQUISAR);
    }
    
    @Override
    public void preencherDados(int pk) {
        registroVendas.setNumVenda(pk);
        registroVendasDao.consultar();
        jtfNumVenda.setText("" + registroVendas.getNumVenda());
        jtfData.setText(registroVendas.getData());
        jtfCliente.setText(registroVendas.getCliente());
        jtfProduto.setText(registroVendas.getProduto());
        jtfQtdeVendida.setText(registroVendas.getQtdeVendida());
        jtfPrecoVendaU.setText(registroVendas.getPrecoVendaU());
        jtfDescTotal.setText(registroVendas.getDescTotal());
        jtfValorTotal.setText(registroVendas.getValorTotal());
        jtfCodigoCliente.setText("" + registroVendas.getCodigoCliente());
        jtfCodProd.setText("" + registroVendas.getCodProd());
        super.preencherDados(pk);
    }
}
