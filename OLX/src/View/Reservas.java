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
 * @author Augusto Kalel
 */
public class Reservas extends javax.swing.JFrame {

    AcaoBD acaoBD = new AcaoBD();
    Produto prod = new Produto();
    TableModel tmReservas = new TableModel();    
    /**
     * Creates new form Reservas
     */
    public Reservas(Produto produto) {
        this.prod = produto;
        
        initComponents();
        jtReservas.setModel(tmReservas);
        carregarTable();
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

        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtReservas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(560, 456));
        setMinimumSize(new java.awt.Dimension(560, 456));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(560, 456));
        setResizable(false);
        getContentPane().setLayout(null);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Botao fechar.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setFocusPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(515, 5, 40, 40);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Tela superior.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 560, 50);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 50)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(247, 130, 50));
        jLabel2.setText("Reservas");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(195, 60, 200, 50);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/CancelarReserva.png"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setFocusPainted(false);
        getContentPane().add(jButton4);
        jButton4.setBounds(370, 410, 140, 30);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Reservar icon.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        getContentPane().add(jButton1);
        jButton1.setBounds(90, 410, 79, 30);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Não reservar icon.png"))); // NOI18N
        jButton2.setToolTipText("");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusPainted(false);
        getContentPane().add(jButton2);
        jButton2.setBounds(220, 410, 110, 30);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jtReservas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jtReservas);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(54, 75, 452, 240);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 50, 560, 410);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void carregarTable(){
        try {
//            tmReservas.setDados(acaoBD.listar(prod, "Reserva"));
        } catch (Exception ex) {
            Logger.getLogger(Reservas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtReservas;
    // End of variables declaration//GEN-END:variables
}
