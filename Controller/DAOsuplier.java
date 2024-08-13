/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.supplier;
import java.util.ArrayList;
import java.sql.*;
import connection.JDBCUtil;

/**
 *
 * @author Dell
 */
public class DAOsuplier {
    

    
    public  boolean insert(supplier t) {
        Connection conn = JDBCUtil.getConnection();
        int ketqua = 0 ;
    String sql = "INSERT INTO `quan_ly_kho`.`supplier`"
                + "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getId());
            ps.setString(2, t.getName()); 
            ps.setString(3 ,t.getAddress() );
            ps.setString(4, t.getEmail());
            ps.setString(5 ,t.getSdt());
            ketqua = ps.executeUpdate();
            return ketqua>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }

    
    public boolean update(supplier t) {
         Connection conn = JDBCUtil.getConnection();
        int ketqua = 0 ;
    String sql = "UPDATE quan_ly_kho.supplier SET SUP_ID = ?, SUP_NAME= ? , SUP_ADDRESS=?, SUP_EMAIL=?,SUP_SDT=? WHERE SUP_ID=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getId());
            ps.setString(2, t.getName()); 
            ps.setString(3 ,t.getAddress() );
            ps.setString(4, t.getEmail());
            ps.setString(5 ,t.getSdt()); 
            ps.setString(6, t.getId());
            ketqua = ps.executeUpdate();
            return ketqua>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }

    
    public boolean delete(supplier t) {
         Connection conn = JDBCUtil.getConnection();
        String sql = "DELETE FROM quan_ly_kho.supplier WHERE SUP_ID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getId());
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    
    public ArrayList<supplier> selectAll() {
       Connection conn = JDBCUtil.getConnection();
         ArrayList<supplier> list = new ArrayList<>();
        String sql = "SELECT * FROM quan_ly_kho.supplier";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                supplier s = new supplier();
                s.setId(rs.getString("SUP_ID"));
                s.setName(rs.getString("SUP_NAME"));
                s.setAddress(rs.getString("SUP_ADDRESS"));
                s.setEmail(rs.getString("SUP_EMAIL"));
                s.setSdt(rs.getString("SUP_SDT"));
              
                list.add(s);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
}
