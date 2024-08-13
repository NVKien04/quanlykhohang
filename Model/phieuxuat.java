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
public class phieuxuat {
    private String pnID,user_id,cus_code;
   private int quantity,total;
   private Date date;

    public String getPnID() {
        return pnID;
    }

    public void setPnID(String pnID) {
        this.pnID = pnID;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCus_code() {
        return cus_code;
    }

    public void setCus_code(String cus_code) {
        this.cus_code = cus_code;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public phieuxuat() {
    }

    public phieuxuat(String pnID, String user_id, String cus_code, int quantity, int total ,Date date) {
        this.pnID = pnID;
        this.user_id = user_id;
        this.cus_code = cus_code;
        this.quantity = quantity;
        this.total = total;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
