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

/**
 *
 * @author vu vuong
 */
public class AdminDAO {
    DataConnect connection= new DataConnect();
    Connection conn = connection.DataConnect();
    public static PreparedStatement ps;
    public static ResultSet rs;
    public Admin CheckLogin(String username, String password){
        Admin ad = null;
        String sql = "SELECT * FROM tbladmin where username =? and password =?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if(rs.next()){
               ad = new Admin(); 
            }
        } catch (SQLException ex) {
           return ad = null;
        }
        return ad;
    }
}
