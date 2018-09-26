
/**
 * Write a description of class UserInterface here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class UserInterface
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class UserInterface
     */
    public UserInterface()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void logIn()
    {
        System.out.println("Welcome to MFVS!");
        System.out.println("Press 1 login by username and password.");
        System.out.println("Press 2 login as a visitor.");
        
        
    }
    
    public void ownerMenu()
    {
        System.out.println("Welcome to MFVS!");
        System.out.println("Press 1 search Product.");
        System.out.println("Press 2 edit product.");
        System.out.println("Press 3 add product.");
        System.out.println("Press 4 remove product.");
        System.out.println("Press 5 search customer.");
    }
    
    public void visitorMenu()
    {
        System.out.println("Welcome to MFVS!");
        System.out.println("Press 1 register.");
        System.out.println("Press 2 view products.");
    }
    
    public void customerMenu()
    {
        System.out.println("Welcome to MFVS!");
        System.out.println("Press 1 view product.");
        System.out.println("Press 2 search product.");
        System.out.println("Press 3 update profile.");
        System.out.println("Press 4 log off.");
    }
}
