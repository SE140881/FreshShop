/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienvm.dtos;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author TienVM_PC
 */
public class CartDTO {
    Map<String, Integer> cart;

    public Map<String, Integer> getCart() {
        return cart;
    }

    public void setCart(Map<String, Integer> cart) {
        this.cart = cart;
    }
    
    public void addToCart(String productID) {
        if(this.cart == null){
            cart = new HashMap<>();
        }
        int quantity = 1;
        Set<String> listKeys = cart.keySet();
        for (String key : listKeys) {
            if(key.equals(productID)){
                quantity = this.cart.get(key) + 1;
            }
        }
        this.cart.put(productID, quantity);
    }
    
    public void deleteProductOnCart(String productID){
        int quantity;
        Iterator keys = this.cart.entrySet().iterator();
        while(keys.hasNext()){
            Map.Entry product = (Map.Entry) keys.next();
            if(product.getKey().equals(productID)){
                if((Integer)product.getValue() > 1){
                    quantity = (Integer)product.getValue() - 1;
                    product.setValue(quantity);
                }
                else {
                    keys.remove();
                }
            }
        }
    }
    
    public void deleteProductAllOnCart(String productId){
        Iterator keys = this.cart.entrySet().iterator();
        while(keys.hasNext()){
            Map.Entry product = (Map.Entry) keys.next();
            if(product.getKey().equals(productId)){
                keys.remove();
            }
        }
    }
    
    public void updateCart(String productID, int newQuantity){
        Iterator keys = this.cart.entrySet().iterator();
        while(keys.hasNext()){
            Map.Entry product = (Map.Entry) keys.next();
            if(product.getKey().equals(productID)){
                product.setValue(newQuantity);
            }
        }
    }
}
