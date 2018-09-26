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
        System.out.println("Press 2 login as a visitor.");
        
        
    }
    

    public void userRegister(Visitor visitor)
    {
        Scanner input = new Scanner(System.in);
        String username;
        String password;
        System.out.println("Please input the username!");
        username = input.nextLine();
        boolean checkLength = visitor.userNameLengthChecking(username);
        boolean checkExist = visitor.existChecking(userAccount.getAccount(),username);
        while (checkLength == false) 
        {
            System.out.println("Username must less than 16 characters!");
            System.out.println("Please input the username!");
            username = input.nextLine();
            checkLength = visitor.userNameLengthChecking(username);
        }
        if (checkLength == true)
        {
            while (checkExist == false)
            {
                System.out.println("Username has already exist!");
                System.out.println("Please input the username!");
                username = input.nextLine();
                checkLength = visitor.userNameLengthChecking(username);
                while (checkLength == false) 
                {
                    System.out.println("Username must less than 16 characters!");
                    System.out.println("Please input the username!");
                    username = input.nextLine();
                    checkLength = visitor.userNameLengthChecking(username);
                }
                checkExist = visitor.existChecking(userAccount.getAccount(),username);
            }
        }        
        
        System.out.println("Please input the password!");
        password = input.nextLine();
        boolean checkPassword = visitor.passwordChecking(password);
        while (checkPassword == false)
        {
            System.out.println("Username has already exist!");
            username = input.nextLine();
        }
        visitor.register(username, password);
        userAccount.addUser(visitor.getRegisterInfo());       
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
