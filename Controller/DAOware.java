/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.ware;
import java.util.ArrayList;
import java.sql.*;
import connection.JDBCUtil;
/**
 *
 * @author Dell
 */
public class DAOware implements DaoInterFace<ware> {
      
    public static DAOware getInstance(){
        return new DAOware();
    }

    @Override
    public int insert(ware t) {
        Connection conn = JDBCUtil.getConnection();
        int ketqua = 0 ;
    String sql = "INSERT INTO `quan_ly_kho`.`warehouse`"
                + "VALUES(?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getId());
            ps.setString(2, t.getName()); 
            ps.setString(3 ,t.getAddress() );  
            ketqua = ps.executeUpdate();
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ketqua;
    }

    @Override
    public int update(ware t) {
         Connection conn = JDBCUtil.getConnection();
        int ketqua = 0 ;
    String sql = "UPDATE quan_ly_kho.warehouse SET WH_ID = ?, WH_NAME= ? , WH_ADDRESS=?"
                + " WHERE WH_ID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getId());
            ps.setString(2, t.getName()); 
            ps.setString(3 ,t.getAddress() );
            ps.setString(4, t.getId());
            ketqua = ps.executeUpdate();
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ketqua;
    }

    @Override
    public int delete(ware t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<ware> selectAll() {
        Connection conn = JDBCUtil.getConnection();
         ArrayList<ware> list = new ArrayList<>();
        String sql = "SELECT * FROM quan_ly_kho.users";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ware s = new ware();
                s.setId(rs.getString("WH_ID"));
                s.setName(rs.getString("WH_NAME"));
                s.setAddress(rs.getString("WH_ADDRESS"));
                list.add(s);
                JDBCUtil.closeConnection(conn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
}
