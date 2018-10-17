import java.util.*;
/**
 * Write a description of class Visitor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Visitor extends User
{
    private User newUser;
    
    /**
     * Constructor for objects of class Visitor
     */
    public Visitor()
    {
        super("visitor","00000000");        
    }

    /**
     * 
     */
    public void register(String username, String password, int phone, String address,
                            String email)
    {
        newUser = new Customer(username, password, phone, address, email);
    }
    
    public boolean existChecking(HashMap<String, User> map, String userName)
    {
        Iterator keys =map.keySet().iterator();
        while(keys.hasNext())
        {
            String key = (String)keys.next();
            if(userName.equals(key))
            {
                return false;
            }            
        }
        return true;
    }
    
    public boolean userNameLengthChecking(String userName)
    {
        if (userName.length() <1 | userName.length() > 16)
        {
            return false;
        }
        return true;
    }
    
    public boolean passwordChecking(String password)
    {
        if (password.length() <8 | password.length() > 16)
        {
            return false;
        }
        return true;
    }
    
    public User getRegisterInfo()
    {
        return newUser;
    }
}
