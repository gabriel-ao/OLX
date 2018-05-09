/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Classes.Produto;
import Classes.Usuario;
import ConexaoBD.ProdutoBD;
import UTIL.ManipularImagem;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

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
        this.setLocationRelativeTo(null);
        btn_buscar.setIcon(BuscarSelected);
        
        try {
            preencherMenuAnuncios();
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Variavel BufferedImage
    BufferedImage imagemBuffer;

    //Criando objetos que serão utilizados
    Produto produto = new Produto();
    ProdutoBD produtoBD = new ProdutoBD();
    
    List<Produto> listaProduto;
    
    public void preencherMenuAnuncios() throws Exception {
        //Criando List para armazenar todos os anuncios do Banco de Dados

        listaProduto = produtoBD.listarTodosProdutos();
        
        int j = 0;
        
        for (int i = 0; i < listaProduto.size(); i++) {
            JPanel anuncio = new JPanel();
            
            anuncio.setName("" + i);
            anuncio.setBackground(new java.awt.Color(255, 255, 255));
            anuncio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
            anuncio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            anuncio.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    exibirAnuncio(evt, anuncio);
                }
            });
            anuncio.setLayout(null);

            //Criando label que ficará a imagem do anuncio
            JLabel lblImgAnuncio = new JLabel();
            ManipularImagem.exibiImagemLabel(listaProduto.get(i).getImg(), lblImgAnuncio);
            lblImgAnuncio.setBackground(new java.awt.Color(255, 255, 255));
            lblImgAnuncio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblImgAnuncio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
            anuncio.add(lblImgAnuncio);
            lblImgAnuncio.setBounds(0, 0, 120, 110);

            //Criando label do preço do anuncio 
            JLabel lblPreco = new JLabel();

            //Coversão de Double para formato de dinheiro real
            double preco = listaProduto.get(i).getPreco();
            Locale ptBr = new Locale("pt", "BR");
            String valorString = NumberFormat.getCurrencyInstance(ptBr).format(preco);
            
            lblPreco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            lblPreco.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            lblPreco.setText(valorString);
            anuncio.add(lblPreco);
            lblPreco.setBounds(130, 40, 150, 20);

            //criando titulo do anuncio
            JLabel lblTitulo = new JLabel();
            lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblTitulo.setText(listaProduto.get(i).getNome());
            anuncio.add(lblTitulo);
            lblTitulo.setBounds(120, 0, 170, 20);

            //adicionando o anuncio no painel 
            PainelAnuncios.add(anuncio);
            
            if (((3 * j) + 1) == (i + 1)) {
                anuncio.setBounds(10, 10 + (140 * j), 290, 110);
            } else if (((3 * j) + 2) == (i + 1)) {
                anuncio.setBounds(330, 10 + (140 * j), 290, 110);
            } else if (((3 * j) + 3) == (i + 1)) {
                anuncio.setBounds(650, 10 + (140 * j), 290, 110);
                j++;
            }
        }
        
        PainelAnuncios.setPreferredSize(new Dimension(940, 180 * j));
    }
    
    public void StatusAnuncios(String Status) {
        //Fazer uma busca no banco para verificar o status de cada pedido para o id daquele usuario

        switch (Status) {
            case "Reservado":
                btn_Reservas.setIcon(Reservar);
            
            case "Desapegar":
                //
                btn_Reservas.setIcon(CancelarReserva);
            
            case "Interessado":
                btn_Reservas.setIcon(Desapegar);
            
            default:
                break;
        }
        
    }

    //Icones do menu lateral
    ImageIcon Buscar2 = new ImageIcon(getClass().getResource("/Img/MenuLateral/Buscar.png"));
    ImageIcon MeuCadastro2 = new ImageIcon(getClass().getResource("/Img/MenuLateral/MeuCadastro.png"));
    ImageIcon Desapegar2 = new ImageIcon(getClass().getResource("/Img/MenuLateral/Desapegar.png"));
    ImageIcon MeusPedidos2 = new ImageIcon(getClass().getResource("/Img/MenuLateral/MeusPedidos.png"));
    ImageIcon MeusAnuncios2 = new ImageIcon(getClass().getResource("/Img/MenuLateral/MeusAnuncios.png"));
    ImageIcon Sair2 = new ImageIcon(getClass().getResource("/Img/MenuLateral/Sair.png"));

//Icones do menu lateral se for selecionado
    ImageIcon BuscarSelected = new ImageIcon(getClass().getResource("/Img/MenuLateral/BuscarSelected.png"));
    ImageIcon MeuCadastroSelected = new ImageIcon(getClass().getResource("/Img/MenuLateral/MeuCadastroSelected.png"));
    ImageIcon DesapegarSelected = new ImageIcon(getClass().getResource("/Img/MenuLateral/DesapegarSelected.png"));
    ImageIcon MeusPedidosSelected = new ImageIcon(getClass().getResource("/Img/MenuLateral/MeusPedidosSelected.png"));
    ImageIcon MeusAnunciosSelected = new ImageIcon(getClass().getResource("/Img/MenuLateral/MeusAnunciosSelected.png"));
    ImageIcon SairSelected = new ImageIcon(getClass().getResource("/Img/MenuLateral/SairSelected.png"));

    //botoes do menu meus anuncios
    ImageIcon Reservar = new ImageIcon(getClass().getResource("/Img/Reservar icon.png"));
    ImageIcon CancelarReserva = new ImageIcon(getClass().getResource("/Img/CancelarReserva.png"));
    ImageIcon Desapegar = new ImageIcon(getClass().getResource("/Img/Desepegar.png"));

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupEstadoProd = new javax.swing.ButtonGroup();
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
        Inicio_buscar = new javax.swing.JPanel();
        jLabelB_Categoria = new javax.swing.JLabel();
        jLabelB_Regiao = new javax.swing.JLabel();
        jLabelB_Estado = new javax.swing.JLabel();
        jComboBoxCategoria = new javax.swing.JComboBox<>();
        jComboBoxRegiao = new javax.swing.JComboBox<>();
        jRadioButtonNovo = new javax.swing.JRadioButton();
        jRadioButtonUsado = new javax.swing.JRadioButton();
        jTextFieldBuscar = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        bt_Lupa = new javax.swing.JButton();
        PainelAnuncios = new javax.swing.JPanel();
        background1 = new javax.swing.JLabel();
        Desapego = new javax.swing.JPanel();
        btn_cancelar = new javax.swing.JButton();
        btn_excluir = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        btn_novo = new javax.swing.JButton();
        btn_inserirFoto = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        bj_Categoria = new javax.swing.JComboBox<>();
        jLabel_Desapego = new javax.swing.JLabel();
        lblImagemProd = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jl_valor = new javax.swing.JLabel();
        jl_condicaoProduto = new javax.swing.JLabel();
        jtf_titulo = new javax.swing.JTextField();
        CampoTitulo = new javax.swing.JLabel();
        jtf_preco = new javax.swing.JTextField();
        CampoPreco = new javax.swing.JLabel();
        jrb_Novo = new javax.swing.JRadioButton();
        jrb_Usado = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jta_descricao = new javax.swing.JTextArea();
        jLabel23 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        FundoD = new javax.swing.JLabel();
        MeuCadastro = new javax.swing.JPanel();
        jLabelNomeCompleto = new javax.swing.JLabel();
        jLabelCidade = new javax.swing.JLabel();
        jLabelBairro = new javax.swing.JLabel();
        jLabelEstado = new javax.swing.JLabel();
        jLabelTelefone = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jtf_Senha = new javax.swing.JPasswordField();
        jLabelSenha = new javax.swing.JLabel();
        jtfTelefone = new javax.swing.JFormattedTextField();
        jtf_Nome = new javax.swing.JTextField();
        jtf_Cidade = new javax.swing.JTextField();
        jtf_Bairro = new javax.swing.JTextField();
        jtf_Email = new javax.swing.JTextField();
        jtf_Usuario = new javax.swing.JTextField();
        btn_editMC = new javax.swing.JButton();
        btn_excluirMC = new javax.swing.JButton();
        btn_SalvarMC = new javax.swing.JButton();
        jtf_CancelarMC = new javax.swing.JButton();
        jLabelNome = new javax.swing.JLabel();
        JlCidade = new javax.swing.JLabel();
        JlTelefone = new javax.swing.JLabel();
        JlUsuario = new javax.swing.JLabel();
        JlEmail = new javax.swing.JLabel();
        JlSenha = new javax.swing.JLabel();
        jl_MeuCadastro = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jc_estado = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        Jlbackground = new javax.swing.JLabel();
        MeusAnuncios = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        btn_Reservas = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        btn_venda = new javax.swing.JButton();
        fundoExibiranuncio = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel_Pesquisa = new javax.swing.JLabel();
        btn_busca = new javax.swing.JButton();
        background = new javax.swing.JLabel();
        MeusPedidos = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel_Pesquisa1 = new javax.swing.JLabel();
        btn_Reservas1 = new javax.swing.JButton();
        btn_venda1 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        fundoExibiranuncio1 = new javax.swing.JLabel();
        btn_busca2 = new javax.swing.JButton();
        background3 = new javax.swing.JLabel();
        ExibirAnuncio = new javax.swing.JPanel();
        lblTitulo_EA = new javax.swing.JLabel();
        jLabelFoto = new javax.swing.JLabel();
        lblPreco_EA = new javax.swing.JLabel();
        jLabelNovo_Usado = new javax.swing.JLabel();
        jLabelDataEstado = new javax.swing.JLabel();
        bt_comprar = new javax.swing.JButton();
        bt_reservar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jta_Descricao_EA = new javax.swing.JTextArea();

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
        nomeUser.setBounds(65, 16, 210, 22);

        BarraTop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/barra superior.png"))); // NOI18N
        getContentPane().add(BarraTop);
        BarraTop.setBounds(0, 0, 1370, 50);

        bt_meuCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/MenuLateral/MeuCadastro.png"))); // NOI18N
        bt_meuCadastro.setBorderPainted(false);
        bt_meuCadastro.setContentAreaFilled(false);
        bt_meuCadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_meuCadastro.setFocusPainted(false);
        bt_meuCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_meuCadastroActionPerformed(evt);
            }
        });
        getContentPane().add(bt_meuCadastro);
        bt_meuCadastro.setBounds(-7, 200, 310, 74);

        bt_desapegar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/MenuLateral/Desapegar.png"))); // NOI18N
        bt_desapegar.setBorderPainted(false);
        bt_desapegar.setContentAreaFilled(false);
        bt_desapegar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_desapegar.setFocusPainted(false);
        bt_desapegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_desapegarActionPerformed(evt);
            }
        });
        getContentPane().add(bt_desapegar);
        bt_desapegar.setBounds(-7, 310, 310, 74);

        bt_meusPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/MenuLateral/MeusPedidos.png"))); // NOI18N
        bt_meusPedidos.setBorderPainted(false);
        bt_meusPedidos.setContentAreaFilled(false);
        bt_meusPedidos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_meusPedidos.setFocusPainted(false);
        bt_meusPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_meusPedidosActionPerformed(evt);
            }
        });
        getContentPane().add(bt_meusPedidos);
        bt_meusPedidos.setBounds(-7, 420, 310, 74);

        bt_meusAnuncios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/MenuLateral/MeusAnuncios.png"))); // NOI18N
        bt_meusAnuncios.setBorderPainted(false);
        bt_meusAnuncios.setContentAreaFilled(false);
        bt_meusAnuncios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_meusAnuncios.setFocusPainted(false);
        bt_meusAnuncios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_meusAnunciosActionPerformed(evt);
            }
        });
        getContentPane().add(bt_meusAnuncios);
        bt_meusAnuncios.setBounds(-7, 530, 310, 74);

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/MenuLateral/Sair.png"))); // NOI18N
        bt_sair.setBorderPainted(false);
        bt_sair.setContentAreaFilled(false);
        bt_sair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_sair.setFocusPainted(false);
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
        btn_buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_buscar.setFocusPainted(false);
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_buscar);
        btn_buscar.setBounds(-2, 90, 300, 66);

        Fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Fundo menu.png"))); // NOI18N
        getContentPane().add(Fundo);
        Fundo.setBounds(0, 0, 350, 730);

        Principal.setLayout(new java.awt.CardLayout());

        Inicio_buscar.setLayout(null);

        jLabelB_Categoria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelB_Categoria.setText("Categoria:");
        Inicio_buscar.add(jLabelB_Categoria);
        jLabelB_Categoria.setBounds(650, 50, 63, 20);

        jLabelB_Regiao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelB_Regiao.setText("Região:");
        Inicio_buscar.add(jLabelB_Regiao);
        jLabelB_Regiao.setBounds(670, 20, 46, 17);

        jLabelB_Estado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelB_Estado.setText("Estado:");
        Inicio_buscar.add(jLabelB_Estado);
        jLabelB_Estado.setBounds(810, 20, 48, 17);

        jComboBoxCategoria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCategoriaActionPerformed(evt);
            }
        });
        Inicio_buscar.add(jComboBoxCategoria);
        jComboBoxCategoria.setBounds(721, 50, 70, 23);

        jComboBoxRegiao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxRegiao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Inicio_buscar.add(jComboBoxRegiao);
        jComboBoxRegiao.setBounds(721, 18, 70, 23);

        jRadioButtonNovo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonNovo.setText("Novo");
        jRadioButtonNovo.setContentAreaFilled(false);
        Inicio_buscar.add(jRadioButtonNovo);
        jRadioButtonNovo.setBounds(860, 10, 70, 25);

        jRadioButtonUsado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonUsado.setText("Usado");
        jRadioButtonUsado.setContentAreaFilled(false);
        jRadioButtonUsado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonUsadoActionPerformed(evt);
            }
        });
        Inicio_buscar.add(jRadioButtonUsado);
        jRadioButtonUsado.setBounds(860, 30, 70, 25);

        jTextFieldBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldBuscar.setBorder(null);
        Inicio_buscar.add(jTextFieldBuscar);
        jTextFieldBuscar.setBounds(50, 30, 590, 30);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Buscar/CAMPO BUSCA.png"))); // NOI18N
        Inicio_buscar.add(jLabel10);
        jLabel10.setBounds(40, 20, 610, 50);

        bt_Lupa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Buscar/botao lupa.png"))); // NOI18N
        bt_Lupa.setBorderPainted(false);
        bt_Lupa.setContentAreaFilled(false);
        Inicio_buscar.add(bt_Lupa);
        bt_Lupa.setBounds(940, 20, 60, 43);

        PainelAnuncios.setBackground(new java.awt.Color(223, 223, 223));
        PainelAnuncios.setPreferredSize(new java.awt.Dimension(940, 1000));
        PainelAnuncios.setLayout(null);
        Inicio_buscar.add(PainelAnuncios);
        PainelAnuncios.setBounds(40, 80, 950, 580);

        background1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Íco-Imovel copiar 6.png"))); // NOI18N
        Inicio_buscar.add(background1);
        background1.setBounds(0, -40, 1025, 720);

        Principal.add(Inicio_buscar, "Inicio");

        Desapego.setFocusable(false);
        Desapego.setLayout(null);

        btn_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancel icon.png"))); // NOI18N
        btn_cancelar.setToolTipText("Cancelar");
        btn_cancelar.setBorder(null);
        btn_cancelar.setBorderPainted(false);
        btn_cancelar.setContentAreaFilled(false);
        btn_cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancelar.setFocusPainted(false);
        btn_cancelar.setFocusable(false);
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        Desapego.add(btn_cancelar);
        btn_cancelar.setBounds(580, 580, 70, 70);

        btn_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Excluir.png"))); // NOI18N
        btn_excluir.setToolTipText("Excluir");
        btn_excluir.setBorder(null);
        btn_excluir.setBorderPainted(false);
        btn_excluir.setContentAreaFilled(false);
        btn_excluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_excluir.setFocusPainted(false);
        btn_excluir.setFocusable(false);
        Desapego.add(btn_excluir);
        btn_excluir.setBounds(500, 580, 70, 70);

        btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Save icon.png"))); // NOI18N
        btn_save.setToolTipText("Salvar");
        btn_save.setBorder(null);
        btn_save.setBorderPainted(false);
        btn_save.setContentAreaFilled(false);
        btn_save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_save.setFocusPainted(false);
        btn_save.setFocusable(false);
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });
        Desapego.add(btn_save);
        btn_save.setBounds(420, 580, 70, 70);

        btn_novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Edit icon.png"))); // NOI18N
        btn_novo.setToolTipText("Novo");
        btn_novo.setBorder(null);
        btn_novo.setBorderPainted(false);
        btn_novo.setContentAreaFilled(false);
        btn_novo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_novo.setFocusPainted(false);
        btn_novo.setFocusable(false);
        Desapego.add(btn_novo);
        btn_novo.setBounds(340, 580, 70, 70);

        btn_inserirFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Inserir foto icon.png"))); // NOI18N
        btn_inserirFoto.setBorder(null);
        btn_inserirFoto.setBorderPainted(false);
        btn_inserirFoto.setContentAreaFilled(false);
        btn_inserirFoto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_inserirFoto.setFocusPainted(false);
        btn_inserirFoto.setFocusable(false);
        btn_inserirFoto.setNextFocusableComponent(btn_save);
        btn_inserirFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inserirFotoActionPerformed(evt);
            }
        });
        Desapego.add(btn_inserirFoto);
        btn_inserirFoto.setBounds(180, 480, 110, 32);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Categoria:");
        Desapego.add(jLabel1);
        jLabel1.setBounds(560, 480, 70, 17);

        bj_Categoria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bj_Categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Automóvel", "Eletrônicos", "Imóvel", "Pet", "Vestimentas" }));
        bj_Categoria.setNextFocusableComponent(btn_inserirFoto);
        Desapego.add(bj_Categoria);
        bj_Categoria.setBounds(560, 500, 210, 20);

        jLabel_Desapego.setFont(new java.awt.Font("Tahoma", 0, 50)); // NOI18N
        jLabel_Desapego.setForeground(new java.awt.Color(247, 130, 50));
        jLabel_Desapego.setText("Desapego");
        Desapego.add(jLabel_Desapego);
        jLabel_Desapego.setBounds(420, 20, 230, 70);

        lblImagemProd.setBackground(new java.awt.Color(242, 242, 242));
        lblImagemProd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImagemProd.setToolTipText("");
        lblImagemProd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Desapego.add(lblImagemProd);
        lblImagemProd.setBounds(90, 130, 290, 340);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Titulo:");
        Desapego.add(jLabel3);
        jLabel3.setBounds(560, 120, 50, 17);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Descricão:");
        Desapego.add(jLabel4);
        jLabel4.setBounds(560, 180, 70, 17);

        jl_valor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jl_valor.setText("Preço:");
        Desapego.add(jl_valor);
        jl_valor.setBounds(560, 420, 40, 17);

        jl_condicaoProduto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jl_condicaoProduto.setText("O produto é");
        Desapego.add(jl_condicaoProduto);
        jl_condicaoProduto.setBounds(800, 440, 80, 17);

        jtf_titulo.setBackground(new java.awt.Color(242, 242, 242));
        jtf_titulo.setBorder(null);
        jtf_titulo.setNextFocusableComponent(jta_descricao);
        Desapego.add(jtf_titulo);
        jtf_titulo.setBounds(568, 142, 360, 30);

        CampoTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Campo Titulo.png"))); // NOI18N
        Desapego.add(CampoTitulo);
        CampoTitulo.setBounds(560, 140, 380, 34);

        jtf_preco.setBackground(new java.awt.Color(242, 242, 242));
        jtf_preco.setBorder(null);
        jtf_preco.setNextFocusableComponent(jRadioButtonNovo);
        Desapego.add(jtf_preco);
        jtf_preco.setBounds(605, 442, 140, 30);

        CampoPreco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Valor campo.png"))); // NOI18N
        Desapego.add(CampoPreco);
        CampoPreco.setBounds(560, 440, 200, 34);

        groupEstadoProd.add(jrb_Novo);
        jrb_Novo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jrb_Novo.setText("Novo");
        jrb_Novo.setContentAreaFilled(false);
        jrb_Novo.setNextFocusableComponent(jRadioButtonUsado);
        Desapego.add(jrb_Novo);
        jrb_Novo.setBounds(800, 460, 59, 25);

        groupEstadoProd.add(jrb_Usado);
        jrb_Usado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jrb_Usado.setText("Usado");
        jrb_Usado.setContentAreaFilled(false);
        jrb_Usado.setNextFocusableComponent(jComboBoxCategoria);
        Desapego.add(jrb_Usado);
        jrb_Usado.setBounds(870, 460, 80, 25);

        jta_descricao.setBackground(new java.awt.Color(242, 242, 242));
        jta_descricao.setColumns(20);
        jta_descricao.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jta_descricao.setRows(5);
        jta_descricao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jta_descricao.setNextFocusableComponent(jtf_preco);
        jScrollPane1.setViewportView(jta_descricao);

        Desapego.add(jScrollPane1);
        jScrollPane1.setBounds(560, 200, 380, 200);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(247, 130, 50));
        jLabel23.setText("*");
        Desapego.add(jLabel23);
        jLabel23.setBounds(550, 170, 10, 30);

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(247, 130, 50));
        jLabel22.setText("*");
        Desapego.add(jLabel22);
        jLabel22.setBounds(550, 410, 10, 30);

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(247, 130, 50));
        jLabel21.setText("*");
        Desapego.add(jLabel21);
        jLabel21.setBounds(550, 470, 10, 30);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(247, 130, 50));
        jLabel20.setText("*");
        Desapego.add(jLabel20);
        jLabel20.setBounds(550, 110, 10, 30);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(247, 130, 50));
        jLabel19.setText("*");
        Desapego.add(jLabel19);
        jLabel19.setBounds(170, 480, 10, 17);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(247, 130, 50));
        jLabel18.setText("Campos Obrigatorios*");
        Desapego.add(jLabel18);
        jLabel18.setBounds(90, 80, 150, 17);

        FundoD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Íco-Imovel copiar 6.png"))); // NOI18N
        Desapego.add(FundoD);
        FundoD.setBounds(0, -50, 1030, 730);

        Principal.add(Desapego, "Desapegar");

        MeuCadastro.setLayout(null);

        jLabelNomeCompleto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNomeCompleto.setText("Nome:");
        MeuCadastro.add(jLabelNomeCompleto);
        jLabelNomeCompleto.setBounds(100, 140, 50, 30);

        jLabelCidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCidade.setText("Cidade:");
        MeuCadastro.add(jLabelCidade);
        jLabelCidade.setBounds(100, 273, 46, 20);

        jLabelBairro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelBairro.setText("Bairro:");
        MeuCadastro.add(jLabelBairro);
        jLabelBairro.setBounds(100, 210, 50, 20);

        jLabelEstado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelEstado.setText("Estado:");
        MeuCadastro.add(jLabelEstado);
        jLabelEstado.setBounds(100, 350, 50, 17);

        jLabelTelefone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTelefone.setText("Telefone:");
        MeuCadastro.add(jLabelTelefone);
        jLabelTelefone.setBounds(630, 210, 60, 20);

        jLabelEmail.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelEmail.setText("Email:");
        MeuCadastro.add(jLabelEmail);
        jLabelEmail.setBounds(630, 137, 50, 30);

        jLabelUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelUsuario.setText("Usuário:");
        MeuCadastro.add(jLabelUsuario);
        jLabelUsuario.setBounds(630, 273, 60, 20);

        jtf_Senha.setBackground(new java.awt.Color(242, 242, 242));
        jtf_Senha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtf_Senha.setBorder(null);
        jtf_Senha.setDoubleBuffered(true);
        MeuCadastro.add(jtf_Senha);
        jtf_Senha.setBounds(640, 360, 200, 30);

        jLabelSenha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelSenha.setText("Senha:");
        MeuCadastro.add(jLabelSenha);
        jLabelSenha.setBounds(630, 340, 50, 17);

        jtfTelefone.setBackground(new java.awt.Color(242, 242, 242));
        jtfTelefone.setBorder(null);
        try {
            jtfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jtfTelefone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        MeuCadastro.add(jtfTelefone);
        jtfTelefone.setBounds(640, 231, 310, 30);

        jtf_Nome.setBackground(new java.awt.Color(242, 242, 242));
        jtf_Nome.setBorder(null);
        jtf_Nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_NomeActionPerformed(evt);
            }
        });
        MeuCadastro.add(jtf_Nome);
        jtf_Nome.setBounds(110, 165, 450, 30);

        jtf_Cidade.setBackground(new java.awt.Color(242, 242, 242));
        jtf_Cidade.setBorder(null);
        MeuCadastro.add(jtf_Cidade);
        jtf_Cidade.setBounds(110, 295, 310, 30);

        jtf_Bairro.setBackground(new java.awt.Color(242, 242, 242));
        jtf_Bairro.setBorder(null);
        MeuCadastro.add(jtf_Bairro);
        jtf_Bairro.setBounds(110, 231, 310, 30);

        jtf_Email.setBackground(new java.awt.Color(242, 242, 242));
        jtf_Email.setBorder(null);
        MeuCadastro.add(jtf_Email);
        jtf_Email.setBounds(640, 165, 310, 30);

        jtf_Usuario.setBackground(new java.awt.Color(242, 242, 242));
        jtf_Usuario.setBorder(null);
        MeuCadastro.add(jtf_Usuario);
        jtf_Usuario.setBounds(640, 295, 200, 30);

        btn_editMC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Edit icon.png"))); // NOI18N
        btn_editMC.setBorderPainted(false);
        btn_editMC.setContentAreaFilled(false);
        btn_editMC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_editMC.setFocusPainted(false);
        MeuCadastro.add(btn_editMC);
        btn_editMC.setBounds(360, 550, 70, 73);

        btn_excluirMC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Excluir.png"))); // NOI18N
        btn_excluirMC.setBorderPainted(false);
        btn_excluirMC.setContentAreaFilled(false);
        btn_excluirMC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_excluirMC.setFocusPainted(false);
        MeuCadastro.add(btn_excluirMC);
        btn_excluirMC.setBounds(520, 550, 70, 70);

        btn_SalvarMC.setBackground(new java.awt.Color(242, 242, 242));
        btn_SalvarMC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Save icon.png"))); // NOI18N
        btn_SalvarMC.setBorderPainted(false);
        btn_SalvarMC.setContentAreaFilled(false);
        btn_SalvarMC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_SalvarMC.setFocusPainted(false);
        btn_SalvarMC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SalvarMCActionPerformed(evt);
            }
        });
        MeuCadastro.add(btn_SalvarMC);
        btn_SalvarMC.setBounds(440, 550, 70, 70);

        jtf_CancelarMC.setBackground(new java.awt.Color(242, 242, 242));
        jtf_CancelarMC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancel icon.png"))); // NOI18N
        jtf_CancelarMC.setBorderPainted(false);
        jtf_CancelarMC.setContentAreaFilled(false);
        jtf_CancelarMC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtf_CancelarMC.setFocusPainted(false);
        MeuCadastro.add(jtf_CancelarMC);
        jtf_CancelarMC.setBounds(600, 550, 70, 70);

        jLabelNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Campo Nome.png"))); // NOI18N
        MeuCadastro.add(jLabelNome);
        jLabelNome.setBounds(100, 160, 480, 40);

        JlCidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Campo Cidade.png"))); // NOI18N
        MeuCadastro.add(JlCidade);
        JlCidade.setBounds(100, 290, 340, 40);

        JlTelefone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Campo telefone.png"))); // NOI18N
        MeuCadastro.add(JlTelefone);
        JlTelefone.setBounds(630, 226, 350, 40);

        JlUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Campo user.png"))); // NOI18N
        MeuCadastro.add(JlUsuario);
        JlUsuario.setBounds(630, 290, 220, 40);

        JlEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Campo Email.png"))); // NOI18N
        MeuCadastro.add(JlEmail);
        JlEmail.setBounds(630, 160, 333, 40);

        JlSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Campo Senha2.png"))); // NOI18N
        MeuCadastro.add(JlSenha);
        JlSenha.setBounds(630, 355, 220, 40);

        jl_MeuCadastro.setFont(new java.awt.Font("Tahoma", 0, 50)); // NOI18N
        jl_MeuCadastro.setForeground(new java.awt.Color(250, 130, 50));
        jl_MeuCadastro.setText("Meu Cadastro");
        MeuCadastro.add(jl_MeuCadastro);
        jl_MeuCadastro.setBounds(360, 30, 330, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Campo Bairro.png"))); // NOI18N
        MeuCadastro.add(jLabel2);
        jLabel2.setBounds(100, 226, 340, 40);

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(247, 130, 50));
        jLabel8.setText("Campos Obrigatorios*");
        MeuCadastro.add(jLabel8);
        jLabel8.setBounds(100, 90, 150, 17);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(247, 130, 50));
        jLabel9.setText("*");
        MeuCadastro.add(jLabel9);
        jLabel9.setBounds(90, 210, 10, 10);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(247, 130, 50));
        jLabel12.setText("*");
        MeuCadastro.add(jLabel12);
        jLabel12.setBounds(90, 260, 10, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(247, 130, 50));
        jLabel11.setText("*");
        MeuCadastro.add(jLabel11);
        jLabel11.setBounds(90, 140, 10, 20);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(247, 130, 50));
        jLabel13.setText("*");
        MeuCadastro.add(jLabel13);
        jLabel13.setBounds(620, 130, 10, 30);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(247, 130, 50));
        jLabel14.setText("*");
        MeuCadastro.add(jLabel14);
        jLabel14.setBounds(90, 340, 10, 30);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(247, 130, 50));
        jLabel15.setText("*");
        MeuCadastro.add(jLabel15);
        jLabel15.setBounds(620, 330, 10, 17);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(247, 130, 50));
        jLabel16.setText("*");
        MeuCadastro.add(jLabel16);
        jLabel16.setBounds(630, 250, 10, 20);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(247, 130, 50));
        jLabel17.setText("*");
        MeuCadastro.add(jLabel17);
        jLabel17.setBounds(620, 270, 10, 10);

        jc_estado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jc_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        jc_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jc_estadoActionPerformed(evt);
            }
        });
        MeuCadastro.add(jc_estado);
        jc_estado.setBounds(170, 350, 50, 23);

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(247, 130, 50));
        jLabel32.setText("*");
        MeuCadastro.add(jLabel32);
        jLabel32.setBounds(620, 210, 10, 10);

        Jlbackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background.jpeg"))); // NOI18N
        Jlbackground.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MeuCadastro.add(Jlbackground);
        Jlbackground.setBounds(0, -48, 1030, 728);

        Principal.add(MeuCadastro, "MeuCadastro");

        MeusAnuncios.setLayout(null);

        jLabel27.setText("status da reserva/compra aqui");
        MeusAnuncios.add(jLabel27);
        jLabel27.setBounds(210, 210, 190, 14);

        btn_Reservas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Reservar icon.png"))); // NOI18N
        btn_Reservas.setBorderPainted(false);
        btn_Reservas.setContentAreaFilled(false);
        btn_Reservas.setFocusPainted(false);
        btn_Reservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ReservasActionPerformed(evt);
            }
        });
        MeusAnuncios.add(btn_Reservas);
        btn_Reservas.setBounds(220, 270, 90, 30);

        jLabel24.setText("Data do anuncio aqui");
        MeusAnuncios.add(jLabel24);
        jLabel24.setBounds(300, 250, 130, 20);

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel26.setText("Preço");
        MeusAnuncios.add(jLabel26);
        jLabel26.setBounds(210, 230, 120, 22);

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setText("Titulo aqui");
        MeusAnuncios.add(jLabel25);
        jLabel25.setBounds(210, 180, 120, 22);

        btn_venda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Vendas.png"))); // NOI18N
        btn_venda.setBorderPainted(false);
        btn_venda.setContentAreaFilled(false);
        btn_venda.setFocusPainted(false);
        btn_venda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vendaActionPerformed(evt);
            }
        });
        MeusAnuncios.add(btn_venda);
        btn_venda.setBounds(320, 270, 100, 30);

        fundoExibiranuncio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fundo meus anuncios.png"))); // NOI18N
        MeusAnuncios.add(fundoExibiranuncio);
        fundoExibiranuncio.setBounds(30, 180, 402, 125);

        jTextField2.setBackground(new java.awt.Color(242, 242, 242));
        jTextField2.setAutoscrolls(false);
        jTextField2.setBorder(null);
        MeusAnuncios.add(jTextField2);
        jTextField2.setBounds(50, 113, 440, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 50)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(250, 130, 50));
        jLabel6.setText("Meus Anuncios");
        MeusAnuncios.add(jLabel6);
        jLabel6.setBounds(330, 10, 400, 61);

        jLabel_Pesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Campo Nome.png"))); // NOI18N
        MeusAnuncios.add(jLabel_Pesquisa);
        jLabel_Pesquisa.setBounds(30, 110, 480, 34);

        btn_busca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Buscar/botao lupa.png"))); // NOI18N
        btn_busca.setBorderPainted(false);
        btn_busca.setContentAreaFilled(false);
        MeusAnuncios.add(btn_busca);
        btn_busca.setBounds(510, 107, 50, 40);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Íco-Imovel copiar 6.png"))); // NOI18N
        MeusAnuncios.add(background);
        background.setBounds(0, -50, 1040, 726);

        Principal.add(MeusAnuncios, "MeusAnuncios");
        MeusAnuncios.getAccessibleContext().setAccessibleName("");

        MeusPedidos.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 50)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(250, 130, 50));
        jLabel7.setText("Meus Pedidos");
        MeusPedidos.add(jLabel7);
        jLabel7.setBounds(320, 10, 420, 61);

        jTextField3.setBackground(new java.awt.Color(242, 242, 242));
        jTextField3.setAutoscrolls(false);
        jTextField3.setBorder(null);
        MeusPedidos.add(jTextField3);
        jTextField3.setBounds(50, 112, 440, 30);

        jLabel_Pesquisa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Campo Nome.png"))); // NOI18N
        MeusPedidos.add(jLabel_Pesquisa1);
        jLabel_Pesquisa1.setBounds(30, 110, 480, 34);

        btn_Reservas1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/CancelarReserva.png"))); // NOI18N
        btn_Reservas1.setBorderPainted(false);
        btn_Reservas1.setContentAreaFilled(false);
        btn_Reservas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Reservas1ActionPerformed(evt);
            }
        });
        MeusPedidos.add(btn_Reservas1);
        btn_Reservas1.setBounds(200, 280, 140, 30);

        btn_venda1.setBorderPainted(false);
        btn_venda1.setContentAreaFilled(false);
        btn_venda1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_venda1ActionPerformed(evt);
            }
        });
        MeusPedidos.add(btn_venda1);
        btn_venda1.setBounds(350, 280, 79, 30);

        jLabel28.setText("Data do anuncio aqui");
        MeusPedidos.add(jLabel28);
        jLabel28.setBounds(300, 260, 130, 20);

        jLabel29.setText("status da reserva/aguardar confirmacao de venda");
        MeusPedidos.add(jLabel29);
        jLabel29.setBounds(210, 220, 300, 14);

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel30.setText("Preço");
        MeusPedidos.add(jLabel30);
        jLabel30.setBounds(210, 240, 120, 22);

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel31.setText("Titulo aqui");
        MeusPedidos.add(jLabel31);
        jLabel31.setBounds(210, 190, 120, 22);

        fundoExibiranuncio1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fundo meus anuncios.png"))); // NOI18N
        MeusPedidos.add(fundoExibiranuncio1);
        fundoExibiranuncio1.setBounds(30, 190, 402, 125);

        btn_busca2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Buscar/botao lupa.png"))); // NOI18N
        btn_busca2.setBorderPainted(false);
        btn_busca2.setContentAreaFilled(false);
        MeusPedidos.add(btn_busca2);
        btn_busca2.setBounds(510, 107, 50, 40);

        background3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Íco-Imovel copiar 6.png"))); // NOI18N
        MeusPedidos.add(background3);
        background3.setBounds(0, -50, 1040, 726);

        Principal.add(MeusPedidos, "MeusPedidos");

        ExibirAnuncio.setBackground(new java.awt.Color(223, 223, 223));
        ExibirAnuncio.setLayout(null);

        lblTitulo_EA.setBackground(new java.awt.Color(250, 250, 250));
        lblTitulo_EA.setFont(new java.awt.Font("Tahoma", 0, 50)); // NOI18N
        lblTitulo_EA.setForeground(new java.awt.Color(247, 130, 50));
        lblTitulo_EA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo_EA.setText("Titulo AQUI");
        ExibirAnuncio.add(lblTitulo_EA);
        lblTitulo_EA.setBounds(130, 10, 680, 70);

        jLabelFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ExibirAnuncio/OLX FOTO.png"))); // NOI18N
        ExibirAnuncio.add(jLabelFoto);
        jLabelFoto.setBounds(110, 100, 290, 340);

        lblPreco_EA.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lblPreco_EA.setForeground(new java.awt.Color(144, 39, 175));
        lblPreco_EA.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPreco_EA.setText("R$ 999999,00");
        lblPreco_EA.setToolTipText("");
        ExibirAnuncio.add(lblPreco_EA);
        lblPreco_EA.setBounds(770, 460, 220, 37);

        jLabelNovo_Usado.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabelNovo_Usado.setForeground(new java.awt.Color(132, 211, 61));
        jLabelNovo_Usado.setText("Novo/Usado");
        ExibirAnuncio.add(jLabelNovo_Usado);
        jLabelNovo_Usado.setBounds(880, 500, 110, 25);

        jLabelDataEstado.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabelDataEstado.setText("Exibir a data e estado dessa forma(18 de Novembro de 2017   SP)");
        ExibirAnuncio.add(jLabelDataEstado);
        jLabelDataEstado.setBounds(20, 550, 510, 19);

        bt_comprar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ExibirAnuncio/botao Comprar.png"))); // NOI18N
        bt_comprar.setBorderPainted(false);
        bt_comprar.setContentAreaFilled(false);
        bt_comprar.setFocusPainted(false);
        bt_comprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_comprarActionPerformed(evt);
            }
        });
        ExibirAnuncio.add(bt_comprar);
        bt_comprar.setBounds(290, 620, 230, 46);

        bt_reservar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ExibirAnuncio/botao reservar.png"))); // NOI18N
        bt_reservar.setBorderPainted(false);
        bt_reservar.setContentAreaFilled(false);
        bt_reservar.setCursor(new java.awt.Cursor(java.awt.Cursor.SE_RESIZE_CURSOR));
        bt_reservar.setFocusPainted(false);
        ExibirAnuncio.add(bt_reservar);
        bt_reservar.setBounds(570, 620, 230, 46);

        jta_Descricao_EA.setBackground(new java.awt.Color(242, 242, 242));
        jta_Descricao_EA.setColumns(20);
        jta_Descricao_EA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jta_Descricao_EA.setRows(5);
        jta_Descricao_EA.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jScrollPane3.setViewportView(jta_Descricao_EA);

        ExibirAnuncio.add(jScrollPane3);
        jScrollPane3.setBounds(520, 100, 450, 340);

        Principal.add(ExibirAnuncio, "ExibirAnuncio");
        ExibirAnuncio.getAccessibleContext().setAccessibleName("");

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
        System.exit(0);
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
        
        try {
            preencherMenuAnuncios();
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
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
        CardLayout card = (CardLayout) Principal.getLayout();
        card.show(Principal, "MeusPedidos");
    }//GEN-LAST:event_bt_meusPedidosActionPerformed

    private void jRadioButtonUsadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonUsadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonUsadoActionPerformed

    private void jComboBoxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCategoriaActionPerformed

    private void bt_comprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_comprarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_comprarActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        String estadoProd = "";
        
        if (jrb_Novo.isSelected()) {
            estadoProd = "Novo";
        }
        if (jrb_Usado.isSelected()) {
            estadoProd = "Usado";
        }

        //Verificando se todos os dados obrigatórios foram preenchidos 
        if (jtf_titulo.getText().isEmpty() || jta_descricao.getText().isEmpty() || jtf_preco.getText().isEmpty() || (estadoProd.isEmpty()) || (lblImagemProd.getIcon() == null)) {
            JOptionPane.showMessageDialog(null, "PREENCHA TODOS OS CAMPOS!!");
        } else {
            //Se tiver tudo preenchido encapsula os dados do produto
            produto.setNome(jtf_titulo.getText());
            produto.setDescricao(jta_descricao.getText());
            produto.setPreco(Double.parseDouble(jtf_preco.getText()));
            produto.setEstadoConserv(estadoProd);
            produto.setImg(ManipularImagem.getImgBytes(imagemBuffer));
            produto.setCategoria("Teste");
            produto.setStatus("Disponivel");
            produto.setId_usuario(1);
            
            if (produto.getId_produto() == 0) {
                try {
                    //inserindo no banco de dados
                    produtoBD.inserir(produto);
                    JOptionPane.showMessageDialog(null, "Anuncio realizado com sucesso!");
                    limparCamposDesapegar();
                } catch (Exception ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    produtoBD.alterar(produto);
                } catch (Exception ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_SalvarMCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SalvarMCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_SalvarMCActionPerformed

    private void btn_ReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ReservasActionPerformed
//        int dialogButton = 0;
//
//        //anuncio com interesse de reserva
//        if (StatusAnuncios == 1) {
//            Reservas reservas = new Reservas();
//            reservas.setVisible(true);
//
////anuncio ja reservado
//        } else if (StatusAnuncios() == 2) {
//            dialogButton = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja cancelar a reserva para o +nome+ ?", "Cancelar reserva!", JOptionPane.YES_NO_OPTION);
//        }
//        if (dialogButton == JOptionPane.YES_OPTION) {
//            //Alterar o status no banco para nao reservado para disponivel.
//             dialogButton = 0;
//        } //Alguem quer comprar o produto
//        else if (StatusAnuncios() == 3) {
//            dialogButton = JOptionPane.showConfirmDialog(null, "+nome+ quer comprar seu produto!!", "Desapegar!", JOptionPane.YES_NO_OPTION);
//                if (dialogButton == JOptionPane.YES_OPTION) {
//            DadosUsuario dadosUsuario = new DadosUsuario;
//              dadosUsuario.setVisble(true);
//        }
//       
//        }
//        else if (StatusAnuncios() == 4) {
//            dialogButton = JOptionPane.showConfirmDialog(null, "Ninguem ainda teve interesse no seu desapego", "Aguarde!", JOptionPane.YES_NO_OPTION);
//               
//        }
//       
//        }

//

    }//GEN-LAST:event_btn_ReservasActionPerformed

    private void jc_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jc_estadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jc_estadoActionPerformed

    private void btn_vendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vendaActionPerformed
        Vendas vendas = new Vendas();
        vendas.setVisible(true);
    }//GEN-LAST:event_btn_vendaActionPerformed

    private void btn_Reservas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Reservas1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_Reservas1ActionPerformed

    private void btn_venda1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_venda1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_venda1ActionPerformed

    private void btn_inserirFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inserirFotoActionPerformed
        //Criando o JFileChooser para buscar a imagem no computador
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("Imagem", "bmp", "png", "jpg", "jpeg"));
        fc.setAcceptAllFileFilterUsed(false);
        fc.setCurrentDirectory(new File("c:\\"));
        fc.setDialogTitle("Selecionar Imagem");
        int res = fc.showOpenDialog(null);
        
        if (res == JFileChooser.APPROVE_OPTION) {
            File arquivo = fc.getSelectedFile();
            
            try {
                //setando a dimensão da imagem 
                imagemBuffer = ManipularImagem.setImagemDimensao(arquivo.getAbsolutePath(), 300, 300);

                //setando o icone da label com a imagem selecionada
                lblImagemProd.setIcon(new ImageIcon(imagemBuffer));
            } catch (Exception ex) {
                //System.out.println(ex.printStackTrace().toString());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Voce nao selecionou nenhum arquivo.");
        }
    }//GEN-LAST:event_btn_inserirFotoActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente CANCELAR o cadastro do anuncio?", "** CANCELAR CADASTRO ANUNCIO **", JOptionPane.YES_NO_OPTION);
        
        if (resposta == 0) {
            limparCamposDesapegar();
        }
    }//GEN-LAST:event_btn_cancelarActionPerformed
    
    private void exibirAnuncio(java.awt.event.MouseEvent evt, javax.swing.JPanel panel) {
        int indexAnuncio = Integer.parseInt(panel.getName());
        
        double preco = listaProduto.get(indexAnuncio).getPreco();
        Locale ptBr = new Locale("pt", "BR");
        String valorString = NumberFormat.getCurrencyInstance(ptBr).format(preco);
        
        ManipularImagem.exibiImagemLabel(listaProduto.get(indexAnuncio).getImg(), jLabelFoto);
        lblTitulo_EA.setText(listaProduto.get(indexAnuncio).getNome());
        lblPreco_EA.setText(valorString);
        jta_Descricao_EA.setText(listaProduto.get(indexAnuncio).getDescricao());
        
        CardLayout card = (CardLayout) Principal.getLayout();
        card.show(Principal, "ExibirAnuncio");
    }
    
    public void limparCamposDesapegar() {
        jtf_titulo.setText("");
        jtf_preco.setText("");
        jta_descricao.setText("");
        lblImagemProd.setIcon(null);
        groupEstadoProd.clearSelection();
    }

    public void manipularBotoes(boolean modo){
        btn_save.setEnabled(modo);
        btn_cancelar.setEnabled(modo);
        
    }
    
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
                Usuario usuario = new Usuario();
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BarraTop;
    private javax.swing.JLabel CampoPreco;
    private javax.swing.JLabel CampoTitulo;
    private javax.swing.JPanel Desapego;
    private javax.swing.JPanel ExibirAnuncio;
    private javax.swing.JLabel Fundo;
    private javax.swing.JLabel FundoD;
    private javax.swing.JPanel Inicio_buscar;
    private javax.swing.JLabel JlCidade;
    private javax.swing.JLabel JlEmail;
    private javax.swing.JLabel JlSenha;
    private javax.swing.JLabel JlTelefone;
    private javax.swing.JLabel JlUsuario;
    private javax.swing.JLabel Jlbackground;
    private javax.swing.JLabel Logo;
    private javax.swing.JPanel MeuCadastro;
    private javax.swing.JPanel MeusAnuncios;
    private javax.swing.JPanel MeusPedidos;
    private javax.swing.JPanel PainelAnuncios;
    private javax.swing.JPanel Principal;
    private javax.swing.JLabel background;
    private javax.swing.JLabel background1;
    private javax.swing.JLabel background3;
    private javax.swing.JComboBox<String> bj_Categoria;
    private javax.swing.JButton bt_Lupa;
    private javax.swing.JButton bt_comprar;
    private javax.swing.JButton bt_desapegar;
    private javax.swing.JButton bt_fechar;
    private javax.swing.JButton bt_meuCadastro;
    private javax.swing.JButton bt_meusAnuncios;
    private javax.swing.JButton bt_meusPedidos;
    private javax.swing.JButton bt_reservar;
    private javax.swing.JButton bt_sair;
    private javax.swing.JButton btn_Reservas;
    private javax.swing.JButton btn_Reservas1;
    private javax.swing.JButton btn_SalvarMC;
    private javax.swing.JButton btn_busca;
    private javax.swing.JButton btn_busca2;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_editMC;
    private javax.swing.JButton btn_excluir;
    private javax.swing.JButton btn_excluirMC;
    private javax.swing.JButton btn_inserirFoto;
    private javax.swing.JButton btn_novo;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_venda;
    private javax.swing.JButton btn_venda1;
    private javax.swing.JLabel fundoExibiranuncio;
    private javax.swing.JLabel fundoExibiranuncio1;
    private javax.swing.ButtonGroup groupEstadoProd;
    private javax.swing.JComboBox<String> jComboBoxCategoria;
    private javax.swing.JComboBox<String> jComboBoxRegiao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelB_Categoria;
    private javax.swing.JLabel jLabelB_Estado;
    private javax.swing.JLabel jLabelB_Regiao;
    private javax.swing.JLabel jLabelBairro;
    private javax.swing.JLabel jLabelCidade;
    private javax.swing.JLabel jLabelDataEstado;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelEstado;
    private javax.swing.JLabel jLabelFoto;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelNomeCompleto;
    private javax.swing.JLabel jLabelNovo_Usado;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JLabel jLabelTelefone;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JLabel jLabel_Desapego;
    private javax.swing.JLabel jLabel_Pesquisa;
    private javax.swing.JLabel jLabel_Pesquisa1;
    private javax.swing.JRadioButton jRadioButtonNovo;
    private javax.swing.JRadioButton jRadioButtonUsado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextFieldBuscar;
    private javax.swing.JComboBox<String> jc_estado;
    private javax.swing.JLabel jl_MeuCadastro;
    private javax.swing.JLabel jl_condicaoProduto;
    private javax.swing.JLabel jl_valor;
    private javax.swing.JRadioButton jrb_Novo;
    private javax.swing.JRadioButton jrb_Usado;
    private javax.swing.JTextArea jta_Descricao_EA;
    private javax.swing.JTextArea jta_descricao;
    private javax.swing.JFormattedTextField jtfTelefone;
    private javax.swing.JTextField jtf_Bairro;
    private javax.swing.JButton jtf_CancelarMC;
    private javax.swing.JTextField jtf_Cidade;
    private javax.swing.JTextField jtf_Email;
    private javax.swing.JTextField jtf_Nome;
    private javax.swing.JPasswordField jtf_Senha;
    private javax.swing.JTextField jtf_Usuario;
    private javax.swing.JTextField jtf_preco;
    private javax.swing.JTextField jtf_titulo;
    private javax.swing.JLabel lblImagemProd;
    private javax.swing.JLabel lblPreco_EA;
    private javax.swing.JLabel lblTitulo_EA;
    private javax.swing.JLabel nomeUser;
    // End of variables declaration//GEN-END:variables
}
