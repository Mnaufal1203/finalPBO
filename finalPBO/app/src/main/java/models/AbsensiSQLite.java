/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import entities.Pegawai;
import entities.Absensi;
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
public class AbsensiSQLite implements AbsensiDAO {

    @Override
    public void insert(Absensi absensi) {
        String sql = "INSERT INTO absensi(idabsensi, tanggal, idpegawai, alasan) VALUES(?, ?, ?, ?)";

        try (Connection conn = KoneksiDB.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, absensi.idabsensi);
            pstmt.setString(2, absensi.tanggal);
            pstmt.setString(3, absensi.idpegawai.idpegawai);
            pstmt.setString(4, absensi.alasan);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Absensi> selectAll() {
        String sql = """
            SELECT idabsensi, tanggal, p.idpegawai AS idgawe, alasan
            FROM absensi a, pegawai p
            WHERE a.idpegawai = p.idpegawai""";
        List<Absensi> dataabs = new ArrayList<>();
        try (Connection conn = KoneksiDB.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Absensi absensi = new Absensi(
                        rs.getString("idabsensi"),
                        rs.getString("tanggal"),
                        rs.getString("alasan")
                );
                String idpegawai = rs.getString("idgawe");
                if (idpegawai != null) {
                    absensi.idpegawai = new Pegawai(idpegawai);
                }
                dataabs.add(absensi);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return dataabs;
    }

    @Override
    public void delete(String idabsensi) {
        String sql = "DELETE FROM absensi WHERE idabsensi = ?";

        try (Connection conn = KoneksiDB.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, idabsensi);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Absensi selectbyIDAbsensi(String idabsensi) {
        String sql = """
            SELECT idabsensi, a.idpegawai AS idgawe, tanggal, alasan
            FROM absensi a, pegawai p
            WHERE a.idpegawai = p.idpegawai AND idabsensi = ?""";

        Absensi absensi = null;

        try (Connection conn = KoneksiDB.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, idabsensi);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                absensi = new Absensi(
                        rs.getString("idabsensi"),
                        rs.getString("tanggal"),
                        rs.getString("alasan")
                );
                String idpegawai = rs.getString("idgawe");
                if (idpegawai != null) {
                    absensi.idpegawai = new Pegawai(idpegawai);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return absensi;
    }

    @Override
    public void update(Absensi absensi) {
        String sql = "UPDATE absensi SET alasan = ? WHERE idabsensi = ?";

        try (Connection conn = KoneksiDB.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, absensi.alasan);
            pstmt.setString(2, absensi.idabsensi);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void reset() {
        String sql = "DELETE FROM absensi";

        try (Connection conn = KoneksiDB.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
