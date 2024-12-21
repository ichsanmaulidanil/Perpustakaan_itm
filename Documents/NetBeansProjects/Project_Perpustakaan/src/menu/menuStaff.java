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
import kelas.Staff;
import popUp.PopUp_Staff;
import static popUp.PopUp_Staff.Lb_staf;
import static popUp.PopUp_Staff.tAlamat;
import static popUp.PopUp_Staff.tEmail;
import static popUp.PopUp_Staff.tNama;
import static popUp.PopUp_Staff.tNimNidn;
import static popUp.PopUp_Staff.tNoHp;

/**
 *
 * @author WINDOWS 10
 */
public class menuStaff extends javax.swing.JPanel {

    private String nim_nidn;

    /**
     * Creates new form Dashboard
     */
    public menuStaff() {
        initComponents();
        loadTable();
    }
    
    void loadTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id staf");
        model.addColumn("nama");
        model.addColumn("alamat");
        model.addColumn("nohp");
        model.addColumn("email");
        model.addColumn("nim_nidn");
        
        try {
            Staff st = new Staff();
            ResultSet data = st.tampilStaf();
                       while (data.next()) {
                model.addRow(new Object[]{
                    data.getInt("id_staf"),
                    data.getString("nama"),
                    data.getString("alamat"),
                    data.getString("nohp"),
                    data.getString("email"),
                    data.getString("nim_nidn"),});
                    
                       }


        } catch (SQLException sQLException) {
        }
        tStaff.setModel(model);
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
        tStaff = new javax.swing.JTable();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu/add.png"))); // NOI18N
        jButton1.setText("TAMBAH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tStaff.setModel(new javax.swing.table.DefaultTableModel(
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
        tStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tStaffMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tStaff);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1029, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(272, Short.MAX_VALUE))
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
            PopUp_Staff pp = new PopUp_Staff();
            pp.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(menuStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tStaffMouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            int baris = tStaff.rowAtPoint(evt.getPoint());
            String id_staff = tStaff.getValueAt(baris, 0).toString();
            String nama = tStaff.getValueAt(baris, 1).toString();
            String alamat = tStaff.getValueAt(baris, 2).toString();
            String nohp = tStaff.getValueAt(baris, 3).toString();
            String email = tStaff.getValueAt(baris, 4).toString();
           
            PopUp_Staff anggota = new PopUp_Staff();
            
            Lb_staf.setText(id_staff);
            // Konversi tanggal dari format "dd MMMM yyyy" ke "java.util.Date"
           
            tNama.setText(nama);
            tAlamat.setText(alamat);
            tNoHp.setText(nohp);
            tEmail.setText(email);
            tNimNidn.setText(nim_nidn);
//
            
            anggota.setVisible(true);
            
        } catch (SQLException ex) {
            Logger.getLogger(menuPeminjaman.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tStaffMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tStaff;
    // End of variables declaration//GEN-END:variables
}
