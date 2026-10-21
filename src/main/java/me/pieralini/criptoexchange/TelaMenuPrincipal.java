package me.pieralini.criptoexchange;

import me.pieralini.criptoexchange.modelo.Investidor;

public class TelaMenuPrincipal extends javax.swing.JFrame {
    
    private Investidor investidor;

    public TelaMenuPrincipal() {
    initComponents();
    setLocationRelativeTo(null);

        btnSaldo.addActionListener(e -> abrirSaldo());
        btnExtrato.addActionListener(e -> abrirExtrato());
        btnDepositar.addActionListener(e -> abrirDepositar());
        btnSacar.addActionListener(e -> abrirSacar());
        btnComprar.addActionListener(e -> abrirComprar());
        btnVender.addActionListener(e -> abrirVender());
        btnCotacao.addActionListener(e -> abrirCotacao());
        btnSair.addActionListener(e -> dispose());
    }

    public TelaMenuPrincipal(Investidor investidor) {
        this();
        this.investidor = investidor;
        lblBemVindo.setText("Bem-vindo, " + investidor.getNome() + "!");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblBemVindo = new javax.swing.JLabel();
        btnSaldo = new javax.swing.JButton();
        btnExtrato = new javax.swing.JButton();
        btnDepositar = new javax.swing.JButton();
        btnSacar = new javax.swing.JButton();
        btnComprar = new javax.swing.JButton();
        btnVender = new javax.swing.JButton();
        btnCotacao = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Exchange - Menu Principal");
        setResizable(false);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 22));
        lblTitulo.setText("Menu Principal");
        lblBemVindo.setText("Bem-vindo, investidor!");
        btnSaldo.setText("Consultar Saldo");
        btnExtrato.setText("Consultar Extrato");
        btnDepositar.setText("Depositar");
        btnSacar.setText("Sacar");
        btnComprar.setText("Comprar Criptomoedas");
        btnVender.setText("Vender Criptomoedas");
        btnCotacao.setText("Atualizar Cotação");
        btnSair.setText("Sair");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(lblBemVindo, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(btnSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(btnExtrato, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(btnDepositar, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(btnSacar, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(btnComprar, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(btnVender, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(btnCotacao, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                )
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lblBemVindo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnExtrato, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnDepositar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnSacar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnVender, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnCotacao, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void abrirSaldo() {
        if (investidor == null) {
            return;
        }

        new TelaConsultarSaldo(investidor).setVisible(true);
    }

    private void abrirExtrato() {
        if (investidor == null) {
            return;
        }

        new TelaConsultarExtrato(investidor).setVisible(true);
    }

    private void abrirDepositar() {
        if (investidor == null) {
            return;
        }

        new TelaDepositar(investidor).setVisible(true);
    }

    private void abrirSacar() {
        if (investidor == null) {
            return;
        }

        new TelaSacar(investidor).setVisible(true);
    }

    private void abrirComprar() {
        if (investidor == null) {
            return;
        }

        new TelaComprar(investidor).setVisible(true);
    }

    private void abrirVender() {
        if (investidor == null) {
            return;
        }

        new TelaVender(investidor).setVisible(true);
    }

    private void abrirCotacao() {
        if (investidor == null) {
            return;
        }

        new TelaAtualizarCotacao().setVisible(true);
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new TelaMenuPrincipal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComprar;
    private javax.swing.JButton btnCotacao;
    private javax.swing.JButton btnDepositar;
    private javax.swing.JButton btnExtrato;
    private javax.swing.JButton btnSacar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSaldo;
    private javax.swing.JButton btnVender;
    private javax.swing.JLabel lblBemVindo;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
