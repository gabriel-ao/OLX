/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import ConexaoBD.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
        btn_fechar = new javax.swing.JButton();
        btn_Logar = new javax.swing.JButton();
        btn_Cadastrar = new javax.swing.JButton();
        jtfUsuario = new javax.swing.JTextField();
        jpfSenha = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        Logo = new javax.swing.JLabel();
        Usuario = new javax.swing.JLabel();
        Senha = new javax.swing.JLabel();
        Top = new javax.swing.JLabel();
        Fundo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(518, 438));
        setMinimumSize(new java.awt.Dimension(518, 438));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(518, 438));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_fechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Botao fechar.png"))); // NOI18N
        btn_fechar.setBorder(null);
        btn_fechar.setBorderPainted(false);
        btn_fechar.setContentAreaFilled(false);
        btn_fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fecharActionPerformed(evt);
            }
        });
        getContentPane().add(btn_fechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 8, 60, -1));

        btn_Logar.setBackground(new java.awt.Color(169, 45, 215));
        btn_Logar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Logar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Entrar button.png"))); // NOI18N
        btn_Logar.setBorder(null);
        btn_Logar.setBorderPainted(false);
        btn_Logar.setContentAreaFilled(false);
        btn_Logar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_Logar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Logar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LogarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Logar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 110, 30));

        btn_Cadastrar.setBackground(new java.awt.Color(169, 45, 215));
        btn_Cadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Desapegue já button.png"))); // NOI18N
        btn_Cadastrar.setBorder(null);
        btn_Cadastrar.setBorderPainted(false);
        btn_Cadastrar.setContentAreaFilled(false);
        btn_Cadastrar.setMaximumSize(new java.awt.Dimension(345, 25));
        btn_Cadastrar.setMinimumSize(new java.awt.Dimension(345, 25));
        btn_Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Cadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 395, 150, 40));

        jtfUsuario.setBorder(null);
        jtfUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(jtfUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 290, 40));

        jpfSenha.setBorder(null);
        getContentPane().add(jpfSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 254, 290, 40));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(247, 130, 50));
        jLabel1.setText("Não possui cadastro?");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 365, -1, -1));

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/olx.png"))); // NOI18N
        getContentPane().add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, -1, 140));

        Usuario.setBackground(new java.awt.Color(255, 255, 255));
        Usuario.setForeground(new java.awt.Color(255, 255, 255));
        Usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/campo login.png"))); // NOI18N
        getContentPane().add(Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 370, 40));

        Senha.setForeground(new java.awt.Color(255, 255, 255));
        Senha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/campo senha.png"))); // NOI18N
        getContentPane().add(Senha, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 254, -1, -1));

        Top.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Retângulo top.png"))); // NOI18N
        getContentPane().add(Top, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 50));

        Fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fundo.png"))); // NOI18N
        getContentPane().add(Fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 440));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Desapegue já button.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfUsuarioActionPerformed
        jtfUsuario.setText("");
    }//GEN-LAST:event_jtfUsuarioActionPerformed

    private void btn_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fecharActionPerformed
        System.exit(0);      
    }//GEN-LAST:event_btn_fecharActionPerformed

    private void btn_LogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LogarActionPerformed
        try {
                String usuario, senha;
                
                Connection con;
                Conexao conecta = new Conexao();
                con  = Conexao.conectar();
                ResultSet rs;
                
                usuario = jtfUsuario.getText();
                senha  = String.valueOf(jpfSenha.getPassword());
                
                String sql = "SELECT usuario, senha FROM usuario WHERE usuario = '"+usuario+"' AND  senha = '"+senha+"'" ;
                
                PreparedStatement statement = con.prepareStatement(sql);
                
                rs = statement.executeQuery();
                
                if(rs.next()){
                    
                    if(usuario.equals(rs.getString("usuario")) && senha.equals(rs.getString("senha"))){
       
                        Principal principal = new Principal(usuario);
                        principal.setVisible(true);
                        this.setVisible(false);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Usuário ou Senha inválidos");
                }
              } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_LogarActionPerformed

    private void btn_CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CadastrarActionPerformed
        Cadastro cadastro = new Cadastro ();
        cadastro.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_CadastrarActionPerformed

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
    private javax.swing.JLabel Fundo;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel Senha;
    private javax.swing.JLabel Top;
    private javax.swing.JLabel Usuario;
    private javax.swing.JButton btn_Cadastrar;
    private javax.swing.JButton btn_Logar;
    private javax.swing.JButton btn_fechar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jpfSenha;
    private javax.swing.JTextField jtfUsuario;
    // End of variables declaration//GEN-END:variables
}
