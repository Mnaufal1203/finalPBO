/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import entities.Pegawai;
import entities.Kehadiran;
import java.util.List;
/**
 *
 * @author WINDOWS 10
 */
public interface KehadiranDAO {
    void insert(Kehadiran kehadiran);
    void reset();
    List<Kehadiran> selectAll();
    void update(Kehadiran kehadiran);
    void delete(String kehadiran);
    Kehadiran selectbyIDKehadiran(String idabsensi);
}
