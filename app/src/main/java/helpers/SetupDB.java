/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helpers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author A11.2022.14727
 */
public class SetupDB {
    public static void migrate() {
        String[] sql = {"""
            CREATE TABLE IF NOT EXISTS pegawai (
            idpegawai TEXT PRIMARY KEY,
            nama TEXT NOT NULL,
            dept TEXT NOT NULL);""",
            """
            CREATE TABLE IF NOT EXISTS absensi (
            idabsensi TEXT PRIMARY KEY,
            tanggal TEXT NOT NULL,
            idpegawai TEXT,
            nama TEXT,
            alasan TEXT NOT NULL,
            FOREIGN KEY (idpegawai) REFERENCES pegawai(idpegawai)
            );""",
            """
            CREATE TABLE IF NOT EXISTS kehadiran (
            idkehadiran TEXT PRIMARY KEY,
            tanggal TEXT NOT NULL,
            idpegawai TEXT,
            nama TEXT,
            jammasuk INTEGER DEFAULT 0,
            menitmasuk INTEGER DEFAULT 0,
            jamkeluar INTEGER DEFAULT 0,
            menitkeluar INTEGER DEFAULT 0,
            durasi TEXT,
            FOREIGN KEY (idpegawai) REFERENCES pegawai(idpegawai)
            );""",};

        try (Connection conn = KoneksiDB.connect(); Statement stmt = conn.createStatement()) {

            for (String query : sql) {
                stmt.executeUpdate(query);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
