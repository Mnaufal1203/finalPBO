/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;
import entities.Pegawai;
import entities.Kehadiran;
import helpers.TabelPegawai;
import helpers.TabelKehadiran;
import java.util.List;
import models.PegawaiDAO;
import models.PegawaiSQLite;
import models.KehadiranDAO;
import models.KehadiranSQLite;
/**
 *
 * @author WINDOWS 10
 */
public class PanelKehadiran extends javax.swing.JPanel {
    KehadiranDAO dao;
    PegawaiDAO daoPegawai;
    List<Kehadiran> dataKehadiran;
    List<Pegawai> dataPegawai;
    boolean editMode = false;
    /**
     * Creates new form PanelKehadiran
     */
    public PanelKehadiran() {
        initComponents();
        dao = new KehadiranSQLite();
        daoPegawai = new PegawaiSQLite();
        refresh();
    }
    
    private void clear() {
        txtIDKehadiran.setText("");
        txtIDPegawai.setText("");
        txtTanggal.setText("");
        txtJamMasuk.setText("");
        txtMenitMasuk.setText("");
        txtJamKeluar.setText("");
        txtMenitKeluar.setText("");
        btnHapus.setEnabled(false);
    }

    public void refresh() {
    dataPegawai = daoPegawai.selectAll();
    tblPegawai.setEnabled(true);
    tblPegawai.setModel(new TabelPegawai(dataPegawai));
    dataKehadiran = dao.selectAll();
    tblKehadiran.setModel(new TabelKehadiran(dataKehadiran));
    txtIDKehadiran.setEnabled(true);
    txtTanggal.setEnabled(true);
    txtIDPegawai.setEnabled(false);
    editMode = false;
    clear();
    }

    private Pegawai getPegawaiByID(String id) {
        for (Pegawai pegawai : dataPegawai) {
            if (pegawai.idpegawai.equals(id)) {
                return pegawai;
            }
        }
        return null;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPegawai = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        btnRefresh1 = new javax.swing.JButton();
        btnHapus1 = new javax.swing.JButton();
        txtIDKehadiran = new javax.swing.JTextField();
        txtMenitMasuk = new javax.swing.JTextField();
        txtTanggal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtJamKeluar = new javax.swing.JTextField();
        txtJamMasuk = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();
        txtMenitKeluar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblKehadiran = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtIDPegawai = new javax.swing.JTextField();

        jLabel1.setText("jLabel1");

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(255, 51, 51));
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        setPreferredSize(new java.awt.Dimension(420, 520));

        tblPegawai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPegawaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPegawai);

        jLabel2.setText("ID Kehadiran");

        jLabel3.setText("Tanggal");

        jLabel4.setText("Menit Masuk");

        jLabel5.setText("Jam Masuk");

        btnSimpan.setBackground(new java.awt.Color(51, 255, 102));
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnRefresh1.setText("Refresh");
        btnRefresh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefresh1ActionPerformed(evt);
            }
        });

        btnHapus1.setBackground(new java.awt.Color(255, 51, 51));
        btnHapus1.setText("Hapus");
        btnHapus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapus1ActionPerformed(evt);
            }
        });

        txtIDKehadiran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDKehadiranActionPerformed(evt);
            }
        });

        txtTanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTanggalActionPerformed(evt);
            }
        });

        jLabel6.setText("Jam Keluar");

        jLabel7.setText("Menit Keluar");

        txtJamKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJamKeluarActionPerformed(evt);
            }
        });

        txtJamMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJamMasukActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(255, 51, 51));
        btnReset.setText("RESET");
        btnReset.setPreferredSize(new java.awt.Dimension(72, 30));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        tblKehadiran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblKehadiran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKehadiranMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblKehadiran);

        jLabel9.setText("ID Pegawai");

        txtIDPegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDPegawaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIDKehadiran)
                    .addComponent(txtTanggal)
                    .addComponent(txtIDPegawai)))
            .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtJamMasuk, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtJamKeluar, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(84, 84, 84)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMenitMasuk)
                    .addComponent(txtMenitKeluar)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnSimpan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                .addComponent(btnRefresh1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                .addComponent(btnHapus1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIDKehadiran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtIDPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtMenitMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMenitKeluar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtJamMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtJamKeluar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefresh1)
                    .addComponent(btnSimpan)
                    .addComponent(btnHapus1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        txtIDKehadiran.setEnabled(true);
        String idpegawai = txtIDPegawai.getText();
        String idkehadiran = txtIDKehadiran.getText();
        Pegawai pegawaiID = getPegawaiByID(idpegawai);
        String tanggal = txtTanggal.getText();
        int jammasuk = Integer.parseInt(txtJamMasuk.getText());
        int menitmasuk = Integer.parseInt(txtMenitMasuk.getText());
        int jamkeluar = Integer.parseInt(txtJamKeluar.getText());
        int menitkeluar = Integer.parseInt(txtMenitKeluar.getText());
        
        Kehadiran newkehadiran = new Kehadiran(idkehadiran, tanggal, jammasuk, menitmasuk, jamkeluar, menitkeluar);
        newkehadiran.idpegawai= pegawaiID;
        if (editMode == false) {
            dao.insert(newkehadiran);
        } else {
            dao.update(newkehadiran);
        }
        refresh();
        clear();//    }//GEN-LAST:event_btnSimpanActionPerformed
    }
    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
       refresh();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnRefresh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefresh1ActionPerformed
        refresh();
    }//GEN-LAST:event_btnRefresh1ActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        txtIDKehadiran.setEnabled(true);

        dao.delete(txtIDKehadiran.getText());
        refresh();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnHapus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapus1ActionPerformed
        txtIDKehadiran.setEnabled(true);
        dao.delete(txtIDKehadiran.getText());
        refresh();
    }//GEN-LAST:event_btnHapus1ActionPerformed

    private void txtIDKehadiranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDKehadiranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDKehadiranActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtIDKehadiran.setEnabled(true);
        dao.reset();
        refresh();
    }//GEN-LAST:event_btnResetActionPerformed

    private void txtJamMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJamMasukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJamMasukActionPerformed

    private void txtJamKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJamKeluarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJamKeluarActionPerformed

    private void txtTanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTanggalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTanggalActionPerformed

    private void txtIDPegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDPegawaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDPegawaiActionPerformed

    private void tblPegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPegawaiMouseClicked
            txtIDKehadiran.setEnabled(true);

            Pegawai pegawai = dataPegawai.get(tblPegawai.getSelectedRow());

            txtIDPegawai.setText(pegawai.idpegawai);
            txtIDPegawai.setEnabled(false);

    }//GEN-LAST:event_tblPegawaiMouseClicked

    private void tblKehadiranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKehadiranMouseClicked
            editMode = true;
            tblPegawai.setEnabled(false);
            btnHapus.setEnabled(true);

            Kehadiran kehadiran = dataKehadiran.get(tblKehadiran.getSelectedRow());

            txtIDPegawai.setText(kehadiran.idpegawai.idpegawai);
            txtIDKehadiran.setText(kehadiran.idkehadiran);
            txtTanggal.setText(kehadiran.tanggal);

            txtIDKehadiran.setEnabled(false);
            txtIDPegawai.setEnabled(false);
            txtTanggal.setEnabled(false);
    }//GEN-LAST:event_tblKehadiranMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnHapus1;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRefresh1;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblKehadiran;
    private javax.swing.JTable tblPegawai;
    private javax.swing.JTextField txtIDKehadiran;
    private javax.swing.JTextField txtIDPegawai;
    private javax.swing.JTextField txtJamKeluar;
    private javax.swing.JTextField txtJamMasuk;
    private javax.swing.JTextField txtMenitKeluar;
    private javax.swing.JTextField txtMenitMasuk;
    private javax.swing.JTextField txtTanggal;
    // End of variables declaration//GEN-END:variables
}
