package me.pieralini.criptoexchange;

import javax.swing.JOptionPane;
import me.pieralini.criptoexchange.controle.LoginControle;
import me.pieralini.criptoexchange.modelo.Investidor;

public class TelaLogin extends javax.swing.JFrame {
    
    private final LoginControle loginControle = new LoginControle();

    public TelaLogin() {
        initComponents();
        setLocationRelativeTo(null);

        btnEntrar.addActionListener(e -> entrar());
        txtSenha.addActionListener(e -> entrar());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        btnEntrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Exchange - Login");
        setResizable(false);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 22));
        lblTitulo.setText("Exchange de Criptomoedas");
        lblCpf.setText("CPF (somente números)");
        lblSenha.setText("Senha (6 dígitos)");
        btnEntrar.setText("Entrar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(lblCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(txtCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(lblSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(btnEntrar, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                )
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lblCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lblSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void entrar() {

        try {
            String cpf = txtCpf.getText().trim();
            String senha = new String(txtSenha.getPassword());

            Investidor investidor = loginControle.entrar(cpf, senha);

            TelaMenuPrincipal menu = new TelaMenuPrincipal(investidor);
            menu.setVisible(true);

            dispose();

        } catch (IllegalArgumentException erro) {
            JOptionPane.showMessageDialog(
                this,
                erro.getMessage(),
                "Erro no login",
                JOptionPane.ERROR_MESSAGE
            );

            txtSenha.setText("");

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(
                this,
                "Não foi possível realizar o login: " + erro.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new TelaLogin().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
