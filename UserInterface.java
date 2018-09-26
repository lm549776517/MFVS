import java.util.*;
/**
 * Write a description of class UserInterface here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class UserInterface
{
    // instance variables - replace the example below with your own
    private Account userAccount;

    /**
     * Constructor for objects of class UserInterface
     */
    public UserInterface()
    {
        userAccount = new Account();
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
        System.out.println("Press 2 login as a vositor.");
        
        
    }
    
    public void userRegister(Visitor visitor)
    {
        Scanner input = new Scanner(System.in);
        String username;
        String password;
        System.out.println("Please input the username!");
        username = input.nextLine();
        while (visitor.userNameLengthChecking(username) == false) 
        {
            System.out.println("Username must within 8-16 characters!");
            username = input.nextLine();
        }
        while (visitor.existChecking(userAccount.getAccount(),username)== false)
        {
            System.out.println("Username has already exist!");
            username = input.nextLine();
        }
        System.out.println("Please input the password!");
        password = input.nextLine();        
    }
}
