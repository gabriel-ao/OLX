package View;

import Classes.Acao;
import Classes.Produto;
import Classes.Usuario;
import ConexaoBD.AcaoBD;
import ConexaoBD.ProdutoBD;
import ConexaoBD.UsuarioBD;
import UTIL.ManipularImagem;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

    //Variavel BufferedImage
    BufferedImage imagemBuffer;

    //Criando objetos que serão utilizados
    Produto produto = new Produto();
    ProdutoBD produtoBD = new ProdutoBD();

    Usuario usuario = new Usuario();
    UsuarioBD usuarioBD = new UsuarioBD();

    List<Produto> listaProduto;
    List<Produto> listaMeusProduto;
    List<Produto> listaMeusPedidos;

    int indexAnuncio;
    int indexMeuAnuncio;

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

    public Principal(Usuario usuario1) {
        this.usuario = usuario1;

        initComponents();

        this.setLocationRelativeTo(null);
        btn_buscar.setIcon(BuscarSelected);

        try {
            preencherMenuAnuncios(1);
            preencherMeusAnuncios();
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void preencherMenuAnuncios(int opcao) throws Exception {
        nomeUser.setText(usuario.getNome());
        //Criando List para armazenar todos os anuncios do Banco de Dados
        listaProduto = produtoBD.listarTodosProdutos(opcao, jtf_Buscar.getText());

        int j = 0;

        for (int i = 0; i < listaProduto.size(); i++) {
            JPanel anuncio = new JPanel();

            anuncio.setName("" + i);
            anuncio.setBackground(new java.awt.Color(255, 255, 255));
            anuncio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
            anuncio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            anuncio.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    exibirAnuncio(evt, anuncio, listaProduto);
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

            Date data = listaProduto.get(i).getDt_anuncio();
            Locale local = new Locale("pt", "BR");
            DateFormat formato = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", local);
            String dataFormatada = formato.format(data);

            JLabel lblData = new JLabel();
            lblData.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            lblData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblData.setText(dataFormatada);
            anuncio.add(lblData);
            lblData.setBounds(120, 85, 170, 20);

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

    public void preencherMeusAnuncios() throws Exception {
        //Criando List para armazenar todos os anuncios do Banco de Dados
        listaMeusProduto = produtoBD.listarMeusProdutos(usuario, 2);

        int j = 0;

        for (int i = 0; i < listaMeusProduto.size(); i++) {
            JPanel anuncio = new JPanel();

            anuncio.setName("" + i);
            anuncio.setBackground(new java.awt.Color(255, 255, 255));
            anuncio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
            anuncio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            anuncio.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    exibirMeuAnuncio(evt, anuncio);
                }
            });
            anuncio.setLayout(null);

            //Criando label que ficará a imagem do anuncio
            JLabel lblImgAnuncio = new JLabel();
            ManipularImagem.exibiImagemLabel(listaMeusProduto.get(i).getImg(), lblImgAnuncio);
            lblImgAnuncio.setBackground(new java.awt.Color(255, 255, 255));
            lblImgAnuncio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblImgAnuncio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
            anuncio.add(lblImgAnuncio);
            lblImgAnuncio.setBounds(0, 0, 120, 110);

            //Criando label do preço do anuncio 
            JLabel lblPreco = new JLabel();

            //Coversão de Double para formato de dinheiro real
            double preco = listaMeusProduto.get(i).getPreco();
            Locale ptBr = new Locale("pt", "BR");
            String valorString = NumberFormat.getCurrencyInstance(ptBr).format(preco);

            lblPreco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            lblPreco.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            lblPreco.setText(valorString);
            anuncio.add(lblPreco);
            lblPreco.setBounds(130, 25, 150, 20);

            //criando titulo do anuncio
            JLabel lblTitulo = new JLabel();
            lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblTitulo.setText(listaMeusProduto.get(i).getNome());
            anuncio.add(lblTitulo);
            lblTitulo.setBounds(120, 0, 170, 20);

            Date data = listaMeusProduto.get(i).getDt_anuncio();
            Locale local = new Locale("pt", "BR");
            DateFormat formato = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", local);
            String dataFormatada = formato.format(data);

            JLabel lblData = new JLabel();
            lblData.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            lblData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblData.setText(dataFormatada);
            anuncio.add(lblData);
            lblData.setBounds(120, 55, 170, 20);

            JLabel lblNumCompras = new JLabel();
            lblNumCompras.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
            lblNumCompras.setForeground(new java.awt.Color(255, 255, 255));
            lblNumCompras.setText("");
            anuncio.add(lblNumCompras);
            lblNumCompras.setBounds(224, 80, 23, 20);

            JLabel lblNumReservas = new JLabel();
            lblNumReservas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
            lblNumReservas.setForeground(new java.awt.Color(255, 255, 255));
            lblNumReservas.setText("");
            anuncio.add(lblNumReservas);
            lblNumReservas.setBounds(127, 80, 23, 20);

            JButton btn_compras = new JButton();
            btn_compras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ExibirAnuncio/compras.png"))); // NOI18N
            btn_compras.setBorderPainted(false);
            btn_compras.setContentAreaFilled(false);
            btn_compras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            btn_compras.setFocusPainted(false);
            btn_compras.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btn_comprasActionPerformed(evt);
                }
            });
            anuncio.add(btn_compras);
            btn_compras.setBounds(220, 75, 95, 30);

            JButton btn_reservas = new JButton();
            btn_reservas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ExibirAnuncio/Reservas.png"))); // NOI18N
            btn_reservas.setBorder(null);
            btn_reservas.setBorderPainted(false);
            btn_reservas.setContentAreaFilled(false);
            btn_reservas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            btn_reservas.setFocusPainted(false);
            btn_reservas.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btn_reservasActionPerformed(evt);
                }
            });
            anuncio.add(btn_reservas);
            btn_reservas.setBounds(123, 75, 95, 30);

            //adicionando o anuncio no painel 
            PainelMeusAnuncios.add(anuncio);

            if (((3 * j) + 1) == (i + 1)) {
                anuncio.setBounds(10, 10 + (140 * j), 318, 110);
            } else if (((3 * j) + 2) == (i + 1)) {
                anuncio.setBounds(335, 10 + (140 * j), 318, 110);
            } else if (((3 * j) + 3) == (i + 1)) {
                anuncio.setBounds(660, 10 + (140 * j), 318, 110);
                j++;
            }
        }
        PainelMeusAnuncios.setPreferredSize(new Dimension(940, 180 * j));
    }

    public void preencherMeusPedidos() throws Exception {
        //Criando List para armazenar todos os anuncios do Banco de Dados
        listaMeusPedidos = produtoBD.listarMeusProdutos(usuario, 1);

        int j = 0;

        for (int i = 0; i < listaMeusPedidos.size(); i++) {
            JPanel anuncio = new JPanel();

            anuncio.setName("" + i);
            anuncio.setBackground(new java.awt.Color(255, 255, 255));
            anuncio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
            anuncio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            anuncio.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    exibirAnuncio(evt, anuncio, listaMeusPedidos);
                }
            });
            anuncio.setLayout(null);

            //Criando label que ficará a imagem do anuncio
            JLabel lblImgAnuncio = new JLabel();
            ManipularImagem.exibiImagemLabel(listaMeusPedidos.get(i).getImg(), lblImgAnuncio);
            lblImgAnuncio.setBackground(new java.awt.Color(255, 255, 255));
            lblImgAnuncio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblImgAnuncio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
            anuncio.add(lblImgAnuncio);
            lblImgAnuncio.setBounds(0, 0, 120, 110);

            //Criando label do preço do anuncio 
            JLabel lblPreco = new JLabel();

            //Coversão de Double para formato de dinheiro real
            double preco = listaMeusPedidos.get(i).getPreco();
            Locale ptBr = new Locale("pt", "BR");
            String valorString = NumberFormat.getCurrencyInstance(ptBr).format(preco);

            lblPreco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            lblPreco.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            lblPreco.setText(valorString);
            anuncio.add(lblPreco);
            lblPreco.setBounds(130, 25, 150, 20);

            //criando titulo do anuncio
            JLabel lblTitulo = new JLabel();
            lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblTitulo.setText(listaMeusPedidos.get(i).getNome());
            anuncio.add(lblTitulo);
            lblTitulo.setBounds(120, 0, 170, 20);

            Date data = listaMeusPedidos.get(i).getDt_anuncio();
            Locale local = new Locale("pt", "BR");
            DateFormat formato = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", local);
            String dataFormatada = formato.format(data);

            JLabel lblData = new JLabel();
            lblData.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            lblData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblData.setText(dataFormatada);
            anuncio.add(lblData);
            lblData.setBounds(120, 55, 170, 20);

            JButton btn_cancelar = new JButton();
            btn_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ExibirAnuncio/Reservas.png"))); // NOI18N
            btn_cancelar.setBorder(null);
            btn_cancelar.setBorderPainted(false);
            btn_cancelar.setContentAreaFilled(false);
            btn_cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            btn_cancelar.setFocusPainted(false);
            btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btn_reservasActionPerformed(evt);
                }
            });
            anuncio.add(btn_cancelar);
            btn_cancelar.setBounds(123, 75, 95, 30);

            //adicionando o anuncio no painel 
            PainelMeusPedidos.add(anuncio);

            if (((3 * j) + 1) == (i + 1)) {
                anuncio.setBounds(10, 10 + (140 * j), 318, 110);
            } else if (((3 * j) + 2) == (i + 1)) {
                anuncio.setBounds(335, 10 + (140 * j), 318, 110);
            } else if (((3 * j) + 3) == (i + 1)) {
                anuncio.setBounds(660, 10 + (140 * j), 318, 110);
                j++;
            }
        }
        PainelMeusAnuncios.setPreferredSize(new Dimension(940, 180 * j));
    }

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
        btn_meuCadastro = new javax.swing.JButton();
        btn_desapegar = new javax.swing.JButton();
        btn_meusPedidos = new javax.swing.JButton();
        btn_meusAnuncios = new javax.swing.JButton();
        btn_sair = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();
        Fundo = new javax.swing.JLabel();
        Principal = new javax.swing.JPanel();
        Inicio_buscar = new javax.swing.JPanel();
        jtf_Buscar = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        bt_Lupa = new javax.swing.JButton();
        PainelAnuncios = new javax.swing.JPanel();
        background1 = new javax.swing.JLabel();
        Desapego = new javax.swing.JPanel();
        jl_valor1 = new javax.swing.JLabel();
        btn_cancelar = new javax.swing.JButton();
        btn_excluir = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        btn_novo = new javax.swing.JButton();
        btn_Alterar = new javax.swing.JButton();
        btn_inserirFoto = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jcb_Categoria = new javax.swing.JComboBox<>();
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
        jcb_estado = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        Jlbackground = new javax.swing.JLabel();
        MeusAnuncios = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        PainelMeusAnuncios = new javax.swing.JPanel();
        background = new javax.swing.JLabel();
        MeusPedidos = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel_Pesquisa1 = new javax.swing.JLabel();
        btn_venda1 = new javax.swing.JButton();
        btn_busca2 = new javax.swing.JButton();
        PainelMeusPedidos = new javax.swing.JPanel();
        background3 = new javax.swing.JLabel();
        ExibirAnuncio = new javax.swing.JPanel();
        lblEndereco1 = new javax.swing.JLabel();
        lblEndereco = new javax.swing.JLabel();
        lblTitulo_EA = new javax.swing.JLabel();
        jLabelFoto = new javax.swing.JLabel();
        lblPreco_EA = new javax.swing.JLabel();
        lblNovo_Usado = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        bt_comprar = new javax.swing.JButton();
        bt_reservar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jta_Descricao_EA = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1369, 730));
        setUndecorated(true);
        getContentPane().setLayout(null);

        bt_fechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Botao fechar.png"))); // NOI18N
        bt_fechar.setBorderPainted(false);
        bt_fechar.setContentAreaFilled(false);
        bt_fechar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_fechar.setFocusPainted(false);
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

        btn_meuCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/MenuLateral/MeuCadastro.png"))); // NOI18N
        btn_meuCadastro.setBorderPainted(false);
        btn_meuCadastro.setContentAreaFilled(false);
        btn_meuCadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_meuCadastro.setFocusPainted(false);
        btn_meuCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_meuCadastroActionPerformed(evt);
            }
        });
        getContentPane().add(btn_meuCadastro);
        btn_meuCadastro.setBounds(-7, 200, 310, 74);

        btn_desapegar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/MenuLateral/Desapegar.png"))); // NOI18N
        btn_desapegar.setBorderPainted(false);
        btn_desapegar.setContentAreaFilled(false);
        btn_desapegar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_desapegar.setFocusPainted(false);
        btn_desapegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_desapegarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_desapegar);
        btn_desapegar.setBounds(-7, 310, 310, 74);

        btn_meusPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/MenuLateral/MeusPedidos.png"))); // NOI18N
        btn_meusPedidos.setBorderPainted(false);
        btn_meusPedidos.setContentAreaFilled(false);
        btn_meusPedidos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_meusPedidos.setFocusPainted(false);
        btn_meusPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_meusPedidosActionPerformed(evt);
            }
        });
        getContentPane().add(btn_meusPedidos);
        btn_meusPedidos.setBounds(-7, 420, 310, 74);

        btn_meusAnuncios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/MenuLateral/MeusAnuncios.png"))); // NOI18N
        btn_meusAnuncios.setBorderPainted(false);
        btn_meusAnuncios.setContentAreaFilled(false);
        btn_meusAnuncios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_meusAnuncios.setFocusPainted(false);
        btn_meusAnuncios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_meusAnunciosActionPerformed(evt);
            }
        });
        getContentPane().add(btn_meusAnuncios);
        btn_meusAnuncios.setBounds(-7, 530, 310, 74);

        btn_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/MenuLateral/Sair.png"))); // NOI18N
        btn_sair.setBorderPainted(false);
        btn_sair.setContentAreaFilled(false);
        btn_sair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_sair.setFocusPainted(false);
        btn_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sairActionPerformed(evt);
            }
        });
        getContentPane().add(btn_sair);
        btn_sair.setBounds(-7, 640, 310, 70);

        btn_buscar.setBackground(new java.awt.Color(242, 242, 242));
        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/MenuLateral/Buscar.png"))); // NOI18N
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
        btn_buscar.setBounds(-2, 90, 300, 74);

        Fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Fundo menu.png"))); // NOI18N
        getContentPane().add(Fundo);
        Fundo.setBounds(0, 0, 350, 730);

        Principal.setLayout(new java.awt.CardLayout());

        Inicio_buscar.setLayout(null);

        jtf_Buscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtf_Buscar.setBorder(null);
        Inicio_buscar.add(jtf_Buscar);
        jtf_Buscar.setBounds(50, 30, 590, 30);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Buscar/CAMPO BUSCA.png"))); // NOI18N
        Inicio_buscar.add(jLabel10);
        jLabel10.setBounds(40, 20, 610, 50);

        bt_Lupa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Buscar/botao lupa.png"))); // NOI18N
        bt_Lupa.setBorderPainted(false);
        bt_Lupa.setContentAreaFilled(false);
        bt_Lupa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_LupaActionPerformed(evt);
            }
        });
        Inicio_buscar.add(bt_Lupa);
        bt_Lupa.setBounds(660, 20, 60, 43);

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

        jl_valor1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jl_valor1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jl_valor1.setText("R$");
        Desapego.add(jl_valor1);
        jl_valor1.setBounds(570, 447, 30, 20);
        jl_valor1.getAccessibleContext().setAccessibleName("");

        btn_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancel icon.png"))); // NOI18N
        btn_cancelar.setToolTipText("Cancelar");
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
        btn_cancelar.setBounds(630, 580, 70, 70);

        btn_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Excluir.png"))); // NOI18N
        btn_excluir.setToolTipText("Excluir");
        btn_excluir.setBorderPainted(false);
        btn_excluir.setContentAreaFilled(false);
        btn_excluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_excluir.setFocusPainted(false);
        btn_excluir.setFocusable(false);
        btn_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluirActionPerformed(evt);
            }
        });
        Desapego.add(btn_excluir);
        btn_excluir.setBounds(550, 580, 70, 70);

        btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Save icon.png"))); // NOI18N
        btn_save.setToolTipText("Salvar");
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
        btn_save.setBounds(470, 580, 70, 70);

        btn_novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ExibirAnuncio/Novo produto.png"))); // NOI18N
        btn_novo.setToolTipText("Novo");
        btn_novo.setBorderPainted(false);
        btn_novo.setContentAreaFilled(false);
        btn_novo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_novo.setFocusPainted(false);
        btn_novo.setFocusable(false);
        btn_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_novoActionPerformed(evt);
            }
        });
        Desapego.add(btn_novo);
        btn_novo.setBounds(310, 580, 70, 70);

        btn_Alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Edit icon.png"))); // NOI18N
        btn_Alterar.setToolTipText("Alterar");
        btn_Alterar.setBorderPainted(false);
        btn_Alterar.setContentAreaFilled(false);
        btn_Alterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Alterar.setFocusPainted(false);
        btn_Alterar.setFocusable(false);
        btn_Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AlterarActionPerformed(evt);
            }
        });
        Desapego.add(btn_Alterar);
        btn_Alterar.setBounds(390, 580, 70, 70);

        btn_inserirFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Inserir foto icon.png"))); // NOI18N
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
        btn_inserirFoto.setBounds(180, 480, 110, 40);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Categoria:");
        Desapego.add(jLabel1);
        jLabel1.setBounds(560, 480, 70, 17);

        jcb_Categoria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcb_Categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Automóvel", "Eletrônicos", "Imóvel", "Pet", "Vestimentas" }));
        jcb_Categoria.setNextFocusableComponent(btn_inserirFoto);
        Desapego.add(jcb_Categoria);
        jcb_Categoria.setBounds(560, 500, 210, 20);

        jLabel_Desapego.setFont(new java.awt.Font("Tahoma", 0, 50)); // NOI18N
        jLabel_Desapego.setForeground(new java.awt.Color(247, 130, 50));
        jLabel_Desapego.setText("Desapego");
        Desapego.add(jLabel_Desapego);
        jLabel_Desapego.setBounds(420, 10, 230, 70);

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
        jtf_titulo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtf_titulo.setBorder(null);
        jtf_titulo.setNextFocusableComponent(jta_descricao);
        Desapego.add(jtf_titulo);
        jtf_titulo.setBounds(568, 142, 360, 30);

        CampoTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Campo Titulo.png"))); // NOI18N
        Desapego.add(CampoTitulo);
        CampoTitulo.setBounds(560, 140, 380, 34);

        jtf_preco.setBackground(new java.awt.Color(242, 242, 242));
        jtf_preco.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtf_preco.setBorder(null);
        Desapego.add(jtf_preco);
        jtf_preco.setBounds(605, 442, 140, 30);

        CampoPreco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Valor campo.png"))); // NOI18N
        Desapego.add(CampoPreco);
        CampoPreco.setBounds(560, 440, 200, 34);

        groupEstadoProd.add(jrb_Novo);
        jrb_Novo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jrb_Novo.setText("Novo");
        jrb_Novo.setContentAreaFilled(false);
        Desapego.add(jrb_Novo);
        jrb_Novo.setBounds(800, 460, 59, 25);

        groupEstadoProd.add(jrb_Usado);
        jrb_Usado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jrb_Usado.setText("Usado");
        jrb_Usado.setContentAreaFilled(false);
        Desapego.add(jrb_Usado);
        jrb_Usado.setBounds(870, 460, 80, 25);

        jta_descricao.setBackground(new java.awt.Color(242, 242, 242));
        jta_descricao.setColumns(20);
        jta_descricao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
        btn_editMC.setBorder(null);
        btn_editMC.setBorderPainted(false);
        btn_editMC.setContentAreaFilled(false);
        btn_editMC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_editMC.setFocusPainted(false);
        MeuCadastro.add(btn_editMC);
        btn_editMC.setBounds(360, 550, 70, 65);

        btn_SalvarMC.setBackground(new java.awt.Color(242, 242, 242));
        btn_SalvarMC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Save icon.png"))); // NOI18N
        btn_SalvarMC.setBorder(null);
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
        jtf_CancelarMC.setBorder(null);
        jtf_CancelarMC.setBorderPainted(false);
        jtf_CancelarMC.setContentAreaFilled(false);
        jtf_CancelarMC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtf_CancelarMC.setFocusPainted(false);
        MeuCadastro.add(jtf_CancelarMC);
        jtf_CancelarMC.setBounds(520, 550, 70, 70);

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

        jcb_estado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcb_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        jcb_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_estadoActionPerformed(evt);
            }
        });
        MeuCadastro.add(jcb_estado);
        jcb_estado.setBounds(170, 350, 50, 23);

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

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 50)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(250, 130, 50));
        jLabel6.setText("Meus Anuncios");
        MeusAnuncios.add(jLabel6);
        jLabel6.setBounds(330, 30, 400, 61);

        PainelMeusAnuncios.setBackground(new java.awt.Color(223, 223, 223));
        PainelMeusAnuncios.setPreferredSize(new java.awt.Dimension(940, 1000));
        PainelMeusAnuncios.setLayout(null);
        MeusAnuncios.add(PainelMeusAnuncios);
        PainelMeusAnuncios.setBounds(20, 100, 990, 560);

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

        btn_venda1.setBorderPainted(false);
        btn_venda1.setContentAreaFilled(false);
        btn_venda1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_venda1ActionPerformed(evt);
            }
        });
        MeusPedidos.add(btn_venda1);
        btn_venda1.setBounds(350, 280, 79, 30);

        btn_busca2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Buscar/botao lupa.png"))); // NOI18N
        btn_busca2.setBorderPainted(false);
        btn_busca2.setContentAreaFilled(false);
        MeusPedidos.add(btn_busca2);
        btn_busca2.setBounds(510, 107, 50, 40);

        PainelMeusPedidos.setBackground(new java.awt.Color(223, 223, 223));
        PainelMeusPedidos.setPreferredSize(new java.awt.Dimension(940, 1000));
        PainelMeusPedidos.setLayout(null);
        MeusPedidos.add(PainelMeusPedidos);
        PainelMeusPedidos.setBounds(20, 160, 990, 500);

        background3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Íco-Imovel copiar 6.png"))); // NOI18N
        MeusPedidos.add(background3);
        background3.setBounds(0, -50, 1040, 726);

        Principal.add(MeusPedidos, "MeusPedidos");

        ExibirAnuncio.setBackground(new java.awt.Color(223, 223, 223));
        ExibirAnuncio.setLayout(null);

        lblEndereco1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblEndereco1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ExibirAnuncio/icons8-marcador-filled-50 (1).png"))); // NOI18N
        ExibirAnuncio.add(lblEndereco1);
        lblEndereco1.setBounds(40, 495, 30, 50);

        lblEndereco.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblEndereco.setText("Endereço do anunciante");
        ExibirAnuncio.add(lblEndereco);
        lblEndereco.setBounds(80, 510, 550, 30);

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

        lblNovo_Usado.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblNovo_Usado.setForeground(new java.awt.Color(132, 211, 61));
        lblNovo_Usado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNovo_Usado.setText("Novo/Usado");
        ExibirAnuncio.add(lblNovo_Usado);
        lblNovo_Usado.setBounds(880, 500, 110, 25);

        lblData.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblData.setText("Exibir a data dessa forma(18 de Novembro de 2017 )");
        ExibirAnuncio.add(lblData);
        lblData.setBounds(50, 459, 410, 30);

        bt_comprar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ExibirAnuncio/botao Comprar.png"))); // NOI18N
        bt_comprar.setBorderPainted(false);
        bt_comprar.setContentAreaFilled(false);
        bt_comprar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_comprar.setFocusPainted(false);
        bt_comprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_comprarActionPerformed(evt);
            }
        });
        ExibirAnuncio.add(bt_comprar);
        bt_comprar.setBounds(290, 600, 230, 46);

        bt_reservar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ExibirAnuncio/botao reservar.png"))); // NOI18N
        bt_reservar.setBorderPainted(false);
        bt_reservar.setContentAreaFilled(false);
        bt_reservar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_reservar.setFocusPainted(false);
        bt_reservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_reservarActionPerformed(evt);
            }
        });
        ExibirAnuncio.add(bt_reservar);
        bt_reservar.setBounds(570, 600, 230, 46);

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

    private void btn_meuCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_meuCadastroActionPerformed
        if (!btn_meuCadastro.isSelected()) {
            btn_buscar.setIcon(Buscar2);
            btn_meuCadastro.setIcon(MeuCadastroSelected);
            btn_desapegar.setIcon(Desapegar2);
            btn_meusPedidos.setIcon(MeusPedidos2);
            btn_meusAnuncios.setIcon(MeusAnuncios2);
            btn_sair.setIcon(Sair2);
        }
        carregarDadosUser();
        ManipularInterfaceCad("MeuCadastro");

        CardLayout card = (CardLayout) Principal.getLayout();
        card.show(Principal, "MeuCadastro");
    }//GEN-LAST:event_btn_meuCadastroActionPerformed

    private void bt_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_fecharActionPerformed
        System.exit(0);
    }//GEN-LAST:event_bt_fecharActionPerformed

    private void jtf_NomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_NomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_NomeActionPerformed

    private void btn_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sairActionPerformed
        if (!btn_sair.isSelected()) {
            btn_buscar.setIcon(Buscar2);
            btn_meuCadastro.setIcon(MeuCadastro2);
            btn_desapegar.setIcon(Desapegar2);
            btn_meusPedidos.setIcon(MeusPedidos2);
            btn_meusAnuncios.setIcon(MeusAnuncios2);
            btn_sair.setIcon(SairSelected);

        }

        Login login = new Login();
        login.setVisible(true);
        dispose();

    }//GEN-LAST:event_btn_sairActionPerformed

    private void btn_desapegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_desapegarActionPerformed
        if (!btn_desapegar.isSelected()) {
            btn_buscar.setIcon(Buscar2);
            btn_meuCadastro.setIcon(MeuCadastro2);
            btn_desapegar.setIcon(DesapegarSelected);
            btn_meusPedidos.setIcon(MeusPedidos2);
            btn_meusAnuncios.setIcon(MeusAnuncios2);
            btn_sair.setIcon(Sair2);
        }
        limparCamposDesapegar();
        manipularInterfaceDesapegar(1);
        CardLayout card = (CardLayout) Principal.getLayout();
        card.show(Principal, "Desapegar");
    }//GEN-LAST:event_btn_desapegarActionPerformed

    private void btn_meusAnunciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_meusAnunciosActionPerformed
        if (!btn_meusAnuncios.isSelected()) {
            btn_buscar.setIcon(Buscar2);
            btn_meuCadastro.setIcon(MeuCadastro2);
            btn_desapegar.setIcon(Desapegar2);
            btn_meusPedidos.setIcon(MeusPedidos2);
            btn_meusAnuncios.setIcon(MeusAnunciosSelected);
            btn_sair.setIcon(Sair2);

        }

        CardLayout card = (CardLayout) Principal.getLayout();
        card.show(Principal, "MeusAnuncios");
    }//GEN-LAST:event_btn_meusAnunciosActionPerformed

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
            btn_meuCadastro.setIcon(MeuCadastro2);
            btn_desapegar.setIcon(Desapegar2);
            btn_meusPedidos.setIcon(MeusPedidos2);
            btn_meusAnuncios.setIcon(MeusAnuncios2);
            btn_sair.setIcon(Sair2);

        }

        try {
            PainelAnuncios.removeAll();
            PainelAnuncios.repaint();
            preencherMenuAnuncios(1);
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        CardLayout card = (CardLayout) Principal.getLayout();
        card.show(Principal, "Inicio");
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_meusPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_meusPedidosActionPerformed
        if (!btn_meusPedidos.isSelected()) {
            btn_buscar.setIcon(Buscar2);
            btn_meuCadastro.setIcon(MeuCadastro2);
            btn_desapegar.setIcon(Desapegar2);
            btn_meusPedidos.setIcon(MeusPedidosSelected);
            btn_meusAnuncios.setIcon(MeusAnuncios2);
            btn_sair.setIcon(Sair2);
        }

        try {
            preencherMeusPedidos();
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

        CardLayout card = (CardLayout) Principal.getLayout();
        card.show(Principal, "MeusPedidos");
    }//GEN-LAST:event_btn_meusPedidosActionPerformed

    private void bt_comprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_comprarActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente COMPRAR esse Produto? ", "**Comprar Produto**", JOptionPane.YES_NO_OPTION);
        if (resposta == 0) {
            try {
                Acao compra = new Acao();
                AcaoBD acaobd = new AcaoBD();

                compra.setId_produto(listaProduto.get(indexAnuncio).getId_produto());
                compra.setId_usuario(usuario.getId_usuario());
                compra.setTipo("Compra");
                compra.setStatus("Aguardando resposta anunciante");
                acaobd.inserir(compra);
                JOptionPane.showMessageDialog(null, "Solicitação de compra enviada ao Anunciante!\nAguarde ele aceitar.");
            } catch (Exception ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_bt_comprarActionPerformed
    
    private void btn_SalvarMCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SalvarMCActionPerformed
        usuario.setBairro(jtf_Bairro.getText());
        usuario.setCidade(jtf_Cidade.getText());
        usuario.setNome(jtf_Nome.getText());
        usuario.setEmail(jtf_Email.getText());
        usuario.setTelefone(jtfTelefone.getText());
        usuario.setUF(jcb_estado.getSelectedItem().toString());
        usuario.setUsuario(jtf_Usuario.getText());
        usuario.setSenha(jtf_Senha.getText());
        usuario.getId_usuario();

        try {
            usuarioBD.alterar(usuario);
            JOptionPane.showMessageDialog(null, "Cadastro atualizado com Sucesso");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao alterar Usuário.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        ManipularInterfaceCad("Salvar");
        ManipularInterfaceCad("MeuCadastro");
    }//GEN-LAST:event_btn_SalvarMCActionPerformed

    private void jcb_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_estadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_estadoActionPerformed

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
            manipularInterfaceDesapegar(1);
            limparCamposDesapegar();
        }
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluirActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir esse anuncio?", "***Excluir Anuncio***", JOptionPane.YES_NO_OPTION);

        if (resposta == 0) {
            try {
                produtoBD.excluir(listaProduto.get(indexAnuncio));
                limparCamposDesapegar();
                JOptionPane.showMessageDialog(null, "Anuncio Excluido com sucesso!!");
            } catch (Exception ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_excluirActionPerformed

    private void btn_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_novoActionPerformed
        limparCamposDesapegar();
        manipularInterfaceDesapegar(2);
    }//GEN-LAST:event_btn_novoActionPerformed

    private void btn_AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AlterarActionPerformed
        manipularInterfaceDesapegar(2);
    }//GEN-LAST:event_btn_AlterarActionPerformed

    private void bt_LupaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_LupaActionPerformed
        try {
            PainelAnuncios.removeAll();
            PainelAnuncios.repaint();
            preencherMenuAnuncios(2);
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bt_LupaActionPerformed

    private void bt_reservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_reservarActionPerformed
        try {
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente RESERVAR esse Produto? ", "**Reservar Produto**", JOptionPane.YES_NO_OPTION);

            if (resposta == 0) {
                Acao reserva = new Acao();
                AcaoBD acaoBD = new AcaoBD();

                reserva.setId_produto(produto.getId_produto());
                reserva.setId_usuario(produto.getId_usuario());
                reserva.setTipo("Reserva");
                reserva.setStatus("Aguardando resposta anunciante");
                acaoBD.inserir(reserva);
                JOptionPane.showMessageDialog(null, "Reserva solicitada com sucesso!! \nAguarde anuncioante aceitar");
            }
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bt_reservarActionPerformed

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
            produto = new  Produto();
            produto.setNome(jtf_titulo.getText());
            produto.setDescricao(jta_descricao.getText());
            produto.setPreco(Double.parseDouble(jtf_preco.getText()));
            produto.setEstadoConserv(estadoProd);
            produto.setImg(ManipularImagem.getImgBytes(imagemBuffer));
            produto.setCategoria(jcb_Categoria.getSelectedItem().toString());
            produto.setStatus("Disponivel");
            produto.setId_usuario(usuario.getId_usuario());

            if (produto.getId_produto() == 0) {
                try {
                    //inserindo no banco de dados
                    produtoBD.inserir(produto);
                    JOptionPane.showMessageDialog(null, "Anuncio realizado com sucesso!");
                    limparCamposDesapegar();
                    manipularInterfaceDesapegar(1);
                } catch (Exception ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    produtoBD.alterar(produto);
                    JOptionPane.showMessageDialog(null, "Anuncio alterado com sucesso!");
                } catch (Exception ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    public void carregarDadosUser() {
        jtf_Nome.setText(usuario.getNome());
        jtf_Bairro.setText(usuario.getBairro());
        jtf_Cidade.setText(usuario.getCidade());
        jtf_Email.setText(usuario.getEmail());
        jtfTelefone.setText(usuario.getTelefone());
        jcb_estado.setSelectedItem(usuario.getUF());
        jtf_Usuario.setText(usuario.getUsuario());
        jtf_Senha.setText(usuario.getSenha());
        nomeUser.setText(usuario.getNome());
    }

    public void carregarDadosAnuncio(Produto produto) {
        jtf_titulo.setText(produto.getNome());
        jta_descricao.setText(produto.getDescricao());
        jtf_preco.setText(String.valueOf(produto.getPreco()));

        String estadoConserv = produto.getEstadoConserv();
        if (estadoConserv.equals("Novo")) {
            jrb_Novo.setSelected(true);
        }
        if (estadoConserv.equals("Usado")) {
            jrb_Usado.setSelected(true);
        }
        jcb_Categoria.setSelectedItem(produto.getCategoria());
        ManipularImagem.exibiImagemLabel(produto.getImg(), lblImagemProd);

    }

    private void exibirMeuAnuncio(java.awt.event.MouseEvent evt, javax.swing.JPanel panel) {
        indexMeuAnuncio = Integer.parseInt(panel.getName());
        produto = listaMeusProduto.get(indexMeuAnuncio);
        carregarDadosAnuncio(produto);
        manipularInterfaceDesapegar(3);
        CardLayout card = (CardLayout) Principal.getLayout();
        card.show(Principal, "Desapegar");
    }

    private void exibirAnuncio(java.awt.event.MouseEvent evt, javax.swing.JPanel panel, List<Produto> lista) {
        indexAnuncio = Integer.parseInt(panel.getName());
        produto = lista.get(indexAnuncio);

        if (produto.getId_usuario() == usuario.getId_usuario()) {
            carregarDadosAnuncio(produto);
            manipularInterfaceDesapegar(3);
            CardLayout card = (CardLayout) Principal.getLayout();
            card.show(Principal, "Desapegar");
        } else {
            //Formatando a data para exibir o mês por extenso
            Date data = new Date();
            Locale local = new Locale("pt", "BR");
            DateFormat formato = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", local);
            String dataFormatada = formato.format(data);

            double preco = produto.getPreco();
            Locale ptBr = new Locale("pt", "BR");
            String valorString = NumberFormat.getCurrencyInstance(ptBr).format(preco);
            lblData.setText(dataFormatada);

            ManipularImagem.exibiImagemLabel(produto.getImg(), jLabelFoto);
            lblTitulo_EA.setText(produto.getNome());
            lblPreco_EA.setText(valorString);
            jta_Descricao_EA.setText(produto.getDescricao());
            lblNovo_Usado.setText(produto.getEstadoConserv());
            lblEndereco.setText(produto.getBairro() + ", "
                    + produto.getCidade() + " - " + produto.getUF());

            CardLayout card = (CardLayout) Principal.getLayout();
            card.show(Principal, "ExibirAnuncio");
        }
    }

    public void limparCamposDesapegar() {
        jtf_titulo.setText("");
        jtf_preco.setText("");
        jta_descricao.setText("");
        lblImagemProd.setIcon(null);
        groupEstadoProd.clearSelection();
        jcb_Categoria.setSelectedIndex(0);
        listaProduto.clear();
        imagemBuffer = null;
        produto = null;
    }

    public void manipularInterfaceDesapegar(int opcao) {
        switch (opcao) {
            case 1:
                jtf_titulo.setEnabled(false);
                jtf_preco.setEnabled(false);
                jta_descricao.setEnabled(false);
                jrb_Novo.setEnabled(false);
                jrb_Usado.setEnabled(false);
                jcb_Categoria.setEnabled(false);

                btn_save.setEnabled(false);
                btn_cancelar.setEnabled(false);
                btn_Alterar.setEnabled(false);
                btn_excluir.setEnabled(false);
                btn_novo.setEnabled(true);
                btn_inserirFoto.setEnabled(false);
                break;

            case 2:
                jtf_titulo.setEnabled(true);
                jtf_preco.setEnabled(true);
                jta_descricao.setEnabled(true);
                jrb_Novo.setEnabled(true);
                jrb_Usado.setEnabled(true);
                jcb_Categoria.setEnabled(true);

                btn_save.setEnabled(true);
                btn_cancelar.setEnabled(true);
                btn_Alterar.setEnabled(false);
                btn_excluir.setEnabled(false);
                btn_novo.setEnabled(false);
                btn_inserirFoto.setEnabled(true);
                break;

            case 3:
                jtf_titulo.setEnabled(false);
                jtf_preco.setEnabled(false);
                jta_descricao.setEnabled(false);
                jrb_Novo.setEnabled(false);
                jrb_Usado.setEnabled(false);
                jcb_Categoria.setEnabled(false);

                btn_save.setEnabled(false);
                btn_cancelar.setEnabled(false);
                btn_Alterar.setEnabled(true);
                btn_excluir.setEnabled(true);
                btn_novo.setEnabled(true);
                btn_inserirFoto.setEnabled(false);
                break;
        }
    }

    private void habilitarFormularioUser(boolean modo) {
        jtf_Nome.setEnabled(modo);
        jtf_Bairro.setEnabled(modo);
        jtf_Cidade.setEnabled(modo);
        jtf_Email.setEnabled(modo);
        jtfTelefone.setEnabled(modo);
        jcb_estado.setEnabled(modo);
        jtf_Usuario.setEnabled(modo);
        jtf_Senha.setEnabled(modo);
    }

    private void ManipularInterfaceCad(String modo) {
        switch (modo) {
            case "MeuCadastro":
                btn_editMC.setEnabled(true);
                btn_SalvarMC.setEnabled(false);
                jtf_CancelarMC.setEnabled(false);
                habilitarFormularioUser(false);
                break;

            case "Salvar":
                btn_editMC.setEnabled(false);
                btn_SalvarMC.setEnabled(true);
                jtf_CancelarMC.setEnabled(true);
                habilitarFormularioUser(true);
                break;

        }
    }
    
    
     private void btn_reservasActionPerformed(java.awt.event.ActionEvent evt) {                                             
        Reservas reservas = new Reservas();
        reservas.setVisible(true);
    }                                            

    private void btn_comprasActionPerformed(java.awt.event.ActionEvent evt) {                                            
        Vendas vendas = new Vendas(usuario);
        vendas.setVisible(true);
    }    
    
    // <editor-fold defaultstate="collapsed" desc="Elementos">                          
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
    private javax.swing.JPanel PainelMeusAnuncios;
    private javax.swing.JPanel PainelMeusPedidos;
    private javax.swing.JPanel Principal;
    private javax.swing.JLabel background;
    private javax.swing.JLabel background1;
    private javax.swing.JLabel background3;
    private javax.swing.JButton bt_Lupa;
    private javax.swing.JButton bt_comprar;
    private javax.swing.JButton bt_fechar;
    private javax.swing.JButton bt_reservar;
    private javax.swing.JButton btn_Alterar;
    private javax.swing.JButton btn_SalvarMC;
    private javax.swing.JButton btn_busca2;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_desapegar;
    private javax.swing.JButton btn_editMC;
    private javax.swing.JButton btn_excluir;
    private javax.swing.JButton btn_inserirFoto;
    private javax.swing.JButton btn_meuCadastro;
    private javax.swing.JButton btn_meusAnuncios;
    private javax.swing.JButton btn_meusPedidos;
    private javax.swing.JButton btn_novo;
    private javax.swing.JButton btn_sair;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_venda1;
    private javax.swing.ButtonGroup groupEstadoProd;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelBairro;
    private javax.swing.JLabel jLabelCidade;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelEstado;
    private javax.swing.JLabel jLabelFoto;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelNomeCompleto;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JLabel jLabelTelefone;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JLabel jLabel_Desapego;
    private javax.swing.JLabel jLabel_Pesquisa1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JComboBox<String> jcb_Categoria;
    private javax.swing.JComboBox<String> jcb_estado;
    private javax.swing.JLabel jl_MeuCadastro;
    private javax.swing.JLabel jl_condicaoProduto;
    private javax.swing.JLabel jl_valor;
    private javax.swing.JLabel jl_valor1;
    private javax.swing.JRadioButton jrb_Novo;
    private javax.swing.JRadioButton jrb_Usado;
    private javax.swing.JTextArea jta_Descricao_EA;
    private javax.swing.JTextArea jta_descricao;
    private javax.swing.JFormattedTextField jtfTelefone;
    private javax.swing.JTextField jtf_Bairro;
    private javax.swing.JTextField jtf_Buscar;
    private javax.swing.JButton jtf_CancelarMC;
    private javax.swing.JTextField jtf_Cidade;
    private javax.swing.JTextField jtf_Email;
    private javax.swing.JTextField jtf_Nome;
    private javax.swing.JPasswordField jtf_Senha;
    private javax.swing.JTextField jtf_Usuario;
    private javax.swing.JTextField jtf_preco;
    private javax.swing.JTextField jtf_titulo;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblEndereco1;
    private javax.swing.JLabel lblImagemProd;
    private javax.swing.JLabel lblNovo_Usado;
    private javax.swing.JLabel lblPreco_EA;
    private javax.swing.JLabel lblTitulo_EA;
    private javax.swing.JLabel nomeUser;
    // End of variables declaration//GEN-END:variables
}// </editor-fold>                        
