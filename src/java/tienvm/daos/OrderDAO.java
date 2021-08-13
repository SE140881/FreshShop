/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienvm.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import tienvm.utils.DBUtils;

/**
 *
 * @author TienVM_PC
 */
public class OrderDAO {
    private Connection conn = null;
    private PreparedStatement pstm = null;
    private ResultSet rs = null;
    
    public void closeConnection() throws SQLException{
        if(conn != null)
            conn.close();
        if(pstm != null)
            pstm.close();
        if(rs != null)
            rs.close();
    }
    
    public boolean insertOrder(String userID, float total) throws SQLException {
        boolean check = false;
        try {
            String sql = "INSERT INTO tblOrder(userID, date, total) VALUES(?,?,?) ";
            conn = DBUtils.getConnection1();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, userID);
            pstm.setDate(2, Date.valueOf(LocalDate.now()));
            pstm.setFloat(3, total);
            check = pstm.executeUpdate()==0?false:true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public int getIDCart(String userID) throws SQLException{
        int idCart = 0;
        try {
            String sql = "SELECT orderID FROM tblOrder WHERE userID  = ?";
            conn = DBUtils.getConnection1();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, userID);
            rs = pstm.executeQuery();
            while(rs.next()){
                idCart = rs.getInt("orderID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return idCart;
    }
    
}
