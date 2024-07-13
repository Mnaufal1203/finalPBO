/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import entities.Absensi;
import java.util.List;

/**
 *
 * @author WINDOWS 10
 */
public interface AbsensiDAO {
    void insert(Absensi absensi);
    void reset();
    List<Absensi> selectAll();
    void update(Absensi absensi);
    void delete(String absensi);
    Absensi selectbyIDAbsensi(String idabsensi);
}
