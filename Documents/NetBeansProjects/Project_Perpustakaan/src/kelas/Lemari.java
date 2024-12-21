/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kelas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author FADHILA
 */
public class Lemari {
    String id_lemari,lemari,rak;
    
    private Connection konek;

    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;
    
    public Lemari() throws SQLException {
        koneksi koneksi = new koneksi();
        konek = koneksi.konekDB();
    }

    public String getId_lemari() {
        return id_lemari;
    }

    public void setId_lemari(String id_lemari) {
        this.id_lemari = id_lemari;
    }

    public String getLemari() {
        return lemari;
    }

    public void setLemari(String lemari) {
        this.lemari = lemari;
    }

    public String getRak() {
        return rak;
    }

    public void setRak(String rak) {
        this.rak = rak;
    }
    
    public void tambahLemari() {
        query = "INSERT INTO lemari (id_lemari,lemari,rak) VALUES (?, ?, ?)";

        try (PreparedStatement ps = konek.prepareStatement(query)) {
            ps.setString(1, id_lemari);
            ps.setString(2, lemari);
            ps.setString(3, rak);
            

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data lemari berhasil ditambahkan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal menambahkan data lemari: " + e.getMessage());
        }
    }
    
    public int autoId() {
        int newID = 1;

        try {
            String query = "SELECT MAX(id_lemari) AS max_id FROM lemari";
            Statement st = konek.createStatement();
            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                String lastNoUrut = rs.getString("max_id");

                if (lastNoUrut != null && !lastNoUrut.isEmpty()) {
                    String numericPart = lastNoUrut.split("\\.")[0];
                    newID = Integer.parseInt(numericPart) + 1;
                }
            }

            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal menghasilkan nomor urut baru!");
            e.printStackTrace();
        }

        return newID;
    }

    private static class koneksi {

        public koneksi() {
        }

        private Connection konekDB() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
    }
    
}
