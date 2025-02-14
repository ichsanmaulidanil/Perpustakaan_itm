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
import kelas.Kategori;
import popUp.PopUp_Kategori;
import static popUp.PopUp_Kategori.Lb_kat;
import static popUp.PopUp_Kategori.cKat;

/**
 *
 * @author WINDOWS 10
 */
public class menuKategori extends javax.swing.JPanel {

    /**
     * Creates new form Dashboard
     */
    public menuKategori() {
        initComponents();
        loadTable();
    }
    
    void loadTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id kategori");
        model.addColumn("nama kategori");
       
        
        try {
            Kategori kt = new Kategori();
            ResultSet data = kt.tampilKategori();
                       while (data.next()) {
                model.addRow(new Object[]{
                    data.getInt("id_kategori"),
                    data.getString("nama_kategori"),});
                    
                       }


        } catch (SQLException sQLException) {
        }
        tKategori.setModel(model);
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
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tKategori = new javax.swing.JTable();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu/add.png"))); // NOI18N
        jButton1.setText("TAMBAH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tKategori.setModel(new javax.swing.table.DefaultTableModel(
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
        tKategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tKategoriMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tKategori);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1030, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(271, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jButton1)
                .addGap(53, 53, 53)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(6076, Short.MAX_VALUE))
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            PopUp_Kategori pp = new PopUp_Kategori();
            pp.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Kategori.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tKategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tKategoriMouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            int baris = tKategori.rowAtPoint(evt.getPoint());
            String id_kategori = tKategori.getValueAt(baris, 0).toString();
            String nama = tKategori.getValueAt(baris, 1).toString();
        
           
            PopUp_Kategori kategori = new PopUp_Kategori();
            
            Lb_kat.setText(id_kategori);
            
            cKat.setSelectedItem(kategori);
            
            
            kategori.setVisible(true);
            
        } catch (SQLException ex) {
            Logger.getLogger(menuKategori.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tKategoriMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tKategori;
    // End of variables declaration//GEN-END:variables
}
