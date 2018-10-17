
/**
 * Write a description of class Owner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Owner extends User
{   
    private int phoneNumber;
    private String eMail;
    /**
     * Constructor for objects of class Owner
     */
    public Owner()
    {
        super("Owner","777");
        phoneNumber = 12345678;
        eMail = "MFV@monash.com";
    }
    
    public int getPhone()
    {        
        return phoneNumber;
    }
    
    public String getMail()
    {
        return eMail;
    }

    public void login()
    {
        
    }
    
    public void eidtProduct()
    {
        
    }
    
    public void searchProduct(String productName)
    {
        
    }
    
    public void addProduct()
    {
        
    }
    
    public void removeProduct()
    {
        
    }
    
    public void searchCustomer(String userName)
    {
        
    }
}
