package tela;

import componente.MeuCampoTexto;
import dao.CadastroClientesDao;
import javax.swing.JLabel;
import pojo.CadastroClientes;

public class TelaCadastroClientes extends TelaCadastro {
    public CadastroClientes cadastroClientes = new CadastroClientes();
    public CadastroClientesDao cadastroClientesDao = new CadastroClientesDao(cadastroClientes);
    public MeuCampoTexto jtfCodigoCliente = new MeuCampoTexto(3, true, "Código de Cliente");
    public MeuCampoTexto jtfNome = new MeuCampoTexto(20, true, "Nome");
    public MeuCampoTexto jtfCpf = new MeuCampoTexto(10, true, "CPF");
    public MeuCampoTexto jtfRg = new MeuCampoTexto(10, true, "RG");
    public MeuCampoTexto jtfLogradouro = new MeuCampoTexto(20, true, "Logradouro");
    public MeuCampoTexto jtfNumero = new MeuCampoTexto(4, true, "Número");
    public MeuCampoTexto jtfComplemento = new MeuCampoTexto(20, false, "Complemento");
    public MeuCampoTexto jtfBairro = new MeuCampoTexto(20, true, "Bairro");
    public MeuCampoTexto jtfCidade = new MeuCampoTexto(20, true, "Cidade");
    public MeuCampoTexto jtfEstado = new MeuCampoTexto(20, true, "Estado");
    public MeuCampoTexto jtfTelefone = new MeuCampoTexto(10, true, "Telefone");
    public MeuCampoTexto jtfEmail = new MeuCampoTexto(20, true, "Email");
    
    public TelaCadastroClientes() {
       super("Cadastro de Clientes");
       
       adicionaComponente(1,2,1,1, jtfCodigoCliente);
       adicionaComponente(2,2,1,1, jtfNome);
       adicionaComponente(2,4,1,1, jtfCpf); 
       adicionaComponente(2,6,1,1, jtfRg);
       adicionaComponente(3,2,1,1, jtfLogradouro);  
       adicionaComponente(3,4,1,1, jtfNumero);
       adicionaComponente(3,6,1,1, jtfComplemento);
       adicionaComponente(4,2,1,1, jtfBairro);
       adicionaComponente(4,4,1,1, jtfCidade);
       adicionaComponente(4,6,1,1, jtfEstado);
       adicionaComponente(5,2,1,1, jtfTelefone);
       adicionaComponente(5,4,1,1, jtfEmail);
       pack();
       habilitaComponentes(false);
   }
    
    public void setPersistencia() {
        cadastroClientes.setCodigoCliente(Integer.parseInt(jtfCodigoCliente.getText()));
        cadastroClientes.setNome(jtfNome.getText());
        cadastroClientes.setCpf(jtfCpf.getText());
        cadastroClientes.setRg(jtfRg.getText());
        cadastroClientes.setLogradouro(jtfLogradouro.getText());
        cadastroClientes.setNumero(Integer.parseInt(jtfNumero.getText()));
        cadastroClientes.setComplemento(jtfComplemento.getText());
        cadastroClientes.setBairro(jtfBairro.getText());
        cadastroClientes.setCidade(jtfCidade.getText());
        cadastroClientes.setEstado(jtfEstado.getText());
        cadastroClientes.setTelefone(jtfTelefone.getText());
        cadastroClientes.setEmail(jtfEmail.getText());
    }
    
    @Override
    public void incluirBD() {
        setPersistencia();
        cadastroClientesDao.inserir();
    }
    
    @Override
    public void alterarBD() {
        setPersistencia();
        cadastroClientesDao.alterar();
    }
    
    public void exluirBD() {
        cadastroClientesDao.excluir();
        super.excluirBD();
    }
    
    @Override
    public void consultar() {
        super.consultar();
        new TelaConsulta(this, "Cosulta de Cliente", new String[] {"CódigoCliente", "Nome", "CPF", "RG", "Logradouro", "Número",
            "Complemento", "Bairro", "Cidade", "Estado", "Telefone", "Email"}, CadastroClientesDao.SQL_PESQUISAR);
    }
    
    @Override
    public void preencherDados(int pk) {
        cadastroClientes.setCodigoCliente(pk);
        cadastroClientesDao.consultar();
        jtfCodigoCliente.setText("" + cadastroClientes.getCodigoCliente());
        jtfNome.setText(cadastroClientes.getNome());
        jtfCpf.setText(cadastroClientes.getCpf());
        jtfRg.setText(cadastroClientes.getRg());
        jtfLogradouro.setText(cadastroClientes.getLogradouro());
        jtfNumero.setText("" + cadastroClientes.getNumero());
        jtfComplemento.setText(cadastroClientes.getComplemento());
        jtfBairro.setText(cadastroClientes.getBairro());
        jtfCidade.setText(cadastroClientes.getCidade());
        jtfEstado.setText(cadastroClientes.getEstado());
        jtfTelefone.setText(cadastroClientes.getTelefone());
        jtfEmail.setText(cadastroClientes.getEmail());
        super.preencherDados(pk);
    }
}
