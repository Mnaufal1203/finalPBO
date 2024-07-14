/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helpers;
import entities.Pegawai;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author A11.2022.14727
 */
    public class TabelPegawai extends AbstractTableModel{
    
    List<Pegawai> dataPegawai;
    String header[] = {"ID Pegawai","Nama","Departemen"};

    public TabelPegawai(List<Pegawai> dataPegawai) {
        this.dataPegawai = dataPegawai;
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }
    
    @Override
    public int getRowCount() {
        return dataPegawai.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> dataPegawai.get(rowIndex).idpegawai;
            case 1 ->  dataPegawai.get(rowIndex).nama;
            default -> dataPegawai.get(rowIndex).dept;
        };
    }
    
}

