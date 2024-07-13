/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import entities.Pegawai;
import java.util.List;

/**
 *
 * @author A11.2022.14727
 */
public interface PegawaiDAO {
    void insert(Pegawai pegawai);
    
    List<Pegawai> searchByNama(String nama);
    List<Pegawai> searchByID(String idpegawai);
    Pegawai selectByIdpegawai(String idpegawai);
    List<Pegawai> selectAll();
    void update(Pegawai pegawai);
    void delete(String idpegawai);



}
