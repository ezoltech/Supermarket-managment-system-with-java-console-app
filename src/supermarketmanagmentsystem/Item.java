/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarketmanagmentsystem;

import java.io.Serializable;

public class Item implements Serializable{
    
    private static final long serialVersionUID = 6529645098267757690L;
    
    int id;
    
    String name;
    
    double price;
    
    String addedDate;
    
    int quantity;
    
    public Item() {
    }

    public Item(int id, String name, double price, String addedDate, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.addedDate = addedDate;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(String addedDate) {
        this.addedDate = addedDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
