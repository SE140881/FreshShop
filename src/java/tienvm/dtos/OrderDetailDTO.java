/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienvm.dtos;

/**
 *
 * @author TienVM_PC
 */
public class OrderDetailDTO {
    private String productID;
    private int orderID;
    private double price;
    private int quantity;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(String productID, int orderID, double price, int quantity) {
        this.productID = productID;
        this.orderID = orderID;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderDetailDTO{" + "productID=" + productID + ", orderID=" + orderID + ", price=" + price + ", quantity=" + quantity + '}';
    }

    
    
}
