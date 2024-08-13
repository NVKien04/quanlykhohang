/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.phieunhap;
import java.util.ArrayList;
import connection.JDBCUtil;
import java.sql.*;
import java.sql.Date;
/**
 *
 * @author Dell
 */
public class DAOphieunhap {
    
    public boolean insert(phieunhap t) {
        Connection conn = JDBCUtil.getConnection();
        int ketqua = 0 ;
    String sql = "INSERT INTO `quan_ly_kho`.`phieunhap`"
                + "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getPxID());
            ps.setString(2, t.getUser_id()); 
            ps.setInt(3 ,t.getQuantity() );
            ps.setString(4,t.getTonkho_id());
            ps.setDate(5,new Date(t.getDate().getTime()));
           
            
            ketqua = ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }

    
    public boolean update(phieunhap t) {
         Connection conn = JDBCUtil.getConnection();
        int ketqua = 0 ;
   String sql = "UPDATE quan_ly_kho.phieunhap SET PhieuNhap_ID = ?, USER_ID = ? , PhieuNhap_QUANTITY=?"
                + ",TonKho_id = ? , PhieuNhap_date = ? WHERE PhieuNhap_ID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getPxID());
            ps.setString(2, t.getUser_id()); 
            ps.setInt(3 ,t.getQuantity() );
            ps.setString(4,t.getTonkho_id());
            ps.setDate(5,new Date(t.getDate().getTime()));
            ps.setString(6, t.getPxID());
            
            ketqua = ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }

    
    public boolean delete(phieunhap t) {
        Connection conn = JDBCUtil.getConnection();
         String sql = "DELETE FROM quan_ly_kho.phieunhap WHERE PhieuNhap_ID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getPxID());
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    
    public ArrayList<phieunhap> selectAll() {
        Connection conn = JDBCUtil.getConnection();
         ArrayList<phieunhap> listphieunhap = new ArrayList<>();
        String sql = "SELECT * FROM quan_ly_kho.phieunhap";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                phieunhap s = new phieunhap();
                s.setPxID(rs.getString("PhieuNhap_ID"));
                s.setUser_id(rs.getString("USER_ID"));    
                s.setQuantity(rs.getInt("PhieuNhap_QUANTITY"));
                s.setTonkho_id(rs.getString("TonKho_id"));
                s.setDate(rs.getDate("PhieuNhap_date"));       
                listphieunhap.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return listphieunhap;
        
    }
    
}
