package pojo;

public class CadastroProdutos {
    private int codProd;
    private String nome;
    private String qtdeEstq;
    private String precoCompra;
    private String precoVenda;
    

    public int getCodProd() {
        return codProd;
    }

    public void setCodProd(int codProd) {
        this.codProd = codProd;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQtdeEstq() {
        return qtdeEstq;
    }

    public void setQtdeEstq(String qtdeEstq) {
        this.qtdeEstq = qtdeEstq;
    }

    public String getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(String precoCompra) {
        this.precoCompra = precoCompra;
    }

    public String getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(String precoVenda) {
        this.precoVenda = precoVenda;
    }
}
