/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author gabri
 */
public class Cadastro extends javax.swing.JFrame {

    /**
     * Creates new form Cadastro
     */
    public Cadastro() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField11 = new javax.swing.JTextField();
        jLabelNomeCompleto = new javax.swing.JLabel();
        jLabelDataDeNascimento = new javax.swing.JLabel();
        jLabelCPF = new javax.swing.JLabel();
        jLabelRua = new javax.swing.JLabel();
        jLabelCidade = new javax.swing.JLabel();
        jLabelBairro = new javax.swing.JLabel();
        jLabelEstado = new javax.swing.JLabel();
        jLabelTelefone = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jLabelSenha = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldData = new javax.swing.JTextField();
        jTextFieldCPF = new javax.swing.JTextField();
        jTextFieldRua = new javax.swing.JTextField();
        jTextFieldCidade = new javax.swing.JTextField();
        jTextFieldBairro = new javax.swing.JTextField();
        jTextFieldEstado = new javax.swing.JTextField();
        jTextFieldTelefone = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldUsuario = new javax.swing.JTextField();
        jTextFieldSenha = new javax.swing.JTextField();
        jButtonCadastrar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        fundo = new javax.swing.JLabel();

        jTextField11.setText("jTextField11");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabelNomeCompleto.setText("Nome Completo");
        getContentPane().add(jLabelNomeCompleto);
        jLabelNomeCompleto.setBounds(31, 35, 75, 14);

        jLabelDataDeNascimento.setText("Data de Nascimento");
        getContentPane().add(jLabelDataDeNascimento);
        jLabelDataDeNascimento.setBounds(10, 61, 96, 14);

        jLabelCPF.setText("CPF");
        getContentPane().add(jLabelCPF);
        jLabelCPF.setBounds(87, 87, 19, 14);

        jLabelRua.setText("Rua");
        getContentPane().add(jLabelRua);
        jLabelRua.setBounds(87, 113, 19, 14);

        jLabelCidade.setText("Cidade");
        getContentPane().add(jLabelCidade);
        jLabelCidade.setBounds(73, 139, 33, 14);

        jLabelBairro.setText("Bairro");
        getContentPane().add(jLabelBairro);
        jLabelBairro.setBounds(78, 165, 28, 14);

        jLabelEstado.setText("Estado");
        getContentPane().add(jLabelEstado);
        jLabelEstado.setBounds(73, 191, 33, 14);

        jLabelTelefone.setText("Telefone");
        getContentPane().add(jLabelTelefone);
        jLabelTelefone.setBounds(63, 217, 42, 14);

        jLabelEmail.setText("Email");
        getContentPane().add(jLabelEmail);
        jLabelEmail.setBounds(81, 243, 24, 14);

        jLabelUsuario.setText("Usuario");
        getContentPane().add(jLabelUsuario);
        jLabelUsuario.setBounds(69, 269, 36, 14);

        jLabelSenha.setText("Senha");
        getContentPane().add(jLabelSenha);
        jLabelSenha.setBounds(75, 295, 30, 14);

        jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldNome);
        jTextFieldNome.setBounds(116, 32, 174, 20);
        getContentPane().add(jTextFieldData);
        jTextFieldData.setBounds(116, 58, 174, 20);
        getContentPane().add(jTextFieldCPF);
        jTextFieldCPF.setBounds(116, 84, 174, 20);
        getContentPane().add(jTextFieldRua);
        jTextFieldRua.setBounds(116, 110, 174, 20);
        getContentPane().add(jTextFieldCidade);
        jTextFieldCidade.setBounds(116, 136, 174, 20);
        getContentPane().add(jTextFieldBairro);
        jTextFieldBairro.setBounds(116, 162, 174, 20);
        getContentPane().add(jTextFieldEstado);
        jTextFieldEstado.setBounds(116, 188, 174, 20);
        getContentPane().add(jTextFieldTelefone);
        jTextFieldTelefone.setBounds(115, 214, 175, 20);
        getContentPane().add(jTextFieldEmail);
        jTextFieldEmail.setBounds(115, 240, 175, 20);
        getContentPane().add(jTextFieldUsuario);
        jTextFieldUsuario.setBounds(115, 266, 175, 20);
        getContentPane().add(jTextFieldSenha);
        jTextFieldSenha.setBounds(115, 292, 175, 20);

        jButtonCadastrar.setText("Cadastrar");
        getContentPane().add(jButtonCadastrar);
        jButtonCadastrar.setBounds(115, 330, 81, 23);

        jButtonCancelar.setText("Cancelar");
        getContentPane().add(jButtonCancelar);
        jButtonCancelar.setBounds(214, 330, 75, 23);

        fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/bg verde.jpg"))); // NOI18N
        getContentPane().add(fundo);
        fundo.setBounds(4, 0, 390, 370);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fundo;
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JLabel jLabelBairro;
    private javax.swing.JLabel jLabelCPF;
    private javax.swing.JLabel jLabelCidade;
    private javax.swing.JLabel jLabelDataDeNascimento;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelEstado;
    private javax.swing.JLabel jLabelNomeCompleto;
    private javax.swing.JLabel jLabelRua;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JLabel jLabelTelefone;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextFieldBairro;
    private javax.swing.JTextField jTextFieldCPF;
    private javax.swing.JTextField jTextFieldCidade;
    private javax.swing.JTextField jTextFieldData;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldEstado;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldRua;
    private javax.swing.JTextField jTextFieldSenha;
    private javax.swing.JTextField jTextFieldTelefone;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables
}
