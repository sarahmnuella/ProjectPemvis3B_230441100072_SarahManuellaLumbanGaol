/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projectakhir;

import java.sql.Connection; // Import yang benar
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class HomePage_3 extends javax.swing.JFrame {

    private final Connection conn;
    private final DefaultTableModel model1;
    private int selectedPatientId = -1;

    public HomePage_3() {
        initComponents();
        conn = Koneksi.getConnection(); // Inisialisasi koneksi database

        model1 = (DefaultTableModel) jTable1.getModel(); // Inisialisasi model tabel
        loadDataPasien();
        loadData(); // Memuat data dokter saat form dibuka

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "id_detail", "Nama Lengkap", "Umur", "Jenis Kelamin", "Keluhan", "TTL", "Alergi", "Status Pembayaran", "Tanggal" // Tambahkan kolom ini
                }
        ));

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = jTable1.getSelectedRow();
                if (row != -1) {
                    iddokter.setText(jTable1.getValueAt(row, 0).toString());
                    dr.setText(jTable1.getValueAt(row, 1).toString());
                    spesial.setText(jTable1.getValueAt(row, 2).toString());
                    hrg.setText(jTable1.getValueAt(row, 3).toString());
                }
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = jTable2.getSelectedRow();
                if (row != -1) {
                    int idDetail = (int) jTable2.getValueAt(row, 0);
                    selectedPatientId = idDetail;
                }
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String selectedStatus = (String) jComboBox1.getSelectedItem();
                if ("Lunas".equals(selectedStatus) && selectedPatientId != -1) {
                    updateStatusPembayaran(selectedPatientId, "Lunas");
                }
            }
        });
    }

    private void updateStatusPembayaran(int idDetail, String status) {
        try {
            System.out.println("Updating status for ID: " + idDetail + " to " + status); // Debugging line
            String sql = "UPDATE detail SET status_pembayaran = ? WHERE id_detail = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, status);
            ps.setInt(2, idDetail);
            int rowsAffected = ps.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected); // Debugging line
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Status pembayaran berhasil diperbarui");
                loadDataPasien(); // Refresh the table to show updated data
            } else {
                JOptionPane.showMessageDialog(null, "No rows updated. Please check the ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error Update Status Pembayaran: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error Update Status Pembayaran: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadData() {
        try {
            String sql = "SELECT * FROM dokter";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            model1.setRowCount(0);
            while (rs.next()) {
                int id = rs.getInt("id_dokter");
                String nama = rs.getString("nama");
                String spesialis = rs.getString("spesialis");
                double harga = rs.getDouble("harga");
                model1.addRow(new Object[]{id, nama, spesialis, harga});
            }
        } catch (SQLException e) {
            System.out.println("Error Load Data Dokter: " + e.getMessage());
        }
    }

    private void loadDataPasien() {
        try {
            String sql = "SELECT d.id_detail, d.nama, d.umur, d.jnsklmin, d.keluhan, d.ttl, d.alergi, d.status_pembayaran, d.tanggal "
                    + "FROM detail d "
                    + "JOIN login l ON d.id_user = l.id_user";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel();
            model2.setRowCount(0);

            while (rs.next()) {
                int idDetail = rs.getInt("id_detail");
                String nama = rs.getString("nama");
                int umur = rs.getInt("umur");
                String jenisKelamin = rs.getString("jnsklmin");
                String keluhan = rs.getString("keluhan");
                String ttl = rs.getString("ttl");
                String alergi = rs.getString("alergi");
                String statusPembayaran = rs.getString("status_pembayaran"); 
                Timestamp tanggal=rs.getTimestamp("tanggal");
                model2.addRow(new Object[]{idDetail, nama, umur, jenisKelamin, keluhan, ttl, alergi, statusPembayaran, tanggal});
            }
        } catch (SQLException e) {
            System.out.println("Error Load Data Pasien: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Error Load Data Pasien: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveDataDokter() {
        if (dr.getText().isEmpty() || spesial.getText().isEmpty() || hrg.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Isi data Dokter terlebih dahulu", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String sql = "INSERT INTO dokter (nama, spesialis, harga) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dr.getText());
            ps.setString(2, spesial.getText());
            ps.setDouble(3, Double.parseDouble(hrg.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data Dokter berhasil disimpan");
            loadData();
        } catch (SQLException e) {
            System.out.println("Error Save Data Dokter: " + e.getMessage());
        }
    }

    private void updateDataDokter() {
        if (iddokter.getText().isEmpty() || dr.getText().isEmpty() || spesial.getText().isEmpty() || hrg.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih dokter yang akan diupdate", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String sql = "UPDATE dokter SET nama=?, spesialis=?, harga=? WHERE id_dokter=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dr.getText());
            ps.setString(2, spesial.getText());
            ps.setDouble(3, Double.parseDouble(hrg.getText()));
            ps.setInt(4, Integer.parseInt(iddokter.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data Dokter berhasil diupdate");
            loadData();
        } catch (SQLException e) {
            System.out.println("Error Update Data Dokter: " + e.getMessage());
        }
    }

    private void deleteDataDokter() {
        if (iddokter.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih dokter yang akan dihapus", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String sql = "DELETE FROM dokter WHERE id_dokter=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(iddokter.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data Dokter berhasil dihapus");
            loadData();
        } catch (SQLException e) {
            System.out.println("Error Delete Data Dokter: " + e.getMessage());
        }
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
        HOME = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        iddokter = new javax.swing.JTextField();
        dr = new javax.swing.JTextField();
        spesial = new javax.swing.JTextField();
        hrg = new javax.swing.JTextField();
        delete = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        delete1 = new javax.swing.JButton();
        delete2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        HOME.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\OneDrive\\Pictures\\AAA\\Halo__1_-removebg-preview.png")); // NOI18N
        HOME.setText("jLabel2");
        HOME.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HOMEMouseClicked(evt);
            }
        });
        jPanel3.add(HOME, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 70));

        jLabel3.setFont(new java.awt.Font("Monotype Corsiva", 0, 36)); // NOI18N
        jLabel3.setText("healthMate");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, 160, -1));

        jLabel39.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel39.setText("Layanan Cepat dan Tepat");
        jPanel3.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, -1, -1));

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel4.setText("Konsultasi Kesehatan terpercaya sejak 2005");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 70, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\OneDrive\\Pictures\\AAA\\admin.png")); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 30, 100, 60));

        jLabel22.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\OneDrive\\Pictures\\AAA\\1.jpg")); // NOI18N
        jLabel22.setText("jLabel21");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1370, -1));

        jTabbedPane2.setBackground(new java.awt.Color(211, 233, 255));
        jTabbedPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detail Konsultasi"));

        jPanel5.setBackground(new java.awt.Color(153, 204, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Nama Dokter", "Spesialis", "Harga"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setBackground(new java.awt.Color(191, 218, 245));
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\Downloads\\plus.png")); // NOI18N
        jButton1.setText("Tambah");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(191, 218, 245));
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\Downloads\\changes.png")); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Id");

        jLabel5.setText("Nama Dokter");

        jLabel6.setText("Spesialis");

        jLabel8.setText("Harga");

        spesial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spesialActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(191, 218, 245));
        delete.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\Downloads\\bin.png")); // NOI18N
        delete.setText("Hapus");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Copyright ©Sarahmanuellaaaa. All rights reserved.");
        jPanel7.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 36, -1, 50));

        jLabel19.setText("Direktorat Jenderal Perlindungan Konsumen dan Tertib Niaga Kementerian Perdagangan Republik Indonesia 0853 1111 1010 (WhatsApp)");
        jPanel7.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, 50));

        jLabel20.setText("PT Media Dokter Investama Jl. H.R. Rasuna Said Kav B32-33, Jakarta Selatan help@halodoc.com / 021-5095-9900");
        jPanel7.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, -4, -1, 50));

        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\OneDrive\\Pictures\\AAA\\1.jpg")); // NOI18N
        jLabel14.setText("jLabel7");
        jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1390, 80));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Copyright ©Sarahmanuellaaaa. All rights reserved.");
        jPanel8.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 36, -1, 50));

        jLabel21.setText("Direktorat Jenderal Perlindungan Konsumen dan Tertib Niaga Kementerian Perdagangan Republik Indonesia 0853 1111 1010 (WhatsApp)");
        jPanel8.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, 50));

        jLabel23.setText("PT Media Dokter Investama Jl. H.R. Rasuna Said Kav B32-33, Jakarta Selatan help@halodoc.com / 021-5095-9900");
        jPanel8.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, -4, -1, 50));

        jLabel17.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\OneDrive\\Pictures\\AAA\\1.jpg")); // NOI18N
        jLabel17.setText("jLabel7");
        jPanel8.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1390, 80));

        delete1.setBackground(new java.awt.Color(191, 218, 245));
        delete1.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\Downloads\\circle-of-two-clockwise-arrows-rotation.png")); // NOI18N
        delete1.setText("Reset");
        delete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete1ActionPerformed(evt);
            }
        });

        delete2.setBackground(new java.awt.Color(191, 218, 245));
        delete2.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\Downloads\\logout (1).png")); // NOI18N
        delete2.setText("Keluar");
        delete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dr))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel6))
                                        .addGap(32, 32, 32)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(spesial)
                                            .addComponent(hrg))))
                                .addGap(233, 233, 233))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(42, 42, 42)
                                .addComponent(jButton1)
                                .addGap(46, 46, 46)
                                .addComponent(delete)
                                .addGap(39, 39, 39)
                                .addComponent(delete1)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel2)
                        .addGap(36, 36, 36)
                        .addComponent(iddokter, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(delete2)
                        .addGap(370, 370, 370))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(iddokter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(dr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(spesial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(hrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(132, 132, 132)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton1)
                            .addComponent(delete)
                            .addComponent(delete1)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addComponent(delete2)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 631, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Dokter", jPanel5);

        jPanel6.setBackground(new java.awt.Color(211, 233, 255));

        jLabel31.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\OneDrive\\Pictures\\AAA\\a1.png")); // NOI18N

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id_detail", "Nama Lengkap", "Umur", "Alergi", "Keluhan", "Jenis Kelamin(p/l)", "Alamat", "TTL", "Tanggal Konsultasi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\OneDrive\\Pictures\\AAA\\Dashboard_with_user_interface_elements_Illustration-removebg-preview.png")); // NOI18N
        jButton4.setText("Lihat Data Pasien");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Copyright ©Sarahmanuellaaaa. All rights reserved.");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 36, -1, 50));

        jLabel16.setText("Direktorat Jenderal Perlindungan Konsumen dan Tertib Niaga Kementerian Perdagangan Republik Indonesia 0853 1111 1010 (WhatsApp)");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, 50));

        jLabel18.setText("PT Media Dokter Investama Jl. H.R. Rasuna Said Kav B32-33, Jakarta Selatan help@halodoc.com / 021-5095-9900");
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, -4, -1, 50));

        jLabel12.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\OneDrive\\Pictures\\AAA\\1.jpg")); // NOI18N
        jLabel12.setText("jLabel7");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1390, 80));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Status Pembayaran", "Lunas", "Tidak Lunas" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addGap(58, 58, 58)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1395, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel31))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(78, 78, 78)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(687, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Pasien", jPanel6);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 725, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HOMEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HOMEMouseClicked
        // TODO add your handling code here:
        HomePage hmpge1 = new HomePage();
        hmpge1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_HOMEMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        loadDataPasien();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        // Confirm deletion
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            deleteDataDokter();
        } else {
            return;
        }

    }//GEN-LAST:event_deleteActionPerformed

    private void spesialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spesialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_spesialActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin memperbaharui data ini?", "Konfirmasi Update", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            updateDataDokter();
        } else if (confirm == JOptionPane.NO_OPTION) {
            return;
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        saveDataDokter();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete1ActionPerformed
        // TODO add your handling code here:
        dr.requestFocus();
        dr.setText("");
        spesial.setText("");
        hrg.setText("");

    }//GEN-LAST:event_delete1ActionPerformed

    private void delete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete2ActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin Keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        } else {
            this.dispose();
        }
    }//GEN-LAST:event_delete2ActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked

    }//GEN-LAST:event_jLabel7MouseClicked

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
    private javax.swing.JLabel HOME;
    private javax.swing.JButton delete;
    private javax.swing.JButton delete1;
    private javax.swing.JButton delete2;
    private javax.swing.JTextField dr;
    private javax.swing.JTextField hrg;
    private javax.swing.JTextField iddokter;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField spesial;
    // End of variables declaration//GEN-END:variables
}
