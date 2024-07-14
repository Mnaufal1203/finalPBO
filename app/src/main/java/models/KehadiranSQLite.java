/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import entities.Pegawai;
import entities.Kehadiran;
import helpers.KoneksiDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author WINDOWS 10
 */
public class KehadiranSQLite implements KehadiranDAO{
    @Override
public void insert(Kehadiran kehadiran) {
    String sql = "INSERT INTO kehadiran(idkehadiran, tanggal, idpegawai, jammasuk, menitmasuk, jamkeluar, menitkeluar, durasi) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection conn = KoneksiDB.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, kehadiran.idkehadiran);
        pstmt.setString(2, kehadiran.tanggal);
        pstmt.setString(3, kehadiran.idpegawai.idpegawai);
        pstmt.setInt(4, kehadiran.jammasuk);
        pstmt.setInt(5, kehadiran.menitmasuk);
        pstmt.setInt(6, kehadiran.jamkeluar);
        pstmt.setInt(7, kehadiran.menitkeluar);

        // Hitung durasi
        int totalMenitMasuk = kehadiran.jammasuk * 60 + kehadiran.menitmasuk;
        int totalMenitKeluar = kehadiran.jamkeluar * 60 + kehadiran.menitkeluar;
        int durasiMenit = totalMenitKeluar - totalMenitMasuk;
        
        if (durasiMenit < 0) durasiMenit += 24 * 60; // Handle kasus jika waktu keluar berada pada hari berikutnya

        int durasiJam = durasiMenit / 60;
        int durasiMenitSisa = durasiMenit % 60;

        // Cegah nilai di atas 24 jam dan 59 menit
        if (durasiJam > 24) durasiJam = 24;
        if (durasiMenitSisa > 59) durasiMenitSisa = 59;

        String durasi = durasiJam + " jam, " + durasiMenitSisa + " menit";
        pstmt.setString(8, durasi);

        pstmt.executeUpdate();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}


    @Override
    public List<Kehadiran> selectAll() {
    String sql = """
        SELECT idkehadiran, tanggal, k.idpegawai AS idgawe, jammasuk, menitmasuk, jamkeluar, menitkeluar, durasi
        FROM kehadiran k, pegawai p
        WHERE k.idpegawai = p.idpegawai""";
    List<Kehadiran> datahdr = new ArrayList<>();
    try (Connection conn = KoneksiDB.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
        while (rs.next()) {
            Kehadiran kehadiran = new Kehadiran(
                    rs.getString("idkehadiran"),
                    rs.getString("tanggal"),
                    rs.getInt("jammasuk"),
                    rs.getInt("menitmasuk"),
                    rs.getInt("jamkeluar"),
                    rs.getInt("menitkeluar")
            );
            kehadiran.durasi = rs.getInt("durasi");
            String idpegawai = rs.getString("idgawe");
            if (idpegawai != null) {
                kehadiran.idpegawai = new Pegawai(idpegawai);
            }
            datahdr.add(kehadiran);
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }

    return datahdr;
}

    @Override
    public void delete(String idkehadiran) {
        String sql = "DELETE FROM kehadiran WHERE idkehadiran = ?";

        try (Connection conn = KoneksiDB.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, idkehadiran);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Kehadiran selectbyIDKehadiran(String idkehadiran) {
    String sql = """
        SELECT idkehadiran, k.idpegawai AS idgawe, tanggal, jammasuk, menitmasuk, jamkeluar, menitkeluar, durasi
        FROM kehadiran k, pegawai p
        WHERE k.idpegawai = p.idpegawai""";

    Kehadiran kehadiran = null;

    try (Connection conn = KoneksiDB.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, idkehadiran);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            kehadiran = new Kehadiran(
                    rs.getString("idkehadiran"),
                    rs.getString("tanggal"),
                    rs.getInt("jammasuk"),
                    rs.getInt("menitmasuk"),
                    rs.getInt("jamkeluar"),
                    rs.getInt("menitkeluar")
            );
            kehadiran.durasi = rs.getInt("durasi");
            String idpegawai = rs.getString("idgawe");
            if (idpegawai != null) {
                kehadiran.idpegawai = new Pegawai(idpegawai);
            }
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }

    return kehadiran;
}

    @Override
public void update(Kehadiran kehadiran) {
    String sql = "UPDATE kehadiran SET jammasuk = ?, menitmasuk = ?, jamkeluar = ?, menitkeluar = ?, durasi = ? WHERE idkehadiran = ?";

    try (Connection conn = KoneksiDB.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
        int durasi = kehadiran.hitungDurasiDalamMenit();

        pstmt.setInt(1, kehadiran.jammasuk);
        pstmt.setInt(2, kehadiran.menitmasuk);
        pstmt.setInt(3, kehadiran.jamkeluar);
        pstmt.setInt(4, kehadiran.menitkeluar);
        pstmt.setInt(5, durasi);
        pstmt.setString(6, kehadiran.idkehadiran);
        pstmt.executeUpdate();

        System.out.println("Durasi: " + kehadiran.hitungDurasi());
    } catch (SQLException | IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}

    @Override
    public void reset() {
        String sql = "DELETE FROM kehadiran";

        try (Connection conn = KoneksiDB.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
