/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.CardLayout;
import javax.swing.ImageIcon;

/**
 *
 * @author gabri
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Inicial
     */
    public Principal() {
        initComponents();
    }
   
    ImageIcon Buscar2 = new ImageIcon(getClass().getResource("/Img/MenuLateral/Buscar.png"));
    ImageIcon MeuCadastro2 = new ImageIcon(getClass().getResource("/Img/MenuLateral/MeuCadastro.png"));
    ImageIcon Desapegar2 = new ImageIcon(getClass().getResource("/Img/MenuLateral/Desapegar.png"));
    ImageIcon MeusPedidos2 = new ImageIcon(getClass().getResource("/Img/MenuLateral/MeusPedidos.png"));
    ImageIcon MeusAnuncios2 = new ImageIcon(getClass().getResource("/Img/MenuLateral/MeusAnuncios.png"));
    ImageIcon Sair2 = new ImageIcon(getClass().getResource("/Img/MenuLateral/Sair.png"));
    
     ImageIcon BuscarSelected = new ImageIcon(getClass().getResource("/Img/MenuLateral/BuscarSelected.png"));
     ImageIcon MeuCadastroSelected = new ImageIcon(getClass().getResource("/Img/MenuLateral/MeuCadastroSelected.png"));
     ImageIcon DesapegarSelected = new ImageIcon(getClass().getResource("/Img/MenuLateral/DesapegarSelected.png"));
     ImageIcon MeusPedidosSelected = new ImageIcon(getClass().getResource("/Img/MenuLateral/MeusPedidosSelected.png"));
     ImageIcon MeusAnunciosSelected = new ImageIcon(getClass().getResource("/Img/MenuLateral/MeusAnunciosSelected.png"));
     ImageIcon SairSelected = new ImageIcon(getClass().getResource("/Img/MenuLateral/SairSelected.png"));

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_fechar = new javax.swing.JButton();
        Logo = new javax.swing.JLabel();
        nomeUser = new javax.swing.JLabel();
        BarraTop = new javax.swing.JLabel();
        bt_meuCadastro = new javax.swing.JButton();
        bt_desapegar = new javax.swing.JButton();
        bt_meusPedidos = new javax.swing.JButton();
        bt_meusAnuncios = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();
        Fundo = new javax.swing.JLabel();
        Principal = new javax.swing.JPanel();
        Desapego = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblImagemProd = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtf_titulo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jl_valor = new javax.swing.JLabel();
        jl_condicaoProduto = new javax.swing.JLabel();
        jrb_Novo = new javax.swing.JRadioButton();
        jrb_Usado = new javax.swing.JRadioButton();
        btn_edit = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jta_descricao = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        MeuCadastro = new javax.swing.JPanel();
        jLabelNomeCompleto = new javax.swing.JLabel();
        jLabelDataDeNascimento = new javax.swing.JLabel();
        jLabelCidade = new javax.swing.JLabel();
        jLabelBairro = new javax.swing.JLabel();
        jLabelEstado = new javax.swing.JLabel();
        jLabelTelefone = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jLabelSenha = new javax.swing.JLabel();
        jtf_Nome = new javax.swing.JTextField();
        jtf_Cidade = new javax.swing.JTextField();
        jtf_Bairro = new javax.swing.JTextField();
        jtf_Estado = new javax.swing.JTextField();
        jtf_Telefone = new javax.swing.JTextField();
        jtf_Email = new javax.swing.JTextField();
        jtf_Usuario = new javax.swing.JTextField();
        jtf_Senha = new javax.swing.JTextField();
        btn_Cadastrar = new javax.swing.JButton();
        jtf_Cancelar = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabelNome = new javax.swing.JLabel();
        JlCidade = new javax.swing.JLabel();
        JlTelefone = new javax.swing.JLabel();
        JlUsuario = new javax.swing.JLabel();
        JlEstado = new javax.swing.JLabel();
        JlEmail = new javax.swing.JLabel();
        JlSenha = new javax.swing.JLabel();
        jl_MeuCadastro = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Jlbackground = new javax.swing.JLabel();
        MeusAnuncios = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btn_AlterarAnuncio = new javax.swing.JButton();
        btn_Excluir = new javax.swing.JButton();
        jLabel_Pesquisa = new javax.swing.JLabel();
        btn_busca = new javax.swing.JButton();
        background = new javax.swing.JLabel();
        Inicio = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btn_inicio1 = new javax.swing.JButton();
        background1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1369, 730));
        setMinimumSize(new java.awt.Dimension(1369, 730));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1369, 730));
        getContentPane().setLayout(null);

        bt_fechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Botao fechar.png"))); // NOI18N
        bt_fechar.setBorderPainted(false);
        bt_fechar.setContentAreaFilled(false);
        bt_fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_fecharActionPerformed(evt);
            }
        });
        getContentPane().add(bt_fechar);
        bt_fechar.setBounds(1316, 0, 50, 50);

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo novo.png"))); // NOI18N
        getContentPane().add(Logo);
        Logo.setBounds(10, 0, 50, 50);

        nomeUser.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nomeUser.setForeground(new java.awt.Color(255, 153, 0));
        nomeUser.setText("Nome do usuário aqui");
        getContentPane().add(nomeUser);
        nomeUser.setBounds(70, 20, 210, 22);

        BarraTop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/barra superior.png"))); // NOI18N
        getContentPane().add(BarraTop);
        BarraTop.setBounds(0, 0, 1370, 50);

        bt_meuCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/MenuLateral/MeuCadastro.png"))); // NOI18N
        bt_meuCadastro.setBorderPainted(false);
        bt_meuCadastro.setContentAreaFilled(false);
        bt_meuCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_meuCadastroActionPerformed(evt);
            }
        });
        getContentPane().add(bt_meuCadastro);
        bt_meuCadastro.setBounds(-7, 200, 310, 75);

        bt_desapegar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/MenuLateral/Desapegar.png"))); // NOI18N
        bt_desapegar.setBorderPainted(false);
        bt_desapegar.setContentAreaFilled(false);
        bt_desapegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_desapegarActionPerformed(evt);
            }
        });
        getContentPane().add(bt_desapegar);
        bt_desapegar.setBounds(-7, 310, 310, 75);

        bt_meusPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/MenuLateral/MeusPedidos.png"))); // NOI18N
        bt_meusPedidos.setBorderPainted(false);
        bt_meusPedidos.setContentAreaFilled(false);
        bt_meusPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_meusPedidosActionPerformed(evt);
            }
        });
        getContentPane().add(bt_meusPedidos);
        bt_meusPedidos.setBounds(-7, 420, 310, 75);

        bt_meusAnuncios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/MenuLateral/MeusAnuncios.png"))); // NOI18N
        bt_meusAnuncios.setBorderPainted(false);
        bt_meusAnuncios.setContentAreaFilled(false);
        bt_meusAnuncios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_meusAnunciosActionPerformed(evt);
            }
        });
        getContentPane().add(bt_meusAnuncios);
        bt_meusAnuncios.setBounds(-7, 530, 310, 75);

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/MenuLateral/Sair.png"))); // NOI18N
        bt_sair.setBorderPainted(false);
        bt_sair.setContentAreaFilled(false);
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });
        getContentPane().add(bt_sair);
        bt_sair.setBounds(-7, 640, 310, 70);

        btn_buscar.setBackground(new java.awt.Color(242, 242, 242));
        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/MenuLateral/Buscar.png"))); // NOI18N
        btn_buscar.setBorder(null);
        btn_buscar.setBorderPainted(false);
        btn_buscar.setContentAreaFilled(false);
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_buscar);
        btn_buscar.setBounds(-2, 90, 300, 67);

        Fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Fundo menu.png"))); // NOI18N
        getContentPane().add(Fundo);
        Fundo.setBounds(0, 0, 350, 730);

        Principal.setLayout(new java.awt.CardLayout());

        Desapego.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Novo desapego");
        Desapego.add(jLabel1);
        jLabel1.setBounds(420, 40, 170, 30);

        lblImagemProd.setBackground(new java.awt.Color(242, 242, 242));
        lblImagemProd.setToolTipText("");
        lblImagemProd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Desapego.add(lblImagemProd);
        lblImagemProd.setBounds(90, 130, 290, 340);

        jLabel3.setText("Titulo");
        Desapego.add(jLabel3);
        jLabel3.setBounds(490, 150, 41, 16);

        jtf_titulo.setBackground(new java.awt.Color(242, 242, 242));
        jtf_titulo.setBorder(null);
        Desapego.add(jtf_titulo);
        jtf_titulo.setBounds(570, 142, 360, 30);

        jLabel4.setText("Descricão");
        Desapego.add(jLabel4);
        jLabel4.setBounds(470, 200, 60, 16);

        jl_valor.setText("Preço:");
        Desapego.add(jl_valor);
        jl_valor.setBounds(484, 450, 50, 16);

        jl_condicaoProduto.setText("O produto é");
        Desapego.add(jl_condicaoProduto);
        jl_condicaoProduto.setBounds(482, 505, 100, 16);

        jrb_Novo.setText("Novo");
        jrb_Novo.setContentAreaFilled(false);
        Desapego.add(jrb_Novo);
        jrb_Novo.setBounds(570, 500, 57, 25);

        jrb_Usado.setText("Usado");
        jrb_Usado.setContentAreaFilled(false);
        Desapego.add(jrb_Usado);
        jrb_Usado.setBounds(630, 500, 63, 25);

        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Edit icon.png"))); // NOI18N
        btn_edit.setBorderPainted(false);
        btn_edit.setContentAreaFilled(false);
        Desapego.add(btn_edit);
        btn_edit.setBounds(420, 570, 97, 80);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Campo Titulo.png"))); // NOI18N
        Desapego.add(jLabel5);
        jLabel5.setBounds(560, 140, 390, 34);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Valor campo.png"))); // NOI18N
        Desapego.add(jLabel8);
        jLabel8.setBounds(560, 440, 200, 34);

        jta_descricao.setBackground(new java.awt.Color(242, 242, 242));
        jta_descricao.setColumns(20);
        jta_descricao.setRows(5);
        jScrollPane1.setViewportView(jta_descricao);

        Desapego.add(jScrollPane1);
        jScrollPane1.setBounds(570, 200, 360, 200);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Campo descricao.png"))); // NOI18N
        Desapego.add(jLabel9);
        jLabel9.setBounds(560, 190, 390, 220);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Íco-Imovel copiar 6.png"))); // NOI18N
        Desapego.add(jLabel7);
        jLabel7.setBounds(0, -50, 1030, 730);

        Principal.add(Desapego, "Desapegar");

        MeuCadastro.setLayout(null);

        jLabelNomeCompleto.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N
        jLabelNomeCompleto.setText("Nome");
        MeuCadastro.add(jLabelNomeCompleto);
        jLabelNomeCompleto.setBounds(40, 150, 50, 19);

        jLabelDataDeNascimento.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N
        jLabelDataDeNascimento.setText("Data de Nascimento");
        MeuCadastro.add(jLabelDataDeNascimento);
        jLabelDataDeNascimento.setBounds(580, 150, 127, 19);

        jLabelCidade.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N
        jLabelCidade.setText("Cidade");
        MeuCadastro.add(jLabelCidade);
        jLabelCidade.setBounds(50, 360, 45, 19);

        jLabelBairro.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N
        jLabelBairro.setText("Bairro");
        MeuCadastro.add(jLabelBairro);
        jLabelBairro.setBounds(50, 230, 50, 19);

        jLabelEstado.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N
        jLabelEstado.setText("Estado");
        MeuCadastro.add(jLabelEstado);
        jLabelEstado.setBounds(50, 300, 50, 19);

        jLabelTelefone.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N
        jLabelTelefone.setText("Telefone");
        MeuCadastro.add(jLabelTelefone);
        jLabelTelefone.setBounds(40, 420, 60, 20);

        jLabelEmail.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmail.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N
        jLabelEmail.setText("Email");
        MeuCadastro.add(jLabelEmail);
        jLabelEmail.setBounds(580, 230, 50, 19);

        jLabelUsuario.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N
        jLabelUsuario.setText("Usuario");
        MeuCadastro.add(jLabelUsuario);
        jLabelUsuario.setBounds(580, 300, 60, 19);

        jLabelSenha.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N
        jLabelSenha.setText("Senha");
        MeuCadastro.add(jLabelSenha);
        jLabelSenha.setBounds(600, 360, 60, 19);

        jtf_Nome.setBackground(new java.awt.Color(242, 242, 242));
        jtf_Nome.setBorder(null);
        jtf_Nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_NomeActionPerformed(evt);
            }
        });
        MeuCadastro.add(jtf_Nome);
        jtf_Nome.setBounds(110, 150, 460, 20);

        jtf_Cidade.setBackground(new java.awt.Color(242, 242, 242));
        jtf_Cidade.setBorder(null);
        MeuCadastro.add(jtf_Cidade);
        jtf_Cidade.setBounds(110, 360, 310, 16);

        jtf_Bairro.setBackground(new java.awt.Color(242, 242, 242));
        jtf_Bairro.setBorder(null);
        MeuCadastro.add(jtf_Bairro);
        jtf_Bairro.setBounds(110, 230, 310, 20);

        jtf_Estado.setEditable(false);
        jtf_Estado.setBackground(new java.awt.Color(242, 242, 242));
        jtf_Estado.setBorder(null);
        MeuCadastro.add(jtf_Estado);
        jtf_Estado.setBounds(110, 300, 320, 16);

        jtf_Telefone.setBackground(new java.awt.Color(242, 242, 242));
        jtf_Telefone.setBorder(null);
        jtf_Telefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_TelefoneActionPerformed(evt);
            }
        });
        MeuCadastro.add(jtf_Telefone);
        jtf_Telefone.setBounds(110, 430, 310, 20);

        jtf_Email.setBackground(new java.awt.Color(242, 242, 242));
        jtf_Email.setBorder(null);
        MeuCadastro.add(jtf_Email);
        jtf_Email.setBounds(640, 230, 320, 20);

        jtf_Usuario.setBackground(new java.awt.Color(242, 242, 242));
        jtf_Usuario.setBorder(null);
        MeuCadastro.add(jtf_Usuario);
        jtf_Usuario.setBounds(660, 300, 200, 20);

        jtf_Senha.setBackground(new java.awt.Color(242, 242, 242));
        jtf_Senha.setBorder(null);
        MeuCadastro.add(jtf_Senha);
        jtf_Senha.setBounds(660, 360, 200, 20);

        btn_Cadastrar.setBackground(new java.awt.Color(242, 242, 242));
        btn_Cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Save icon.png"))); // NOI18N
        btn_Cadastrar.setContentAreaFilled(false);
        MeuCadastro.add(btn_Cadastrar);
        btn_Cadastrar.setBounds(390, 540, 97, 70);

        jtf_Cancelar.setBackground(new java.awt.Color(242, 242, 242));
        jtf_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancel icon.png"))); // NOI18N
        jtf_Cancelar.setContentAreaFilled(false);
        MeuCadastro.add(jtf_Cancelar);
        jtf_Cancelar.setBounds(550, 540, 97, 70);

        jDateChooser1.setBackground(new java.awt.Color(242, 242, 242));
        MeuCadastro.add(jDateChooser1);
        jDateChooser1.setBounds(740, 150, 200, 20);

        jLabelNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Campo Nome.png"))); // NOI18N
        MeuCadastro.add(jLabelNome);
        jLabelNome.setBounds(100, 140, 480, 40);

        JlCidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Campo Cidade.png"))); // NOI18N
        MeuCadastro.add(JlCidade);
        JlCidade.setBounds(100, 350, 340, 34);

        JlTelefone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Campo telefone.png"))); // NOI18N
        MeuCadastro.add(JlTelefone);
        JlTelefone.setBounds(100, 420, 350, 34);

        JlUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Campo user.png"))); // NOI18N
        MeuCadastro.add(JlUsuario);
        JlUsuario.setBounds(650, 290, 220, 34);

        JlEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Campo estado.png"))); // NOI18N
        MeuCadastro.add(JlEstado);
        JlEstado.setBounds(100, 290, 340, 40);

        JlEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Campo Email.png"))); // NOI18N
        MeuCadastro.add(JlEmail);
        JlEmail.setBounds(630, 220, 350, 34);

        JlSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Campo Senha2.png"))); // NOI18N
        MeuCadastro.add(JlSenha);
        JlSenha.setBounds(650, 350, 220, 34);

        jl_MeuCadastro.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jl_MeuCadastro.setForeground(new java.awt.Color(250, 130, 50));
        jl_MeuCadastro.setText("Meu Cadastro");
        MeuCadastro.add(jl_MeuCadastro);
        jl_MeuCadastro.setBounds(420, 30, 150, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Campo Bairro.png"))); // NOI18N
        MeuCadastro.add(jLabel2);
        jLabel2.setBounds(100, 220, 340, 40);

        Jlbackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background.jpeg"))); // NOI18N
        MeuCadastro.add(Jlbackground);
        Jlbackground.setBounds(0, -48, 1030, 728);

        Principal.add(MeuCadastro, "MeuCadastro");

        MeusAnuncios.setLayout(null);

        jLabel6.setText("Meus Anuncios");
        MeusAnuncios.add(jLabel6);
        jLabel6.setBounds(350, 20, 110, 16);

        btn_AlterarAnuncio.setText("Alternar");
        MeusAnuncios.add(btn_AlterarAnuncio);
        btn_AlterarAnuncio.setBounds(240, 570, 79, 25);

        btn_Excluir.setText("Excluir");
        MeusAnuncios.add(btn_Excluir);
        btn_Excluir.setBounds(400, 570, 73, 25);

        jLabel_Pesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Campo Nome.png"))); // NOI18N
        MeusAnuncios.add(jLabel_Pesquisa);
        jLabel_Pesquisa.setBounds(130, 50, 480, 34);

        btn_busca.setText("busca");
        MeusAnuncios.add(btn_busca);
        btn_busca.setBounds(630, 60, 73, 25);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Íco-Imovel copiar 6.png"))); // NOI18N
        MeusAnuncios.add(background);
        background.setBounds(0, -50, 1040, 726);

        Principal.add(MeusAnuncios, "MeusAnuncios");
        MeusAnuncios.getAccessibleContext().setAccessibleName("");

        Inicio.setLayout(null);

        jLabel10.setText("TELA INICIAL");
        Inicio.add(jLabel10);
        jLabel10.setBounds(330, 160, 330, 60);

        btn_inicio1.setText("Inicio");
        Inicio.add(btn_inicio1);
        btn_inicio1.setBounds(890, 610, 63, 25);

        background1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Íco-Imovel copiar 6.png"))); // NOI18N
        Inicio.add(background1);
        background1.setBounds(0, -50, 1030, 730);

        Principal.add(Inicio, "Inicio");

        getContentPane().add(Principal);
        Principal.setBounds(340, 50, 1030, 680);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_meuCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_meuCadastroActionPerformed
       if (!bt_meuCadastro.isSelected()) {
            btn_buscar.setIcon(Buscar2);
            bt_meuCadastro.setIcon(MeuCadastroSelected);
            bt_desapegar.setIcon(Desapegar2);
            bt_meusPedidos.setIcon(MeusPedidos2);
            bt_meusAnuncios.setIcon(MeusAnuncios2);
            bt_sair.setIcon(Sair2);
            
        }
        
        CardLayout card = (CardLayout) Principal.getLayout();
        card.show(Principal, "MeuCadastro");
    }//GEN-LAST:event_bt_meuCadastroActionPerformed

    private void bt_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_fecharActionPerformed
        dispose();
    }//GEN-LAST:event_bt_fecharActionPerformed

    private void jtf_NomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_NomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_NomeActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
       if (!bt_sair.isSelected()) {
            btn_buscar.setIcon(Buscar2);
            bt_meuCadastro.setIcon(MeuCadastro2);
            bt_desapegar.setIcon(Desapegar2);
            bt_meusPedidos.setIcon(MeusPedidos2);
            bt_meusAnuncios.setIcon(MeusAnuncios2);
            bt_sair.setIcon(SairSelected);
            
        }
        
        Login login = new Login();
        login.setVisible(true);
        dispose();

    }//GEN-LAST:event_bt_sairActionPerformed

    private void jtf_TelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_TelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_TelefoneActionPerformed

    private void bt_desapegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_desapegarActionPerformed
        if (!bt_desapegar.isSelected()) {
            btn_buscar.setIcon(Buscar2);
            bt_meuCadastro.setIcon(MeuCadastro2);
            bt_desapegar.setIcon(DesapegarSelected);
            bt_meusPedidos.setIcon(MeusPedidos2);
            bt_meusAnuncios.setIcon(MeusAnuncios2);
            bt_sair.setIcon(Sair2);
            
        }

        CardLayout card = (CardLayout) Principal.getLayout();
        card.show(Principal, "Desapegar");
    }//GEN-LAST:event_bt_desapegarActionPerformed

    private void bt_meusAnunciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_meusAnunciosActionPerformed
        if (!bt_meusAnuncios.isSelected()) {
            btn_buscar.setIcon(Buscar2);
            bt_meuCadastro.setIcon(MeuCadastro2);
            bt_desapegar.setIcon(Desapegar2);
            bt_meusPedidos.setIcon(MeusPedidos2);
            bt_meusAnuncios.setIcon(MeusAnunciosSelected);
            bt_sair.setIcon(Sair2);
            
        }
        
        CardLayout card = (CardLayout) Principal.getLayout();
        card.show(Principal, "MeusAnuncios");
    }//GEN-LAST:event_bt_meusAnunciosActionPerformed

    private void jtf_valorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_valorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valorActionPerformed

    private void btn_inicio3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inicio3ActionPerformed
        CardLayout card = (CardLayout) Principal.getLayout();
        card.show(Principal, "Inicio");
    }//GEN-LAST:event_btn_inicio3ActionPerformed

    private void btn_inicio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inicio2ActionPerformed
        CardLayout card = (CardLayout) Principal.getLayout();
        card.show(Principal, "Inicio");
    }//GEN-LAST:event_btn_inicio2ActionPerformed

    private void btn_inicio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inicio1ActionPerformed

    }//GEN-LAST:event_btn_inicio1ActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
       if (!btn_buscar.isSelected()) {
            btn_buscar.setIcon(BuscarSelected);
            bt_meuCadastro.setIcon(MeuCadastro2);
            bt_desapegar.setIcon(Desapegar2);
            bt_meusPedidos.setIcon(MeusPedidos2);
            bt_meusAnuncios.setIcon(MeusAnuncios2);
            bt_sair.setIcon(Sair2);
            
        }

        CardLayout card = (CardLayout) Principal.getLayout();
        card.show(Principal, "Inicio");
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void bt_meusPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_meusPedidosActionPerformed
        if (!bt_meusPedidos.isSelected()) {
            btn_buscar.setIcon(Buscar2);
            bt_meuCadastro.setIcon(MeuCadastro2);
            bt_desapegar.setIcon(Desapegar2);
            bt_meusPedidos.setIcon(MeusPedidosSelected);
            bt_meusAnuncios.setIcon(MeusAnuncios2);
            bt_sair.setIcon(Sair2);
            
        }
        
        
    }//GEN-LAST:event_bt_meusPedidosActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BarraTop;
    private javax.swing.JPanel Desapego;
    private javax.swing.JLabel Fundo;
    private javax.swing.JPanel Inicio;
    private javax.swing.JLabel JlCidade;
    private javax.swing.JLabel JlEmail;
    private javax.swing.JLabel JlEstado;
    private javax.swing.JLabel JlSenha;
    private javax.swing.JLabel JlTelefone;
    private javax.swing.JLabel JlUsuario;
    private javax.swing.JLabel Jlbackground;
    private javax.swing.JLabel Logo;
    private javax.swing.JPanel MeuCadastro;
    private javax.swing.JPanel MeusAnuncios;
    private javax.swing.JPanel Principal;
    private javax.swing.JLabel background;
    private javax.swing.JLabel background1;
    private javax.swing.JButton bt_desapegar;
    private javax.swing.JButton bt_fechar;
    private javax.swing.JButton bt_meuCadastro;
    private javax.swing.JButton bt_meusAnuncios;
    private javax.swing.JButton bt_meusPedidos;
    private javax.swing.JButton bt_sair;
    private javax.swing.JButton btn_AlterarAnuncio;
    private javax.swing.JButton btn_Cadastrar;
    private javax.swing.JButton btn_Excluir;
    private javax.swing.JButton btn_busca;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_inicio1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
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
    private javax.swing.JLabel jLabelDataDeNascimento;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelEstado;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelNomeCompleto;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JLabel jLabelTelefone;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JLabel jLabel_Pesquisa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jl_MeuCadastro;
    private javax.swing.JLabel jl_condicaoProduto;
    private javax.swing.JLabel jl_valor;
    private javax.swing.JRadioButton jrb_Novo;
    private javax.swing.JRadioButton jrb_Usado;
    private javax.swing.JTextArea jta_descricao;
    private javax.swing.JTextField jtf_Bairro;
    private javax.swing.JButton jtf_Cancelar;
    private javax.swing.JTextField jtf_Cidade;
    private javax.swing.JTextField jtf_Email;
    private javax.swing.JTextField jtf_Estado;
    private javax.swing.JTextField jtf_Nome;
    private javax.swing.JTextField jtf_Senha;
    private javax.swing.JTextField jtf_Telefone;
    private javax.swing.JTextField jtf_Usuario;
    private javax.swing.JTextField jtf_titulo;
    private javax.swing.JLabel lblImagemProd;
    private javax.swing.JLabel nomeUser;
    // End of variables declaration//GEN-END:variables
}
