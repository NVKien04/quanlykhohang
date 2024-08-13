/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.employee;
import java.util.ArrayList;
import java.sql.*;
import connection.JDBCUtil;
/**
 *
 * @author Dell
 */
public class DAOemployee{
    
    
    
    public boolean insert(employee t) {
        Connection conn1 = JDBCUtil.getConnection();
        int ketqua = 0 ;
    String sql = "INSERT INTO `quan_ly_kho`.`employee`"
                + "VALUES(?,?,?,?,?,?)";
        try {
           
            PreparedStatement ps = conn1.prepareStatement(sql);
            ps.setString(1, t.getCode());
            ps.setString(2, t.getName()); 
            ps.setString(3 ,t.getGender() );
            ps.setString(4, t.getPosition());
            ps.setString(5 ,t.getPhone() );
            ps.setString(6, t.getEmail());
           
            
            ketqua = ps.executeUpdate();
            
            return ketqua>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }

    
    public boolean update(employee t) {
       Connection conn = JDBCUtil.getConnection();
        int ketqua = 0 ;
    String sql = "UPDATE `quan_ly_kho`.`employee` SET EMP_CODE = ?, EMP_NAME= ? , EMP_GENDER=?, EMP_POSITION=?,EMP_PHONE=?,EMP_EMAIL=? WHERE EMP_CODE = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getCode());
            ps.setString(2, t.getName()); 
            ps.setString(3 ,t.getGender() );
            ps.setString(4, t.getPosition());
            ps.setString(5 ,t.getPhone() );
            ps.setString(6, t.getEmail());
            ps.setString(7, t.getCode());
            ketqua = ps.executeUpdate();
            
            return ketqua>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }

    
    public boolean delete(employee t) {
        Connection conn = JDBCUtil.getConnection();
        String sql = "DELETE FROM quan_ly_kho.employee WHERE EMP_CODE = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getCode());
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
        
    }
        

  
    public ArrayList<employee> selectAll() {
         Connection conn1 = JDBCUtil.getConnection();
         ArrayList<employee> list = new ArrayList<>();
        String sql = "SELECT * FROM quan_ly_kho.employee";
        
        try {
            PreparedStatement ps = conn1.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                employee e = new employee();
                e.setCode(rs.getString("EMP_CODE"));
                e.setName(rs.getString("EMP_NAME"));
                e.setGender(rs.getString("EMP_GENDER"));
                e.setPosition(rs.getString("EMP_POSITION"));
                e.setPhone(rs.getString("EMP_PHONE"));
                e.setEmail(rs.getString("EMP_EMAIL"));
                list.add(e);
                
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return list;
    }
    
}
