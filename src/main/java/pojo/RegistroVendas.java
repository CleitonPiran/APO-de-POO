package pojo;

public class RegistroVendas {
    private int numVenda;
    private String data;
    private String cliente;
    private String produto;
    private String qtdeVendida;
    private String precoVendaU;
    private String descTotal;
    private String valorTotal;
    private int CodigoCliente;
    private CadastroClientes cadastroClientes = new CadastroClientes();
    private int CodProd;
    private CadastroProdutos cadastroProdutos = new CadastroProdutos();

    public int getNumVenda() {
        return numVenda;
    }

    public void setNumVenda(int numVenda) {
        this.numVenda = numVenda;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getQtdeVendida() {
        return qtdeVendida;
    }

    public void setQtdeVendida(String qtdeVendida) {
        this.qtdeVendida = qtdeVendida;
    }

    public String getPrecoVendaU() {
        return precoVendaU;
    }

    public void setPrecoVendaU(String precoVendaU) {
        this.precoVendaU = precoVendaU;
    }

    public String getDescTotal() {
        return descTotal;
    }

    public void setDescTotal(String descTotal) {
        this.descTotal = descTotal;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    public int getCodigoCliente() {
        return CodigoCliente;
    }

    public void setCodigoCliente(int CodigoCliente) {
        this.CodigoCliente = CodigoCliente;
    }

    
     public CadastroClientes getCadastroClientes() {
        return cadastroClientes;
    }

     public void setCadastroClientes(CadastroClientes cadastroClientes) {
        this.cadastroClientes = cadastroClientes;
    }
     
     public int getCodProd() {
        return CodProd;
    }

    public void setCodProd(int CodProd) {
        this.CodProd = CodProd;
    }
     
    public CadastroProdutos getCadastroProdutos() {
        return cadastroProdutos;
    }

    public void setCadastroProdutos(CadastroProdutos cadastroProdutos) {
        this.cadastroProdutos = cadastroProdutos;
    }
}
