/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienvm.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import tienvm.dtos.OrderDetailDTO;
import tienvm.utils.DBUtils;

/**
 *
 * @author TienVM_PC
 */
public class OrderDetailDAO {
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
    
    public boolean insertOrderDetail(OrderDetailDTO detail) throws SQLException {
        boolean check = false;
        try {
            String sql = "INSERT INTO tblOrderDetails(productID, orderID, price, quantity) "
                    + "VALUES(?,?,?,?)";
            conn = DBUtils.getConnection1();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, detail.getProductID());
            pstm.setInt(2, detail.getOrderID());
            pstm.setDouble(3, detail.getPrice());
            pstm.setInt(4, detail.getQuantity());
            check = pstm.executeUpdate()==0?false:true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }
    
}
