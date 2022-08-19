/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarketmanagmentsystem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Shop implements Serializable {
    
    private static final long serialVersionUID = 6529625098267757690L;

    static Object getShop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    int id;
    
    String name;
    
    String location;
    
    private final Map<Integer, Item> groceryItems = new HashMap<>();
    
    private final ArrayList<Sales> shopSales = new ArrayList<>();
    
    private final Map<String, Admin> admins = new HashMap<>();
    
    private static Shop shop = new Shop();
    
    private final Map<String, Client> clients = new HashMap<>();
    
    double liablity = 0.0f;
    
    public Shop() {}
    
    public static Shop getShop() {
        return shop;
    }
    
    public static void setShop(Shop sh) {
        shop = null;
        shop = sh;
    }
    
    public void addClient(Client c) {
        clients.put(c.email, c);
    }
    
    public void addSales(Sales s) {
        shopSales.add(s);
    }
    
    public void addItem(Item i) {
        groceryItems.put(i.id, i);
    }
    
    public void addAdmin(Admin a) {
        admins.put(a.email, a);
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    public Item getItem(int id) {
        return groceryItems.get(id);
    }

    public Collection<Item> getGroceryItems() {
        return groceryItems.values();
    }
    
    public ArrayList<Sales> getShopSales() {
        return shopSales;
    }

    public Collection<Client> getClients() {
        return clients.values();
    }

    public Collection<Admin> getAdmins() {
        return admins.values();
    }
    
    public Admin getAdmin(String email) {
        return admins.get(email);
    }

    public double getLiablity() {
        return liablity;
    }

    public void setLiablity(double liablity) {
        this.liablity = liablity;
    }
    
    public void removeClient(String email) {
        clients.remove(email);
    }
    
    public void removeItem(int id) {
        groceryItems.remove(id);
    }
    
    public Item getItemById(int id) {
        return groceryItems.get(id);
    }
}
