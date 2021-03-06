/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Classes.Acao;
import Classes.Produto;
import ConexaoBD.AcaoBD;
import TableModel.TableModel;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thais
 */
public class Venda extends javax.swing.JFrame {
    
    TableModel tmVenda = new TableModel();
    Produto produto = new Produto();
    AcaoBD acao = new AcaoBD();
    
    /**
     * Creates new form Venda
     */
    public Venda(Produto prod) {
        this.produto = prod;
        initComponents();
        this.setLocationRelativeTo(null);
        
        jtVenda.setModel(tmVenda);
        carregarTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnVender = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtVenda = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnFechar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(560, 456));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        btnVender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Vender.png"))); // NOI18N
        btnVender.setBorder(null);
        btnVender.setBorderPainted(false);
        btnVender.setContentAreaFilled(false);
        btnVender.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVender.setFocusPainted(false);
        jPanel1.add(btnVender);
        btnVender.setBounds(450, 360, 70, 30);

        jtVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtVenda);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(40, 70, 480, 260);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 50)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(247, 130, 50));
        jLabel2.setText("Vendas");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(190, 10, 200, 50);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 50, 560, 410);

        btnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Botao fechar.png"))); // NOI18N
        btnFechar.setBorder(null);
        btnFechar.setBorderPainted(false);
        btnFechar.setContentAreaFilled(false);
        btnFechar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFechar.setFocusPainted(false);
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });
        getContentPane().add(btnFechar);
        btnFechar.setBounds(510, 6, 40, 40);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Tela superior.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 560, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    public void carregarTable (){
        try {
            //tmVenda.setDados(acao.listarMeusPedidos(produto, "Compra"));
        } catch (Exception ex) {
            Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnVender;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtVenda;
    // End of variables declaration//GEN-END:variables
}
