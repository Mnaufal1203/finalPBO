/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helpers;
import entities.Absensi;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author A11.2022.14727
 */
    public class TabelAbsensi extends AbstractTableModel{
    List<Absensi> dataAbsensi;
    String header[] = {"ID Absensi", "Tanggal", "ID Pegawai", "Alasan"};

    public TabelAbsensi(List<Absensi> dataAbsensi) {
        this.dataAbsensi = dataAbsensi;
    }

    
    @Override
    public String getColumnName(int column) {
        return header[column];
    }
    
    @Override
    public int getRowCount() {
        return dataAbsensi.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> dataAbsensi.get(rowIndex).idabsensi;
            case 1 -> dataAbsensi.get(rowIndex).tanggal;
            case 2 -> dataAbsensi.get(rowIndex).idpegawai.idpegawai;
            default -> dataAbsensi.get(rowIndex).alasan;
        };
    }
}


