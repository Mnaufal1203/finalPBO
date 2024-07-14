/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author A11.2022.14727
 */
public class Pegawai {
    public String idpegawai;
    public String nama;
    public String dept;

    public Pegawai(String idpegawai, String nama, String dept) {
        this.idpegawai = idpegawai;
        this.nama = nama;
        this.dept = dept;
    }

    public Pegawai(String idpegawai, String nama) {
        this.idpegawai = idpegawai;
        this.nama = nama;
    }

    public Pegawai(String idpegawai) {
        this.idpegawai = idpegawai;
    }


    public String getIdpegawai() {
        return idpegawai;
    }

    public String getNama() {
        return nama;
    }

    public String getDept() {
        return dept;
    }
    
@Override
public String toString() {
    return idpegawai;
}
}
