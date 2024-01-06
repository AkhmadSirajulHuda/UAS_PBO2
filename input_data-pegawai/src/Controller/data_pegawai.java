 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author ASUS
 */
public class data_pegawai {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private String sql;
    public String nama;
    public String nip;
    public String pangkat;
    public String golongan;
    public String jabatan;
    
    public void simpan()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "INSERT INTO input_data_pegawai(Nama,NIP,Pangkat,Golongan,Jabatan)VALUES(?,?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1, nama);
        pst.setString(2, nip);
        pst.setString(3, pangkat);
        pst.setString(4, golongan);
        pst.setString(5, jabatan);
        pst.execute();
        pst.close();
    }
    
    public void ubah()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "UPDATE INTO input_data_pegawai set Nama=?,Pangkat=?,Golongan=?,Jabatan=? where NIP=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1, nama);
        pst.setString(2, nip);
        pst.setString(3, pangkat);
        pst.setString(4, golongan);
        pst.setString(5, jabatan);
        pst.executeUpdate();
        pst.close();
    }
    
    public void hapus()throws SQLException{
        conn=Koneksi.getKoneksi();
        String sql = "DELETE from input_data_pegawai where nip=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, nip);
            pst.execute();
        }catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public ResultSet UpdateJTable()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "select Nama,NIP,Pangkat,Golongan,Jabatan from input_data_pegawai";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        return rs;
    }
}
