/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienvm.dtos;

import java.io.Serializable;

/**
 *
 * @author TienVM_PC
 */
public class UserDTO implements Serializable{
    private String userID;
    private String password;
    private String userName;
    private String phone;
    private String address;
    private String roleID;
    private String email;

    public UserDTO() {
    }

    public UserDTO(String userID, String userName, String roleID) {
        this.userID = userID;
        this.userName = userName;
        this.roleID = roleID;
    }

    public UserDTO(String userName, String roleID) {
        this.userName = userName;
        this.roleID = roleID;
    }
    public UserDTO(String userID, String password, String userName, String phone, String address, String roleID, String email) {
        this.userID = userID;
        this.password = password;
        this.userName = userName;
        this.phone = phone;
        this.address = address;
        this.roleID = roleID;
        this.email = email;
    }

    public UserDTO(String userID, String password, String userName, String roleID) {
        this.userID = userID;
        this.password = password;
        this.userName = userName;
        this.roleID = roleID;
    }

    public UserDTO(String userID, String userName, String phone, String address, String email) {
        this.userID = userID;
        this.userName = userName;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "userID=" + userID + ", password=" + password + ", userName=" + userName + ", phone=" + phone + ", address=" + address + ", roleID=" + roleID + ", email=" + email + '}';
    }
    
}
