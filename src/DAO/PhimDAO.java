/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Phim;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vu vuong
 */
public class PhimDAO {
    DataConnect connection= new DataConnect();
    Connection conn = connection.DataConnect();
    
    /* Method them phim*
    @param Object Phim
    */
    public void ThemPhim(Phim phim){
        String sql = "INSERT INTO tblphim(tenphim,daodien,dienvien,theloai,noidung,namsanxuat, quocgia) VALUES (?,?,?,?,?,?,?)"  ;
         PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, phim.getName());
            ps.setString(2, phim.getDirector());
            ps.setString(3, phim.getActor());
            ps.setString(4, phim.getGenre());
            ps.setString(5, phim.getDescription());
            ps.setInt(6, phim.getNamSanXuat());
            ps.setString(7, phim.getCountry());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhimDAO.class.getName()).log(Level.SEVERE, null, ex);
        }                
    }
    public boolean checkTenPhim(String tenPhim){
        PreparedStatement ps1;
        ResultSet rs1;
        String sql = "SELECT tenphim from tblphim where tenphim = ?";
        try {
            ps1 = conn.prepareStatement(sql);
            ps1.setString(1, tenPhim);
            rs1 = ps1.executeQuery();
            if(rs1.next()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhimDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
