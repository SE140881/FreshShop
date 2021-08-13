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
import tienvm.dtos.ProductDTO;
import tienvm.utils.DBUtils;

/**
 *
 * @author TienVM_PC
 */
public class ProductDAO {
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
    
    public List<ProductDTO> listProduct() throws SQLException{
        List<ProductDTO> list = null;
        ProductDTO pro;
        try {
            String sql = "SELECT productID, productName, quantity, price, image, categoryID "
                    + "FROM tblProducts WHERE Product_status = 1";
            conn = DBUtils.getConnection1();
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            list = new ArrayList<>();
            while(rs.next()){
                String productID = rs.getString("productID");
                String productName = rs.getString("productName");
                String image = rs.getString("image");
                String categoryID = rs.getString("categoryID");
                int quantity = Integer.parseInt(rs.getString("quantity"));
                double price = Double.parseDouble(rs.getString("price"));
                pro = new ProductDTO(productID, productName, price, image, categoryID, quantity);
                list.add(pro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public List<ProductDTO> listProduct01() throws SQLException{
        List<ProductDTO> list = null;
        ProductDTO pro;
        try {
            String sql = "SELECT productID, productName, quantity, price, image, categoryID "
                    + "FROM tblProducts WHERE categoryID = 'P01' AND Product_status = 1";
            conn = DBUtils.getConnection1();
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            list = new ArrayList<>();
            while(rs.next()){
                String productID = rs.getString("productID");
                String productName = rs.getString("productName");
                String image = rs.getString("image");
                String categoryID = rs.getString("categoryID");
                int quantity = Integer.parseInt(rs.getString("quantity"));
                double price = Double.parseDouble(rs.getString("price"));
                pro = new ProductDTO(productID, productName, price, image, categoryID, quantity);
                list.add(pro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public List<ProductDTO> listProduct02() throws SQLException{
        List<ProductDTO> list = null;
        ProductDTO pro;
        try {
            String sql = "SELECT productID, productName, quantity, price, image, categoryID "
                    + "FROM tblProducts WHERE categoryID = 'P02' AND Product_status = 1";
            conn = DBUtils.getConnection1();
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            list = new ArrayList<>();
            while(rs.next()){
                String productID = rs.getString("productID");
                String productName = rs.getString("productName");
                String image = rs.getString("image");
                String categoryID = rs.getString("categoryID");
                int quantity = Integer.parseInt(rs.getString("quantity"));
                double price = Double.parseDouble(rs.getString("price"));
                pro = new ProductDTO(productID, productName, price, image, categoryID, quantity);
                list.add(pro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public List<ProductDTO> findByProductName(String search) throws SQLException {
        List<ProductDTO> list = null;
        ProductDTO pro;
        try {
            String sql = "SELECT productID, productName, quantity, price, image, categoryID "
                    + "FROM tblProducts WHERE productName LIKE ? AND Product_status = 1";
            conn = DBUtils.getConnection1();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, "%" + search + "%");
            rs = pstm.executeQuery();
            list = new ArrayList<>();
            while(rs.next()){
                String productID = rs.getString("productID");
                String productName = rs.getString("productName");
                String image = rs.getString("image");
                String categoryID = rs.getString("categoryID");
                int quantity = Integer.parseInt(rs.getString("quantity"));
                double price = Double.parseDouble(rs.getString("price"));
                pro = new ProductDTO(productID, productName, price, image, categoryID, quantity);
                list.add(pro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public ProductDTO findProductByID(String id, List<ProductDTO> list){
        for (ProductDTO pro : list) {
            if(pro.getProductID().trim().equals(id.trim())){
                return pro;
            }
        }
        return null;
    }
    
    public boolean insertProduct(ProductDTO pro) throws SQLException, ClassNotFoundException{
        boolean check = false;
        try {
            String sql = "INSERT INTO tblProducts(productID, productName, quantity, price, image, categoryID, Product_status) "
                    + "VALUES(?,?,?,?,?,?,1)";
            conn = DBUtils.getConnection1();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, pro.getProductID());
            pstm.setString(2, pro.getProductName());
            pstm.setInt(3, pro.getQuantity());
            pstm.setFloat(4, (float) pro.getPrice());
            pstm.setString(5, pro.getImage());
            pstm.setString(6, pro.getCategoryID());
            check = pstm.executeUpdate()==0?false:true;
        }finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean updateProduct(ProductDTO pro) throws SQLException {
        boolean check = false;
        try {
            String sql = "UPDATE tblProducts set productName = ?, quantity = ?, price = ?, image = ?, categoryID = ? "
                    + "WHERE productID = ?";
            conn = DBUtils.getConnection1();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, pro.getProductName());
            pstm.setInt(2, pro.getQuantity());
            pstm.setFloat(3, (float) pro.getPrice());
            pstm.setString(4, pro.getImage());
            pstm.setString(5, pro.getCategoryID());
            pstm.setString(6, pro.getProductID());
            check = pstm.executeUpdate()==0?false:true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean deleteProduct(String productID) throws SQLException{
        boolean check = false;
        try {
            String sql = "UPDATE tblProducts SET Product_status = 0 WHERE productID = ?";
            conn = DBUtils.getConnection1();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, productID);
            check = pstm.executeUpdate()==0?false:true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }
    
}
