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
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void register(String username, String password)
    {
        User newUser = new User(username, password);
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
        if (userName.length() <8 | userName.length() > 16)
        {
            return false;
        }
        return true;
    }
}
