/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.Date;

/**
 *
 * @author Dell
 */
public class phieunhap {
    private String pxID,user_id,tonkho_id;
    private int quantity;
    private Date date;
    public phieunhap(String pxID, String user_id, int quantity,String tonkho_id, Date date) {
        this.pxID = pxID;
        this.user_id = user_id;
        this.tonkho_id = tonkho_id;
        this.quantity = quantity;
        this.date = date ;
    }

    public String getTonkho_id() {
        return tonkho_id;
    }

    public void setTonkho_id(String tonkho_id) {
        this.tonkho_id = tonkho_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

   

    public phieunhap() {
    }

    public String getPxID() {
        return pxID;
    }

    public void setPxID(String pxID) {
        this.pxID = pxID;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
   
}
