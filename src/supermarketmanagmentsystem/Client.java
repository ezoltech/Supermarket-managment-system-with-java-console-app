package supermarketmanagmentsystem;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author jah
 */
public class Client extends User implements Serializable {
    
    private static final long serialVersionUID = 6529655098267757690L;

    String role = "Client";
        
    public Client() {
    }

    public Client(int id, String name, String email, String password) {
        super(id, name, email, password);
    }

    public String getRole() {
        return role;
    }
    
}
