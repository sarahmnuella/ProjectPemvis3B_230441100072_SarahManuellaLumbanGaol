/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projectakhir;

import javax.swing.*;
import java.sql.*;

/**
 *
 * @author USER
 */
public class HomePage_1 extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */
    public HomePage_1() {
        initComponents();
        LoadNamaDokter(); // Memuat nama dokter saat form dibuka

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
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        dr = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        detaildokter = new javax.swing.JTextArea();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(211, 233, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\OneDrive\\Pictures\\AAA\\Halo__1_-removebg-preview.png")); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 70));

        jLabel3.setFont(new java.awt.Font("Monotype Corsiva", 0, 36)); // NOI18N
        jLabel3.setText("healthMate");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 0, -1, -1));

        jLabel4.setText("Konsultasi Kesehatan terpercaya sejak 2005");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 60, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\OneDrive\\Pictures\\AAA\\2.png")); // NOI18N
        jLabel5.setText("Profil");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 10, 100, 60));

        jLabel22.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\OneDrive\\Pictures\\AAA\\1.jpg")); // NOI18N
        jLabel22.setText("jLabel21");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1350, -1));

        jLabel6.setFont(new java.awt.Font("MV Boli", 0, 18)); // NOI18N
        jLabel6.setText("\"Kesehatan Jadi Lebih Sederhana Bersama Health Mate!");

        jLabel8.setText("Cukup daftar, pilih dokter, dan mulai konsultasi dalam hitungan menit. Nyaman, cepat, dan terpercaya!");

        jPanel4.setBackground(new java.awt.Color(223, 235, 249));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rekomendasi Dokter", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Emoji", 1, 18))); // NOI18N
        jPanel4.setLayout(new java.awt.GridLayout(3, 2));

        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\OneDrive\\Pictures\\AAA\\01.png")); // NOI18N
        jLabel11.setText(" dr AA Ayu Ratnawati Sp.M");
        jPanel4.add(jLabel11);

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\OneDrive\\Pictures\\AAA\\Download_free_png_of_PNG_Healthcare_workers_preventing_doctor_physician_standing__by_piyapon_singthong_about_asian_doctor__24__adult__apparel__and_asian_13636649-removebg-preview.png")); // NOI18N
        jLabel9.setText("dr. Atiek Indriawati, Sp.M");
        jPanel4.add(jLabel9);

        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\OneDrive\\Pictures\\AAA\\03.png")); // NOI18N
        jLabel14.setText("dr. Alif Reza Faizal S. Sp.M");
        jPanel4.add(jLabel14);

        jLabel12.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\OneDrive\\Pictures\\AAA\\02.png")); // NOI18N
        jLabel12.setText("dr. Adhi Wicaksono, Sp.M");
        jPanel4.add(jLabel12);

        jLabel16.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\OneDrive\\Pictures\\AAA\\07.png")); // NOI18N
        jLabel16.setText("dr. Cahya Dessy Rahmawati, Sp.M");
        jPanel4.add(jLabel16);

        jLabel18.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\OneDrive\\Pictures\\AAA\\80.png")); // NOI18N
        jLabel18.setText("dr. Anastasia Vanny Launardo, M.Kes., Sp.M");
        jPanel4.add(jLabel18);

        jLabel19.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\OneDrive\\Pictures\\AAA\\04.png")); // NOI18N
        jLabel19.setText("dr. Abdurrahman Ama, SpKJ, M.Kes");
        jPanel4.add(jLabel19);

        jLabel13.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\OneDrive\\Pictures\\AAA\\02.png")); // NOI18N
        jLabel13.setText("dr. Adhitya Indrapraja, Sp.OG");
        jPanel4.add(jLabel13);

        jLabel20.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\OneDrive\\Pictures\\AAA\\09.png")); // NOI18N
        jLabel20.setText("dr. Britya Intar Luvila, Sp.M");
        jPanel4.add(jLabel20);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Copyright ©Sarahmanuellaaaa. All rights reserved.");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 36, -1, 50));

        jLabel15.setText("Direktorat Jenderal Perlindungan Konsumen dan Tertib Niaga Kementerian Perdagangan Republik Indonesia 0853 1111 1010 (WhatsApp)");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 16, -1, 50));

        jLabel17.setText("PT Media Dokter Investama Jl. H.R. Rasuna Said Kav B32-33, Jakarta Selatan help@halodoc.com / 021-5095-9900");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, -4, -1, 50));

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\OneDrive\\Pictures\\AAA\\1.jpg")); // NOI18N
        jLabel7.setText("jLabel7");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 80));

        jLabel21.setText("Konsultasikan keluhan kesehatan dan dapatkan saran terbaik dari dokter ahli di Health Mate. Siap sehat? Kami siap bantu!");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setText("Lihat Harga ");

        jButton1.setText("Informasi ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel30.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\OneDrive\\Pictures\\AAA\\a2.png")); // NOI18N
        jLabel30.setText("Mulai Konsultasi");

        jLabel31.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\OneDrive\\Pictures\\AAA\\a1.png")); // NOI18N
        jLabel31.setText("Riwayat Konsultasi");

        jLabel24.setText("Pilih Dokter ");

        dr.setBackground(new java.awt.Color(191, 218, 245));
        dr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Select Dokter---", " " }));
        dr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                drMouseClicked(evt);
            }
        });
        dr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drActionPerformed(evt);
            }
        });

        detaildokter.setEditable(false);
        detaildokter.setBackground(new java.awt.Color(211, 233, 255));
        detaildokter.setColumns(20);
        detaildokter.setRows(5);
        detaildokter.setBorder(javax.swing.BorderFactory.createTitledBorder("Detail Harga"));
        jScrollPane1.setViewportView(detaildokter);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel23)
                        .addGap(383, 383, 383))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel21)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel24)
                                        .addGap(124, 124, 124)
                                        .addComponent(dr, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(86, 86, 86)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(161, 161, 161))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel21)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel23)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(dr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel31)
                                .addComponent(jButton1))
                            .addComponent(jLabel30))
                        .addGap(35, 35, 35)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 private void LoadNamaDokter() {
        try {
            String sql = "SELECT nama FROM dokter";
            PreparedStatement ps = Koneksi.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dr.addItem(rs.getString("nama"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        Informasi infor = new Informasi();
        infor.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Informasi infor = new Informasi();
        infor.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        HomePage hmpge = new HomePage();
        hmpge.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void drMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drMouseClicked


    }//GEN-LAST:event_drMouseClicked

    private void drActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drActionPerformed
        String selectedDoctor = (String) dr.getSelectedItem();
        if (selectedDoctor != null && !selectedDoctor.equals("---Select Dokter---")) {
            StringBuilder infoDokter = new StringBuilder();
            try {
                String sql = "SELECT spesialis, harga FROM dokter WHERE nama = ?";
                PreparedStatement ps = Koneksi.getConnection().prepareStatement(sql);
                ps.setString(1, selectedDoctor); // Set parameter query
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    String spesialis = rs.getString("spesialis");
                    String harga = rs.getString("harga");

                    infoDokter.append("Spesialis: ").append(spesialis).append("\n");
                    infoDokter.append("Harga: ").append(harga).append("\n");
                } else {
                    infoDokter.append("Dokter tidak ditemukan.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            detaildokter.setText(infoDokter.toString()); 
            detaildokter.setVisible(true); 
            jScrollPane1.setVisible(true);
        }
    }//GEN-LAST:event_drActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea detaildokter;
    private javax.swing.JComboBox<String> dr;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
