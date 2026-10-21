package me.pieralini.criptoexchange;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import me.pieralini.criptoexchange.controle.CarteiraControle;
import me.pieralini.criptoexchange.modelo.Carteira;
import me.pieralini.criptoexchange.modelo.Investidor;

public class TelaSacar extends javax.swing.JFrame {
    
    private Investidor investidor;
    private final CarteiraControle carteiraControle = new CarteiraControle();

    public TelaSacar() {
        initComponents();
        setLocationRelativeTo(null);

        btnSacar.addActionListener(e -> sacar());
        btnVoltar.addActionListener(e -> dispose());
    }

    public TelaSacar(Investidor investidor) {
        this();
        this.investidor = investidor;
        carregarSaldo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblSaldoAtual = new javax.swing.JLabel();
        lblValorSaldoAtual = new javax.swing.JLabel();
        lblValorSaque = new javax.swing.JLabel();
        txtValorSaque = new javax.swing.JTextField();
        btnSacar = new javax.swing.JButton();
        lblNovoSaldo = new javax.swing.JLabel();
        lblValorNovoSaldo = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Exchange - Sacar Reais");
        setResizable(false);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 22));
        lblTitulo.setText("Sacar Reais");
        lblSaldoAtual.setText("Saldo atual:");
        lblValorSaldoAtual.setText("R$ 0,00");
        lblValorSaque.setText("Valor do saque (R$)");
        btnSacar.setText("Confirmar Saque");
        lblNovoSaldo.setText("Novo saldo:");
        lblValorNovoSaldo.setText("—");
        btnVoltar.setText("Voltar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(lblSaldoAtual, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(lblValorSaldoAtual, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(lblValorSaque, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(txtValorSaque, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(btnSacar, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(lblNovoSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(lblValorNovoSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
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
                .addComponent(lblSaldoAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lblValorSaldoAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lblValorSaque, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(txtValorSaque, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnSacar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lblNovoSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lblValorNovoSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private String formatarValor(BigDecimal valor) {
    NumberFormat formato = NumberFormat.getCurrencyInstance(
        new Locale("pt", "BR")
    );

    return formato.format(valor);
}

    private void carregarSaldo() {

        if (investidor == null) {
            return;
        }

        try {
            String senha = JOptionPane.showInputDialog(
                this,
                "Confirme sua senha para consultar o saldo:"
            );

            if (senha == null) {
                return;
            }

            Carteira carteira = carteiraControle.consultarSaldo(investidor, senha);

            lblValorSaldoAtual.setText(formatarValor(carteira.getReais()));

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }

    private void sacar() {

        if (investidor == null) {
            JOptionPane.showMessageDialog(this, "Nenhum investidor autenticado.");
            return;
        }

        try {
            BigDecimal valor = new BigDecimal(
                txtValorSaque.getText().trim().replace(",", ".")
            );

            Carteira carteira = carteiraControle.sacar(investidor, valor);

            lblValorNovoSaldo.setText(formatarValor(carteira.getReais()));
            lblValorSaldoAtual.setText(formatarValor(carteira.getReais()));

            txtValorSaque.setText("");

            JOptionPane.showMessageDialog(this, "Saque realizado com sucesso!");

        } catch (NumberFormatException erro) {
            JOptionPane.showMessageDialog(this, "Informe um valor válido.");

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new TelaSacar().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSacar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel lblNovoSaldo;
    private javax.swing.JLabel lblSaldoAtual;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblValorNovoSaldo;
    private javax.swing.JLabel lblValorSaldoAtual;
    private javax.swing.JLabel lblValorSaque;
    private javax.swing.JTextField txtValorSaque;
    // End of variables declaration//GEN-END:variables
}
