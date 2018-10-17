import java.util.*;
/**
 * Write a description of class User here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class User
{
    // instance variables - replace the example below with your own
    private String userName;
    private String password;

    /**
     * Constructor for objects of class User
     */
    public User()
    {

    }
    
    public User(String userName, String password)
    {
        this.userName = userName;
        this.password = password;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getUserName()
    {
        return userName;
    }
    
    public String getPassword()
    {
        return password;
    }
}
