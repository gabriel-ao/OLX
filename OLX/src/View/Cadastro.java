/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Classes.Usuario;
import ConexaoBD.UsuarioBD;
import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class Cadastro extends javax.swing.JFrame {

    Usuario usuario = new Usuario();
    UsuarioBD usuarioBD = new UsuarioBD();

    /**
     * Creates new form Cadastro
     */
    public Cadastro() {
        initComponents();
        this.setLocationRelativeTo(null);
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
        jLabel1 = new javax.swing.JLabel();
        jtf_Nome = new javax.swing.JTextField();
        jtf_Cidade = new javax.swing.JTextField();
        jtfTelefone = new javax.swing.JFormattedTextField();
        jtf_Email = new javax.swing.JTextField();
        jtf_Usuario = new javax.swing.JTextField();
        jtf_Bairro = new javax.swing.JTextField();
        jtf_Senha = new javax.swing.JPasswordField();
        jLabelNomeCompleto = new javax.swing.JLabel();
        jLabelCidade = new javax.swing.JLabel();
        jLabelBairro = new javax.swing.JLabel();
        jLabelEstado = new javax.swing.JLabel();
        jLabelTelefone = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jLabelSenha = new javax.swing.JLabel();
        btn_Fechar = new javax.swing.JButton();
        btn_Cadastrar = new javax.swing.JButton();
        jtf_Cancelar = new javax.swing.JButton();
        jLabelNome = new javax.swing.JLabel();
        JlCidade = new javax.swing.JLabel();
        JlTelefone = new javax.swing.JLabel();
        JlUsuario = new javax.swing.JLabel();
        JlEmail = new javax.swing.JLabel();
        JlSenha = new javax.swing.JLabel();
        jLabel_logo_OLX = new javax.swing.JLabel();
        JlTopobackground = new javax.swing.JLabel();
        jLBairro = new javax.swing.JLabel();
        jLabel_CampoObrigatorio = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jcb_estado = new javax.swing.JComboBox<>();
        Jlbackground = new javax.swing.JLabel();

        jTextField11.setText("jTextField11");

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1025, 627));
        setMinimumSize(new java.awt.Dimension(1025, 627));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1025, 627));
        setResizable(false);
        setSize(new java.awt.Dimension(1025, 627));
        getContentPane().setLayout(null);

        jtf_Nome.setBackground(new java.awt.Color(242, 242, 242));
        jtf_Nome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtf_Nome.setBorder(null);
        jtf_Nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_NomeActionPerformed(evt);
            }
        });
        getContentPane().add(jtf_Nome);
        jtf_Nome.setBounds(110, 225, 455, 30);

        jtf_Cidade.setBackground(new java.awt.Color(242, 242, 242));
        jtf_Cidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtf_Cidade.setBorder(null);
        getContentPane().add(jtf_Cidade);
        jtf_Cidade.setBounds(110, 362, 310, 30);

        jtfTelefone.setBackground(new java.awt.Color(242, 242, 242));
        jtfTelefone.setBorder(null);
        try {
            jtfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jtfTelefone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jtfTelefone);
        jtfTelefone.setBounds(650, 295, 310, 30);

        jtf_Email.setBackground(new java.awt.Color(242, 242, 242));
        jtf_Email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtf_Email.setBorder(null);
        getContentPane().add(jtf_Email);
        jtf_Email.setBounds(650, 225, 316, 30);

        jtf_Usuario.setBackground(new java.awt.Color(242, 242, 242));
        jtf_Usuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtf_Usuario.setBorder(null);
        getContentPane().add(jtf_Usuario);
        jtf_Usuario.setBounds(650, 362, 200, 30);

        jtf_Bairro.setBackground(new java.awt.Color(242, 242, 242));
        jtf_Bairro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtf_Bairro.setBorder(null);
        getContentPane().add(jtf_Bairro);
        jtf_Bairro.setBounds(110, 295, 310, 30);

        jtf_Senha.setBackground(new java.awt.Color(242, 242, 242));
        jtf_Senha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtf_Senha.setBorder(null);
        jtf_Senha.setDoubleBuffered(true);
        getContentPane().add(jtf_Senha);
        jtf_Senha.setBounds(650, 425, 200, 30);

        jLabelNomeCompleto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNomeCompleto.setText("Nome:");
        getContentPane().add(jLabelNomeCompleto);
        jLabelNomeCompleto.setBounds(100, 200, 60, 20);

        jLabelCidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCidade.setText("Cidade:");
        getContentPane().add(jLabelCidade);
        jLabelCidade.setBounds(100, 340, 70, 17);

        jLabelBairro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelBairro.setText("Bairro:");
        getContentPane().add(jLabelBairro);
        jLabelBairro.setBounds(100, 270, 50, 20);

        jLabelEstado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelEstado.setText("Estado:");
        getContentPane().add(jLabelEstado);
        jLabelEstado.setBounds(100, 410, 60, 17);

        jLabelTelefone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTelefone.setText("Telefone:");
        getContentPane().add(jLabelTelefone);
        jLabelTelefone.setBounds(640, 270, 70, 20);

        jLabelEmail.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelEmail.setText("Email:");
        getContentPane().add(jLabelEmail);
        jLabelEmail.setBounds(640, 200, 50, 17);

        jLabelUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelUsuario.setText("Usuario:");
        getContentPane().add(jLabelUsuario);
        jLabelUsuario.setBounds(640, 340, 50, 17);

        jLabelSenha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelSenha.setText("Senha:");
        getContentPane().add(jLabelSenha);
        jLabelSenha.setBounds(640, 400, 43, 17);

        btn_Fechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Botao fechar.png"))); // NOI18N
        btn_Fechar.setBorderPainted(false);
        btn_Fechar.setContentAreaFilled(false);
        btn_Fechar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_FecharActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Fechar);
        btn_Fechar.setBounds(970, 0, 40, 50);

        btn_Cadastrar.setBackground(new java.awt.Color(242, 242, 242));
        btn_Cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Save icon.png"))); // NOI18N
        btn_Cadastrar.setBorder(null);
        btn_Cadastrar.setContentAreaFilled(false);
        btn_Cadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Cadastrar);
        btn_Cadastrar.setBounds(410, 530, 65, 70);

        jtf_Cancelar.setBackground(new java.awt.Color(242, 242, 242));
        jtf_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancel icon.png"))); // NOI18N
        jtf_Cancelar.setBorderPainted(false);
        jtf_Cancelar.setContentAreaFilled(false);
        jtf_Cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtf_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_CancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jtf_Cancelar);
        jtf_Cancelar.setBounds(510, 530, 70, 70);

        jLabelNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Campo Nome.png"))); // NOI18N
        getContentPane().add(jLabelNome);
        jLabelNome.setBounds(100, 220, 480, 40);

        JlCidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Campo Cidade.png"))); // NOI18N
        getContentPane().add(JlCidade);
        JlCidade.setBounds(100, 360, 340, 34);

        JlTelefone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Campo telefone.png"))); // NOI18N
        getContentPane().add(JlTelefone);
        JlTelefone.setBounds(640, 290, 350, 40);

        JlUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Campo user.png"))); // NOI18N
        getContentPane().add(JlUsuario);
        JlUsuario.setBounds(640, 360, 230, 34);

        JlEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Campo Email.png"))); // NOI18N
        getContentPane().add(JlEmail);
        JlEmail.setBounds(640, 220, 350, 40);

        JlSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Campo Senha2.png"))); // NOI18N
        getContentPane().add(JlSenha);
        JlSenha.setBounds(640, 420, 230, 40);

        jLabel_logo_OLX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo novo.png"))); // NOI18N
        getContentPane().add(jLabel_logo_OLX);
        jLabel_logo_OLX.setBounds(7, 4, 50, 41);

        JlTopobackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Tela superior.png"))); // NOI18N
        getContentPane().add(JlTopobackground);
        JlTopobackground.setBounds(0, 0, 1030, 50);

        jLBairro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Campo Bairro.png"))); // NOI18N
        getContentPane().add(jLBairro);
        jLBairro.setBounds(100, 290, 340, 40);

        jLabel_CampoObrigatorio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_CampoObrigatorio.setForeground(new java.awt.Color(247, 130, 50));
        jLabel_CampoObrigatorio.setText("Campos Obrigatorios*");
        getContentPane().add(jLabel_CampoObrigatorio);
        jLabel_CampoObrigatorio.setBounds(100, 160, 160, 17);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(247, 130, 50));
        jLabel2.setText("*");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(90, 340, 10, 10);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(247, 130, 50));
        jLabel3.setText("*");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(630, 400, 10, 10);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(247, 130, 50));
        jLabel4.setText("*");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(90, 270, 10, 10);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(247, 130, 50));
        jLabel5.setText("*");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(90, 410, 10, 10);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(247, 130, 50));
        jLabel6.setText("*");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(90, 200, 10, 10);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(247, 130, 50));
        jLabel7.setText("*");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(630, 200, 10, 10);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(247, 130, 50));
        jLabel8.setText("*");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(630, 270, 10, 10);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(247, 130, 50));
        jLabel9.setText("*");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(630, 340, 10, 10);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 50)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(247, 130, 50));
        jLabel10.setText("CADASTRAR");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(400, 70, 290, 61);

        jcb_estado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcb_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        getContentPane().add(jcb_estado);
        jcb_estado.setBounds(170, 410, 50, 23);

        Jlbackground.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Jlbackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background.jpeg"))); // NOI18N
        getContentPane().add(Jlbackground);
        Jlbackground.setBounds(0, 0, 1030, 710);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtf_NomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_NomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_NomeActionPerformed

    private void btn_FecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_FecharActionPerformed
        Login login = new Login();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_FecharActionPerformed

    private void jtf_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_CancelarActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja Realmente cancelar o cadastro? ", "***Cancelar Cadastro***", JOptionPane.YES_NO_OPTION);

        if (resposta == 0) {
            Login login = new Login();
            login.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jtf_CancelarActionPerformed

    private void btn_CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CadastrarActionPerformed
        if (jtf_Bairro.getText().isEmpty() || jtf_Cidade.getText().isEmpty() || jtf_Nome.getText().isEmpty() || (jtf_Email.getText().isEmpty())
                || (jtfTelefone.getText().isEmpty() || jtf_Usuario.getText().isEmpty() || jtf_Senha.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "PREENCHA TODOS OS CAMPOS!!");
        } else {
            usuario.setBairro(jtf_Bairro.getText());
            usuario.setCidade(jtf_Cidade.getText());
            usuario.setNome(jtf_Nome.getText());
            usuario.setEmail(jtf_Email.getText());
            usuario.setTelefone(jtfTelefone.getText());
            usuario.setUF(jcb_estado.getSelectedItem().toString());
            usuario.setUsuario(jtf_Usuario.getText());
            usuario.setSenha(jtf_Senha.getText());

            try {
                usuarioBD.inserir(usuario);
                JOptionPane.showMessageDialog(null, "Usuário Cadastrado com Sucesso");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao inserir Usuário.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }

            Login login = new Login();
            login.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btn_CadastrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JlCidade;
    private javax.swing.JLabel JlEmail;
    private javax.swing.JLabel JlSenha;
    private javax.swing.JLabel JlTelefone;
    private javax.swing.JLabel JlTopobackground;
    private javax.swing.JLabel JlUsuario;
    private javax.swing.JLabel Jlbackground;
    private javax.swing.JButton btn_Cadastrar;
    private javax.swing.JButton btn_Fechar;
    private javax.swing.JLabel jLBairro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelBairro;
    private javax.swing.JLabel jLabelCidade;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelEstado;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelNomeCompleto;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JLabel jLabelTelefone;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JLabel jLabel_CampoObrigatorio;
    private javax.swing.JLabel jLabel_logo_OLX;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JComboBox<String> jcb_estado;
    private javax.swing.JFormattedTextField jtfTelefone;
    private javax.swing.JTextField jtf_Bairro;
    private javax.swing.JButton jtf_Cancelar;
    private javax.swing.JTextField jtf_Cidade;
    private javax.swing.JTextField jtf_Email;
    private javax.swing.JTextField jtf_Nome;
    private javax.swing.JPasswordField jtf_Senha;
    private javax.swing.JTextField jtf_Usuario;
    // End of variables declaration//GEN-END:variables
}
