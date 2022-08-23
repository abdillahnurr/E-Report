
package pa.e.report;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class koneksi_db {
    Connection con;
    Statement st;
    
    public void koneksi() {
    try {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/db_report","root","");
        st = con.createStatement();
    }catch(Exception e) {
        JOptionPane.showMessageDialog(null, "Koneksi Gagal masuk ke Database!!!\n" + e.getMessage());
    }
  }
}
