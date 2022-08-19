package supermarketmanagmentsystem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Random;
import java.util.Scanner;

public class SuperMarketManagmentSystem {

    /**
     * @param args the command line arguments
     */
    
    static Random rd = new Random();
    static Scanner sc = new Scanner(System.in);
    static String filePath = "/home/jah/Desktop/backup.sms";
    
    public static void main(String[] args) {
        Admin admin = new Admin(Math.abs(rd.nextInt()), "a", "a@gmail.com", "a");
        Shop.getShop().addAdmin(admin);
        
        readBack();
        printmainmenu();
        
       
        int a = sc.nextInt();
        
        switch (a) {
            case 1:
                displayjoincustomer();
                break;
            case 2:
                displayadminmenu();
                break;
            case 3:
                displayproducts();
                break;
            case 4:
                backupState(Shop.getShop());
                break;
                
            case 5:
                readBack();
                break;
            default:
                break;
        }
    }
    
    public static void displayproducts() {
        System.out.println("Enter 1.To Buy 2.To Exit");
        System.out.println("-----------Items--------------------");
        System.out.println("Id\t\tName\t\tPrice\t\tDate\t\tQuantitiy");
        System.out.println("-----------------------------------------------------------");
        
        Collection<Item> allitems = Shop.getShop().getGroceryItems();
        
        if (allitems.isEmpty()) {
            System.out.println("No Items yet...");
        } else {
            for (Item it : allitems) {
                System.out.println(it.id + "|" + it.name + "|" + it.price +"|" + it.quantity);
            }
        }
        
        int b = sc.nextInt();
        if (b == 1) {
            System.out.println("Enter the ID of the Item: ");
            int id = sc.nextInt();
            Item i = Shop.getShop().getItem(id);
            System.out.println("Enter quanitity: ");
            int q = sc.nextInt();
            
            if (i != null) {
                double totalprice = i.price * q;
                System.out.println("The total price is " + totalprice + " do you want to buy?(y/n)");
                String response = sc.next();
                
                if (response.equals("y") || response.equals("yes")) {
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    Calendar cal = Calendar.getInstance();
                    Sales s = new Sales(dateFormat.format(cal.getTime()), i, i.price, q);
                    Shop.getShop().addSales(s);
                    System.out.println("Thanks for shopping with us!");
                    System.out.println("Enter \n1.to go back Main menu \n2. to Exit the system");
                    int ch = sc.nextInt();
                    if (ch == 1) {
                        main(null);
                        
                    } else if (ch == 2) {
                        exitSystem();
                        
                    }
                } else {
                    System.out.println("Thanks for coming!");
                    exitSystem();
                    
                }
            }
        }
    }
    
    public static void displayadminmenu() {
        System.out.println("please enter email: ");
        String email = sc.next();
        System.out.println("Enter password: ");
        String password = sc.next();
        Admin a = Shop.getShop().getAdmin(email);
        
        if (a != null && a.password.equals(password)) {
            System.out.println("Welcome To Amin Menu.");
            System.out.println("Enter: \n1.To Add Items \n2.To View Clients \n3.Financial Data \n4.Back to main menu");
            int c = sc.nextInt();
            
            switch (c) {
                case 1:
                    additems();
                    break;
                case 2:
                    
                    viewusers();
                    break;
                case 3:
                    viewfinancialdata();
                    break;
                case 4:
                    main(null);
                    break;
                default:
                    System.out.println("Unknown Input");
                    break;
            }
        } else {
            System.out.println("couldn't find your email and acount.");
            System.out.println("Enter \n1.To retry \n2.To Main menu");
            int c = sc.nextInt();
            if (c == 1) {
                displayadminmenu();
            } else if (c == 2) {
                main(null);
            }
        }
    }
    
    public static void additems() {
        System.out.println("How many Items do you want to add?");
        int a = sc.nextInt();
        
        for (int i = 0; i < a; i++) {
            System.out.println("Enter Id for Item: ");
            int id = sc.nextInt();
            System.out.println("Enter the name of the item: ");
            String name = sc.next();
            System.out.println("Enter the price: ");
            double price = sc.nextDouble();
            String date = "Aug 7 2022";
            System.out.println("Enter the quantitiy: ");
            int quantitiy = sc.nextInt();

            Item it = new Item(id, name, price, date,quantitiy);
            Shop.getShop().addItem(it);
            System.out.println("Item added successfully!");
        }   
        System.out.println("Enter 1.To go back 2.To add again");
        int b = sc.nextInt();
        if (b == 1) {
            displayadminmenu();
        }else if (b == 2) {
            additems();
        }
    }
    
    public static void viewusers() {
        System.out.println("--------- shop Name---------");
        System.out.println("--------- Clients-----------");
        
        Collection<Client> allclients = Shop.getShop().getClients();
        System.out.println(allclients.size());
        System.out.println("Id\t\tName\t\tEmail");
        for (Client c: allclients) {
            System.out.println(c.id + "|\t" + c.name + "|\t" + c.email);
        }
        System.out.println("-------------------------------------");
        System.out.println("Enter 1.To go back 2.Exit");
        
        int b = sc.nextInt();
        
        if (b == 1) {
            displayadminmenu();
        }else if (b == 2) {
            exitSystem();
        }
    }
    
    public static void viewfinancialdata() {
        System.out.println("--------------- financial data ----------------");
        System.out.println("Sales: ");
        Collection<Sales> sales = Shop.getShop().getShopSales();
        
        if (sales.isEmpty()) {
            System.out.println("No sales yet....");
        } else {
            System.out.println("Name\tDate\tPrice\tQuantity"  );
            for (Sales s: sales) {
                System.out.println(s.item.name + "|\t" + s.date + "|\t" + s.price + "|\t" + s.quantity);
            }
        }
        
        double currassets = 0.0f;
        double totalsales = 0.0f;
        
        Collection<Item> allitems = Shop.getShop().getGroceryItems();
        
        for (Item im : allitems) {
            currassets += im.price * im.quantity;
        }
        
        for (Sales s: sales) {
            totalsales += s.price * s.quantity;
        }
        
        double totalasset = currassets + totalsales;
        double wc = totalasset - Shop.getShop().getLiablity();
        System.out.println("Current Assets: " + currassets);
        System.out.println("Total Sales: " + totalsales);
        System.out.println("Total asset: " + totalasset);
        System.out.println("Working Capital: " + wc);
        System.out.println("Enter \n1.To go back to Main Menu \n2.Exit the system");
        
        int a = sc.nextInt();
        
        if (a == 1) {
            main(null);
        } else if (a == 2) {
            exitSystem();
        }
    }
    
    public static void printmainmenu() {
        System.out.println("-------------- welcome Text --------------");
        System.out.println("----------- group memebers --------------");
        System.out.println("Please Enter: \n1.To join as customer \n2.Admin Menu \n3.View Products \n4.Create A backup \n5.to exit the system.");
    }
    
    public static void displayjoincustomer() {
        System.out.println("Hi, welcome to registration page");
        System.out.println("------------------------------------------------");
        System.out.println("Enter your name?");
        String name = sc.next();
        System.out.println("Enter your email?");
        String email = sc.next();
        System.out.println("Enter your password?");
        String password = sc.next();
        
        
        
        Client nc = new Client(Math.abs(rd.nextInt()), name, email, password);
        Shop.getShop().addClient(nc);
        
        System.out.println("Dear " + name + " thanks for registering...");
        System.out.println("Enter \n 1.to go back to main menu \n 2.to Exit the system");
        int ch = sc.nextInt();
        
        if (ch == 1) {
            main(null);
        } else if (ch == 2) {
            exitSystem();
        } 
    }
    
    public static void exitSystem() {
        System.out.println("------------ Good bye text -------");
        backupState(Shop.getShop());
        System.exit(0);
    }
        
    public static void readBack() {
        try {
            System.out.println("reading back");
            FileInputStream fin = new FileInputStream(filePath);
            ObjectInputStream oin = new ObjectInputStream(fin);
            
            Shop sh1 = (Shop) oin.readObject();
            if (sh1 != null) {
                Shop.setShop(sh1);
            }
            
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static void backupState(Object o) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filePath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(o);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    
    }
    
}
