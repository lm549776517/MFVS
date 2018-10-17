import java.util.*;
import java.util.Scanner;
import java.text.SimpleDateFormat;
public class UserInterface
{
    // instance variables - replace the example below with your own
    private Account userAccount;
    private ProductList productList;
    HashMap<String, Customer> userList = new HashMap<>(); 
    HashMap<String, Owner> ownerList = new HashMap<>(); 
    Owner currentOwner = new Owner();
    User currentUser = new User();
    Customer currentCustomer = new Customer();
    /**
     * Constructor for objects of class UserInterface
     */
    public UserInterface()
    {
        userAccount = new Account();
        productList = new ProductList();
        userList = userAccount.getAccount();
        ownerList = userAccount.getOwnerAccount();
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
        index = index - 1;
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
                int newAttribute6 = inputInt("addDate");
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
    }
    
    public void viewProductVisitor()
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
        System.out.println("");
        System.out.println("Press 1 Return to previous menu");
        int option = input.nextInt();
        if (option == 1)
        {
            Visitor visitor = new Visitor();
            visitorMenu(visitor);
        }
    }
    
    public void viewProductCustomer()
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
        System.out.println("Press 1 to add to cart!");
        System.out.println("Press 2 to menu!");
        int option = input.nextInt();
        if (option == 1)
        {
            boolean co = false;
            do
            {
            Scanner input4 = new Scanner(System.in);
            System.out.println("Please input index of the product name you wanna add to cart!");
            int prodectIndex = input4.nextInt();
            System.out.println("Please input the quantity you wanna add!");
            Scanner input2 = new Scanner(System.in);
            float quantity = input2.nextFloat();
            currentCustomer.addToShoppingCart(productList.get(prodectIndex-1),quantity);
            System.out.println("Add successfully!");            
            System.out.println("Press E/e to end adding or any keys to continue");
            Scanner input3 = new Scanner(System.in);
            char con = input3.nextLine().charAt(0);
            if(con == 'E' || con == 'e')
            {
                co = true;
            }
            }while(!co);
            customerMenu();
        }
        
        if (option == 2)
        {
            customerMenu();
        }
        System.out.println("");
        System.out.println("Press 1 Return to previous menu");
        int option2 = input.nextInt();
        if (option2 == 1)
        {
            customerMenu();
        }
    }
    
    public void searchCustomerPage()
    {
        Scanner input = new Scanner(System.in);
        int index;
        boolean co1 = false;
        do
        {
            index = 1;
            System.out.println("Please input the customer name");
            String userName = input.nextLine();
            System.out.println("Index UserName Phone Address Email");
            if(userList.containsKey(userName))
            {                          
                System.out.printf("%d %s %d %s %s", index, userList.get(userName).getUserName(),
                                  userList.get(userName).getPhone(), userList.get(userName).getAddress(), 
                                  userList.get(userName).getAddress()); 
                                  System.out.println("");
                index ++;
            
            }
            else
            {
                System.out.println("No such customer!");
            }
            System.out.println("Press E/e to end searching or any key to continue.");
            String end = input.nextLine();
            if (end.matches("[Ee]"))
            {
                co1 = true;
            }
            
        }while(!co1);
        System.out.println("Press 1 Romove customer");
        System.out.println("Press 2 Return to owner menu.");
        int option = input.nextInt();
        if (option == 1)
        {
            boolean co = false;
            do
            {
                Scanner sc = new Scanner(System.in);
                System.out.println("Input the userName: ");
                String userName2 = sc.nextLine();
                userList.remove(userName2);
                System.out.println("Remove customer compeleted!");            
                System.out.println("Press E/e to end customer remove or any keys to continue");
                String con = sc.nextLine();
            if(con.matches("[Ee]"))
            {
                co = true;
            }
            }while (!co);
            viewCustomerPage();
        }
        if (option == 2)
        {
            ownerMenu();
        }
    }
    
    public void viewCustomerPage()
    {
        Scanner input = new Scanner(System.in);
        int index = 1;
        Iterator<String> it = userList.keySet().iterator();
        System.out.println("This is view customer page.");
        System.out.println("Index UserName Phone Address Email");
        while(it.hasNext())
        {
            String userName = it.next();
            System.out.printf("%d %s %d %s %s", index, userList.get(userName).getUserName(),
                              userList.get(userName).getPhone(), userList.get(userName).getAddress(), 
                              userList.get(userName).getAddress());
                              System.out.println("");
            index ++;
        }
        
        System.out.println("Press 1 Romove customer");
        System.out.println("Press 2 Return to owner menu.");
        int option = input.nextInt();
        if (option == 1)
        {
            boolean co = false;
            do
            {
                Scanner sc = new Scanner(System.in);
                System.out.println("Input the userName: ");
                String userName = sc.nextLine();
                userList.remove(userName);
                System.out.println("Remove customer compeleted!");            
                System.out.println("Press E/e to end customer remove or any keys to continue");
                String con = sc.nextLine();
            if(con.matches("[Ee]"))
            {
                co = true;
            }
            }while (!co);
            viewCustomerPage();
        }
        if (option == 2)
        {
            ownerMenu();
        }
    }
    
    public void searchProductPage()
    {
        boolean con1 = false;
        ArrayList<Product> productList = this.productList.getProductList();
        int index;
        do
        {
            index = 1;
            System.out.println("Please input the product name:");
            Scanner sc = new Scanner(System.in);
            String term = sc.nextLine();
            
            System.out.println("Index ProductID ProductName Category Type SaleMethod Source AddDate ShelfLife Price Quantity");
            
            boolean find = false;
            for(Product p : productList)
            {
                if (p.getProductName().equals(term))
                {
                   
    
                    System.out.printf("%d %s %s %s %s %s %s %tD %d %f %f%n", index, p.getProductID(),
                                                                    p.getProductName(), p.getCategory(),
                    p.getType(),p.getSaleMethod(),p.getSource(),p.getAddDate(),
                    p.getShelfLife(),p.getPrice(),p.getQuantity());
                    System.out.println();
                    index ++;
                    find = true;            
                }
            }
            if (!find)
            {
                System.out.println("No such product!");
            }
            System.out.println("Press E/e to end searching or other key to continue.");
            String end = sc.nextLine();
            if (end.matches("[Ee]"))
            {
                con1 = true;
            }
        }while(!con1);
        
        
        
        Scanner input = new Scanner(System.in);       
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
            String con = sc2.nextLine();
            if(con.matches("[Ee]"))
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
            String con = sc2.nextLine();
            if(con.matches("[Ee]"))
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
        System.out.println("");
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
            String con = sc2.nextLine();
            if(con.matches("[Ee]"))
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
            String con = sc2.nextLine();
            if(con.matches("[Ee]"))
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
        System.out.println("This is register page!");
        System.out.println("Please input the username:");
        username = input.nextLine();
        boolean checkLength = visitor.userNameLengthChecking(username);
        boolean checkExist = visitor.existChecking(userAccount.getAccount(),username);
        while (checkLength == false) 
        {
            System.out.println("Username must less than 16 characters!");
            System.out.println("Please input the username:");
            username = input.nextLine();
            checkLength = visitor.userNameLengthChecking(username);
        }
        if (checkLength == true)
        {
            while (checkExist == false)
            {
                System.out.println("Username has already exist!");
                System.out.println("Please input the username: ");
                username = input.nextLine();
                checkLength = visitor.userNameLengthChecking(username);
                while (checkLength == false) 
                {
                    System.out.println("Username must less than 16 characters!");
                    System.out.println("Please inp+ut the username: ");
                    username = input.nextLine();
                    checkLength = visitor.userNameLengthChecking(username);
                }
                checkExist = visitor.existChecking(userAccount.getAccount(),username);
            }
        }        
        System.out.println("Please input the password: ");
        password = input.nextLine();
        boolean checkPassword = visitor.passwordChecking(password);
        while (checkPassword == false)
        {
            System.out.println("Password must within 8-16");
            password = input.nextLine();
            checkPassword = visitor.passwordChecking(password);
        }
        System.out.println("Please input the Email address: ");
        email = input.nextLine();
        System.out.println("Please input the Address: ");
        address = input.nextLine();
        System.out.println("Please input the phone number:");
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
        System.out.println("Press 2 Search Product");
        System.out.println("Press 3 Add product.");
        System.out.println("Press 4 View customer.");
        System.out.println("Press 5 Search customer.");
        System.out.println("Press 6 Log out");

        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();

        switch(option)
        {
            case 1:
                viewProductPage();
                break;
            case 2:
                searchProductPage();
                break;
            case 3:
                addProduct();
                break;
            case 4:
                viewCustomerPage();
                break;
            case 5:    
                searchCustomerPage();
                break;
            case 6:
                //currentUser = new User();
                System.out.println("You have logged out!");
                intialMenu();
                break;
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
            System.out.println("Pres 4 Return to main page.");
            option = input.nextInt();
            if(option == 1 || option == 2 || option == 3 || option == 4)
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
            
            case 2:
                viewProductVisitor();
                break;
            
            case 3:
                searchProduct();
                visitorMenu(visitor);
                break;
            case 4:
                intialMenu();
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
        System.out.println("Press 6 View your profile");
        System.out.println("Press 7 Log off.");
        
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();

        switch(option)
        {
            case 1:
                viewProductCustomer();
                break;
            case 2:
                searchProduct();
                customerMenu();
                break;
            case 3:
                updateProfilePage();
                break;
            case 4:
                HashMap<Product, Float> l = currentCustomer.shoppingCart.getCart();
                HashMap<String, Float> p = currentCustomer.shoppingCart.
                    calculateUnitPrice();
                System.out.println("Index productName Quantity unitprice");
                Iterator<Product> it = l.keySet().iterator();
                int index=0;
                while(it.hasNext())
                {
                    index ++;
                    Product product = it.next();
                    Iterator<String> it2 = p.keySet().iterator();
                    while(it2.hasNext())
                    {
                        String name = it2.next();
                        if (product.getProductName().equals(name))
                        {System.out.printf("%d %s %f %f", index, product
                         .getProductName(), l.get(product),p.get(name));
                         System.out.println("");
                        }
                    }
                }
                System.out.println("Press C/c to check out or E/e to return to menu!");
                Scanner input = new Scanner(System.in);
                char con = input.nextLine().charAt(0);
                if(con == 'C' || con == 'c')
                {
                    currentCustomer.shoppingCart.checkOut();
                    System.out.println("Order has finished check out");
                    System.out.println("Press E/e to return to menu!");
                    Scanner input4 = new Scanner(System.in);
                    char con4 = input4.nextLine().charAt(0);
                    if(con4 == 'E' || con4 == 'e')
                    {
                        customerMenu();
                    }
                }
                if(con == 'E' || con == 'e')
                {
                    customerMenu();
                }
                break;
            case 5:
                ArrayList<OrderList> orderList = currentCustomer.shoppingCart.
                getHistoryOrder();
                System.out.println("Index orderID dateShipped shipStatus subtotal");
                int index1 = 0;
                for(OrderList order:orderList)
                {
                    index1++;
                    System.out.printf("%d %d %s %b %f", index1, order
                         .getOrderID(), order.getDateShipped(),order.getShippedStatus()
                         ,order.getSubtotal());
                    System.out.println("");
                }
                System.out.println("");
                Scanner input2 = new Scanner(System.in);
                System.out.println("Press E/e to return to menu!");
                char con2 = input2.nextLine().charAt(0);
                if(con2 == 'E' || con2 == 'e')
                {
                    customerMenu();
                }
                break;
            case 6:
                System.out.println("userName phone address Email");
                System.out.printf("%s %d %s %s",currentCustomer.getUserName(),
                currentCustomer.getPhone(),currentCustomer.getAddress(),
                currentCustomer.getAddress());
                System.out.println("");
                Scanner input3 = new Scanner(System.in);
                System.out.println("Press E/e to return to menu!");
                char con3 = input3.nextLine().charAt(0);
                if(con3 == 'E' || con3 == 'e')
                {
                    customerMenu();
                }
                break;
            case 7:
                currentUser = new User();
                System.out.println("You have logged out!");
                intialMenu();
                break;
        }
    }
    
    public void searchProduct()
    {
        boolean con = false;
        do
        {
            System.out.println("Please input the product name:");
            Scanner sc = new Scanner(System.in);
            String term = sc.nextLine();
            ArrayList<Product> productList = this.productList.getProductList();
            System.out.println("Index ProductID ProductName Category Type SaleMethod Source AddDate ShelfLife Price Quantity");
            int index = 1;
            boolean find = false;
            for(Product p : productList)
            {
                if (p.getProductName().equals(term))
                {
                   
    
                    System.out.printf("%d %s %s %s %s %s %s %tD %d %f %f%n", index, p.getProductID(),
                                                                    p.getProductName(), p.getCategory(),
                    p.getType(),p.getSaleMethod(),p.getSource(),p.getAddDate(),
                    p.getShelfLife(),p.getPrice(),p.getQuantity());
                    System.out.println();
                    index ++;
                    find = true;            
                }
            }
            if (!find)
            {
                System.out.println("No such product!");
            }
            System.out.println("Press E/e to end searching or other key to continue.");
            String end = sc.nextLine();
            if (end.matches("[Ee]"))
            {
                con = true;
            }
        }while(!con);
    }
    
    public void updateProfilePage()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Please input your new phone");
        int newphone =  input.nextInt();
        currentCustomer.setPhone(newphone);
        System.out.println("Please input your new Email");
        String newemail = input.nextLine();
        currentCustomer.setEmail(newemail);
        System.out.println("Please input your new Address");
        String newaddress = input.nextLine();
        currentCustomer.setAddress(newaddress);
        System.out.println("Update successfully!");
        System.out.println("Press E/e to return to menu!");
        char con = input.nextLine().charAt(0);
            if(con == 'E' || con == 'e')
            {
                customerMenu();
            }
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
            int addDate = inputInt("addDate");
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
    

    public String inputDate()
    {
        Scanner input = new Scanner(System.in);
        boolean isValid = false;
        String addDate = new String();
        while(! isValid)
        {
            System.out.println("Please input the add date, the format must be dd/MM/yyyy: ");
            String aDate = input.nextLine();  
            //try
            //{
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                addDate = formatter.format(aDate);
                isValid = true;
            //}
            /*catch(Exception e)
            {
                System.out.println("Invalid date format, please reinput");
            }*/
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

    public boolean login(String username, String password, Account userAccount)
    {   
        if (username.equals("Owner"))
        {
            if (password.equals("777"))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
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
                    currentOwner = ownerList.get(userName);
                    ownerMenu();
                }
                else
                {
                    currentCustomer = userList.get(userName);
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
