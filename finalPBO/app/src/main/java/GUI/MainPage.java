/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import java.awt.CardLayout;

/**
 *
 * @author A11.2022.14727
 */
public class MainPage extends javax.swing.JFrame {

    /**
     * Creates new form MainPage
     */
    
    PanelAbsensi panelAbsensi;
    PanelKehadiran panelKehadiran;
    PanelPegawai panelPegawai;
    CardLayout layout;
    
    public MainPage() {
        initComponents();
        
        layout = (CardLayout) mainPanel.getLayout();

        panelAbsensi = new PanelAbsensi();
        panelKehadiran = new PanelKehadiran();
        panelPegawai = new PanelPegawai();

        mainPanel.add("pegawai", panelPegawai);
        mainPanel.add("kehadiran", panelKehadiran);
        mainPanel.add("absensi", panelAbsensi);

        layout.show(mainPanel, "perjalanan");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPegawai = new javax.swing.JButton();
        btnKehadiran = new javax.swing.JButton();
        btnAbsensi = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnPegawai.setText("Pegawai");
        btnPegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPegawaiActionPerformed(evt);
            }
        });

        btnKehadiran.setText("Kehadiran");
        btnKehadiran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKehadiranActionPerformed(evt);
            }
        });

        btnAbsensi.setText("Absensi");
        btnAbsensi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbsensiActionPerformed(evt);
            }
        });

        mainPanel.setPreferredSize(new java.awt.Dimension(420, 520));
        mainPanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnKehadiran, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPegawai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAbsensi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnPegawai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKehadiran)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAbsensi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbsensiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbsensiActionPerformed
        layout.show(mainPanel, "absensi");
    }//GEN-LAST:event_btnAbsensiActionPerformed

    private void btnPegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPegawaiActionPerformed
        layout.show(mainPanel, "pegawai");
    }//GEN-LAST:event_btnPegawaiActionPerformed

    private void btnKehadiranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKehadiranActionPerformed
        layout.show(mainPanel, "kehadiran");
    }//GEN-LAST:event_btnKehadiranActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbsensi;
    private javax.swing.JButton btnKehadiran;
    private javax.swing.JButton btnPegawai;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}