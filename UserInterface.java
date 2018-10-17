import java.util.*;
import java.util.Scanner;
import java.text.SimpleDateFormat;
public class UserInterface
{
    // instance variables - replace the example below with your own
    private Account userAccount;
    private ProductList productList;

    /**
     * Constructor for objects of class UserInterface
     */
    public UserInterface()
    {
        userAccount = new Account();
        productList = new ProductList();
    }

    /**
     * 
     */
    public void intialMenu()
    {
        System.out.print('\u000C'); 
        int option = 0;
        Visitor aVisitor = new Visitor();
        Scanner input = new Scanner(System.in);
        boolean optionValid = false;
        while(!optionValid) 
        {
            System.out.println("Welcome to MFVS!");
            System.out.println("Press 1 Login with username and password.");
            System.out.println("Press 2 Create a MFV account.");
            System.out.println("Press 3 Visitor Mode.");
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
            loginPage(); 
            break;
            case 2:
            userRegister(aVisitor);
            break;
            case 3:

            visitorMenu(aVisitor);
            break;
        }
    }
    
    public void editProduct(int index,
                            String attribute)
    {
        index = index -1;
        Scanner input = new Scanner(System.in);
        ArrayList<Product> productList;
        productList = this.productList.getProductList();
        switch (attribute)
        {
            case "productName":
                String newAttribute1 = inputEditAttribute("productName");
                productList.get(index).setProductName(newAttribute1);
                break;
               
            case "category":
                String newAttribute2 = inputEditAttribute("category");
                productList.get(index).setCategory(newAttribute2);
                break;
                
            case "type":
                String newAttribute3 = inputEditAttribute("type");
                productList.get(index).setType(newAttribute3);
                break;
                
            case "saleMethod":
                String newAttribute4 = inputEditAttribute("saleMethod");
                productList.get(index).setSaleMethod(newAttribute4);
                break;
                
            case "source":
                String newAttribute5 = inputEditAttribute("source");
                productList.get(index).setSource(newAttribute5);
                break;
                
            case "addDate":
                Date newAttribute6 = inputDate();
                productList.get(index).setAddDate(newAttribute6);
                break;
                
            case "ShelfLife":
                int newAttribute7 = inputEditAttribute3("shelfLife");
                productList.get(index).setShelfLife(newAttribute7);
                break;
                
            case "Price":
                float newAttribute8 = inputEditAttribute1("price");
                productList.get(index).setPrice(newAttribute8);
                break;
            
            case "Quantity":
                float newAttribute9 = inputEditAttribute1("quantity");
                productList.get(index).setQuantity(newAttribute9);
                break;
        }
    }
    
    public String inputEditAttribute(String attribute)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Input new " + attribute + " :");
        String newAttribute = input.nextLine();
        return newAttribute;
    }
    
    public int inputEditAttribute3(String attribute)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Input new " + attribute + " :");
        int newAttribute = input.nextInt();
        return newAttribute;
    }
    
    public float inputEditAttribute1(String attribute)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Input new " + attribute + " :");
        float newAttribute = input.nextFloat();
        return newAttribute;
    }
    
    public void removeProduct(int index)
    {
        index = index -1;
      
        ArrayList<Product> productList;
        productList = this.productList.getProductList();
        String productID = productList.get(index).getProductID();
        this.productList.removeProductAsID(productID);
       
        
       //productList.removeProductAsID(productList.getProductList().get(index).getProductID());
    }
    
    public void viewProductPage()
    {
        Scanner input = new Scanner(System.in);
        int index = 1;
        ArrayList<Product> productList;
        productList = this.productList.getProductList();
        //Collections.sort(productList, ALPHABETICAL_ORDER); Sort productList
        System.out.println("This is product list.");
        
        System.out.println("Index ProductID ProductName Category Type SaleMethod Source AddDate ShelfLife Price Quantity");
        for (Product item : productList)
        {
            System.out.printf("%d %s %s %s %s %s %s %tD %d %f %f%n", index, item.getProductID(),
                                                            item.getProductName(), item.getCategory(),
            item.getType(),item.getSaleMethod(),item.getSource(),item.getAddDate(),
            item.getShelfLife(),item.getPrice(),item.getQuantity());
            index ++;
        }
        System.out.println("Press 1 Edit product");
        System.out.println("Press 2 Remove product");
        System.out.println("Press 3 Return to Owner Menu");
        int option = input.nextInt();
        if (option == 1)
        {
            boolean co = false;
            do
            {
            System.out.println("Input the product index: ");
            int productIndex = input.nextInt();
            System.out.println("Input the product attribute: ");
            Scanner sc2 = new Scanner(System.in);
            String attribute = sc2.nextLine();
            editProduct(productIndex, attribute);
            System.out.println("Edit compeleted!");            
            System.out.println("Press E/e to end editing or any keys to continue");
            char con = sc2.nextLine().charAt(0);
            if(con == 'E' || con == 'e')
            {
                co = true;
            }
            }while(!co);
            viewProductPage();
        }
        if (option == 2)
        {
            boolean co = false;
            do
            {
            System.out.println("Input the product index: ");
            int productIndex = input.nextInt();
            removeProduct(productIndex);
            Scanner sc2 = new Scanner(System.in);
            System.out.println("Press E/e to end deleting or any keys to continue");
            char con = sc2.nextLine().charAt(0);
            if(con == 'E' || con == 'e')
            {
                co = true;
            }
            }while(!co);
            viewProductPage();
        }
        if (option == 3)
        {
            ownerMenu();
        }
    }



    public void userRegister(Visitor visitor)
    {
        Scanner input = new Scanner(System.in);
        String username;
        String password;
        String email;
        String address;
        int phonenumber;
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
        System.out.println("Please input the Email address!");
        email = input.nextLine();
        System.out.println("Please input the Address!");
        address = input.nextLine();
        System.out.println("Please input the phone number!");
        phonenumber = input.nextInt();
        visitor.register(username, password,phonenumber,address,email);
        userAccount.addUser(visitor.getRegisterInfo()); 
        System.out.println("Register successfully!");
        loginPage();
    }

    public void ownerMenu()
    {
        System.out.println("Ower menu: ");
        System.out.println("Press 1 View Product.");
        System.out.println("Press 2 Add product.");
        System.out.println("Press 3 Manage customer.");

        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();

        switch(option)
        {
            case 1:
                viewProductPage();
                break;
            case 2:
                addProduct();
                break;
            case 3:
                

        }
    }

    public void visitorMenu(Visitor visitor)
    {
        int option=0;
        Scanner input = new Scanner(System.in);
        boolean optionValid = false;
        while(!optionValid) 
        {
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

    public void addProduct()
    {
        System.out.println("This is the add product window!");
        boolean back = false;
        do
        {
            Scanner input = new Scanner(System.in);
            String productName = inputProductInfo("productName");
            String category = inputProductInfo("category");
            String saleMethod = inputProductInfo("saleMethod");
            String source = inputProductInfo("source");
            String type = inputProductInfo("type");
            float price = inputFloat("price");
            float quantity = inputFloat("quantity");
            int shelfLife = inputInt("shelfLife");
            Date addDate = inputDate();
            System.out.println("Input information completed.");
            System.out.println("Do you want to save this product? Y/N");
            boolean stop = false;
            while(! stop)
            {
                char choose = input.nextLine().charAt(0);
                if (choose == 'Y' || choose == 'y')
                {
                    productList.addProduct(productName, category, saleMethod, shelfLife,
                        source, price, type, addDate, quantity);
                    System.out.println("Information saved!");
                    stop = true;
                    System.out.println("Press E/e to end adding or any keys to continue!");
                    Scanner input2 = new Scanner(System.in);
                    char ifContinue = input2.nextLine().charAt(0);
                    if (ifContinue == 'E' || ifContinue == 'e')
                    {
                        back = true;
                        stop = true;
                    }
                }  
                else if (choose == 'N' || choose == 'n')
                {
                    System.out.println("Press E/e to end adding or any keys to continue!");
                    Scanner input2 = new Scanner(System.in);
                    char ifContinue = input2.nextLine().charAt(0);
                    if (ifContinue == 'E' || ifContinue == 'e')
                    {
                        back = true;
                        stop = true;
                    }
                    
                    stop = true;                    
                }
                else
                {
                    System.out.println("Invalid input, please input Y or N.");
                }
            }
        }while(!back);
        
        ownerMenu();
    }
    
    

    public Date inputDate()
    {
        Scanner input = new Scanner(System.in);
        boolean isValid = false;
        Date addDate = new Date();
        while(! isValid)
        {
            System.out.println("Please input the add date, the format must be dd/MM/yyyy: ");
            String aDate = input.nextLine();  
            try
            {
                addDate = new SimpleDateFormat("mm/dd/yyyy").parse(aDate);
                isValid = true;
            }
            catch(Exception e)
            {
                System.out.println("Invalid date format, please reinput");
            }
        }
        return addDate;
    }

    public float inputFloat(String name)
    {
        Scanner input = new Scanner(System.in);
        float num = 0;
        boolean isFloat = false;
        while(! isFloat)
        {
            System.out.println("Please input " + name + ", only number is allowed:");
            try
            {
                num = input.nextFloat();
                isFloat = true;
            }
            catch(InputMismatchException e)
            {
                input.nextLine();
                System.out.println("Invalid input, please input number");
            }
        }
        return num;
    }

    public int inputInt(String name)
    {
        Scanner input = new Scanner(System.in);
        int num = 0;
        boolean isInt = false;
        while(! isInt)
        {
            System.out.println("Please input " + name + ", only number is allowed:");
            try
            {
                num = input.nextInt();
                isInt = true;
            }
            catch(InputMismatchException e)
            {
                input.nextLine();
                System.out.println("Invalid input, please input number");
            }
        }
        return num;
    }

    public String inputProductInfo(String name)
    {
        Scanner input = new Scanner(System.in);
        boolean isString = false;
        String productInfo = "";
        while(! isString)
        {
            System.out.println("Pleae input "+ name + ": ");
            productInfo = input.nextLine();
            if (isAlpha(productInfo))
            {
                isString = true;
            }
            else
            {
                System.out.println("Only letter is allowed, please reinput.");
            }
        }
        return productInfo;
    }

    
    public boolean isAlpha(String aString) 
    {
        char[] chars = aString.toCharArray();
        for (char c : chars) 
        {
            if(!Character.isLetter(c)) 
            {
                return false;
            }
        }
        return true;
    }

    public void mainPage()
    {
        intialMenu();
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        if (option == 1)
        {

        }
        else if (option == 2)
        {

        }
    }

    public boolean login(String username, String password, Account userAccount)
    {
        Iterator keys =userAccount.getAccount().keySet().iterator();
        while(keys.hasNext())
        {
            String key = (String)keys.next();
            User value = (User)userAccount.getAccount().get(key);
            if(username.equals(key))
            {
                if (password.equals(value.getPassword()))
                {
                    return true;
                }
            }            
        }
        return false;
    }

    public void loginPage()
    {
        String userName;
        String password;
        boolean valid = false;
        Scanner input = new Scanner(System.in);
        System.out.println("This is login page!");
        while(! valid)
        {
            System.out.println("Pleae input username:");
            userName = input.nextLine();
            System.out.println("Please input password:");
            password = input.nextLine();

            if (login(userName, password, userAccount))
            {
                valid = true;
                System.out.println("Login successfully");
                if (userName.equals("Owner"))
                {
                    ownerMenu();
                }
                else
                {
                    customerMenu();
                }
            }
            else
            {
                System.out.println("UserName or password is incorrect.");
            }
        }
    }

}
