package me.pieralini.criptoexchange;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import me.pieralini.criptoexchange.controle.CarteiraControle;
import me.pieralini.criptoexchange.modelo.Investidor;
import me.pieralini.criptoexchange.modelo.Movimentacao;

public class TelaConsultarExtrato extends javax.swing.JFrame {
    
    private Investidor investidor;
    private final CarteiraControle carteiraControle = new CarteiraControle();

    public TelaConsultarExtrato() {
        initComponents();
        setLocationRelativeTo(null);

        btnConsultar.addActionListener(e -> consultarExtrato());
        btnVoltar.addActionListener(e -> dispose());
    }

    public TelaConsultarExtrato(Investidor investidor) {
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
        scrollExtrato = new javax.swing.JScrollPane();
        tblExtrato = new javax.swing.JTable();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Exchange - Consultar Extrato");
        setResizable(false);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 22));
        lblTitulo.setText("Consultar Extrato");
        lblSenha.setText("Confirme sua senha");
        btnConsultar.setText("Consultar");
        lblNome.setText("Nome:");
        lblValorNome.setText("—");
        lblCpf.setText("CPF:");
        lblValorCpf.setText("—");
        tblExtrato.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {}, new String [] {"Data/Hora", "Operação", "Moeda", "Valor", "Cotação", "Taxa", "Saldo BRL", "Saldo BTC", "Saldo ETH", "Saldo XRP"}));
        scrollExtrato.setViewportView(tblExtrato);
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
                    .addComponent(scrollExtrato, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
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
                .addComponent(scrollExtrato, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void consultarExtrato() {

        if (investidor == null) {
            JOptionPane.showMessageDialog(this, "Nenhum investidor autenticado.");
            return;
        }

        DefaultTableModel tabela = (DefaultTableModel) tblExtrato.getModel();
        tabela.setRowCount(0);

        lblValorNome.setText("—");
        lblValorCpf.setText("—");

        try {
            String senha = new String(txtSenha.getPassword());

            List<Movimentacao> movimentacoes =
                    carteiraControle.consultarExtrato(investidor, senha);

            lblValorNome.setText(investidor.getNome());
            lblValorCpf.setText(investidor.getCpf());

            for (Movimentacao movimentacao : movimentacoes) {

                tabela.addRow(new Object[]{
                    movimentacao.getDataHora(),
                    movimentacao.getTipo(),
                    movimentacao.getMoeda(),
                    movimentacao.getValor(),
                    movimentacao.getCotacao(),
                    movimentacao.getTaxa(),
                    movimentacao.getSaldoReais(),
                    movimentacao.getSaldoBitcoin(),
                    movimentacao.getSaldoEthereum(),
                    movimentacao.getSaldoRipple()
                });
            }

            if (movimentacoes.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nenhuma movimentação encontrada.");
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());

        } finally {
            txtSenha.setText("");
        }
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new TelaConsultarExtrato().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblValorCpf;
    private javax.swing.JLabel lblValorNome;
    private javax.swing.JTable tblExtrato;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JScrollPane scrollExtrato;
    // End of variables declaration//GEN-END:variables
}
