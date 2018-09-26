import java.util.*;
import java.util.Scanner;
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
     * 
     */
   public void intialMenu(Visitor visitor)
   {
        int option=0;
        Scanner input = new Scanner(System.in);
        boolean optionValid = false;
        while(!optionValid) {
            System.out.println("Welcome to MFVS!");
            System.out.println("Press 1 Login with username and password.");
            System.out.println("Press 2 Visitor Mode.");
            option = input.nextInt();
        if(option == 1 || option ==2)
        { 
          optionValid = true;
        } else{
            System.out.println("Invalid option! Please re-enter!");  
        }
       }
       switch(option)
       {
        case 1:
            loginPage();
            break;
        case 2:
            visitorMenu(visitor);
            break;
        }
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
            System.out.println("Password must within 8-16");
            username = input.nextLine();
            checkPassword = visitor.passwordChecking(password);
        }
        visitor.register(username, password);
        userAccount.addUser(visitor.getRegisterInfo()); 
        System.out.println("Register successfully!");
        loginPage();
    }

    public void ownerMenu()
    {
        System.out.println("Ower menu: ");
        System.out.println("Press 1 Search Product.");
        System.out.println("Press 2 Edit product.");
        System.out.println("Press 3 Add product.");
        System.out.println("Press 4 Remove product.");
        System.out.println("Press 5 Search customer.");
    }
    
    public void visitorMenu(Visitor visitor)
    {
        int option=0;
        Scanner input = new Scanner(System.in);
        boolean optionValid = false;
        while(!optionValid) {
         System.out.println("Visitor menu: ");
         System.out.println("Press 1 Register.");
         System.out.println("Press 2 View products.");
         System.out.println("Press 3 Search products.");
         option = input.nextInt();
        if(option == 1 || option == 2 || option == 3)
        { 
          optionValid = true;
        } else{
            System.out.println("Invalid option! Please re-enter!");  
        }
       }
        switch(option)
       {
        case 1:
            userRegister(visitor);
            break;
        }
       
    }
    
    public void customerMenu()
    {
        System.out.println("Customer menu: ");
        System.out.println("Press 1 View product.");
        System.out.println("Press 2 Search product.");
        System.out.println("Press 3 Update profile.");
        System.out.println("Press 4 View shopping cart.");
        System.out.println("Press 5 View order.");
        System.out.println("Press 6 Log off.");

    }
    
    public void loginPage()
    {
        String userName;
        String password;
        Scanner input = new Scanner(System.in);
        System.out.println("This is login page!");
        System.out.println("Pleae input username:");
        userName = input.nextLine();
        System.out.println("Please input password:");
        password = input.nextLine();
    }
}
