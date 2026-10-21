package me.pieralini.criptoexchange;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;
import javax.swing.JOptionPane;
import me.pieralini.criptoexchange.controle.CotacaoControle;

public class TelaAtualizarCotacao extends javax.swing.JFrame {
    
    private final CotacaoControle cotacaoControle = new CotacaoControle();

    public TelaAtualizarCotacao() {
        initComponents();
        setLocationRelativeTo(null);

        btnAtualizar.addActionListener(e -> atualizarCotacoes());
        btnVoltar.addActionListener(e -> dispose());

        carregarCotacoes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblBitcoin = new javax.swing.JLabel();
        lblValorBitcoin = new javax.swing.JLabel();
        lblEthereum = new javax.swing.JLabel();
        lblValorEthereum = new javax.swing.JLabel();
        lblRipple = new javax.swing.JLabel();
        lblValorRipple = new javax.swing.JLabel();
        lblAviso = new javax.swing.JLabel();
        btnAtualizar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Exchange - Atualizar Cotação");
        setResizable(false);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 22));
        lblTitulo.setText("Atualizar Cotação");
        lblBitcoin.setText("Bitcoin (BTC):");
        lblValorBitcoin.setText("—");
        lblEthereum.setText("Ethereum (ETH):");
        lblValorEthereum.setText("—");
        lblRipple.setText("Ripple (XRP):");
        lblValorRipple.setText("—");
        lblAviso.setText("Variação aleatória de -5% a +5%");
        btnAtualizar.setText("Atualizar Cotações");
        btnVoltar.setText("Voltar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(lblBitcoin, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(lblValorBitcoin, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(lblEthereum, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(lblValorEthereum, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(lblRipple, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(lblValorRipple, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(lblAviso, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
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
                .addComponent(lblAviso, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private String formatarValor(BigDecimal valor) {
        NumberFormat formato = NumberFormat.getCurrencyInstance(
            Locale.forLanguageTag("pt-BR")
        );

        return formato.format(valor);
    }

    private void carregarCotacoes() {
        try {
            Map<String, BigDecimal> cotacoes = cotacaoControle.consultar();

            lblValorBitcoin.setText(formatarValor(cotacoes.get("BTC")));
            lblValorEthereum.setText(formatarValor(cotacoes.get("ETH")));
            lblValorRipple.setText(formatarValor(cotacoes.get("XRP")));

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }

    private void atualizarCotacoes() {
        try {
            Map<String, BigDecimal> cotacoes = cotacaoControle.atualizar();

            lblValorBitcoin.setText(formatarValor(cotacoes.get("BTC")));
            lblValorEthereum.setText(formatarValor(cotacoes.get("ETH")));
            lblValorRipple.setText(formatarValor(cotacoes.get("XRP")));

            JOptionPane.showMessageDialog(
                this,
                "Cotações atualizadas com sucesso!"
            );

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new TelaAtualizarCotacao().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel lblAviso;
    private javax.swing.JLabel lblBitcoin;
    private javax.swing.JLabel lblEthereum;
    private javax.swing.JLabel lblRipple;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblValorBitcoin;
    private javax.swing.JLabel lblValorEthereum;
    private javax.swing.JLabel lblValorRipple;
    // End of variables declaration//GEN-END:variables
}
