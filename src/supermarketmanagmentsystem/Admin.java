/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarketmanagmentsystem;

import java.io.Serializable;
import java.util.ArrayList;


public class Admin extends User implements Serializable {
    
    private static final long serialVersionUID = 6529685098267757690L;
    
    String role = "Admin";
    
    public Admin(int id, String name, String email, String password) {
        super(id, name, email, password);
    }

    public String getRole() {
        return role;
    }
    
    public void addItem(ArrayList<Item> items, Item currentItem) {
        items.add(currentItem);
    }
    
    public void addItems(ArrayList<Item> items, ArrayList<Item> tobeAdded) {
        items.addAll(tobeAdded);
    }
    
    public void removeItem(ArrayList<Item> items, int Index) {
        items.remove(Index);
    }
    
    public void removeItem(ArrayList<Item> items, Item i) {
        items.remove(i);
    }
    
    public void editItem(ArrayList<Item> items, int index, Item newItem) {
        items.set(index, newItem);
    }
    
}
