/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import entities.Pegawai;
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
public class PegawaiSQLite implements PegawaiDAO{
    @Override
    public void insert(Pegawai pegawai) {
        String sql = "INSERT INTO pegawai(idpegawai, nama, dept) VALUES(?, ?, ?)";

        try (Connection conn = KoneksiDB.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, pegawai.idpegawai);
            pstmt.setString(2, pegawai.nama);
            pstmt.setString(3, pegawai.dept);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Pegawai> searchByNama(String nama) {
    String sql = "SELECT * FROM pegawai WHERE nama =?";
    List<Pegawai> dataPegawai = new ArrayList<>();

    try (Connection conn = KoneksiDB.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, nama);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            Pegawai pegawai = new Pegawai(
                    rs.getString("idpegawai"),
                    rs.getString("nama"),
                    rs.getString("dept"));
            dataPegawai.add(pegawai);
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }

    return dataPegawai;
}
    
    @Override
    public List<Pegawai> searchByID(String idpegawai) {
    String sql = "SELECT * FROM pegawai WHERE idpegawai =?";
    List<Pegawai> dataPegawai = new ArrayList<>();

    try (Connection conn = KoneksiDB.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, idpegawai);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            Pegawai pegawai = new Pegawai(
                    rs.getString("idpegawai"),
                    rs.getString("nama"),
                    rs.getString("dept"));
            dataPegawai.add(pegawai);
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }

    return dataPegawai;
}
    
 
       @Override
         public List<Pegawai> selectAll() {
        String sql = "SELECT idpegawai,nama,dept FROM pegawai";
        List<Pegawai> dataPegawai = new ArrayList<>();

        try (Connection conn = KoneksiDB.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Pegawai pegawai = new Pegawai(
                        rs.getString("idpegawai"),
                        rs.getString("nama"),
                        rs.getString("dept"));
                    dataPegawai.add(pegawai);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return dataPegawai;
    }


    @Override
    public void update(Pegawai pegawai) {
    String sql = "UPDATE pegawai SET nama = ?, dept = ? WHERE idpegawai = ?";

    try (Connection conn = KoneksiDB.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, pegawai.nama);
        pstmt.setString(2, pegawai.dept);
        pstmt.setString(3, pegawai.idpegawai);
        pstmt.executeUpdate();
        System.out.println("Updated: " + pegawai.idpegawai);
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}


    @Override
    public void delete(String idpegawai) {
        String sql = "DELETE FROM pegawai WHERE idpegawai = ?";

        try (Connection conn = KoneksiDB.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, idpegawai);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public Pegawai selectByIdpegawai(String idpegawai) {
        String sql = "SELECT idpegawai,nama FROM pegawai WHERE idpegawai = ?";
        Pegawai pegawai = null;

        try (Connection conn = KoneksiDB.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, idpegawai);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                pegawai = new Pegawai(
                        rs.getString("idpegawai"),
                        rs.getString("nama"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    return pegawai;
    }

   

   
}


  