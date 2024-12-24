/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package menu;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import kelas.Lemari;
import popUp.PopUp_Lemari;
import static popUp.PopUp_Lemari.Lb_lem;
import static popUp.PopUp_Lemari.tRak;

/**
 *
 * @author FADHILA
 */
public class menuLemari extends javax.swing.JPanel {

    /**
     * Creates new form Dashboard
     */
    public menuLemari() {
        initComponents();
        loadTable();
    }
    
    void loadTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id lemari");
        model.addColumn("lemari");
        model.addColumn("rak");
        
        try {
            Lemari lm = new Lemari();
            ResultSet data = lm.tampilLemari();
                       while (data.next()) {
                model.addRow(new Object[]{
                    data.getInt("id_lemari"),
                    data.getString("lemari"),
                    data.getString("rak"),});
                    
                       }


        } catch (SQLException sQLException) {
        }
        tLemari.setModel(model);
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
        bTambah = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tLemari = new javax.swing.JTable();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        bTambah.setText("TAMBAH");
        bTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTambahActionPerformed(evt);
            }
        });

        tLemari.setModel(new javax.swing.table.DefaultTableModel(
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
        tLemari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tLemariMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tLemari);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bTambah)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1030, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(271, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(bTambah)
                .addGap(53, 53, 53)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(6076, Short.MAX_VALUE))
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void bTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTambahActionPerformed
        try {
            // TODO add your handling code here:
            PopUp_Lemari pp = new PopUp_Lemari();
            pp.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(menuLemari.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bTambahActionPerformed

    private void tLemariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tLemariMouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            int baris = tLemari.rowAtPoint(evt.getPoint());
            String id_lemari = tLemari.getValueAt(baris, 0).toString();
            String lemari = tLemari.getValueAt(baris, 1).toString();
            String rak = tLemari.getValueAt(baris, 2).toString();
           
            PopUp_Lemari Lemari = new PopUp_Lemari();
            
            Lb_lem.setText(id_lemari);
            
            tLemari.setToolTipText(lemari);
            tRak.setText(rak);

            
             Lemari.setVisible(true);
            
        } catch (SQLException ex) {
            Logger.getLogger(menuLemari.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tLemariMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bTambah;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tLemari;
    // End of variables declaration//GEN-END:variables
}
