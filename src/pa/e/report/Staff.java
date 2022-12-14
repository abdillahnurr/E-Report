/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa.e.report;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax. swing.table.DefaultTableModel;
/**
 *
 * @author Dooo
 */
public class Staff extends javax.swing.JFrame {

    private Statement st;
    private Connection con;
    private ResultSet rs; 
    DefaultTableModel model;
    public Staff() {
        initComponents();
        koneksi_db data = new koneksi_db();
        data.koneksi();
        con = data.con;
        st = data.st;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(
        (screenSize.width - frameSize.width) / 2,
        (screenSize.height - frameSize.height) / 2);
        String[] judul = {"NAMA","USERNAME","PASSWORD","ROLE"};
        model = new DefaultTableModel(judul,0);
        tabelAkun.setModel(model);
        tampilkan();
    }
    private void ubahData(){
        String nama = namaUser.getText();
        String uName = username.getText();
        String pass = password.getText();
        String role = "";
        
        if(guru.isSelected()){
                role = "Guru";
            }else if(siswa.isSelected()){
                role = "Siswa";
            }else{
                role = "";
            }
        try {
            st = con.createStatement();
            
            
            String sql = "UPDATE `akun` SET nama ='"+nama+"',password='"+pass+"',role='"+role+"' WHERE username='"+uName+"' ";
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Berhasil Diubah");
            tampilkan();
            
            clearField();
            } catch (SQLException e) {
                e.printStackTrace();
            } 
        
    }
    private void tambahData(){
        String nama = namaUser.getText();
        String uName = username.getText();
        String pass = password.getText();
        String role = "";
        
        if(guru.isSelected()){
                role = "Guru";
            }else if(siswa.isSelected()){
                role = "Siswa";
            }else{
                role = "";
            }
        try {
            st = con.createStatement();
            
            
            String sql = "INSERT INTO `akun` VALUES"+"('"+nama+"','"+uName+"','"+pass+"','"+role+"')";
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Berhasil Ditambahkan");
            tampilkan();
            
            clearField();
            } catch (SQLException e) {
                e.printStackTrace();
            } 
        
    }
    private void hapusData(){
            String[] options = {"Yes", "No"};
            JOptionPane.showOptionDialog(null, "Yakin Hapus Data Ini??", "Delete Confirm", 
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

            String uName = username.getText();

            try {

            st = con.createStatement();
            String sqlUpdate = "DELETE FROM akun WHERE username='"+uName+"'";
            st.executeUpdate(sqlUpdate);
           
            clearField();
            

        JOptionPane.showMessageDialog(null, "Data Dihapus dari Database");
        tampilkan();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus " + e.getMessage());
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        namaUser = new javax.swing.JTextField();
        username = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        guru = new javax.swing.JRadioButton();
        siswa = new javax.swing.JRadioButton();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelAkun = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1133, 744));

        jPanel2.setLayout(null);
        jPanel2.add(namaUser);
        namaUser.setBounds(470, 251, 340, 25);
        jPanel2.add(username);
        username.setBounds(470, 291, 340, 25);
        jPanel2.add(password);
        password.setBounds(470, 331, 340, 25);

        buttonGroup1.add(guru);
        guru.setText("Guru");
        jPanel2.add(guru);
        guru.setBounds(470, 370, 55, 25);

        buttonGroup1.add(siswa);
        siswa.setText("Siswa");
        jPanel2.add(siswa);
        siswa.setBounds(610, 370, 63, 25);

        btnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background/tbhBtn.png"))); // NOI18N
        btnTambah.setText("jButton1");
        btnTambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahMouseClicked(evt);
            }
        });
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        jPanel2.add(btnTambah);
        btnTambah.setBounds(389, 450, 140, 30);

        btnUbah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background/ubahBtn.png"))); // NOI18N
        btnUbah.setText("jButton2");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });
        jPanel2.add(btnUbah);
        btnUbah.setBounds(630, 453, 140, 20);

        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background/hapusBtn.png"))); // NOI18N
        btnHapus.setText("jButton3");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel2.add(btnHapus);
        btnHapus.setBounds(390, 510, 140, 30);

        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background/logoutBtn.png"))); // NOI18N
        btnLogout.setText("jButton1");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jPanel2.add(btnLogout);
        btnLogout.setBounds(640, 510, 130, 30);

        tabelAkun.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelAkun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelAkunMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelAkun);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(0, 550, 1110, 150);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background/pbo_002.png"))); // NOI18N
        jPanel2.add(jLabel2);
        jLabel2.setBounds(1, -4, 1130, 750);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1111, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        tambahData();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnTambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseClicked

    }//GEN-LAST:event_btnTambahMouseClicked

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        ubahData();
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        hapusData();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void tabelAkunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelAkunMouseClicked
        DefaultTableModel model = (DefaultTableModel) tabelAkun.getModel();
        int row = tabelAkun.getSelectedRow();
        int col = tabelAkun.getColumnCount();

        namaUser.setText(model.getValueAt(row,0).toString());
        username.setText(model.getValueAt(row,1).toString());
        password.setText(model.getValueAt(row,2).toString());
        String role = model.getValueAt(row, 3).toString();
        for (int i = 0;i<(buttonGroup1.getButtonCount());i++){
            if(role.equalsIgnoreCase(guru.getText())){
                guru.setSelected(rootPaneCheckingEnabled);
            }else if(role.equalsIgnoreCase(siswa.getText())){
                siswa.setSelected(rootPaneCheckingEnabled);
            }
            else{
                buttonGroup1.clearSelection();
            }
        }
        
        tabelAkun.setDefaultEditor(Object.class, null);
    }//GEN-LAST:event_tabelAkunMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Staff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton guru;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField namaUser;
    private javax.swing.JTextField password;
    private javax.swing.JRadioButton siswa;
    private javax.swing.JTable tabelAkun;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
    private void tampilkan() {
        int row = tabelAkun.getRowCount();
        for (int i = 0;i<row;i++){
            model.removeRow(0);
        }
        try {
        st = con.createStatement();
        rs = st.executeQuery("SELECT * FROM `akun`");
        while(rs.next()){
            String[] data = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)};
            model.addRow(data);
        }
        if (con != null) {
            JOptionPane.showMessageDialog(null, "Wait Connecting Database");
        }
        } catch (Exception e) {
            e.printStackTrace();
      }
    }
    private void clearField(){
        namaUser.requestFocus();
        namaUser.setText("");
        username.setText("");
        password.setText("");
        buttonGroup1.clearSelection();
    }
}
