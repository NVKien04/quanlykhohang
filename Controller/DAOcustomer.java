/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayList;
import java.sql.*;

import java.util.logging.Level;
import java.util.logging.Logger;
import Model.customer;
import Model.product;
import connection.JDBCUtil;

/**
 *
 * @author Dell
 */
public class DAOcustomer{
    public boolean insert(customer c) {
        Connection conn = JDBCUtil.getConnection();
        int ketqua = 0 ;
    String sql = "INSERT INTO `quan_ly_kho`.`customer`"
                + "VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, c.getCode());
            ps.setString(2, c.getName()); 
            ps.setString(3 ,c.getPhone() );
            ps.setString(4, c.getEmail());
           
            
            ketqua = ps.executeUpdate();
            JDBCUtil.closeConnection(conn);
            return ketqua>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }

   
    public boolean update(customer c) {
Connection conn = JDBCUtil.getConnection();
        int ketqua = 0 ;
    String sql = "UPDATE quan_ly_kho.customer SET CUS_CODE = ?, CUS_NAME= ? , CUS_PHONE=?"
                + ",CUS_EMAIL = ? WHERE CUS_CODE = ? ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, c.getCode());
            ps.setString(2, c.getName()); 
            ps.setString(3 ,c.getPhone() );
            ps.setString(4, c.getEmail());
            ps.setString(5, c.getCode());
            ketqua = ps.executeUpdate();
            JDBCUtil.closeConnection(conn);
            return ketqua>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }

   
    public boolean delete(customer c) {
       Connection conn = JDBCUtil.getConnection();
        int ketqua = 0 ;
    String sql = "DELETE FROM quan_ly_kho.customer WHERE CUS_CODE = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, c.getCode()); 
            ketqua = ps.executeUpdate();
            JDBCUtil.closeConnection(conn);
            return ketqua>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }

  
    public ArrayList<customer> selectAll() {
        Connection conn = JDBCUtil.getConnection();
         ArrayList<customer> list = new ArrayList<>();
        String sql = "SELECT * FROM quan_ly_kho.customer";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                customer s = new customer();
                s.setCode(rs.getString("CUS_CODE"));
                s.setName(rs.getString("CUS_NAME"));
                s.setPhone(rs.getString("CUS_PHONE"));
                s.setEmail(rs.getString("CUS_EMAIL"));
              
                list.add(s);
                JDBCUtil.closeConnection(conn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
