/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasAkhir;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Ahsin Fauzi
 */
public class TugasAkhir {
    Connection con;
    Statement stm;
    private static Connection mysqlconfig;
    public void login(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/db_ka", "root", "");
            stm = con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "koneksi gagal "+e.getMessage());
            System.err.println("koneksi gagal" +e.getMessage());
        }
        
    }
    public static Connection config()throws SQLException{
        try {
            String url ="jdbc:mysql://localhost/db_ka";
            String user="root";
            String pass="";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            mysqlconfig = DriverManager.getConnection(url,user,pass);
            System.out.println("koneksi berhasil;");
        } catch (Exception e) {
            System.err.println("koneksi gagal" +e.getMessage());
        }
        return mysqlconfig;
    }
    
}
