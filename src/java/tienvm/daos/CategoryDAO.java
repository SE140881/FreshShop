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
import java.util.ArrayList;
import java.util.List;
import tienvm.dtos.CategoryDTO;
import tienvm.utils.DBUtils;

/**
 *
 * @author TienVM_PC
 */
public class CategoryDAO {
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
    
    public List<CategoryDTO> listCategory() throws SQLException{
        List<CategoryDTO> list = null;
        try {
            String sql = "SELECT categoryID, categoryName FROM tblCategory "
                    + "WHERE Category_status = 'True'";
            conn = DBUtils.getConnection1();
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            list = new ArrayList<>();
            while(rs.next()){
                String categoryID = rs.getString("categoryID");
                String categoryName = rs.getString("categoryName");
                CategoryDTO cate = new CategoryDTO(categoryID, categoryName);
                list.add(cate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }
    
}
