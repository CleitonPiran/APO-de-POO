package tela;

import componente.MeuCampoTexto;
import componente.MeuDBComboBox;
import dao.CadastroClientesDao;
import dao.CadastroProdutosDao;
import pojo.CadastroProdutos;

public class TelaCadastroProdutos extends TelaCadastro {
    public CadastroProdutos cadastroProdutos = new CadastroProdutos();
    public CadastroProdutosDao cadastroProdutosDao = new CadastroProdutosDao(cadastroProdutos);
    public MeuCampoTexto jtfCodProd = new MeuCampoTexto(2, true, "Código do Produto");
    public MeuCampoTexto jtfNome = new MeuCampoTexto(20, true, "Nome do Produto");
    public MeuCampoTexto jtfQtdeEstq = new MeuCampoTexto(10, true, "Quantidade em Estoque");
    public MeuCampoTexto jtfPrecoCompra = new MeuCampoTexto(10, true, "Preço de Compra");
    public MeuCampoTexto jtfPrecoVenda = new MeuCampoTexto(10, true, "Preço de Venda");
    
    public TelaCadastroProdutos() {
        super("Cadastro de Produtos");
        
        adicionaComponente(1,2,1,1, jtfCodProd);
        adicionaComponente(2,2,1,1, jtfNome);
        adicionaComponente(3,2,1,1, jtfQtdeEstq);
        adicionaComponente(4,2,1,1, jtfPrecoCompra);
        adicionaComponente(5,2,1,1, jtfPrecoVenda);
        pack();
        habilitaComponentes(false);
    }
    
    public void setPersistencia() {
        cadastroProdutos.setCodProd(Integer.parseInt(jtfCodProd.getText()));
        cadastroProdutos.setNome(jtfNome.getText());
        cadastroProdutos.setQtdeEstq(jtfQtdeEstq.getText());
        cadastroProdutos.setPrecoCompra(jtfPrecoCompra.getText());
        cadastroProdutos.setPrecoVenda(jtfPrecoVenda.getText());
    }
    
    @Override
    public void incluirBD() {
        setPersistencia();
        cadastroProdutosDao.inserir();
    }
    
    @Override
    public void alterarBD() {
        setPersistencia();
        cadastroProdutosDao.alterar();
    }
    
    @Override
    public void excluirBD() {
        cadastroProdutosDao.excluir();
        super.excluirBD();
    }
    
    @Override
    public void consultar() {
        super.consultar();
        new TelaConsulta(this, "Cosulta de Produto", new String[] {"CódProd", "Nome", "QtdeEstq", "PrecoCompra", "PrecoVenda"}, CadastroProdutosDao.SQL_PESQUISAR);
    }
    
    @Override
    public void preencherDados(int pk) {
        cadastroProdutos.setCodProd(pk);
        cadastroProdutosDao.consultar();
        jtfCodProd.setText("" + cadastroProdutos.getCodProd());
        jtfNome.setText(cadastroProdutos.getNome());
        jtfQtdeEstq.setText(cadastroProdutos.getQtdeEstq());
        jtfPrecoCompra.setText(cadastroProdutos.getPrecoCompra());
        jtfPrecoVenda.setText(cadastroProdutos.getPrecoVenda());
        super.preencherDados(pk);
    }
}
