package me.pieralini.criptoexchange;

import java.math.BigDecimal;
import java.util.Map;
import javax.swing.JOptionPane;
import me.pieralini.criptoexchange.controle.OperacaoControle;
import me.pieralini.criptoexchange.controle.CotacaoControle;
import me.pieralini.criptoexchange.modelo.Investidor;

public class TelaComprar extends javax.swing.JFrame {
    
    private Investidor investidor;
    private final OperacaoControle operacaoControle = new OperacaoControle();
    private final CotacaoControle cotacaoControle = new CotacaoControle();

    public TelaComprar() {
        initComponents();
        setLocationRelativeTo(null);

        btnComprar.addActionListener(e -> comprar());
        btnVoltar.addActionListener(e -> dispose());
    }

    public TelaComprar(Investidor investidor) {
        this();
        this.investidor = investidor;
        carregarCotacoes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        lblCotacoes = new javax.swing.JLabel();
        lblValorCotacoes = new javax.swing.JLabel();
        lblMoeda = new javax.swing.JLabel();
        cmbMoeda = new javax.swing.JComboBox();
        lblValor = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        lblTaxa = new javax.swing.JLabel();
        btnComprar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Exchange - Comprar Criptomoedas");
        setResizable(false);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 22));
        lblTitulo.setText("Comprar Criptomoedas");
        lblSenha.setText("Confirme sua senha");
        lblCotacoes.setText("Cotações: BTC / ETH / XRP");
        lblValorCotacoes.setText("—");
        lblMoeda.setText("Moeda");
        cmbMoeda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bitcoin (BTC)", "Ethereum (ETH)", "Ripple (XRP)" }));
        lblValor.setText("Valor em reais (R$)");
        lblTaxa.setText("Taxa de compra: BTC 2%, ETH 1%, XRP 1%");
        btnComprar.setText("Comprar");
        btnVoltar.setText("Voltar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(lblSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(lblCotacoes, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(lblValorCotacoes, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(lblMoeda, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(cmbMoeda, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(lblValor, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(txtValor, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(lblTaxa, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(btnComprar, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                )
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lblSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lblCotacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lblValorCotacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lblMoeda, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(cmbMoeda, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lblValor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lblTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void carregarCotacoes() {

        try {
            Map<String, BigDecimal> cotacoes = cotacaoControle.consultar();

            lblValorCotacoes.setText(
                "BTC: R$ " + cotacoes.get("BTC")
                + " | ETH: R$ " + cotacoes.get("ETH")
                + " | XRP: R$ " + cotacoes.get("XRP")
            );

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }
    
    private void comprar() {

        if (investidor == null) {
            JOptionPane.showMessageDialog(this, "Nenhum investidor autenticado.");
            return;
        }

        try {
            String senha = new String(txtSenha.getPassword());

            String moeda = switch (cmbMoeda.getSelectedIndex()) {
                case 0 -> "BTC";
                case 1 -> "ETH";
                case 2 -> "XRP";
                default -> throw new IllegalArgumentException("Moeda inválida.");
            };

            BigDecimal valor = new BigDecimal(
                txtValor.getText().trim().replace(",", ".")
            );

            operacaoControle.comprar(investidor, senha, moeda, valor);

            JOptionPane.showMessageDialog(this, "Compra realizada com sucesso!");

            txtSenha.setText("");
            txtValor.setText("");

            carregarCotacoes();

        } catch (NumberFormatException erro) {
            JOptionPane.showMessageDialog(this, "Informe um valor válido.");

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new TelaComprar().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComprar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox cmbMoeda;
    private javax.swing.JLabel lblCotacoes;
    private javax.swing.JLabel lblMoeda;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTaxa;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblValor;
    private javax.swing.JLabel lblValorCotacoes;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
