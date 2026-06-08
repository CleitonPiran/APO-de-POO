package tela;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TelaSistema extends JFrame implements ActionListener {
    public static JDesktopPane jdp = new JDesktopPane();
    public JMenuBar jmb = new JMenuBar();
    public JMenu jmCadastros = new JMenu("Cadastros");
    public JMenu jmMovimentos = new JMenu("Movimentos");
    public JMenu jmRelatorios = new JMenu("Relatórios");
    public JMenuItem jmiCliente = new JMenuItem("Cliente");
    public JMenuItem jmiProduto = new JMenuItem("Produto");
    public JMenuItem jmiVendas = new JMenuItem("Vendas");
    
    public TelaSistema() {
        getContentPane().add(jdp);
        jdp.setBackground(Color.black);
       setTitle("Sistema de Vendas");
       setSize (1024, 768);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setJMenuBar(jmb);
        jmb.add(jmCadastros);
        jmb.add(jmMovimentos);
        jmb.add(jmRelatorios);
        jmCadastros.add(jmiCliente);
        jmCadastros.add(jmiProduto);
        jmMovimentos.add(jmiVendas);
        jmiCliente.addActionListener(this);
        jmiProduto.addActionListener(this);
        jmiVendas.addActionListener(this);
       setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == jmiCliente){
            TelaCadastroClientes telaCadastroClientes = new TelaCadastroClientes();
            jdp.add(telaCadastroClientes);
        } else if (ae.getSource() == jmiProduto){
            TelaCadastroProdutos telaCadastroProdutos = new TelaCadastroProdutos();
            jdp.add(telaCadastroProdutos);
        } else if (ae.getSource() == jmiVendas){
            TelaRegistroVendas telaRegistroVendas = new TelaRegistroVendas();
            jdp.add(telaRegistroVendas);
        }
    }
}
        
