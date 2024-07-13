/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author WINDOWS 10
 */
public class Kehadiran {
    public String    idkehadiran; 
    public String    tanggal; 
    public Pegawai   idpegawai; 
    public int       jammasuk; 
    public int       menitmasuk; 
    public int       jamkeluar; 
    public int       menitkeluar; 
    public int       durasi;

    public Kehadiran(String idkehadiran, String tanggal, int jammasuk, int menitmasuk, int jamkeluar, int menitkeluar, int durasi) {
        this.idkehadiran = idkehadiran;
        this.tanggal = tanggal;
        this.jammasuk = jammasuk;
        this.menitmasuk = menitmasuk;
        this.jamkeluar = jamkeluar;
        this.menitkeluar = menitkeluar;
        this.durasi = durasi;
    }

@Override
    public String toString() {
        return idpegawai.toString();
    }
}
