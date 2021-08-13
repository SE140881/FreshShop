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
public class CartDetailDTO {
    private int quantity;
    private String cartID;
    private String productID;

    public CartDetailDTO() {
    }

    public CartDetailDTO(int quantity, String cartID, String productID) {
        this.quantity = quantity;
        this.cartID = cartID;
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCartID() {
        return cartID;
    }

    public void setCartID(String cartID) {
        this.cartID = cartID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }
    
    
}
