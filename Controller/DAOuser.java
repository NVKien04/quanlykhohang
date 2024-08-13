/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.user;
import java.util.ArrayList;
import java.sql.*;
import connection.JDBCUtil;
/**
 *
 * @author Dell
 */
public class DAOuser implements DaoInterFace<user>{
    public static DAOuser getInstance(){
        return new DAOuser();
    }
    @Override
    public int insert(user t) {
 Connection conn = JDBCUtil.getConnection();
        int ketqua = 0 ;
    String sql = "INSERT INTO `quan_ly_kho`.`users`"
                + "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getId());
            ps.setString(2, t.getName()); 
            ps.setString(3 ,t.getPassword() );
            ps.setString(4, t.getEmail());
            ps.setString(5, t.getWh_id());
            
            ketqua = ps.executeUpdate();
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ketqua;
    }

    @Override
    public int update(user t) {
        Connection conn = JDBCUtil.getConnection();
        int ketqua = 0 ;
    String sql = "UPDATE quan_ly_kho.users SET USER_ID = ?, USER_NAME= ? , USER_PASSWORD=?"
                + ",USER_EMAIL = ? ,WH_ID=? WHERE USER_ID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getId());
            ps.setString(2, t.getName()); 
            ps.setString(3 ,t.getPassword() );
            ps.setString(4, t.getEmail());
            ps.setString(5, t.getWh_id());
            ps.setString(6, t.getId());
            ketqua = ps.executeUpdate();
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ketqua;
    }

    @Override
    public int delete(user t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<user> selectAll() {
         Connection conn = JDBCUtil.getConnection();
         ArrayList<user> list = new ArrayList<>();
        String sql = "SELECT * FROM quan_ly_kho.users";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                user s = new user();
                s.setId(rs.getString("USER_ID"));
                s.setName(rs.getString("USER_NAME"));
                s.setPassword(rs.getString("PASSWORD_PHONE"));
                s.setEmail(rs.getString("USER_EMAIL"));
                s.setWh_id(rs.getString("WH_ID"));
              
                list.add(s);
                JDBCUtil.closeConnection(conn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
}
