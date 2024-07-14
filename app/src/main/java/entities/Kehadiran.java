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
    
    public int hitungDurasiDalamMenit() {
        if (this.jammasuk > 24 || this.jammasuk < 0 || this.menitmasuk > 59 || this.menitmasuk < 0 ||
            this.jamkeluar > 24 || this.jamkeluar < 0 || this.menitkeluar > 59 || this.menitkeluar < 0) {
            throw new IllegalArgumentException("Invalid time input.");
        }

        int jamMasukDalamMenit = this.jammasuk * 60 + this.menitmasuk;
        int jamKeluarDalamMenit = this.jamkeluar * 60 + this.menitkeluar;

        int durasiDalamMenit = jamKeluarDalamMenit - jamMasukDalamMenit;
        if (durasiDalamMenit < 0) {
            throw new IllegalArgumentException("End time is before start time.");
        }

        return durasiDalamMenit;
    }
    
    public String hitungDurasi() {
        int durasiDalamMenit = hitungDurasiDalamMenit();
        int durasiJam = durasiDalamMenit / 60;
        int durasiMenit = durasiDalamMenit % 60;

        return durasiJam + " jam, " + durasiMenit + " menit";
    }

    public Kehadiran(String idkehadiran, String tanggal, int jammasuk, int menitmasuk, int jamkeluar, int menitkeluar, int durasi) {
        this.idkehadiran = idkehadiran;
        this.tanggal = tanggal;
        this.jammasuk = jammasuk;
        this.menitmasuk = menitmasuk;
        this.jamkeluar = jamkeluar;
        this.menitkeluar = menitkeluar;
        this.durasi = hitungDurasiDalamMenit();
    }

    public Kehadiran(String idkehadiran, String tanggal, int jammasuk, int menitmasuk, int jamkeluar, int menitkeluar) {
        this.idkehadiran = idkehadiran;
        this.tanggal = tanggal;
        this.idpegawai = idpegawai;
        this.jammasuk = jammasuk;
        this.menitmasuk = menitmasuk;
        this.jamkeluar = jamkeluar;
        this.menitkeluar = menitkeluar;
    }

    

    
@Override
    public String toString() {
        return idpegawai.toString();
    }
}
