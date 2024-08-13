/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.product;
import connection.JDBCUtil;

/**
 *
 * @author Dell
 */
public class DAO{
    /*private Connection conn;
    public DAO(){
        
         try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url = "jdbc:mysql://localhost:3306/Quan_Ly_Kho";
            String user = "root";
            String password = "123456";
            
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }*/
    Connection conn = JDBCUtil.getConnection();
    
    public boolean addProduct(product p){
        
        String sql = "INSERT INTO `quan_ly_kho`.`product`"
                + "VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getId());
            ps.setString(2, p.getName()); 
            ps.setString(3 ,p.getPrice() );
            ps.setString(4, p.getOs());
            ps.setString(5,p.getOs());
            ps.setString(6, p.getSupplier());
            ps.setString(7, p.getWareHouse());
            
            return ps.executeUpdate() > 0;  
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public ArrayList<product> getListProduct(){
        ArrayList<product> list = new ArrayList<>();
        String sql = "SELECT * FROM quan_ly_kho.product";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                product s = new product();
                s.setId(rs.getString("PRO_ID"));
                s.setName(rs.getString("PRO_NAME"));    
                s.setPrice(rs.getString("PRO_PRICE"));
                s.setBrand(rs.getString("PRO_BRAND"));
                s.setOs(rs.getString("PRO_OS"));
                s.setSupplier(rs.getString("SUP_ID"));
                s.setWareHouse(rs.getString("WH_ID"));
                
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    public boolean updateProduct(product p){
        
        String sql = "UPDATE quan_ly_kho.product SET PRO_ID = ?, PRO_NAME= ? , PRO_PRICE=?"
                + ",PRO_BRAND = ? , PRO_OS = ?,SUP_ID=?,WH_ID=? WHERE PRO_ID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getId());
            ps.setString(2, p.getName());            
            ps.setString(3 ,p.getPrice() );
            ps.setString(4, p.getOs());
            ps.setString(5,p.getOs());
            ps.setString(6, p.getSupplier());
            ps.setString(7, p.getWareHouse());
            ps.setString(8, p.getId());
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public boolean deleteProduct(product p){
        
        String sql = "DELETE FROM quan_ly_kho.product WHERE PRO_ID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getId());
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static void main(String[] args) {
        
    }
    
}
