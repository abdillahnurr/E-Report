/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa.e.report;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    private Statement St;
    private Connection Con;
    private ResultSet Rs; 
    private String sql="";
    public static String viewName ;
    public Login() {
        initComponents();
        koneksi_db data = new koneksi_db();
        data.koneksi();
        Con = data.con;
        St = data.st;
        viewName = idLogin.getText();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(
        (screenSize.width - frameSize.width) / 2,
        (screenSize.height - frameSize.height) / 2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        idLogin = new javax.swing.JTextField();
        passLogin = new javax.swing.JPasswordField();
        loginBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1133, 744));

        jPanel1.setLayout(null);
        jPanel1.add(idLogin);
        idLogin.setBounds(440, 332, 240, 30);
        jPanel1.add(passLogin);
        passLogin.setBounds(440, 415, 240, 30);

        loginBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background/loginbtn.png"))); // NOI18N
        loginBtn.setName(""); // NOI18N
        loginBtn.setOpaque(false);
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });
        jPanel1.add(loginBtn);
        loginBtn.setBounds(490, 490, 150, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background/pbo_001.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1130, 750);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1130, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        
        try{
            St = Con.createStatement();
            Rs = St.executeQuery("select * from akun where "+"username='"+idLogin.getText()+"'");
            String userType = "Siswa";
            String staff = "admin";
            String guru = "Guru";
            if(Rs.next()){
                if (passLogin.getText().equals(Rs.getString("password"))) {
                    if (userType.equals(Rs.getString("role"))) {
                        String namaDisplay = Rs.getString("nama");
                    JOptionPane.showMessageDialog(rootPane, "Selamat Datang " + namaDisplay);
                    viewName = idLogin.getText();
                    this.setVisible(false);
                    Siswa objL = new Siswa();
                    objL.setVisible(true);
                    }else if(guru.equals(Rs.getString("role"))){
                        String namaDisplay = Rs.getString("nama");
                    JOptionPane.showMessageDialog(rootPane, "Selamat Datang " + namaDisplay);
                    viewName = idLogin.getText();
        
                    this.setVisible(false);
                    Guru objL = new Guru();
                    objL.setVisible(true);
                    }
                    else {
                    String namaDisplay = Rs.getString("nama");
                    JOptionPane.showMessageDialog(rootPane, "Selamat Datang " + namaDisplay);
                    viewName = idLogin.getText();
                    this.setVisible(false);
                    Staff objL = new Staff();
                    objL.setVisible(true);
                    
                }
            }else {
                JOptionPane.showMessageDialog(rootPane, "Password Salah");
                passLogin.setText("");
                passLogin.requestFocus();
                }
                }else {
                    JOptionPane.showMessageDialog(rootPane, "Username Salah");
                    idLogin.setText("");
                    idLogin.requestFocus();
            }
                    
        } catch (Exception e){
            e.printStackTrace();
        }

    }//GEN-LAST:event_loginBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField idLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPasswordField passLogin;
    // End of variables declaration//GEN-END:variables
//    public String nama(){
//        
//        
//        
//    }
}
