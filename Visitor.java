import java.util.*;
/**
 * Write a description of class Visitor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Visitor extends User
{
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
    public void register(String username, String password)
    {
        User newUser = new User(username, password);
    }
    
    public boolean verifyUsername(HashMap<String, User> map, String userName)
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
}
