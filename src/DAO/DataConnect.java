/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author admin-pc
 */
public class DataConnect {
    private Connection conn;    
    
    private static DataConnect dataConnect = new DataConnect();
    
    public static DataConnect getDataConnect(){
        return dataConnect;
    }
    public Connection DataConnect(){
        String dbHost = "localhost";
        String dbName = "quanlyphim";
        String dbUser = "root";
        String dbPassword = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://" + dbHost + ":3306/" + dbName;
            try {
                conn = DriverManager.getConnection(connectionUrl,dbUser,dbPassword);              
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Cannot connect to db");
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Cannot find JDBC");
        }
        return conn;
    }
}
