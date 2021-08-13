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
import tienvm.dtos.UserDTO;
import tienvm.utils.DBUtils;

/**
 *
 * @author TienVM_PC
 */
public class UserDAO {
    private Connection conn = null;
    private PreparedStatement pstm = null;
    private ResultSet rs = null;
    
    public void closeConnection() throws SQLException {
        if(conn != null)
            conn.close();
        if(pstm != null)
            pstm.close();
        if(rs != null)
            rs.close();
    }
    
    public UserDTO checkLogin(String userID, String password) throws SQLException{
        UserDTO user = null;
        try {
            conn = DBUtils.getConnection1();
            if(conn != null) {
                String sql = "SELECT userID, userName, roleID FROM tblUser WHERE userID = ? AND password = ?";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, userID);
                pstm.setString(2, password);
                rs = pstm.executeQuery();
                if(rs.next()){
                    String id = rs.getString("userID");
                    String userName = rs.getString("userName");
                    String roleID = rs.getString("roleID");
                    user = new UserDTO(id, userName, roleID);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return user;
    }
    
    public List<UserDTO> listUser() throws SQLException{
        List<UserDTO> list = null;
        UserDTO user;
        try {
            String sql = "SELECT userID, userName, phone, address, password, roleID, email "
                    + " FROM tblUser";
            conn = DBUtils.getConnection1();
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            list = new ArrayList<>();
            while(rs.next()) {
                String userID = rs.getString("userID");
                String userName = rs.getString("userName");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String password = rs.getString("password");
                String roleID = rs.getString("roleID");
                String email = rs.getString("email");
                user = new UserDTO(userID, password, userName, phone, address, roleID, email);
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public List<UserDTO> findByFullName(String search) throws SQLException {
        List<UserDTO> listUser = null;
        UserDTO user;
        try {
            String sql = "SELECT userID, userName, phone, address, password, roleID, email "
                    + "FROM tblUser WHERE userName LIKE ?";
            conn = DBUtils.getConnection1();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, "%" + search +"%");
            rs = pstm.executeQuery();
            listUser = new ArrayList<>();
            while(rs.next()){
                String userID = rs.getString("userID");
                String userName = rs.getString("userName");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String password = rs.getString("password");
                String roleID = rs.getString("roleID");
                String email = rs.getString("email");
                user = new UserDTO(userID, password, userName, phone, address, roleID, email);
                listUser.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return listUser;
    }
    
    public boolean insertUser(UserDTO user) throws SQLException, ClassNotFoundException {
        boolean check = false;
        try {
            String sql = "INSERT INTO tblUser(userID, userName, phone, address, password, roleID, email) "
                    + "VALUES(?,?,?,?,?,'US',?)";
            conn = DBUtils.getConnection1();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, user.getUserID());
            pstm.setString(2, user.getUserName());
            pstm.setString(3, user.getPhone());
            pstm.setString(4, user.getAddress());
            pstm.setString(5, user.getPassword());
            pstm.setString(6, user.getEmail());
            check = pstm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean updateUser(UserDTO user) throws SQLException{
        boolean check = false;
        try {
            String sql = "UPDATE tblUser set userName = ?, phone = ?, address = ?, password = ?, roleID = ?, email = ? "
                    + "WHERE userID = ?";
            conn = DBUtils.getConnection1();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, user.getUserName());
            pstm.setString(2, user.getPhone());
            pstm.setString(3, user.getAddress());
            pstm.setString(4, user.getPassword());
            pstm.setString(5, user.getRoleID());
            pstm.setString(6, user.getEmail());
            pstm.setString(7, user.getUserID());
            check = pstm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean deleteUser(String userID) throws SQLException{
        boolean check = false;
        try {
            String sql = "DELETE FROM tblUser WHERE userID = ?";
            conn = DBUtils.getConnection1();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, userID);
            check = pstm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public UserDTO findByPrimaryKey(String userID) throws SQLException {
        UserDTO user = null;
        try {
            String sql = "SELECT userName, phone, email, address FROM tblUser "
                    + "WHERE userID = ?";
            conn = DBUtils.getConnection1();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, userID);
            rs = pstm.executeQuery();
            if(rs.next()){
                String userName = rs.getString("userName");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String address = rs.getString("address");
                user = new UserDTO(userID, userName, phone, address, email);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return user;
    }
}
