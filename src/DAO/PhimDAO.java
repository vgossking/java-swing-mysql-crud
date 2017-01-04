/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Phim;
import Model.ThongKeTheLoai;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vu vuong
 */
public class PhimDAO {
    
    
    /* Method them phim*
    @param Object Phim
    */
    public void ThemPhim(Phim phim){
        DataConnect connection= DataConnect.getDataConnect();
        Connection conn = connection.DataConnect();
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
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PhimDAO.class.getName()).log(Level.SEVERE, null, ex);
        }                
    }
    /*
    Method check ten phim
    @param ten phim
    */
    public boolean checkTenPhim(String tenPhim){
        DataConnect connection= DataConnect.getDataConnect();
        Connection conn = connection.DataConnect();
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
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PhimDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    /*
    Method tim phim
    @param tenphim
    Return a list of object phim
    */
    public List<Phim> timPhim(String tenPhim){
        DataConnect connection= DataConnect.getDataConnect();
        Connection conn = connection.DataConnect();
        PreparedStatement ps;
        ResultSet rs;
        List<Phim> listPhim = new ArrayList<Phim>();
        String sql ="SELECT * FROM tblphim WHERE tenphim LIKE '%"+tenPhim+"%'";
        try {
            ps = conn.prepareStatement(sql);
           // ps.setString(1, tenPhim);
            rs = ps.executeQuery();
            while(rs.next()){
                int id =rs.getInt("id");
                String ten = rs.getString("tenphim");
                String daoDien = rs.getString("daodien");
                String noiDung = rs.getString("noidung");
                String theLoai = rs.getString("theloai");
                String dienVien = rs.getString("dienvien");
                int namSanXuat = rs.getInt("namsanxuat");
                String quocGia = rs.getString("quocGia");
                listPhim.add(new Phim(id, ten, dienVien, theLoai, namSanXuat, daoDien, noiDung, quocGia));
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PhimDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listPhim;
    }
    
    public List<ThongKeTheLoai> thongKeTheLoai(){
        DataConnect connection= DataConnect.getDataConnect();
        Connection conn = connection.DataConnect();
        List<ThongKeTheLoai> lisThongKe = new ArrayList<ThongKeTheLoai>();
        PreparedStatement ps;
        ResultSet rs;
        String sql = "SELECT theloai, COUNT(*) AS soPhim FROM tblphim GROUP BY theloai ORDER BY soPhim DESC, theLoai";
        try {
            ps =conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                String theLoai = rs.getString("theloai");
                int soPhim = rs.getInt("soPhim");
                lisThongKe.add(new ThongKeTheLoai(theLoai, soPhim));
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PhimDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lisThongKe;
    }
    /*
    Method Sua Phim
    @Param Object Phim
    */
    public void SuaPhim(Phim phim){
        DataConnect connection = DataConnect.getDataConnect();
        Connection conn = connection.DataConnect();
        PreparedStatement ps;
        String sql = "UPDATE tblphim SET tenphim =?, daodien =?, dienvien=?, theloai=?, noidung=?, namsanxuat=?,quocgia=? WHERE id =?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, phim.getName());
            ps.setString(2, phim.getDirector());
            ps.setString(3, phim.getActor());
            ps.setString(4, phim.getGenre());
            ps.setString(5, phim.getDescription());
            ps.setInt(6, phim.getNamSanXuat());
            ps.setString(7, phim.getCountry());
            ps.setInt(8, phim.getId());
            ps.executeUpdate();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(PhimDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
    Method xoa phim
    @param phim ID
    */
    public void XoaPhim(int ID){
        DataConnect connection = DataConnect.getDataConnect();
        Connection conn = connection.DataConnect();
        PreparedStatement ps;
        String sql ="DELETE FROM tblphim WHERE id = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, ID);
            ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PhimDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
