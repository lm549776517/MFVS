
import java.util.*;
/**
 * Write a description of class Account here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Account
{
    // instance variables - replace the example below with your own
    private HashMap<String, Customer> userAccount;
    private HashMap<String, Owner> ownerAccount;
    private HashMap<String, Visitor> visitorAccount;
    private Visitor visitor;
    private Owner owner;

    /**
     * Constructor for objects of class Account
     */
    public Account()
    {
        userAccount = new HashMap<String, Customer>();
        ownerAccount = new HashMap<String, Owner>();
        visitorAccount = new HashMap<String, Visitor>();
        visitor = new Visitor();
        owner = new Owner(); 
        
        ownerAccount.put(owner.getUserName(),  owner); 
        visitorAccount.put(visitor.getUserName(), visitor);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void addUser(Customer customer)
    {
        userAccount.put(customer.getUserName(),customer);
    }
    
    public HashMap getAccount()
    {
        return userAccount;
    }
    
     public HashMap getOwnerAccount()
    {
        return ownerAccount;
    }
    
     public HashMap getVisitorAccount()
    {
        return visitorAccount;
    }
}
