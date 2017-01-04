/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author vu vuong
 */
public class AdminDAO {
    
    public Admin CheckLogin(String username, String password){
        DataConnect connection = DataConnect.getDataConnect();
        Connection conn = connection.DataConnect();
        PreparedStatement ps;
        ResultSet rs;
        Admin ad = null;
        String sql = "SELECT * FROM tbladmin where username =? and password =?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if(rs.next()){
               int Id =rs.getInt("id");
               String address = rs.getString("address");
               ad = new Admin(Id, username, password, address); 
            }
        } catch (SQLException ex) {
           return ad = null;
        }
        return ad;
    }
    
    public void addAdmin(Admin admin){
        DataConnect connection = DataConnect.getDataConnect();
        Connection conn = connection.DataConnect();
        PreparedStatement ps;
        String sql = "INSERT INTO tbladmin(username, password, address) VALUES(?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, admin.getUsername());
            ps.setString(2, admin.getPassword());
            ps.setString(3, admin.getAddress());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Them admin "+admin.getUsername()+" thanh cong");
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
    public boolean checkUsername(Admin admin){
        
        return false;
    }
}
