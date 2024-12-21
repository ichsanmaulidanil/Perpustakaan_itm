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
 * @author WINDOWS 10
 */
public class Staff {
    int idStaf,nimNidn;
    String nama,alamat,noHp,email;
    
    private Connection konek;

    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;
    
    public Staff() throws SQLException {
        koneksi koneksi = new koneksi();
        konek = koneksi.konekDB();
    }

    public int getIdStaf() {
        return idStaf;
    }

    public void setIdStaf(int idStaf) {
        this.idStaf = idStaf;
    }

    public int getNimNidn() {
        return nimNidn;
    }

    public void setNimNidn(int nimNidn) {
        this.nimNidn = nimNidn;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public int autoId() {
        int newID = 1;

        try {
            query = "SELECT MAX(id_staf) AS max_id FROM staf_perpustakaan";
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
    
    public void tambahStaff() {
        String queryInsert = "INSERT INTO staf_perpustakaan (id_staf,nama,alamat,nohp,email,nim_nidn) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = konek.prepareStatement(queryInsert)) {
            ps.setInt(1, idStaf);
            ps.setString(2, nama);
            ps.setString(3, alamat);
            ps.setString(4, noHp);
            ps.setString(5, email);
            ps.setInt(6, nimNidn);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data staff berhasil ditambahkan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal menambahkan data staff: " + e.getMessage());
        }
    }
    
    public ResultSet tampilStaf() {
        
        query = "SELECT * FROM staf_perpustakaan ";
        try {
            st = konek.createStatement();            
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Tampil");
        }
        return rs;
    }
    public void hapusStaf() {
        query = "DELETE FROM staf_perpustakaan WHERE id_staf = ?";
        try {

            ps = konek.prepareStatement(query);

            ps.setInt(1, idStaf);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Staf Berhasil Di Hapus");

        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Staf Gagal Di Hapus");
        }
    }
    
    public void ubahStaff() {

        query = "UPDATE staf_perpustakaan SET nama = ? "
                + " WHERE id_staf = ?";
        try {

            ps = konek.prepareStatement(query);

            ps.setString(1, nama);
            ps.setInt(2, idStaf);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Staf Berhasil Di Ubah");

        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Staf Gagal Di Ubah");
        }

    }
}
