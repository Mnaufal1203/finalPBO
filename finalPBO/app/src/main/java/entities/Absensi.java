/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author WINDOWS 10
 */
public class Absensi {
    public String idabsensi;
    public String tanggal;
    public Pegawai idpegawai;
    public Pegawai nama;
    public String alasan;

    public Absensi(String idabsensi, String tanggal, Pegawai idpegawai, Pegawai nama, String alasan) {
        this.idabsensi = idabsensi;
        this.tanggal = tanggal;
        this.idpegawai = idpegawai;
        this.nama = nama;
        this.alasan = alasan;
    }

    public Absensi(String idabsensi, String tanggal, String alasan) {
        this.idabsensi = idabsensi;
        this.tanggal = tanggal;
        this.alasan = alasan;
    }

    
    public String getIdabsensi() {
        return idabsensi;
    }

    public String getTanggal() {
        return tanggal;
    }

    public Pegawai getIdpegawai() {
        return idpegawai;
    }

    public Pegawai getNama() {
        return nama;
    }

    public String getAlasan() {
        return alasan;
    }

    
    
    
    
    
}
