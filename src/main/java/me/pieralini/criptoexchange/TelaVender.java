package me.pieralini.criptoexchange;
        
import java.math.BigDecimal;
import java.util.Map;
import javax.swing.JOptionPane;
import me.pieralini.criptoexchange.controle.OperacaoControle;
import me.pieralini.criptoexchange.controle.CotacaoControle;
import me.pieralini.criptoexchange.modelo.Investidor;

public class TelaVender extends javax.swing.JFrame {
    
    private Investidor investidor;
    private final OperacaoControle operacaoControle = new OperacaoControle();
    private final CotacaoControle cotacaoControle = new CotacaoControle();

    public TelaVender() {
        initComponents();
        setLocationRelativeTo(null);

        btnVender.addActionListener(e -> vender());
        btnVoltar.addActionListener(e -> dispose());
    }

    public TelaVender(Investidor investidor) {
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
        lblQuantidade = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        lblTaxa = new javax.swing.JLabel();
        btnVender = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Exchange - Vender Criptomoedas");
        setResizable(false);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 22));
        lblTitulo.setText("Vender Criptomoedas");
        lblSenha.setText("Confirme sua senha");
        lblCotacoes.setText("Cotações: BTC / ETH / XRP");
        lblValorCotacoes.setText("—");
        lblMoeda.setText("Moeda");
        cmbMoeda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bitcoin (BTC)", "Ethereum (ETH)", "Ripple (XRP)" }));
        lblQuantidade.setText("Quantidade a vender");
        lblTaxa.setText("Taxa de venda: BTC 3%, ETH 2%, XRP 1%");
        btnVender.setText("Vender");
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
                    .addComponent(lblQuantidade, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(lblTaxa, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(btnVender, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
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
                .addComponent(lblQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lblTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnVender, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void vender() {

        if (investidor == null) {
            JOptionPane.showMessageDialog(this, "Nenhum investidor autenticado.");
            return;
        }

        try {
            String senha = new String(txtSenha.getPassword());

            String moeda;

            switch (cmbMoeda.getSelectedIndex()) {
                case 0:
                    moeda = "BTC";
                    break;

                case 1:
                    moeda = "ETH";
                    break;

                case 2:
                    moeda = "XRP";
                    break;

                default:
                    throw new IllegalArgumentException("Selecione uma moeda válida.");
            }

            BigDecimal quantidade = new BigDecimal(
                txtQuantidade.getText().trim().replace(",", ".")
            );

            operacaoControle.vender(investidor, senha, moeda, quantidade);

            JOptionPane.showMessageDialog(this, "Venda realizada com sucesso!");

            txtSenha.setText("");
            txtQuantidade.setText("");

            carregarCotacoes();

        } catch (NumberFormatException erro) {
            JOptionPane.showMessageDialog(this, "Informe uma quantidade válida.");

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new TelaVender().setVisible(true));
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVender;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox cmbMoeda;
    private javax.swing.JLabel lblCotacoes;
    private javax.swing.JLabel lblMoeda;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTaxa;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblValorCotacoes;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
