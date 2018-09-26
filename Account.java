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
    private HashMap<String, User> userAccount;
    private Visitor visitor;
    private Owner owner;

    /**
     * Constructor for objects of class Account
     */
    public Account()
    {
        userAccount = new HashMap<>();
        visitor = new Visitor();
        owner = new Owner(); 
        userAccount.put(visitor.getUserName(), visitor);
        userAccount.put(owner.getUserName(),  owner);        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void addUser(User user)
    {
        userAccount.put(user.getUserName(),user);
    }
    
    public HashMap getAccount()
    {
        return userAccount;
    }
}
