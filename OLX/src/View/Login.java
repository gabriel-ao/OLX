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
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
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

        jLabel2 = new javax.swing.JLabel();
        btn_Logar = new javax.swing.JButton();
        btn_Cadastrar = new javax.swing.JButton();
        btn_Sair = new javax.swing.JButton();
        jtfUsuario = new javax.swing.JTextField();
        jpfSenha = new javax.swing.JPasswordField();
        Logo = new javax.swing.JLabel();
        Botton = new javax.swing.JLabel();
        Usuario = new javax.swing.JLabel();
        Senha = new javax.swing.JLabel();
        Top = new javax.swing.JLabel();
        fundo_login = new javax.swing.JLabel();
        Fundo = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(339, 507));
        setMinimumSize(new java.awt.Dimension(339, 507));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(339, 507));
        setResizable(false);
        getContentPane().setLayout(null);

        btn_Logar.setBackground(new java.awt.Color(119, 32, 152));
        btn_Logar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Logar.setText("Logar");
        btn_Logar.setBorder(null);
        btn_Logar.setBorderPainted(false);
        btn_Logar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(btn_Logar);
        btn_Logar.setBounds(0, 280, 360, 30);

        btn_Cadastrar.setBackground(new java.awt.Color(119, 32, 152));
        btn_Cadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Cadastrar.setText("Cadastrar");
        btn_Cadastrar.setBorder(null);
        btn_Cadastrar.setBorderPainted(false);
        btn_Cadastrar.setMaximumSize(new java.awt.Dimension(345, 25));
        btn_Cadastrar.setMinimumSize(new java.awt.Dimension(345, 25));
        getContentPane().add(btn_Cadastrar);
        btn_Cadastrar.setBounds(0, 320, 360, 30);

        btn_Sair.setBackground(new java.awt.Color(119, 32, 152));
        btn_Sair.setForeground(new java.awt.Color(255, 255, 255));
        btn_Sair.setText("Sair");
        btn_Sair.setBorder(null);
        btn_Sair.setBorderPainted(false);
        btn_Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SairActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Sair);
        btn_Sair.setBounds(0, 360, 360, 30);

        jtfUsuario.setText("Entre com seu login aqui!");
        jtfUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(jtfUsuario);
        jtfUsuario.setBounds(70, 180, 230, 30);

        jpfSenha.setText("DIGITE SUA SENHA");
        getContentPane().add(jpfSenha);
        jpfSenha.setBounds(70, 220, 230, 30);

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/olx.png"))); // NOI18N
        getContentPane().add(Logo);
        Logo.setBounds(100, 30, 140, 130);

        Botton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/login topo.png"))); // NOI18N
        Botton.setText("jLabel4");
        getContentPane().add(Botton);
        Botton.setBounds(0, 400, 360, 25);
        Botton.getAccessibleContext().setAccessibleName("design_topo");

        Usuario.setBackground(new java.awt.Color(255, 255, 255));
        Usuario.setForeground(new java.awt.Color(255, 255, 255));
        Usuario.setText("Usuario:");
        getContentPane().add(Usuario);
        Usuario.setBounds(20, 190, 50, 14);

        Senha.setForeground(new java.awt.Color(255, 255, 255));
        Senha.setText("Senha:");
        getContentPane().add(Senha);
        Senha.setBounds(20, 230, 34, 14);

        Top.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/login topo.png"))); // NOI18N
        Top.setText("jLabel4");
        getContentPane().add(Top);
        Top.setBounds(0, 0, 360, 25);

        fundo_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/login Campos.png"))); // NOI18N
        getContentPane().add(fundo_login);
        fundo_login.setBounds(10, 170, 340, 86);

        Fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/login fundo.png"))); // NOI18N
        getContentPane().add(Fundo);
        Fundo.setBounds(0, 0, 370, 460);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfUsuarioActionPerformed
        jtfUsuario.setText("");
    }//GEN-LAST:event_jtfUsuarioActionPerformed

    private void btn_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SairActionPerformed
        dispose();
    }//GEN-LAST:event_btn_SairActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Botton;
    private javax.swing.JLabel Fundo;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel Senha;
    private javax.swing.JLabel Top;
    private javax.swing.JLabel Usuario;
    private javax.swing.JButton btn_Cadastrar;
    private javax.swing.JButton btn_Logar;
    private javax.swing.JButton btn_Sair;
    private javax.swing.JLabel fundo_login;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jpfSenha;
    private javax.swing.JTextField jtfUsuario;
    // End of variables declaration//GEN-END:variables
}
