/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helpers;
import entities.Kehadiran;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author A11.2022.14727
 */
public class TabelKehadiran extends AbstractTableModel{
    List<Kehadiran> dataKehadiran;
    String header[] = {"ID Kehadiran", "Tanggal", "ID Pegawai", "Jam Masuk", "Menit Masuk", "Jam Keluar", "Menit Keluar", "Durasi"};

    public TabelKehadiran(List<Kehadiran> dataKehadiran) {
        this.dataKehadiran = dataKehadiran;
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    @Override
    public int getRowCount() {
        return dataKehadiran.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> dataKehadiran.get(rowIndex).idkehadiran;
            case 1 -> dataKehadiran.get(rowIndex).tanggal;
            case 2 -> dataKehadiran.get(rowIndex).idpegawai.idpegawai;
            case 3 -> dataKehadiran.get(rowIndex).jammasuk;
            case 4 -> dataKehadiran.get(rowIndex).menitmasuk;
            case 5 -> dataKehadiran.get(rowIndex).jamkeluar;
            case 6 -> dataKehadiran.get(rowIndex).menitkeluar;
            default -> dataKehadiran.get(rowIndex).hitungDurasi();
        };
    }
}
