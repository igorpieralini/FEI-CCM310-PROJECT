package me.pieralini.criptoexchange;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import me.pieralini.criptoexchange.controle.CarteiraControle;
import me.pieralini.criptoexchange.modelo.Carteira;
import me.pieralini.criptoexchange.modelo.Investidor;

public class TelaConsultarSaldo extends javax.swing.JFrame {
    
    private Investidor investidor;
    private final CarteiraControle carteiraControle = new CarteiraControle();

    public TelaConsultarSaldo() {
        initComponents();
        setLocationRelativeTo(null);

        btnConsultar.addActionListener(e -> consultarSaldo());
        btnVoltar.addActionListener(e -> dispose());
    }

    public TelaConsultarSaldo(Investidor investidor) {
        this();
        this.investidor = investidor;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        btnConsultar = new javax.swing.JButton();
        lblNome = new javax.swing.JLabel();
        lblValorNome = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        lblValorCpf = new javax.swing.JLabel();
        lblReais = new javax.swing.JLabel();
        lblValorReais = new javax.swing.JLabel();
        lblBitcoin = new javax.swing.JLabel();
        lblValorBitcoin = new javax.swing.JLabel();
        lblEthereum = new javax.swing.JLabel();
        lblValorEthereum = new javax.swing.JLabel();
        lblRipple = new javax.swing.JLabel();
        lblValorRipple = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Exchange - Consultar Saldo");
        setResizable(false);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 22));
        lblTitulo.setText("Consultar Saldo");
        lblSenha.setText("Confirme sua senha");
        btnConsultar.setText("Consultar");
        lblNome.setText("Nome:");
        lblValorNome.setText("—");
        lblCpf.setText("CPF:");
        lblValorCpf.setText("—");
        lblReais.setText("Saldo em Reais:");
        lblValorReais.setText("—");
        lblBitcoin.setText("Bitcoin (BTC):");
        lblValorBitcoin.setText("—");
        lblEthereum.setText("Ethereum (ETH):");
        lblValorEthereum.setText("—");
        lblRipple.setText("Ripple (XRP):");
        lblValorRipple.setText("—");
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
                    .addComponent(btnConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(lblNome, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(lblValorNome, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(lblCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(lblValorCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(lblReais, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(lblValorReais, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(lblBitcoin, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(lblValorBitcoin, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(lblEthereum, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(lblValorEthereum, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(lblRipple, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(lblValorRipple, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
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
                .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lblValorNome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lblCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lblValorCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lblReais, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lblValorReais, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lblBitcoin, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lblValorBitcoin, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lblEthereum, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lblValorEthereum, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lblRipple, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lblValorRipple, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private String formatarReais(BigDecimal valor) {
        NumberFormat formato = NumberFormat.getCurrencyInstance(
            new Locale("pt", "BR")
        );

        return formato.format(valor);
    }

    private void consultarSaldo() {

        if (investidor == null) {
            JOptionPane.showMessageDialog(this, "Nenhum investidor autenticado.");
            return;
        }

        try {
            String senha = new String(txtSenha.getPassword());

            Carteira carteira = carteiraControle.consultarSaldo(investidor, senha);

            lblValorNome.setText(investidor.getNome());
            lblValorCpf.setText(investidor.getCpf());

            lblValorReais.setText(formatarReais(carteira.getReais()));
            lblValorBitcoin.setText(carteira.getBitcoin().toPlainString() + " BTC");
            lblValorEthereum.setText(carteira.getEthereum().toPlainString() + " ETH");
            lblValorRipple.setText(carteira.getRipple().toPlainString() + " XRP");

            txtSenha.setText("");

        } catch (Exception erro) {

            lblValorNome.setText("—");
            lblValorCpf.setText("—");
            lblValorReais.setText("—");
            lblValorBitcoin.setText("—");
            lblValorEthereum.setText("—");
            lblValorRipple.setText("—");

            txtSenha.setText("");

            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new TelaConsultarSaldo().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel lblBitcoin;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblEthereum;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblReais;
    private javax.swing.JLabel lblRipple;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblValorBitcoin;
    private javax.swing.JLabel lblValorCpf;
    private javax.swing.JLabel lblValorEthereum;
    private javax.swing.JLabel lblValorNome;
    private javax.swing.JLabel lblValorReais;
    private javax.swing.JLabel lblValorRipple;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
