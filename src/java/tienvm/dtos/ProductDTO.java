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
public class ProductDTO implements Serializable{
    private String productID;
    private String productName;
    private double price;
    private String image;
    private String categoryID;
    private int quantity;
    private boolean status;
    

    public ProductDTO() {
    }

    public ProductDTO(String productID, String productName, double price, String image, String categoryID, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.image = image;
        this.categoryID = categoryID;
        this.quantity = quantity;
    }

    public ProductDTO(String productID, String productName, double price, String image, String categoryID, int quantity, boolean status) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.image = image;
        this.categoryID = categoryID;
        this.quantity = quantity;
        this.status = status;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ProductDTO{" + "productID=" + productID + ", productName=" + productName + ", price=" + price + ", image=" + image + ", categoryID=" + categoryID + ", quantity=" + quantity + '}';
    }

    
}
